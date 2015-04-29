package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class AntiAFK extends Module{
	public int tick = 0;
	public AntiAFK() {
		super("Anti AFK", Category.PLAYER);
	}
	
	public void onUpdate() {
		tick ++;
		if(!this.getToggled())
			return;
		
		if(tick % 50 == 0) {
			Minecraft.getMinecraft().thePlayer.jump();
		}
	}
}
