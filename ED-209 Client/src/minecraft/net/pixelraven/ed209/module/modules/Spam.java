package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C01PacketChatMessage;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Spam extends Module{

	public Spam() {
		super("Spam", Category.MISC);
		setUseType(1);
		setUsage("Spam(String [TEXT], int [TIMES]);");
		setBlockedState(2);
	}

	public void onUse() {
		onUse("Hello!", 3);
	}
	
	public void onUse(String text, int times) {
		for(int i = 0; i < times; i++) {
			Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(text));
		}
	}
}
