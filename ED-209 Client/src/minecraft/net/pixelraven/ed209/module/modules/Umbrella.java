package net.pixelraven.ed209.module.modules;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
//import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Umbrella extends Module{
	double buildRadius = 3.0D;
	int xPos = -1, yPos = -1, zPos = -1;
	
	public Umbrella() {
		super("Umbrella", Category.BUILDING);
		setUsage("Umbrella();");
		setBlockedState(1);
	}
	
	public void onUpdate() {
		/*
		if(!this.getToggled())
			return;
		//for(int yRadius = (int)this.buildRadius; yRadius >= (-this.buildRadius); yRadius--) {
			for(int zRadius = (int)(-this.buildRadius); zRadius <= this.buildRadius; zRadius++) {
				for(int xRadius = (int)(-this.buildRadius); xRadius <= this.buildRadius; xRadius++) {
					this.xPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posX + xRadius);
					this.yPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posY + 2);// + yRadius);
					this.zPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posZ + zRadius);
		
					Block currentBlock = Minecraft.getMinecraft().theWorld.getBlock(this.xPos, this.yPos, this.zPos);
					
					if(currentBlock.getMaterial() == Material.air) {		
						Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement(this.xPos, this.yPos, this.zPos, (int)(Math.random()*6), null, 0, 0, 0));
					}
				}
			}
		//}*/
	}
}