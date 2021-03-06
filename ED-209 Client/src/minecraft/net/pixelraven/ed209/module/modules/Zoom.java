package net.pixelraven.ed209.module.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;

public class Zoom extends Module{
	int amount;
	
	public Zoom() {
		super("Zoom", Category.RENDER);
		setUsage("Zoom(int [AMOUNT]);");
		setBlockedState(3);
	}
	
	public void onUpdate() {
		onUpdate(15);
	}
	
	public void onUpdate(int amount) {
		this.amount = amount;
		
		if(!this.getToggled()) {
			if(Minecraft.getMinecraft().entityRenderer.cameraZoom > 1) {
				Minecraft.getMinecraft().entityRenderer.cameraZoom -= 1;
			}
			
			if(Minecraft.getMinecraft().entityRenderer.cameraZoom < 1) {
				Minecraft.getMinecraft().entityRenderer.cameraZoom = 1;
			}
			return;
		}
		
		if(Minecraft.getMinecraft().entityRenderer.cameraZoom < amount) {
			Minecraft.getMinecraft().entityRenderer.cameraZoom += 1;		
		}
		
		if(Minecraft.getMinecraft().entityRenderer.cameraZoom > amount) {
			Minecraft.getMinecraft().entityRenderer.cameraZoom = amount;
		}
	}
	
	public void onEnable() {
		Minecraft.getMinecraft().gameSettings.smoothCamera = true;
	}
	
	public void onDisable() {
		Minecraft.getMinecraft().gameSettings.smoothCamera = false;
	}
}
