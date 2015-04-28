package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Exit extends Module{
	public Exit() {
		super("Exit", Category.MISC);
		setUseType(1);
		setUsage("Disconnect();");
		setBlockedState(4);
	}
	
	public void onUse() {
		Minecraft.getMinecraft().shutdownMinecraftApplet();
	}
}
