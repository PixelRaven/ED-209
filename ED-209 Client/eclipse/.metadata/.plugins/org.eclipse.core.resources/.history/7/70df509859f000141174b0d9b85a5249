package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Phase extends Module{
	public Phase() {
		super("Phase", Category.PLAYER);
		setUsage("Phase();");
		setBlockedState(1);
	}
	
	public void onEnable() {
		Minecraft.getMinecraft().thePlayer.noClip = true;
	}

	public void onDisable() {
		Minecraft.getMinecraft().thePlayer.noClip = false;
	}
}
