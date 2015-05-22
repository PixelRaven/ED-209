package net.pixelraven.ed209.module.modules;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Jesus extends Module{
	public Jesus() {
		super("Jesus", Category.MOVEMENT);
		setUsage("Jesus();");
		setBlockedState(1);
	}
	
	public void onUpdate() {
	}
}
