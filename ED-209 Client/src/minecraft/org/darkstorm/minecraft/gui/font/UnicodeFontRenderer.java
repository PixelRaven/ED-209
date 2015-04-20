package org.darkstorm.minecraft.gui.font;

import java.awt.Font;

import net.pixelraven.ed209.ui.UIRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;


public class UnicodeFontRenderer extends FontRenderer {
	public UnicodeFontRenderer() {
		super(Minecraft.getMinecraft().gameSettings, new ResourceLocation("textures/font/ascii.png"), Minecraft.getMinecraft().renderEngine, false);
	}
		
	public int drawString(String string, int x, int y, int color) {
		UIRenderer.drawText(string, x, y, color);
		return 10;
	}

	@Override
	public int getCharWidth(char c) {
		return getStringWidth(Character.toString(c));
	}
	
	public int getStringWidth(String string) {
		for(int i = 0 ; i < string.length(); i ++) {
			if(string.substring(i, i+1).equals("@") && i+15 < string.length()) {
				string = string.substring(0, i) + string.substring(i+15); 
			}
		}
		return UIRenderer.textWidth(string);
	}

	public int getStringHeight(String string) {
		return 10;
	}
}