package net.pixelraven.ed209.module.modules;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.utils.PlayerVars;

public class Nuker extends Module {
	double nukerRadius = 14.0D, dist = 10.0D;
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
					BlockPos bp = new BlockPos(this.xPos, this.yPos, this.zPos);
					
					Block currentBlock = Minecraft.getMinecraft().theWorld.getChunkFromBlockCoords(bp).getBlock(bp);
					
					if(currentBlock.getMaterial() == Material.air)
						continue;
					
					Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, bp, EnumFacing.NORTH));
					Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, bp, EnumFacing.SOUTH));
				}
			}	
		}
	}
}
