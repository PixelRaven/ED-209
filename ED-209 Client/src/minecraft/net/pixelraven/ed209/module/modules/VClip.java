package net.pixelraven.ed209.module.modules;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class VClip extends Module{

	public VClip() {
		super("VClip", Category.MOVEMENT);
		setUsage("VClip();");
		setBlockedState(1);
		setUseType(1);
	}

	public void onUse() {
		Minecraft.getMinecraft().thePlayer.setPosition(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY+5, Minecraft.getMinecraft().thePlayer.posZ);
	}
}
