package net.pixelraven.ed209.module.modules;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Submarine extends Module{
	public Submarine() {
		super("Submarine", Category.MOVEMENT);
		setUsage("Submarine();");
		setBlockedState(2);
	}
	
	public void onUpdate() {
	}
}
