package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C11PacketEnchantItem;
import net.minecraft.util.EnumFacing;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class NoPause extends Module{
	public NoPause() {
		super("No Lose Focus", Category.MISC);
		setUsage("NoLoseFocus();");
		setBlockedState(4);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		
		Minecraft.getMinecraft().isGamePaused = false;
		Minecraft.getMinecraft().inGameHasFocus = true;
		Minecraft.getMinecraft().thePlayer.capabilities.disableDamage = true;
	}
}
