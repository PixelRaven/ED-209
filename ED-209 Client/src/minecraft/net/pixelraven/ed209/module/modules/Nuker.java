package net.pixelraven.ed209.module.modules;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.utils.PlayerVars;

public class Nuker extends Module {
	double nukerRadius = 4.0D, dist = 10.0D;
	int xPos = -1, yPos = -1, zPos = -1;
	
	public Nuker() {
		super("Nuker", Category.BUILDING);
		setUsage("Nuker();");
		setBlockedState(1);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;

		for(int yRadius = (int)this.nukerRadius; yRadius >= (-this.nukerRadius); yRadius--) {
			for(int zRadius = (int)(-this.nukerRadius); zRadius <= this.nukerRadius; zRadius++) {
				for(int xRadius = (int)(-this.nukerRadius); xRadius <= this.nukerRadius; xRadius++) {
					this.xPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posX + xRadius);
					this.yPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posY + yRadius);
					this.zPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posZ + zRadius);
				
					//Block currentBlock = Minecraft.getMinecraft().theWorld.getBlock(this.xPos, this.yPos, this.zPos);
					
					//if(currentBlock.getMaterial() == Material.air)
					//	continue;
					
					//Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(0, new BlockPos(this.xPos, this.yPos, this.zPos), 1));
					//Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(2, this.xPos, this.yPos, this.zPos, 1));
				}
			}	
		}
	}
}