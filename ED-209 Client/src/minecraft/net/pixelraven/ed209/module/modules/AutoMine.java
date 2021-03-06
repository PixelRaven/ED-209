package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.utils.PlayerVars;

public class AutoMine extends Module{
	float speed = 0.25F;
	
	public AutoMine() {
		super("Auto Mine", Category.MOVEMENT);
		setUsage("AutoMine();");
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		Minecraft.getMinecraft().gameSettings.keyBindAttack.pressed = true;
	}
	
	public void onDisable() {
		Minecraft.getMinecraft().gameSettings.keyBindAttack.pressed = false;
	}
}
