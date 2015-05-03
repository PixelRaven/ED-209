package net.pixelraven.ed209.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import org.lwjgl.opengl.GL11;

import net.pixelraven.ed209.module.Category;
import net.pixelraven.ed209.module.Module;
import net.pixelraven.ed209.utils.DistUtil;
import net.pixelraven.ed209.utils.PlayerVars;

public class MobESP extends Module{
    WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
    public MobESP() {
		super("Mob ESP", Category.RENDER);
	}
	
	public void onRender(float par1) {
		if(!this.getToggled())
			return;
		
		for(Object o : Minecraft.getMinecraft().theWorld.loadedEntityList) {
        	if(o instanceof EntityLiving) {
        		render(0, o);
        	}
        } 
	}
	
	public void render(float par1, Object o) {
		Entity e = (Entity) o;
		double lastX = PlayerVars.getLastX(), lastY = PlayerVars.getLastY(), lastZ = PlayerVars.getLastZ();
    	double thisX = PlayerVars.getX(), thisY = PlayerVars.getY(), thisZ = PlayerVars.getZ();
        
		double x = lastX + (thisX - lastX) * par1;
        double y = lastY + (thisY - lastY) * par1;
        double z = lastZ + (thisZ - lastZ) * par1;
        double eX = e.lastTickPosX + (e.posX - e.lastTickPosX) * par1;
        double eY = e.lastTickPosY + (e.posY - e.lastTickPosY) * par1;
        double eZ = e.lastTickPosZ + (e.posZ - e.lastTickPosZ) * par1;
		
        double dist = DistUtil.dist(thisX, thisY, thisZ, e.posX, e.posY, e.posZ);
		//RENDER: setup
		GL11.glPushMatrix();
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        worldRenderer.setTranslation((float)(eX - x), (float)(eY - y), (float)(eZ - z));
		worldRenderer.setTranslation(-0.5F, 0F, -0.5F);
        //GL11.glLineWidth((float)((50-dist)/7.5));
        //RENDER: draw
        worldRenderer.startDrawing(3);
		//worldRenderer.setColorRGBA_F((float)(Math.min(50-dist, 50)/50), (float)(Math.min(dist-10, 50)/50), 0.0F, 1.0F);
		
		//front
		worldRenderer.addVertex(0, 0, 0);
		worldRenderer.addVertex(0, 2, 0);
		worldRenderer.addVertex(1, 2, 0);
		worldRenderer.addVertex(1, 0, 0);
		
		worldRenderer.addVertex(0, 0, 0);
		
		//back
		worldRenderer.addVertex(0, 0, 1);
		worldRenderer.addVertex(0, 2, 1);
		worldRenderer.addVertex(1, 2, 1);
		worldRenderer.addVertex(1, 0, 1);
		
		//bottom
		worldRenderer.addVertex(1, 0, 0);
		worldRenderer.addVertex(1, 0, 1);
		worldRenderer.addVertex(0, 0, 1);
		worldRenderer.addVertex(0, 0, 0);
		
		worldRenderer.addVertex(1, 0, 0);
		
		//top
		worldRenderer.addVertex(1, 2, 0);
		worldRenderer.addVertex(1, 2, 1);
		worldRenderer.addVertex(0, 2, 1);
		worldRenderer.addVertex(0, 2, 0);
		
		worldRenderer.draw();
		//RENDER: de-setup
		worldRenderer.setTranslation(-(float)(eX - x), -(float)(eY - y), -(float)(eZ - z));
		worldRenderer.setTranslation(0.5F, 0F, 0.5F);
        //GL11.glLineWidth(0);
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
	}
}
