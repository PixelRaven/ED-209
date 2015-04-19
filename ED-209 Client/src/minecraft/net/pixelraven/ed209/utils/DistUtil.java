package net.pixelraven.ed209.utils;

public class DistUtil {
	public static double dist(double x, double y, double z, double x2, double y2, double z2) {
		return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2) + Math.pow(z2 - z, 2));
	}
}
