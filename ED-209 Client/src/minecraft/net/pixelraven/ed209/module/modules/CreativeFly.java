package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class CreativeFly extends Module{

	public CreativeFly() {
		super("Creative Fly", Category.MOVEMENT);
		setUsage("CreativeFly();");
		setBlockedState(1);
	}

	public void onUpdate() {
		if(!this.getToggled())
			return;
		Minecraft.getMinecraft().thePlayer.capabilities.isFlying = true;
	}
	
	public void onDisable() {
		Minecraft.getMinecraft().thePlayer.capabilities.isFlying = false;		
	}
}
