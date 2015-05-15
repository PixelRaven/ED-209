package net.pixelraven.ed209.utils;

import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.module.ModuleManager;

public class ModuleColourUtil {
	public float getBlueFromModuleName(String name) {
		for(final Module module : ModuleManager.activeModules) {
			if (module.getName().equals(name)) {
				return module.getToggled() ? 1F : 0F;
			}
		}
		return 0F;
	}

	public float getGreenFromModuleName(String name) {
		for(final Module module : ModuleManager.activeModules) {
			if (module.getName().equals(name)) {
				return module.getToggled() ? 1F : 0F;
			}
		}
		return 0F;
	}
}
