package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Disconnect extends Module{
	public Disconnect() {
		super("Disconnect", Category.MISC);
		setUseType(1);
		setUsage("Disconnect();");
	}
	
	public void onUse() {
		Minecraft.getMinecraft().stopIntegratedServer();
	}
}
