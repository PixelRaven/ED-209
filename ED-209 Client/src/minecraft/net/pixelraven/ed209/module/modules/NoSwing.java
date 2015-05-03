package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class NoSwing extends Module{
	public NoSwing() {
		super("No Swing", Category.PLAYER);
		setUsage("NoSwing();");
		setBlockedState(2);
	}
}
