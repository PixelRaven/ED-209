package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.utils.PlayerVars;

public class FastBow extends Module{
	float speed = 0.25F;
	
	public FastBow() {
		super("Fast Bow", Category.COMBAT);
		setUsage("FastBow();");
		setBlockedState(1);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		if(Minecraft.getMinecraft().gameSettings.keyBindForward.isPressed()) {
			System.out.println("Trying to release item thangy");
			ItemStack itemStack = Minecraft.getMinecraft().thePlayer.getItemInUse();
			itemStack.onPlayerStoppedUsing(Minecraft.getMinecraft().theWorld, Minecraft.getMinecraft().thePlayer, 0);
		}
	}
	
	public void onDisable() {
		//Minecraft.getMinecraft().gameSettings.keyBindAttack.pressed = false;
	}
}
