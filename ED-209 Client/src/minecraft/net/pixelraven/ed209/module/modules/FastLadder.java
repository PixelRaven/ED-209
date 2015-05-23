package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class FastLadder extends Module{
	public float speed = 2f;
	public FastLadder() {
		super("Fast Ladder", Category.MOVEMENT);
		setUsage("FastLadder();");
		setBlockedState(2);
	}
}
