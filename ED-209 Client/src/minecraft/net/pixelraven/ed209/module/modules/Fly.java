package net.pixelraven.ed209.module.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.world.WorldSettings.GameType;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Fly extends Module{
	public Fly() {
		super("Fly", Category.MOVEMENT);
		setUsage("Fly();");
		setBlockedState(1);
	}
	
	//Following is really messy as it was pasted from elsewhere
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		Minecraft.getMinecraft().thePlayer.onGround = false;
		Minecraft.getMinecraft().thePlayer.motionX = 0.0D;
		Minecraft.getMinecraft().thePlayer.motionY = 0.0D;
		Minecraft.getMinecraft().thePlayer.motionZ = 0.0D;
		double d5 = Minecraft.getMinecraft().thePlayer.rotationPitch + 90F;
 	    double d7 = Minecraft.getMinecraft().thePlayer.rotationYaw + 90F;
 	    boolean flag4 = Keyboard.isKeyDown(17) && Minecraft.getMinecraft().inGameHasFocus;
 	    boolean flag6 = Keyboard.isKeyDown(31) && Minecraft.getMinecraft().inGameHasFocus;
 	    boolean flag8 = Keyboard.isKeyDown(30) && Minecraft.getMinecraft().inGameHasFocus;
 	    boolean flag10 = Keyboard.isKeyDown(32) && Minecraft.getMinecraft().inGameHasFocus;
 	    if(flag4 && flag8) {
 	    	d7 -= 45D;
 	    } 
 	    else if(flag10) {
 	    	d7 += 45D;
 	    } 
 	    else if(flag6) {
 	    	d7 += 180D;
 	    	if(flag8) {
 	    		d7 += 45D;
 	    	}
 	    	else if(flag10) {
 	    		d7 -= 45D;
 	    	}
 	    }
 	    else if(flag8) {
 	    	d7 -= 90D;
 	    }
 	    else if(flag10) {
 	    	d7 += 90D;
 	    }
 	    if(flag4 || flag8 || flag6 || flag10) {
 	    	Minecraft.getMinecraft().thePlayer.motionX = Math.cos(Math.toRadians(d7));
 	   		Minecraft.getMinecraft().thePlayer.motionZ = Math.sin(Math.toRadians(d7));
 	   	}
	}
}
