package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C11PacketEnchantItem;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Regen extends Module{
	static int frame = 0;
	
	public Regen() {
		super("Regen", Category.COMBAT);
		setUsage("Regen();");
		setBlockedState(3);
	}
	
	public void onUpdate() {
		frame ++;
		
		if(!this.getToggled())
			return;
		if(frame % 1 == 0) {
			Minecraft.getMinecraft().thePlayer.setHealth(20);
		}
	}
}