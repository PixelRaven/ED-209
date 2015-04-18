package net.minecraft.client.renderer.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL12;

public class TextureUtil
{
    private static final Logger logger = LogManager.getLogger();
    private static final IntBuffer dataBuffer = GLAllocation.createDirectIntBuffer(4194304);
    public static final DynamicTexture missingTexture = new DynamicTexture(16, 16);
    public static final int[] missingTextureData = missingTexture.getTextureData();
    private static int field_147958_e = -1;
    private static int field_147956_f = -1;
    private static float field_152779_g = -1.0F;
    private static final int[] field_147957_g;
    private static final String __OBFID = "CL_00001067";

    public static int glGenTextures()
    {
        return GL11.glGenTextures();
    }

    public static void deleteTexture(int p_147942_0_)
    {
        GL11.glDeleteTextures(p_147942_0_);
    }

    public static int uploadTextureImage(int p_110987_0_, BufferedImage p_110987_1_)
    {
        return uploadTextureImageAllocate(p_110987_0_, p_110987_1_, false, false);
    }

    public static void uploadTexture(int p_110988_0_, int[] p_110988_1_, int p_110988_2_, int p_110988_3_)
    {
        bindTexture(p_110988_0_);
        func_147947_a(0, p_110988_1_, p_110988_2_, p_110988_3_, 0, 0, false, false, false);
    }

    public static int[][] func_147949_a(int p_147949_0_, int p_147949_1_, int[][] p_147949_2_)
    {
        int[][] var3 = new int[p_147949_0_ + 1][];
        var3[0] = p_147949_2_[0];

        if (p_147949_0_ > 0)
        {
            boolean var4 = false;
            int var5;

            for (var5 = 0; var5 < p_147949_2_.length; ++var5)
            {
                if (p_147949_2_[0][var5] >> 24 == 0)
                {
                    var4 = true;
                    break;
                }
            }

            for (var5 = 1; var5 <= p_147949_0_; ++var5)
            {
                if (p_147949_2_[var5] != null)
                {
                    var3[var5] = p_147949_2_[var5];
                }
                else
                {
                    int[] var6 = var3[var5 - 1];
                    int[] var7 = new int[var6.length >> 2];
                    int var8 = p_147949_1_ >> var5;
                    int var9 = var7.length / var8;
                    int var10 = var8 << 1;

                    for (int var11 = 0; var11 < var8; ++var11)
                    {
                        for (int var12 = 0; var12 < var9; ++var12)
                        {
                            int var13 = 2 * (var11 + var12 * var10);
                            var7[var11 + var12 * var8] = func_147943_a(var6[var13 + 0], var6[var13 + 1], var6[var13 + 0 + var10], var6[var13 + 1 + var10], var4);
                        }
                    }

                    var3[var5] = var7;
                }
            }
        }

        return var3;
    }

