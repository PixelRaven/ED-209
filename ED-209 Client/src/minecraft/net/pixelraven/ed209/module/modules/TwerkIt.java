package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class TwerkIt extends Module{
	public int tick = 0;
	public int twerkInterval = 3;
	
	public TwerkIt() {
		super("Twerk It", Category.PLAYER);
		setUsage("TwerkIt();");
		setBlockedState(0);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		tick ++;
		if(tick%twerkInterval*2 <= twerkInterval)
			Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = true;
		else
			Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = false;
	}

	public void onDisable() {
		Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = false;
	}
}
