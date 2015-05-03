package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Heal extends Module{
	public Heal() {
		super("Heal", Category.PLAYER);
		setUseType(1);
		setUsage("Heal(int [HEALTH]);");
		setBlockedState(3);
	}
	
	public void onUse() {
		onUse(20);
	}
	
	public void onUse(int amount) {
		Minecraft.getMinecraft().thePlayer.heal(amount);
	}
}