    private static int func_147943_a(int p_147943_0_, int p_147943_1_, int p_147943_2_, int p_147943_3_, boolean p_147943_4_)
    {
        if (!p_147943_4_)
        {
            int var13 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 24);
            int var14 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 16);
            int var15 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 8);
            int var16 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 0);
            return var13 << 24 | var14 << 16 | var15 << 8 | var16;
        }
        else
        {
            field_147957_g[0] = p_147943_0_;
            field_147957_g[1] = p_147943_1_;
            field_147957_g[2] = p_147943_2_;
            field_147957_g[3] = p_147943_3_;
            float var5 = 0.0F;
            float var6 = 0.0F;
            float var7 = 0.0F;
            float var8 = 0.0F;
            int var9;

            for (var9 = 0; var9 < 4; ++var9)
            {
                if (field_147957_g[var9] >> 24 != 0)
                {
                    var5 += (float)Math.pow((double)((float)(field_147957_g[var9] >> 24 & 255) / 255.0F), 2.2D);
                    var6 += (float)Math.pow((double)((float)(field_147957_g[var9] >> 16 & 255) / 255.0F), 2.2D);
                    var7 += (float)Math.pow((double)((float)(field_147957_g[var9] >> 8 & 255) / 255.0F), 2.2D);
                    var8 += (float)Math.pow((double)((float)(field_147957_g[var9] >> 0 & 255) / 255.0F), 2.2D);
                }
            }

            var5 /= 4.0F;
            var6 /= 4.0F;
            var7 /= 4.0F;
            var8 /= 4.0F;
            var9 = (int)(Math.pow((double)var5, 0.45454545454545453D) * 255.0D);
            int var10 = (int)(Math.pow((double)var6, 0.45454545454545453D) * 255.0D);
            int var11 = (int)(Math.pow((double)var7, 0.45454545454545453D) * 255.0D);
            int var12 = (int)(Math.pow((double)var8, 0.45454545454545453D) * 255.0D);

            if (var9 < 96)
            {
                var9 = 0;
            }

            return var9 << 24 | var10 << 16 | var11 << 8 | var12;
        }
    }

    private static int func_147944_a(int p_147944_0_, int p_147944_1_, int p_147944_2_, int p_147944_3_, int p_147944_4_)
    {
        float var5 = (float)Math.pow((double)((float)(p_147944_0_ >> p_147944_4_ & 255) / 255.0F), 2.2D);
        float var6 = (float)Math.pow((double)((float)(p_147944_1_ >> p_147944_4_ & 255) / 255.0F), 2.2D);
        float var7 = (float)Math.pow((double)((float)(p_147944_2_ >> p_147944_4_ & 255) / 255.0F), 2.2D);
        float var8 = (float)Math.pow((double)((float)(p_147944_3_ >> p_147944_4_ & 255) / 255.0F), 2.2D);
        float var9 = (float)Math.pow((double)(var5 + var6 + var7 + var8) * 0.25D, 0.45454545454545453D);
        return (int)((double)var9 * 255.0D);
    }

    public static void func_147955_a(int[][] p_147955_0_, int p_147955_1_, int p_147955_2_, int p_147955_3_, int p_147955_4_, boolean p_147955_5_, boolean p_147955_6_)
    {
        for (int var7 = 0; var7 < p_147955_0_.length; ++var7)
        {
            int[] var8 = p_147955_0_[var7];
            func_147947_a(var7, var8, p_147955_1_ >> var7, p_147955_2_ >> var7, p_147955_3_ >> var7, p_147955_4_ >> var7, p_147955_5_, p_147955_6_, p_147955_0_.length > 1);
        }
    }

    private static void func_147947_a(int p_147947_0_, int[] p_147947_1_, int p_147947_2_, int p_147947_3_, int p_147947_4_, int p_147947_5_, boolean p_147947_6_, boolean p_147947_7_, boolean p_147947_8_)
    {
        int var9 = 4194304 / p_147947_2_;
        func_147954_b(p_147947_6_, p_147947_8_);
        setTextureClamped(p_147947_7_);
        int var12;

        for (int var10 = 0; var10 < p_147947_2_ * p_147947_3_; var10 += p_147947_2_ * var12)
        {
            int var11 = var10 / p_147947_2_;
            var12 = Math.min(var9, p_147947_3_ - var11);
            int var13 = p_147947_2_ * var12;
            copyToBufferPos(p_147947_1_, var10, var13);
            GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, p_147947_0_, p_147947_4_, p_147947_5_ + var11, p_147947_2_, var12, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, dataBuffer);
        }
    }

    public static int uploadTextureImageAllocate(int p_110989_0_, BufferedImage p_110989_1_, boolean p_110989_2_, boolean p_110989_3_)
    {
        allocateTexture(p_110989_0_, p_110989_1_.getWidth(), p_110989_1_.getHeight());
        return uploadTextureImageSub(p_110989_0_, p_110989_1_, 0, 0, p_110989_2_, p_110989_3_);
    }

    public static void allocateTexture(int p_110991_0_, int p_110991_1_, int p_110991_2_)
    {
        func_147946_a(p_110991_0_, 0, p_110991_1_, p_110991_2_, 1.0F);
    }

    public static void func_147946_a(int p_147946_0_, int p_147946_1_, int p_147946_2_, int p_147946_3_, float p_147946_4_)
    {
        deleteTexture(p_147946_0_);
        bindTexture(p_147946_0_);

        if (OpenGlHelper.anisotropicFilteringSupported)
        {
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, 34046, p_147946_4_);
        }

        if (p_147946_1_ > 0)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL12.GL_TEXTURE_MAX_LEVEL, p_147946_1_);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL12.GL_TEXTURE_MIN_LOD, 0.0F);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL12.GL_TEXTURE_MAX_LOD, (float)p_147946_1_);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL14.GL_TEXTURE_LOD_BIAS, 0.0F);
        }

        for (int var5 = 0; var5 <= p_147946_1_; ++var5)
        {
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D, var5, GL11.GL_RGBA, p_147946_2_ >> var5, p_147946_3_ >> var5, 0, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, (IntBuffer)null);
        }
    }

    public static int uploadTextureImageSub(int p_110995_0_, BufferedImage p_110995_1_, int p_110995_2_, int p_110995_3_, boolean p_110995_4_, boolean p_110995_5_)
    {
        bindTexture(p_110995_0_);
        uploadTextureImageSubImpl(p_110995_1_, p_110995_2_, p_110995_3_, p_110995_4_, p_110995_5_);
        return p_110995_0_;
    }

    private static void uploadTextureImageSubImpl(BufferedImage p_110993_0_, int p_110993_1_, int p_110993_2_, boolean p_110993_3_, boolean p_110993_4_)
    {
        int var5 = p_110993_0_.getWidth();
        int var6 = p_110993_0_.getHeight();
        int var7 = 4194304 / var5;
        int[] var8 = new int[var7 * var5];
        func_147951_b(p_110993_3_);
        setTextureClamped(p_110993_4_);

        for (int var9 = 0; var9 < var5 * var6; var9 += var5 * var7)
        {
            int var10 = var9 / var5;
            int var11 = Math.min(var7, var6 - var10);
            int var12 = var5 * var11;
            p_110993_0_.getRGB(0, var10, var5, var11, var8, 0, var5);
            copyToBuffer(var8, var12);
            GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, 0, p_110993_1_, p_110993_2_ + var10, var5, var11, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, dataBuffer);
        }
    }

    private static void setTextureClamped(boolean p_110997_0_)
    {
        if (p_110997_0_)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
        }
        else
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
        }
    }

    private static void func_147951_b(boolean p_147951_0_)
    {
        func_147954_b(p_147951_0_, false);
    }

    public static void func_152777_a(boolean p_152777_0_, boolean p_152777_1_, float p_152777_2_)
    {
        field_147958_e = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER);
        field_147956_f = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER);
        field_152779_g = GL11.glGetTexParameterf(GL11.GL_TEXTURE_2D, 34046);
        func_147954_b(p_152777_0_, p_152777_1_);
        func_152778_a(p_152777_2_);
    }

    public static void func_147945_b()
    {
        if (field_147958_e >= 0 && field_147956_f >= 0 && field_152779_g >= 0.0F)
        {
            func_147952_b(field_147958_e, field_147956_f);
            func_152778_a(field_152779_g);
            field_152779_g = -1.0F;
            field_147958_e = -1;
            field_147956_f = -1;
        }
    }

    private static void func_147952_b(int p_147952_0_, int p_147952_1_)
    {
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, p_147952_0_);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, p_147952_1_);
    }

    private static void func_152778_a(float p_152778_0_)
    {
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, 34046, p_152778_0_);
    }

    private static void func_147954_b(boolean p_147954_0_, boolean p_147954_1_)
    {
        if (p_147954_0_)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, p_147954_1_ ? GL11.GL_LINEAR_MIPMAP_LINEAR : GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        }
        else
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, p_147954_1_ ? GL11.GL_NEAREST_MIPMAP_LINEAR : GL11.GL_NEAREST);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        }
    }

    private static void copyToBuffer(int[] p_110990_0_, int p_110990_1_)
    {
        copyToBufferPos(p_110990_0_, 0, p_110990_1_);
    }

    private static void copyToBufferPos(int[] p_110994_0_, int p_110994_1_, int p_110994_2_)
    {
        int[] var3 = p_110994_0_;

        if (Minecraft.getMinecraft().gameSettings.anaglyph)
        {
            var3 = updateAnaglyph(p_110994_0_);
        }

        dataBuffer.clear();
        dataBuffer.put(var3, p_110994_1_, p_110994_2_);
        dataBuffer.position(0).limit(p_110994_2_);
    }

    static void bindTexture(int p_94277_0_)
    {
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, p_94277_0_);
    }

    public static int[] readImageData(IResourceManager p_110986_0_, ResourceLocation p_110986_1_) throws IOException
    {
        BufferedImage var2 = ImageIO.read(p_110986_0_.getResource(p_110986_1_).getInputStream());
        int var3 = var2.getWidth();
        int var4 = var2.getHeight();
        int[] var5 = new int[var3 * var4];
        var2.getRGB(0, 0, var3, var4, var5, 0, var3);
        return var5;
    }

    public static int[] updateAnaglyph(int[] p_110985_0_)
    {
        int[] var1 = new int[p_110985_0_.length];

        for (int var2 = 0; var2 < p_110985_0_.length; ++var2)
        {
            int var3 = p_110985_0_[var2] >> 24 & 255;
            int var4 = p_110985_0_[var2] >> 16 & 255;
            int var5 = p_110985_0_[var2] >> 8 & 255;
            int var6 = p_110985_0_[var2] & 255;
            int var7 = (var4 * 30 + var5 * 59 + var6 * 11) / 100;
            int var8 = (var4 * 30 + var5 * 70) / 100;
            int var9 = (var4 * 30 + var6 * 70) / 100;
            var1[var2] = var3 << 24 | var7 << 16 | var8 << 8 | var9;
        }

        return var1;
    }

    public static int[] func_147948_a(int[] p_147948_0_, int p_147948_1_, int p_147948_2_, int p_147948_3_)
    {
        int var4 = p_147948_1_ + 2 * p_147948_3_;
        int var5;
        int var6;

        for (var5 = p_147948_2_ - 1; var5 >= 0; --var5)
        {
            var6 = var5 * p_147948_1_;
            int var7 = p_147948_3_ + (var5 + p_147948_3_) * var4;
            int var8;

            for (var8 = 0; var8 < p_147948_3_; var8 += p_147948_1_)
            {
                int var9 = Math.min(p_147948_1_, p_147948_3_ - var8);
                System.arraycopy(p_147948_0_, var6 + p_147948_1_ - var9, p_147948_0_, var7 - var8 - var9, var9);
            }

            System.arraycopy(p_147948_0_, var6, p_147948_0_, var7, p_147948_1_);

            for (var8 = 0; var8 < p_147948_3_; var8 += p_147948_1_)
            {
                System.arraycopy(p_147948_0_, var6, p_147948_0_, var7 + p_147948_1_ + var8, Math.min(p_147948_1_, p_147948_3_ - var8));
            }
        }

        for (var5 = 0; var5 < p_147948_3_; var5 += p_147948_2_)
        {
            var6 = Math.min(p_147948_2_, p_147948_3_ - var5);
            System.arraycopy(p_147948_0_, (p_147948_3_ + p_147948_2_ - var6) * var4, p_147948_0_, (p_147948_3_ - var5 - var6) * var4, var4 * var6);
        }

        for (var5 = 0; var5 < p_147948_3_; var5 += p_147948_2_)
        {
            var6 = Math.min(p_147948_2_, p_147948_3_ - var5);
            System.arraycopy(p_147948_0_, p_147948_3_ * var4, p_147948_0_, (p_147948_2_ + p_147948_3_ + var5) * var4, var4 * var6);
        }

        return p_147948_0_;
    }

    public static void func_147953_a(int[] p_147953_0_, int p_147953_1_, int p_147953_2_)
    {
        int[] var3 = new int[p_147953_1_];
        int var4 = p_147953_2_ / 2;

        for (int var5 = 0; var5 < var4; ++var5)
        {
            System.arraycopy(p_147953_0_, var5 * p_147953_1_, var3, 0, p_147953_1_);
            System.arraycopy(p_147953_0_, (p_147953_2_ - 1 - var5) * p_147953_1_, p_147953_0_, var5 * p_147953_1_, p_147953_1_);
            System.arraycopy(var3, 0, p_147953_0_, (p_147953_2_ - 1 - var5) * p_147953_1_, p_147953_1_);
        }
    }

    static
    {
        int var0 = -16777216;
        int var1 = -524040;
        int[] var2 = new int[] { -524040, -524040, -524040, -524040, -524040, -524040, -524040, -524040};
        int[] var3 = new int[] { -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216};
        int var4 = var2.length;

        for (int var5 = 0; var5 < 16; ++var5)
        {
            System.arraycopy(var5 < var4 ? var2 : var3, 0, missingTextureData, 16 * var5, var4);
            System.arraycopy(var5 < var4 ? var3 : var2, 0, missingTextureData, 16 * var5 + var4, var4);
        }

        missingTexture.updateDynamicTexture();
        field_147957_g = new int[4];
    }
}
