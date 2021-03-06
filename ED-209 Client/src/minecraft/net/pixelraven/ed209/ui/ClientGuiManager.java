/*
 * Copyright (c) 2013, DarkStorm (darkstorm@evilminecraft.net)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.pixelraven.ed209.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

import org.darkstorm.minecraft.gui.AbstractGuiManager;
import org.darkstorm.minecraft.gui.component.AbstractComponent;
import org.darkstorm.minecraft.gui.component.Button;
import org.darkstorm.minecraft.gui.component.Component;
import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.component.Slider;
import org.darkstorm.minecraft.gui.component.basic.BasicButton;
import org.darkstorm.minecraft.gui.component.basic.BasicFrame;
import org.darkstorm.minecraft.gui.component.basic.BasicLabel;
import org.darkstorm.minecraft.gui.component.basic.BasicSlider;
import org.darkstorm.minecraft.gui.layout.GridLayoutManager;
import org.darkstorm.minecraft.gui.layout.GridLayoutManager.HorizontalGridConstraint;
import org.darkstorm.minecraft.gui.listener.ButtonListener;
import org.darkstorm.minecraft.gui.theme.Theme;
import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.ED209;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.module.ModuleManager;

/**
 * Minecraft GUI API
 * 
 * This class is not actually intended for use; rather, you should use this as a
 * template for your actual GuiManager, as the creation of frames is highly
 * implementation-specific.
 * 
 * @author DarkStorm (darkstorm@evilminecraft.net)
 */
public final class ClientGuiManager extends AbstractGuiManager {	
	private class ModuleFrame extends BasicFrame {
		private ModuleFrame() {
		}

		private ModuleFrame(String title, Category category) {
			super("@r255@g255@b255" + title + " @r000@g000@b255[@r000@g255@b000" + net.pixelraven.ed209.utils.CategoryCountUtils.getCount(category) + "@r000@g000@b255]");
		}

		private ModuleFrame(String title) {
			super(title);
		}
	}

	private final AtomicBoolean setup;

	public ClientGuiManager() {
		setup = new AtomicBoolean();
	}
	
	public void bindFrame() {
		ModuleFrame frame;
		frame = new ModuleFrame("Binds");
		frame.setTheme(theme);
		frame.setLayoutManager(new GridLayoutManager(2, 0));
		frame.setVisible(true);
		frame.setClosable(false);
		frame.setMinimized(false);
		addFrame(frame);
		
		for(final Module module : ModuleManager.activeModules) {
			frame.add(new BasicLabel(module.getName()));
		
			Button button = new BasicButton(!module.changeBind ? module.getBind() == -1 ? "NONE" : Keyboard.getKeyName(module.getBind()) : "Confirm") {
				@Override
				public void update() {
					setText(!module.changeBind ? module.getBind() == -1 ? "NONE" : Keyboard.getKeyName(module.getBind()) : "Confirm");
				}
			};
			button.addButtonListener(new ButtonListener() {
				@Override
				public void onButtonPress(Button button) {
					if(button.getText().equals(!module.changeBind ? module.getBind() == -1 ? "NONE" : Keyboard.getKeyName(module.getBind()) : "Confirm")) {
						module.changeBind();
						button.setText(!module.changeBind ? module.getBind() == -1 ? "NONE" : Keyboard.getKeyName(module.getBind()) : "Confirm");
					} else {
						button.setText(!module.changeBind ? module.getBind() == -1 ? "NONE" : Keyboard.getKeyName(module.getBind()) : "Confirm");
					}
				}
			});

			frame.add(button, HorizontalGridConstraint.RIGHT);
		
			frame.setWidth(125);
			//frame.setX(391);
			//frame.setY(12);
		}
	}
	
	public void keyFrame() {
		ModuleFrame frame;
		frame = new ModuleFrame("Colour Key");
		frame.setTheme(theme);
		frame.setLayoutManager(new GridLayoutManager(1, 0));
		frame.setVisible(true);
		frame.setClosable(false);
		frame.setMinimized(true);
		frame.setPinnable(false);
		addFrame(frame);
		
		BasicLabel label = new BasicLabel("@r000@g255@b000Works on Bukkit with NC+");
		BasicLabel label2 = new BasicLabel("@r255@g255@b000Works on Bukkit without NC+");
		BasicLabel label3 = new BasicLabel("@r255@g000@b000Vanilla only");
		BasicLabel label4 = new BasicLabel("@r050@g050@b200Client side (Works everywhere)");
		BasicLabel label5 = new BasicLabel("@r255@g255@b255Other");
		frame.add(label, HorizontalGridConstraint.LEFT);
		frame.add(label2, HorizontalGridConstraint.LEFT);
		frame.add(label3, HorizontalGridConstraint.LEFT);
		frame.add(label4, HorizontalGridConstraint.LEFT);
		frame.add(label5, HorizontalGridConstraint.LEFT);
		
		frame.setWidth(200);
		frame.setX(395);
		frame.setY(215);
	}
	
