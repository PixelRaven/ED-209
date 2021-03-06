package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class FastWalk extends Module{
	float speed = 2;
	public FastWalk() {
		super("Fast Walk", Category.MOVEMENT);
		setUsage("FastWalk(float [SPEED]);");
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		Minecraft.getMinecraft().thePlayer.capabilities.setPlayerWalkSpeed(speed);
	}
	
	public void onDisable() {
		Minecraft.getMinecraft().thePlayer.capabilities.setPlayerWalkSpeed(1);
	}
}
