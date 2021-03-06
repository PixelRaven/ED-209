package net.pixelraven.ed209.module.modules;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class MagicCarpet extends Module{
	double buildRadius = 4.0D;
	int xPos = -1, yPos = -1, zPos = -1;
	
	public MagicCarpet() {
		super("Magic Carpet", Category.BUILDING);
		setUsage("MagicCarpet();");
		setBlockedState(1);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		for(int zRadius = (int)(-this.buildRadius); zRadius <= this.buildRadius; zRadius++) {
			for(int xRadius = (int)(-this.buildRadius); xRadius <= this.buildRadius; xRadius++) {
				this.xPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posX);// + xRadius);
				this.yPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posY - 2);
				this.zPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posZ);// + zRadius);
				BlockPos bp = new BlockPos(this.xPos, this.yPos, this.zPos);
				
				Block currentBlock = Minecraft.getMinecraft().theWorld.getChunkFromBlockCoords(bp).getBlock(bp);
					
				if(currentBlock.getMaterial() != Material.air) {		
					Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement(bp, (int)(Math.random()*6), null, (int)(Math.random()*6), 0, (int)(Math.random()*6)));
				}
			}
		}
	}
}