	public void themeFrame() {
		ModuleFrame frame;
		frame = new ModuleFrame("Theme");
		frame.setTheme(theme);
		frame.setLayoutManager(new GridLayoutManager(1, 0));
		frame.setVisible(true);
		frame.setClosable(true);
		frame.setMinimized(true);
		frame.setPinnable(false);
		addFrame(frame);
		
		BasicSlider sliderRed = new BasicSlider("Red", ED209.ED.themeStyle.getEnabledColour().getRed(), 0, 255, 1);
		BasicSlider sliderGreen = new BasicSlider("Green", ED209.ED.themeStyle.getEnabledColour().getGreen(), 0, 255, 1);
		BasicSlider sliderBlue = new BasicSlider("Blue", (double) ED209.ED.themeStyle.getEnabledColour().getBlue(), 0, 255, 1);
		frame.add(sliderRed, HorizontalGridConstraint.FILL);
		frame.add(sliderGreen, HorizontalGridConstraint.FILL);
		frame.add(sliderBlue, HorizontalGridConstraint.FILL);
		
		frame.setWidth(200);
		//frame.setX(395);
		//frame.setY(215);
	}
	
	
	@Override
	public void setup() {
		if(!setup.compareAndSet(false, true))
			return;

		//Add console text field
		GuiTextField consoleTextField;
		
		themeFrame();
		bindFrame();
		keyFrame();
		
		final Map<Category, ModuleFrame> categoryFrames = new HashMap<Category, ModuleFrame>();
		for(final Module module : net.pixelraven.ed209.ED209.ED.moduleManager.activeModules) {
			final String moduleCol;
			switch (module.getBlockedState()) {
				case 0:
					moduleCol = "@r255@g000@b000";
					break;
				case 1:
					moduleCol = "@r255@g255@b000";
					break;
				case 2:
					moduleCol = "@r000@g255@b000";
					break;
				case 3:
					moduleCol = "@r000@g000@b255";
					break;
				default:
					moduleCol = "@r255@g255@b255";
			} 

			ModuleFrame frame = categoryFrames.get(module.getCategory());
			if(frame == null) {
				String name = module.getCategory().name().toLowerCase();
				name = Character.toUpperCase(name.charAt(0))
						+ name.substring(1);
				frame = new ModuleFrame(name, module.getCategory());
				frame.setTheme(theme);
				frame.setLayoutManager(new GridLayoutManager(1, 0));
				frame.setVisible(!name.equals("None"));
				frame.setClosable(true);
				frame.setMinimized(true);
				frame.setPinnable(false);
				frame.setMinimized(true);
				addFrame(frame);
				categoryFrames.put(module.getCategory(), frame);
			}
			//frame.add(new BasicLabel(module.getName()));
			final Module updateModule = module;
			Button button = new BasicButton(module.getName()) {
				@Override
				public void update() {
					//setBackgroundColor(module.getToggled() ? colourEnabled : background);
				}
			};
			button.addButtonListener(new ButtonListener() {
				@Override
				public void onButtonPress(Button button) {
					updateModule.toggleModule();
					//button.setBackgroundColor(module.getToggled() ? org.darkstorm.minecraft.gui.component.AbstractComponent.colourEnabled : org.darkstorm.minecraft.gui.component.AbstractComponent.background);
				}
			});
			frame.add(button, HorizontalGridConstraint.FILL);
		}
		
		// Optional equal sizing and auto-positioning
		resizeComponents();
		Minecraft minecraft = Minecraft.getMinecraft();
		Dimension maxSize = recalculateSizes();
		int offsetX = 5, offsetY = 5;
		int scale = minecraft.gameSettings.guiScale;
		if(scale == 0)
			scale = 1000;
		int scaleFactor = 0;
		while(scaleFactor < scale && minecraft.displayWidth / (scaleFactor + 1) >= 320 && minecraft.displayHeight / (scaleFactor + 1) >= 240)
			scaleFactor++;
		int i = 0;
		for(Frame frame : getFrames()) {
			if(!frame.getTitle().equals("Binds") && !frame.getTitle().equals("Colour Key")) { //My special frames
				Frame[] frames = getFrames();
				if(i > 2) {
					offsetY = frames[i-3].getChildren().length*9 + 10;
				}
				if(i == 3) {
					offsetX = 5;
				}
				i++;
				frame.setX(offsetX-3);
				frame.setY(offsetY+7);
				offsetX += maxSize.width + 5;
			}
		}
	}

	@Override
	protected void resizeComponents() {
		Theme theme = getTheme();
		Frame[] frames = getFrames();
		Button enable = new BasicButton("Enable");
		Button disable = new BasicButton("Disable");
		Dimension enableSize = theme.getUIForComponent(enable).getDefaultSize(enable);
		Dimension disableSize = theme.getUIForComponent(disable).getDefaultSize(disable);
		int buttonWidth = Math.max(enableSize.width, disableSize.width);
		int buttonHeight = Math.max(enableSize.height, disableSize.height);
		for(Frame frame : frames) {
			if(frame instanceof ModuleFrame) {
				for(Component component : frame.getChildren()) {
					if(component instanceof Button) {
						component.setWidth(buttonWidth);
						component.setHeight(buttonHeight);
					}
				}
			}
		}
		recalculateSizes();
	}

	private Dimension recalculateSizes() {
		Frame[] frames = getFrames();
		int maxWidth = 0, maxHeight = 0;
		for(Frame frame : frames) {
			Dimension defaultDimension = frame.getTheme().getUIForComponent(frame).getDefaultSize(frame);
			//maxWidth = Math.max(maxWidth, defaultDimension.width);
			maxWidth = 125;
			frame.setHeight(defaultDimension.height);
			if(frame.isMinimized()) {
				for(Rectangle area : frame.getTheme().getUIForComponent(frame).getInteractableRegions(frame))
					maxHeight = Math.max(maxHeight, area.height);
			} else
				maxHeight = Math.max(maxHeight, defaultDimension.height);
		}
		for(Frame frame : frames) {
			if(!frame.getTitle().equals("Binds") && !frame.getTitle().equals("Colour Key")) { //My special frames
				frame.setWidth(maxWidth);
				frame.setX(5);
				frame.setY(200);
			}
			frame.layoutChildren();
		}
		return new Dimension(maxWidth, maxHeight);
	}
}
