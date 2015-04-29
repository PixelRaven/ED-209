package net.pixelraven.ed209.font;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;
import java.awt.Font;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.pixelraven.ed209.ui.UIRenderer;

public class UnicodeFontRenderer extends FontRenderer {
	public UnicodeFontRenderer(Font awtFont) {
		super(Minecraft.getMinecraft().gameSettings, new ResourceLocation("textures/font/ascii.png"), Minecraft.getMinecraft().getTextureManager(), false);
	}

	@Override
	public int drawString(String string, int x, int y, int color) {
		UIRenderer.drawText(string, x, y, color);
		return x;
	}

	@Override
	public int func_175063_a(String string, float x, float y, int color) {
		return drawString(string, (int) x, (int) y, color);
	}

	@Override
	public int getCharWidth(char c) {
		return getStringWidth(Character.toString(c));
	}

	@Override
	public int getStringWidth(String string) {
		return string.length()*6;
	}

	public int getStringHeight(String string) {
		return 10;
	}
}
