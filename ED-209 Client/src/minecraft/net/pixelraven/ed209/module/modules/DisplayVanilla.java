package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.server.S38PacketPlayerListItem.Action;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class DisplayVanilla extends Module{
	public DisplayVanilla() {
		super("Display Vanilla", Category.RENDER);
		setUsage("DisplayVanilla();");
		setBlockedState(3);
	}
}
