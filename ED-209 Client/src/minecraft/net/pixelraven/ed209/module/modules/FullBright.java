package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.utils.XrayUtils;

public class FullBright extends Module{

	public FullBright() {
		super("Full Bright", Category.RENDER);
		setBind(Keyboard.KEY_B);
		setUsage("FullBright();");
		setBlockedState(3);
	}
	
	public void onUpdate() {
		if(this.getToggled() || XrayUtils.isXray) {
			while(Minecraft.getMinecraft().gameSettings.gammaSetting < 100F) {
				Minecraft.getMinecraft().gameSettings.gammaSetting += 2F;
			}
		}else {
			while(Minecraft.getMinecraft().gameSettings.gammaSetting > 1F) {
				Minecraft.getMinecraft().gameSettings.gammaSetting -= 2F;
			}
		}
	}
}
