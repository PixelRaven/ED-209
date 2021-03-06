package net.pixelraven.ed209.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.pixelraven.ed209.ED209;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.module.ModuleManager;

import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.opengl.Display;

public class UIRenderer {
	public static void renderUI() {
		//ED-209 name and version
		if(!ED209.ED.moduleManager.DisplayVanillaModule.getToggled()) {
			Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("ED-", 2, 2, (128 << 4) + (255 << 4));
			Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("209", 20, 2, (255 << 16));
			UIRenderer.drawText("@r255@g255@b255Version " + ED209.ED.CLIENT_FULLVERSION, Minecraft.getMinecraft().displayWidth/2-109, 2, 0);
			UIRenderer.drawText(ED209.ED.CLIENT_BUILDTYPE, Minecraft.getMinecraft().displayWidth/2-75, 12, 0);
			Display.setTitle("ED-209 [Minecraft 1.8.X]");
		}
		else {
			Display.setTitle("Minecraft 1.8");
		}
		
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
		int w = 0;
		for(int i = 0; i < string.length(); i++) {
			String s = string.substring(i, i+1);
			if(s.equals("@") && string.length() > i + 15) {
				String str = string.substring(i, i+15);
				String col1 = str.substring(2, 5);
				String col2 = str.substring(7, 10);
				String col3 = str.substring(12, 15);
				int colR = Integer.parseInt(col1);
				int colG = Integer.parseInt(col2);
				int colB = Integer.parseInt(col3);
				color = (colR << 16) + (colG << 8) + (colB);
				
				//System.out.println("col1: " + col1 + " col2: " + col2 + " col3: " + col3);
				i += 15;
				s = string.substring(i, i+1);
			}
			Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(s, x+w, y, color);
			w += Minecraft.getMinecraft().fontRendererObj.getStringWidth(s);
		}
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
