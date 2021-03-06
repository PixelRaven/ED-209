package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Strafe360 extends Module{
	float range = 4F;
	
	public Strafe360() {
		super("Strafe 360", Category.COMBAT);
		setUsage("Strafe360();");
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		for(Object o : Minecraft.getMinecraft().theWorld.loadedEntityList) {
			if(o instanceof EntityOtherPlayerMP || o instanceof EntityLiving) {
				Entity e = (Entity) o;
				if(Minecraft.getMinecraft().thePlayer.getDistanceToEntity(e) <= range) {
					Minecraft.getMinecraft().thePlayer.rotationYaw = 360 + (float) (270 + 57.3 * Math.atan2(e.posZ - Minecraft.getMinecraft().thePlayer.posZ, e.posX - Minecraft.getMinecraft().thePlayer.posX));
					if(Minecraft.getMinecraft().thePlayer.motionX < 0) {
						Minecraft.getMinecraft().thePlayer.motionX = -0.5;
					}
					if(Minecraft.getMinecraft().thePlayer.motionX > 0) {
						Minecraft.getMinecraft().thePlayer.motionX = 0.5;
					}
					if(Minecraft.getMinecraft().thePlayer.motionY < 0) {
						Minecraft.getMinecraft().thePlayer.motionY = -0.5;
					}
					if(Minecraft.getMinecraft().thePlayer.motionY > 0) {
						Minecraft.getMinecraft().thePlayer.motionY = -0.5;
					}
					break;
				}
			}
		}
	}
}
