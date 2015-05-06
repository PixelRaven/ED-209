package net.pixelraven.ed209;
import net.pixelraven.ed209.module.ModuleManager;
import net.pixelraven.ed209.ui.ClientGuiManager;
import net.pixelraven.ed209.ui.VersionState;

import org.darkstorm.minecraft.gui.component.AbstractComponent;
import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;

public class ED209 {
	public String CLIENT_NAME = "ED-209";
	//Version stuff
	public final VersionState VERSION_STATE = VersionState.ALPHA;
	public final String VERSION_STATEPRETTY = VERSION_STATE.toString().toUpperCase().substring(0, 1);
	public final String CLIENT_MINECRAFTVERSION = "1.8";
	public final int CLIENT_PUBLICBUILD = 0;
	public final String CLIENT_PRETTYVERSION = "0.5.4";
	public final int CLIENT_VERSION = 33;
	public final String CLIENT_FULLVERSION = VERSION_STATEPRETTY + CLIENT_MINECRAFTVERSION + "." + CLIENT_PUBLICBUILD + "." + CLIENT_PRETTYVERSION + "." + CLIENT_VERSION;
	public final String CLIENT_BUILDTYPE = "@r255@g000@b000Unofficial Build";
	
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
