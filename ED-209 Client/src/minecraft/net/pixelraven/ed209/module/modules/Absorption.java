package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Absorption extends Module{
	int amount = 20;
	
	public Absorption() {
		super("Absorption", Category.PLAYER);
		setUsage("Absorption(int [HEARTS]);");
		setBlockedState(3);
	}
	
	public void onEnable() {
		onEnable(20);
	}
	
	public void onEnable(int amount) {
		this.amount = amount;
		onUpdate();
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		Minecraft.getMinecraft().thePlayer.setAbsorptionAmount(amount);
	}
	
	public void onDisable() {
		Minecraft.getMinecraft().thePlayer.setAbsorptionAmount(0);	
	}
}