package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Step extends Module{
	public Step() {
		super("Step", Category.MOVEMENT);
		setUsage("Step();");
		setBlockedState(1);
	}
	
	public void onEnable() {
		Minecraft.getMinecraft().thePlayer.stepHeight = 1.0F;
	}
	
	public void onDisable() {
		Minecraft.getMinecraft().thePlayer.stepHeight = 0.5F;	
	}
}