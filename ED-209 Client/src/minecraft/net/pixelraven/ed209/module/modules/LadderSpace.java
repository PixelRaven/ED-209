package net.pixelraven.ed209.module.modules;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class LadderSpace extends Module{

	public LadderSpace() {
		super("Ladder Space", Category.MOVEMENT);
		setUsage("LadderSpace();");
		setBlockedState(2);
	}
}
