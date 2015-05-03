package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Glide extends Module{
	public Glide() {
		super("Glide", Category.MOVEMENT);
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		 Minecraft.getMinecraft().thePlayer.motionY = Minecraft.getMinecraft().thePlayer.motionY *= 0.5;
	}
}
