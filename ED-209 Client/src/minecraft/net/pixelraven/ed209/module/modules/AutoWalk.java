package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.utils.PlayerVars;

public class AutoWalk extends Module{
	float speed = 0.25F;
	
	public AutoWalk() {
		super("Auto Walk", Category.MOVEMENT);
		setUsage("AutoWalk();");
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		//Minecraft.getMinecraft().thePlayer.moveForward = 1;
		//Minecraft.getMinecraft().thePlayer.motionX = Math.cos((90+PlayerVars.getYawLookAngle())/57.3)*speed;
		//Minecraft.getMinecraft().thePlayer.motionZ = Math.sin((90+PlayerVars.getYawLookAngle())/57.3)*speed;
		Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = true;
	}
	
	public void onDisable() {
		Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = false;
	}
}
