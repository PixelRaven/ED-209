package net.pixelraven.ed209.module;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.pixelraven.ed209.module.modules.Absorption;
import net.pixelraven.ed209.module.modules.AntiAFK;
import net.pixelraven.ed209.module.modules.AutoEat;
import net.pixelraven.ed209.module.modules.AutoMine;
import net.pixelraven.ed209.module.modules.AutoSpawn;
import net.pixelraven.ed209.module.modules.AutoWalk;
import net.pixelraven.ed209.module.modules.ClickAimbot;
import net.pixelraven.ed209.module.modules.ClickGui;
import net.pixelraven.ed209.module.modules.Criticals;
import net.pixelraven.ed209.module.modules.Dead;
import net.pixelraven.ed209.module.modules.Derp;
import net.pixelraven.ed209.module.modules.Disconnect;
import net.pixelraven.ed209.module.modules.Exit;
import net.pixelraven.ed209.module.modules.FastPlace;
import net.pixelraven.ed209.module.modules.FastWalk;
import net.pixelraven.ed209.module.modules.CreativeFly;
import net.pixelraven.ed209.module.modules.ForceField;
import net.pixelraven.ed209.module.modules.FullBright;
import net.pixelraven.ed209.module.modules.Glide;
import net.pixelraven.ed209.module.modules.Heal;
import net.pixelraven.ed209.module.modules.House;
import net.pixelraven.ed209.module.modules.Jesus;
import net.pixelraven.ed209.module.modules.Killaura;
import net.pixelraven.ed209.module.modules.MagicCarpet;
import net.pixelraven.ed209.module.modules.MobESP;
import net.pixelraven.ed209.module.modules.NoRain;
import net.pixelraven.ed209.module.modules.NoSwing;
import net.pixelraven.ed209.module.modules.Nuker;
import net.pixelraven.ed209.module.modules.PacketSneak;
import net.pixelraven.ed209.module.modules.Fly;
import net.pixelraven.ed209.module.modules.Regen;
import net.pixelraven.ed209.module.modules.Spam;
import net.pixelraven.ed209.module.modules.Strafe360;
import net.pixelraven.ed209.module.modules.ToggleSneak;
import net.pixelraven.ed209.module.modules.Spider;
import net.pixelraven.ed209.module.modules.Sprint;
import net.pixelraven.ed209.module.modules.Step;
import net.pixelraven.ed209.module.modules.Swim;
import net.pixelraven.ed209.module.modules.Triggerbot;
import net.pixelraven.ed209.module.modules.Umbrella;
import net.pixelraven.ed209.module.modules.Zoom;

public class ModuleManager {
	public static ArrayList<Module> activeModules = new ArrayList<Module>();

	//public Xray xrayModule;
	public static NoRain noRainModule;
	//public static EntityOverlay entityOverayModule;
	//public static MobESP MobESPModule;
	//public static BowAimBot bowAimBotModule;
	public static Jesus JesusModule;
	public static NoSwing NoSwingModule;
	
	public ModuleManager() {
		this.activeModules.add(new ClickGui());
		
		this.activeModules.add(new Absorption());
		this.activeModules.add(new AntiAFK());
		this.activeModules.add(new AutoEat());
		this.activeModules.add(new AutoMine());
		this.activeModules.add(new AutoWalk());
		this.activeModules.add(new AutoSpawn());
		this.activeModules.add(new ClickAimbot());
		this.activeModules.add(new CreativeFly());
		this.activeModules.add(new Criticals());
		this.activeModules.add(new Disconnect());
		this.activeModules.add(new Dead());
		this.activeModules.add(new Derp());
		this.activeModules.add(new Exit());
		this.activeModules.add(new FastPlace());
		this.activeModules.add(new FastWalk());
		this.activeModules.add(new Fly());
		this.activeModules.add(new ForceField());
		this.activeModules.add(new FullBright());
		this.activeModules.add(new Glide());
		this.activeModules.add(new Heal());
		this.activeModules.add(new House());
		this.activeModules.add(this.JesusModule = new Jesus());
		this.activeModules.add(new Killaura());
		this.activeModules.add(new MagicCarpet());
		this.activeModules.add(new MobESP());
		this.activeModules.add(this.noRainModule = new NoRain());
		this.activeModules.add(this.NoSwingModule = new NoSwing());
		this.activeModules.add(new Nuker());
		this.activeModules.add(new PacketSneak());
		this.activeModules.add(new Fly());
		this.activeModules.add(new Regen());
		this.activeModules.add(new Spam());
		this.activeModules.add(new Spider());
		this.activeModules.add(new Sprint());
		this.activeModules.add(new Step());
		this.activeModules.add(new Strafe360());
		this.activeModules.add(new Swim());
		this.activeModules.add(new ToggleSneak());
		this.activeModules.add(new Triggerbot());
		this.activeModules.add(new Umbrella());
		this.activeModules.add(new Zoom());
	}
}
