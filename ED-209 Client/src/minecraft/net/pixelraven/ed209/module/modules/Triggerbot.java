package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Triggerbot extends Module{
	private int ticks = 0, speed = 14;
	float range = 3.6F;
	
	public Triggerbot() {
		super("Triggerbot", Category.COMBAT);
		setUsage("Triggerbot();");
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		if (Minecraft.getMinecraft().objectMouseOver.entityHit instanceof EntityLiving){
			EntityLiving e = (EntityLiving) Minecraft.getMinecraft().objectMouseOver.entityHit;
			Minecraft.getMinecraft().thePlayer.swingItem();
			Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer, e);
		}
	}
}
