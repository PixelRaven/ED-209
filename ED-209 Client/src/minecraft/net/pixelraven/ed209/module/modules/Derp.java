package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Derp extends Module{
	public Derp() {
		super("Derp", Category.PLAYER);
		setUsage("Derp();");
		setBlockedState(2);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C05PacketPlayerLook((float)Math.random()*180, (float)Math.random()*360, true));
		Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0APacketAnimation());
	}
}