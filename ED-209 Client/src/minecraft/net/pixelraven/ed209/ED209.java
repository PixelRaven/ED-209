package net.pixelraven.ed209;
import net.pixelraven.ed209.module.ModuleManager;
import net.pixelraven.ed209.ui.ClientGuiManager;

import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;

public class ED209 {
	public String CLIENT_NAME = "ED-209";
	public int CLIENT_VERSION = 17;
	public String CLIENT_PRETTYVERSION = "0.3.1";
	public ModuleManager moduleManager;
	public static ClientGuiManager guiManager;
	public static final ED209 ED = new ED209();
	private int theProtocol = 4;
	
	public void startClient() {
		System.out.println("Client ED-209 launched successfully");
		this.moduleManager = new ModuleManager();
		this.guiManager = new ClientGuiManager();
		
		this.guiManager.setTheme(new SimpleTheme());
		this.guiManager.setup();
	}
	
	public int getProtocol() {
		return theProtocol;
	}
	
	public void setProtocol(int newProtocol) {
		theProtocol = newProtocol;
	}
}
