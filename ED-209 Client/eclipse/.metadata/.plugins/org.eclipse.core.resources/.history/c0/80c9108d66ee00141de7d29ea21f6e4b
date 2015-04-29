package net.pixelraven.ed209.module.modules;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;

import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.input.Keyboard;

import net.pixelraven.ed209.ED209;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class ClickGui extends Module{
	static int colour = 1;
	
	public ClickGui() {
		super("ED-209 Gui", Category.NONE);
		setBind(Keyboard.KEY_LCONTROL);
		setUsage("ClickGui();");
	}
	
	public void onToggle() {
	System.out.println("Toggle Click GUI");
		if(!(Minecraft.getMinecraft().currentScreen instanceof GuiManagerDisplayScreen))
			Minecraft.getMinecraft().displayGuiScreen(new GuiManagerDisplayScreen(ED209.guiManager));
	}
}