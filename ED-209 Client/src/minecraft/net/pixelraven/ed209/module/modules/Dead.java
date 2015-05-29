package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.server.S38PacketPlayerListItem.Action;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Dead extends Module{
	public Dead() {
		super("Dead", Category.PLAYER);
		setUsage("Dead();");
		setBlockedState(3);
	}
	
	public void onEnable() {
		Minecraft.getMinecraft().thePlayer.isDead = true;
		//Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0BPacketEntityAction(Minecraft.getMinecraft().thePlayer, Action.UPDATE_GAME_MODE, 0));
	}

	public void onDisable() {
		Minecraft.getMinecraft().thePlayer.isDead = false;
		//Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0BPacketEntityAction(Minecraft.getMinecraft().thePlayer, Action.START_SNEAKING, 0));
	}
}
