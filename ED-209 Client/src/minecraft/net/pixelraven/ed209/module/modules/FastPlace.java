package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class FastPlace extends Module{

	public FastPlace() {
		super("Fast Place", Category.BUILDING);
		setUsage("FastPlace();");
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		Minecraft.getMinecraft().rightClickDelayTimer = 0;
	}
}
