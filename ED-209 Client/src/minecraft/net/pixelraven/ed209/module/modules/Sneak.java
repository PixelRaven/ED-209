package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Sneak extends Module{
	public Sneak() {
		super("Toggle Sneak", Category.MOVEMENT);
		setUsage("Sneak();");
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = true;
	}
	
	public void onDisable() {
		Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = false;	
	}
}
