package net.pixelraven.ed209.utils;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.module.ModuleManager;

public class CategoryCountUtils {
	public static int getCount(Category category) {
		int amount = 0;
		
		for(final Module module : ModuleManager.activeModules) {
			if (module.getCategory() == category)
				amount ++;
		}
		
		return amount;
	}
}
