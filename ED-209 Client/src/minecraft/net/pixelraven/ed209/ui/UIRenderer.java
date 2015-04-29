package net.pixelraven.ed209.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.pixelraven.ed209.ED209;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.module.ModuleManager;

import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;

public class UIRenderer {
	public static void renderUI() {
		//ED-209 name and version
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("ED-", 2, 2, (255 << 4) + (255 << 4));
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("209", 18, 2, (255 << 16));
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("V" + ED209.ED.CLIENT_PRETTYVERSION, Minecraft.getMinecraft().displayWidth/2-28, 2, (255 << 16));
		renderArrayList();
		
		for(Module module : ModuleManager.activeModules) {
			module.onPreUpdate();
		}
	}
	
	private static void renderAndUpdateFrames() {
		for(Frame moduleFrame : net.pixelraven.ed209.ED209.guiManager.getFrames()) {
			moduleFrame.update();
		}

		for(Frame moduleFrame : net.pixelraven.ed209.ED209.guiManager.getFrames()) {
			if(moduleFrame.isPinned() || Minecraft.getMinecraft().currentScreen instanceof GuiManagerDisplayScreen) {
				moduleFrame.render();
			}
		}
	}
	
	public static void drawText(String string, int x, int y, int color) {
		Minecraft.getMinecraft().fontRendererObj.drawString(string, x, y, color);
	}
	
	public static int textWidth(String string) {
		return Minecraft.getMinecraft().fontRendererObj.getStringWidth(string);
	}
	
	private static void renderArrayList() {
		int yCount = 10;
		for(Module module : ModuleManager.activeModules) {
			if(module.getToggled()) {
				drawText(module.getName(), 2, yCount, (255 << 8));
				yCount += 10;
			}
		}
	}
}
