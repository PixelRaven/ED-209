package net.pixelraven.ed209.module.modules;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class House extends Module{
	double buildRadius = 1.5D, yBuildRadius = 1.0D;
	int xPos = -1, yPos = -1, zPos = -1;
	
	public House() {
		super("House", Category.BUILDING);
		setUseType(1);
		setBind(Keyboard.KEY_G);
		setUsage("House();");
		setBlockedState(1);
	}
	
	public void onUse() {
		/*for(int yRadius = (int)this.yBuildRadius; yRadius >= -this.yBuildRadius; yRadius--) {
			for(int zRadius = (int)(-this.buildRadius); zRadius <= this.buildRadius; zRadius++) {
				for(int xRadius = (int)(-this.buildRadius); xRadius <= this.buildRadius; xRadius++) {
					this.xPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posX + xRadius);
					this.yPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posY-1 + yRadius);
					this.zPos = (int)Math.round(Minecraft.getMinecraft().thePlayer.posZ + zRadius);
	
					Block currentBlock = Minecraft.getMinecraft().theWorld.getBlock(this.xPos, this.yPos, this.zPos);
				
					for(int i = 0; i < 18; i++) {
						if(currentBlock.getMaterial() == Material.air && (xRadius != 0 && zRadius != 0) || yRadius > Minecraft.getMinecraft().thePlayer.posY) {
							Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement(this.xPos, this.yPos, this.zPos, (int)(Math.random()*6), null, 0, 0, 0));
						}else {
							break;
						}
					}
				}
			}
		}
		for(int i = 0; i < 18; i++) {
			Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement((int)Math.round(Minecraft.getMinecraft().thePlayer.posX), (int)Math.round(Minecraft.getMinecraft().thePlayer.posY+1), (int)Math.round(Minecraft.getMinecraft().thePlayer.posZ), (int)(Math.random()*6), null, 0, 0, 0));
		}*/
	}
}