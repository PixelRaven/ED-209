package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class NoFall extends Module{
	public NoFall() {
		super("No Fall", Category.PLAYER);
		setUsage("NoFall();");
		setBlockedState(1);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C05PacketPlayerLook(5, 5, true));
		if(Minecraft.getMinecraft().thePlayer.fallDistance > 2F) {
			Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
		}
	}
}
