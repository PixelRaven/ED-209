package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class AutoSpawn extends Module{
	public AutoSpawn() {
		super("Auto Spawn", Category.PLAYER);
		setUsage("AutoSpawn();");
		setBlockedState(1);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;

		Minecraft.getMinecraft().thePlayer.respawnPlayer();
	}
}
