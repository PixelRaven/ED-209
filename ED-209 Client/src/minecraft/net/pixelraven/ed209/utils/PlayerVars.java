package net.pixelraven.ed209.utils;

import net.minecraft.client.Minecraft;

public class PlayerVars {
	public static double getWalkAngle() {
		double angle = Math.atan2(Minecraft.getMinecraft().thePlayer.motionZ, Minecraft.getMinecraft().thePlayer.motionX);
		return angle;
	}
	public static double getPitchLookAngle() {
		double angle = Minecraft.getMinecraft().thePlayer.rotationPitch;
		return angle;
	}
	public static double getYawLookAngle() {
		double angle = Minecraft.getMinecraft().thePlayer.rotationYawHead;
		System.out.println(angle);
		return angle;
	}
	public static double getX() {
		return Minecraft.getMinecraft().thePlayer.posX;
	}
	public static double getY() {
		return Minecraft.getMinecraft().thePlayer.posY;
	}
	public static double getZ() {
		return Minecraft.getMinecraft().thePlayer.posZ;
	}
	public static double getLastX() {
		return Minecraft.getMinecraft().thePlayer.lastTickPosX;
	}
	public static double getLastY() {
		return Minecraft.getMinecraft().thePlayer.lastTickPosY;
	}
	public static double getLastZ() {
		return Minecraft.getMinecraft().thePlayer.lastTickPosZ;
	}
}
