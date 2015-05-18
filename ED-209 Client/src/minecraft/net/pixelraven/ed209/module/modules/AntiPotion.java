package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class AntiPotion extends Module{
	public AntiPotion() {
		super("Anti Potion", Category.PLAYER);
		setUsage("AntiPotion();");
		setBlockedState(3);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		 Minecraft.getMinecraft().thePlayer.removePotionEffectClient(4);
		 Minecraft.getMinecraft().thePlayer.removePotionEffectClient(9);
		 Minecraft.getMinecraft().thePlayer.removePotionEffectClient(15);
	}
}
