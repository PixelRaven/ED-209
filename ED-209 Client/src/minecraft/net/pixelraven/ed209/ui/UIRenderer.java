package net.pixelraven.ed209.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.module.ModuleManager;

import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;

public class UIRenderer {
	public static void renderUI() {
		//Disconnected name
//		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("D", 2, 2, 255 << 16);
//		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("is", 8, 2, (255 << 16) + (255 << 8));
//		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("c", 16, 2, 255 << 16);
//		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("onnected", 22, 2, (255 << 16) + (255 << 8));
//		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("V" + Float.toString(Disconnected.DC.CLIENT_PRETTYVERSION), Minecraft.getMinecraft().displayWidth/2-22, 2, (255 << 16));
//		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Shrekt", 2, 2, (255 << 8));
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
			Minecraft.getMinecraft().fontRendererObj.drawString(s, x+w, y, color);
			w += Minecraft.getMinecraft().fontRendererObj.getStringWidth(s);
		}
	}
	
	public static int textWidth(String string) {
		return Minecraft.getMinecraft().fontRendererObj.getStringWidth(string);
	}
	
	private static void renderArrayList() {
		int yCount = 8;
		for(Module module : ModuleManager.activeModules) {
			if(module.getToggled()) {
				drawText(module.getName(), 2, yCount, (255 << 8));
				yCount += 8;
			}
		}
	}
}
