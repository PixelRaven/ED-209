package net.pixelraven.ed209.utils;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class CategoryCountUtils {
	public static int getCount(Category category) {
		int amount = 0;
		
		for(final Module module : net.pixelraven.ed209.moduleManager.activeModules) {
			if (module.getCategory() == category)
				amount ++;
		}
		
		return amount;
	}
}