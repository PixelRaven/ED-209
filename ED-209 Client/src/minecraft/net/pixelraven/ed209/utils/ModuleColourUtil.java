package net.pixelraven.ed209.utils;

import net.pixelraven.ed209.ED209;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.module.ModuleManager;
import net.pixelraven.ed209.ui.ThemeStyle;

public class ModuleColourUtil {
	public float getRedFromModuleName(String name) {
		for(final Module module : ModuleManager.activeModules) {
			if (module.getName().equals(name)) {
				return module.getToggled() ? ED209.ED.themeStyle.getEnabledColour().getRed()/255 :  ED209.ED.themeStyle.getDisabledColour().getRed()/255;
			}
		}
		return 0F;
	}

	public float getGreenFromModuleName(String name) {
		for(final Module module : ModuleManager.activeModules) {
			if (module.getName().equals(name)) {
				return module.getToggled() ? ED209.ED.themeStyle.getEnabledColour().getGreen()/255 :  ED209.ED.themeStyle.getDisabledColour().getGreen()/255;
			}
		}
		return 0F;
	}

	public float getBlueFromModuleName(String name) {
		for(final Module module : ModuleManager.activeModules) {
			if (module.getName().equals(name)) {
				return module.getToggled() ? ED209.ED.themeStyle.getEnabledColour().getBlue()/255 :  ED209.ED.themeStyle.getDisabledColour().getBlue()/255;
			}
		}
		return 0F;
	}
}
