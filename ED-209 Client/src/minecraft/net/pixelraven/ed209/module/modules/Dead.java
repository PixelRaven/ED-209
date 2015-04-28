package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Dead extends Module{
	public Dead() {
		super("Dead", Category.PLAYER);
		setUsage("Dead();");
		setBlockedState(3);
	}
	
	public void onEnable() {
		Minecraft.getMinecraft().thePlayer.deathTime = 1000000;
	}

	public void onDisable() {
		Minecraft.getMinecraft().thePlayer.deathTime = 0;
	}
}
