package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Sprint extends Module{

	public Sprint() {
		super("Sprint", Category.MOVEMENT);
		setUsage("Sprint();");
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		if(!(Minecraft.getMinecraft().thePlayer.isCollidedHorizontally) && !(Minecraft.getMinecraft().thePlayer.moveForward == 0.0F)) {
			Minecraft.getMinecraft().thePlayer.setSprinting(true);
		}
	}
	
	public void onDisable() {
		Minecraft.getMinecraft().thePlayer.setSprinting(false);
	}
}
