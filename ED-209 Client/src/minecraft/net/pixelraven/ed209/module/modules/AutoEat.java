package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class AutoEat extends Module{
	public AutoEat() {
		super("Auto Eat", Category.PLAYER);
		setUsage("AutoEat();");
		setBlockedState(1);
	}
	
	public void onUpdate() {
		if(!this.getToggled())
			return;
		
		if(Minecraft.getMinecraft().thePlayer.getFoodStats().needFood() && !Minecraft.getMinecraft().thePlayer.isEating()) {
			for(ItemStack i : Minecraft.getMinecraft().thePlayer.getInventory()) {
				//if(i) {
				//	Minecraft.getMinecraft().thePlayer.setCurrentItemOrArmor(0, i);
				//	Minecraft.getMinecraft().thePlayer.setEating(true);
				//	break;
				//	Minecraft.getMinecraft().thePlayer.isInWater();
				//}
			}
		}
	}
}
