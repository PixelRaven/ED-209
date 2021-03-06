package net.pixelraven.ed209.module;

import org.lwjgl.input.Keyboard;
import net.pixelraven.ed209.ui.ClientGuiManager;

public class Module {
	private String moduleName, moduleUsage = "None";
	private int moduleBind = -1, moduleUseType = 0, blockedState = -1;
	private Category moduleCategory;
	public boolean isToggled, isEnabled, changeBind;
	
	public Module(String moduleName, Category moduleCategory) {
	    this.moduleName = moduleName;
	    this.moduleCategory = moduleCategory;
	}

	public String getName() {
	    return this.moduleName;
	}
	
	public int getBind() {
	    return this.moduleBind;
	}
	
	public Category getCategory() {
	    return this.moduleCategory;
	}
	
	public boolean getToggled() {
	    return this.isToggled;
	}
	
	public int getUseType() {
		return this.moduleUseType;
	}
	
	public int getBlockedState() {
		return this.blockedState;
	}
	
	public String getUsage() {
		return this.moduleUsage;
	}
	
	public Boolean getEnabled() {
		return isEnabled;
	}
	
	public void setEnabled(Boolean newEnabled) {
		isEnabled = newEnabled;
	}
	
	public void setBlockedState(int newBlockedState) { //0 = vanilla, 1 = bukkit, 2 = ncp, 3 = client only 
		this.blockedState = newBlockedState;
	}
	
	public void setToggle(boolean shouldToggle) {
	    if(moduleUseType == 0) {
			this.onToggle();
		    if(shouldToggle) {
		    	this.onEnable();
		        this.isToggled = true;
		    }else {
		        this.onDisable();
		        this.isToggled = false;
		    }
	    }else {
	    	this.onUse();
	    	this.isToggled = false;
	    }
	}
	
	public void toggleModule() {
	    this.setToggle(!this.getToggled());
	}
	
	public void setBind(int newBind) {
	    this.moduleBind = newBind;
	}
	
	public void changeBind() {
		changeBind = !changeBind;
	}
	
	public void listenBind() {
		if(changeBind && Keyboard.getEventKeyState()) {
			setBind(Keyboard.getEventKey());
			changeBind = false;
		}
	}
	
	public void setUseType(int newUseType) {
		this.moduleUseType = newUseType;
	}
	
	public void setUsage(String newUsage) {
		this.moduleUsage = newUsage;
	}
	
	public void onToggle() {}
	
	public void onEnable() {}
	
	public void onDisable() {}
	
	public void onUpdate() {}
	
	public void onPreUpdate() {}
	
	public void onRender(float par1) {}
	
	public void onUse() {}
}