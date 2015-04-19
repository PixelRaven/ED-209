package net.pixelraven.ed209;
import net.pixelraven.ed209.module.ModuleManager;
import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;

public class ED209 {
	public String CLIENT_NAME = "Disconnected";
	public int CLIENT_VERSION = 5;
	public float CLIENT_PRETTYVERSION = 0.7F;
	public ModuleManager moduleManager;
	public ClientGuiManager guiManager;
	public static final ED209 ED = new ED209();
	private int theProtocol = 4;
	
	public void startClient() {
		System.out.println("Client Disconnected launched successfully");
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