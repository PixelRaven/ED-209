package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class ToggleSneak extends Module{
	public ToggleSneak() {
		super("Toggle Sneak", Category.MOVEMENT);
		setUsage("ToggleSneak();");
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