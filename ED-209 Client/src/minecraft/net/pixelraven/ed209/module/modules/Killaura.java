package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Killaura extends Module{
	private int ticks = 0, speed = 14;
	float range = 3.6F;
	
	public Killaura() {
		super("Killaura", Category.COMBAT);
		setUsage("Killaura();");
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		ticks ++;
		if(ticks >= 20 - speed) {
			 ticks = 0;
			 for(Object o : Minecraft.getMinecraft().theWorld.loadedEntityList) {
				 if(o instanceof EntityOtherPlayerMP) {
					 Entity e = (Entity) o;
					 if(Minecraft.getMinecraft().thePlayer.getDistanceToEntity(e) <= range) {
						 Minecraft.getMinecraft().thePlayer.swingItem();
						 Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer, e);
						 ticks = 0;
					 }
				 }
			 }
		}
	}
}
