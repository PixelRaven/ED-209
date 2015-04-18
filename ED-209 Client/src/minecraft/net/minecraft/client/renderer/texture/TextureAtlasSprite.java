package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.client.resources.data.AnimationFrame;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.IIcon;
import net.minecraft.util.ReportedException;

public class TextureAtlasSprite implements IIcon
{
    private final String iconName;
    protected List framesTextureData = Lists.newArrayList();
    private AnimationMetadataSection animationMetadata;
    protected boolean rotated;
    private boolean field_147966_k;
    protected int originX;
    protected int originY;
    protected int width;
    protected int height;
    private float minU;
    private float maxU;
    private float minV;
    private float maxV;
    protected int frameCounter;
    protected int tickCounter;
    private static final String __OBFID = "CL_00001062";

    protected TextureAtlasSprite(String p_i1282_1_)
    {
        this.iconName = p_i1282_1_;
    }

    public void initSprite(int p_110971_1_, int p_110971_2_, int p_110971_3_, int p_110971_4_, boolean p_110971_5_)
    {
        this.originX = p_110971_3_;
        this.originY = p_110971_4_;
        this.rotated = p_110971_5_;
        float var6 = (float)(0.009999999776482582D / (double)p_110971_1_);
        float var7 = (float)(0.009999999776482582D / (double)p_110971_2_);
        this.minU = (float)p_110971_3_ / (float)((double)p_110971_1_) + var6;
        this.maxU = (float)(p_110971_3_ + this.width) / (float)((double)p_110971_1_) - var6;
        this.minV = (float)p_110971_4_ / (float)p_110971_2_ + var7;
        this.maxV = (float)(p_110971_4_ + this.height) / (float)p_110971_2_ - var7;

        if (this.field_147966_k)
        {
            float var8 = 8.0F / (float)p_110971_1_;
            float var9 = 8.0F / (float)p_110971_2_;
            this.minU += var8;
            this.maxU -= var8;
            this.minV += var9;
            this.maxV -= var9;
        }
    }

    public void copyFrom(TextureAtlasSprite p_94217_1_)
    {
        this.originX = p_94217_1_.originX;
        this.originY = p_94217_1_.originY;
        this.width = p_94217_1_.width;
        this.height = p_94217_1_.height;
        this.rotated = p_94217_1_.rotated;
        this.minU = p_94217_1_.minU;
        this.maxU = p_94217_1_.maxU;
        this.minV = p_94217_1_.minV;
        this.maxV = p_94217_1_.maxV;
    }

    /**
     * Returns the X position of this icon on its texture sheet, in pixels.
     */
    public int getOriginX()
    {
        return this.originX;
    }

    /**
     * Returns the Y position of this icon on its texture sheet, in pixels.
     */
    public int getOriginY()
    {
        return this.originY;
    }

    /**
     * Returns the width of the icon, in pixels.
     */
    public int getIconWidth()
    {
        return this.width;
    }

    /**
     * Returns the height of the icon, in pixels.
     */
    public int getIconHeight()
    {
        return this.height;
    }

    /**
     * Returns the minimum U coordinate to use when rendering with this icon.
     */
    public float getMinU()
    {
        return this.minU;
    }

    /**
     * Returns the maximum U coordinate to use when rendering with this icon.
     */
    public float getMaxU()
    {
        return this.maxU;
    }

    /**
     * Gets a U coordinate on the icon. 0 returns uMin and 16 returns uMax. Other arguments return in-between values.
     */
    public float getInterpolatedU(double p_94214_1_)
    {
        float var3 = this.maxU - this.minU;
        return this.minU + var3 * (float)p_94214_1_ / 16.0F;
    }

    /**
     * Returns the minimum V coordinate to use when rendering with this icon.
     */
    public float getMinV()
    {
        return this.minV;
    }

    /**
     * Returns the maximum V coordinate to use when rendering with this icon.
     */
    public float getMaxV()
    {
        return this.maxV;
    }

    /**
     * Gets a V coordinate on the icon. 0 returns vMin and 16 returns vMax. Other arguments return in-between values.
     */
    public float getInterpolatedV(double p_94207_1_)
    {
        float var3 = this.maxV - this.minV;
        return this.minV + var3 * ((float)p_94207_1_ / 16.0F);
    }

    public String getIconName()
    {
        return this.iconName;
    }

    public void updateAnimation()
    {
        ++this.tickCounter;

        if (this.tickCounter >= this.animationMetadata.getFrameTimeSingle(this.frameCounter))
        {
            int var1 = this.animationMetadata.getFrameIndex(this.frameCounter);
            int var2 = this.animationMetadata.getFrameCount() == 0 ? this.framesTextureData.size() : this.animationMetadata.getFrameCount();
            this.frameCounter = (this.frameCounter + 1) % var2;
            this.tickCounter = 0;
            int var3 = this.animationMetadata.getFrameIndex(this.frameCounter);

            if (var1 != var3 && var3 >= 0 && var3 < this.framesTextureData.size())
            {
                TextureUtil.func_147955_a((int[][])this.framesTextureData.get(var3), this.width, this.height, this.originX, this.originY, false, false);
            }
        }
    }

    public int[][] func_147965_a(int p_147965_1_)
    {
        return (int[][])this.framesTextureData.get(p_147965_1_);
    }

    public int getFrameCount()
    {
        return this.framesTextureData.size();
    }

    public void setIconWidth(int p_110966_1_)
    {
        this.width = p_110966_1_;
    }

    public void setIconHeight(int p_110969_1_)
    {
        this.height = p_110969_1_;
    }

    public void func_147964_a(BufferedImage[] p_147964_1_, AnimationMetadataSection p_147964_2_, boolean p_147964_3_)
    {
        this.resetSprite();
        this.field_147966_k = p_147964_3_;
        int var4 = p_147964_1_[0].getWidth();
        int var5 = p_147964_1_[0].getHeight();
        this.width = var4;
        this.height = var5;

        if (p_147964_3_)
        {
            this.width += 16;
            this.height += 16;
        }

        int[][] var6 = new int[p_147964_1_.length][];
        int var7;

        for (var7 = 0; var7 < p_147964_1_.length; ++var7)
        {
            BufferedImage var8 = p_147964_1_[var7];

            if (var8 != null)
            {
                if (var7 > 0 && (var8.getWidth() != var4 >> var7 || var8.getHeight() != var5 >> var7))
                {
                    throw new RuntimeException(String.format("Unable to load miplevel: %d, image is size: %dx%d, expected %dx%d", new Object[] {Integer.valueOf(var7), Integer.valueOf(var8.getWidth()), Integer.valueOf(var8.getHeight()), Integer.valueOf(var4 >> var7), Integer.valueOf(var5 >> var7)}));
                }

                var6[var7] = new int[var8.getWidth() * var8.getHeight()];
                var8.getRGB(0, 0, var8.getWidth(), var8.getHeight(), var6[var7], 0, var8.getWidth());
            }
        }

        if (p_147964_2_ == null)
        {
            if (var5 != var4)
            {
                throw new RuntimeException("broken aspect ratio and not an animation");
            }

            this.func_147961_a(var6);
            this.framesTextureData.add(this.func_147960_a(var6, var4, var5));
        }
        else
        {
            var7 = var5 / var4;
            int var12 = var4;
            int var9 = var4;
            this.height = this.width;
            int var11;

            if (p_147964_2_.getFrameCount() > 0)
            {
                Iterator var10 = p_147964_2_.getFrameIndexSet().iterator();

                while (var10.hasNext())
                {
                    var11 = ((Integer)var10.next()).intValue();

                    if (var11 >= var7)
                    {
                        throw new RuntimeException("invalid frameindex " + var11);
                    }

                    this.allocateFrameTextureData(var11);
                    this.framesTextureData.set(var11, this.func_147960_a(func_147962_a(var6, var12, var9, var11), var12, var9));
                }

                this.animationMetadata = p_147964_2_;
            }
            else
            {
                ArrayList var13 = Lists.newArrayList();

                for (var11 = 0; var11 < var7; ++var11)
                {
                    this.framesTextureData.add(this.func_147960_a(func_147962_a(var6, var12, var9, var11), var12, var9));
                    var13.add(new AnimationFrame(var11, -1));
                }

                this.animationMetadata = new AnimationMetadataSection(var13, this.width, this.height, p_147964_2_.getFrameTime());
            }
        }
    }

    public void func_147963_d(int p_147963_1_)
    {
        ArrayList var2 = Lists.newArrayList();

        for (int var3 = 0; var3 < this.framesTextureData.size(); ++var3)
        {
            final int[][] var4 = (int[][])this.framesTextureData.get(var3);

            if (var4 != null)
            {
                try
                {
                    var2.add(TextureUtil.func_147949_a(p_147963_1_, this.width, var4));
                }
                catch (Throwable var8)
                {
                    CrashReport var6 = CrashReport.makeCrashReport(var8, "Generating mipmaps for frame");
                    CrashReportCategory var7 = var6.makeCategory("Frame being iterated");
                    var7.addCrashSection("Frame index", Integer.valueOf(var3));
                    var7.addCrashSectionCallable("Frame sizes", new Callable()
                    {
                        private static final String __OBFID = "CL_00001063";
                        public String call()
                        {
                            StringBuilder var1 = new StringBuilder();
                            int[][] var2 = var4;
                            int var3 = var2.length;

                            for (int var4x = 0; var4x < var3; ++var4x)
                            {
                                int[] var5 = var2[var4x];

                                if (var1.length() > 0)
                                {
                                    var1.append(", ");
                                }

                                var1.append(var5 == null ? "null" : Integer.valueOf(var5.length));
                            }

                            return var1.toString();
                        }
                    });
                    throw new ReportedException(var6);
                }
            }
        }

        this.setFramesTextureData(var2);
    }

    private void func_147961_a(int[][] p_147961_1_)
    {
        int[] var2 = p_147961_1_[0];
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;
        int var7;

        for (var7 = 0; var7 < var2.length; ++var7)
        {
            if ((var2[var7] & -16777216) != 0)
            {
                var4 += var2[var7] >> 16 & 255;
                var5 += var2[var7] >> 8 & 255;
                var6 += var2[var7] >> 0 & 255;
                ++var3;
            }
        }

        if (var3 != 0)
        {
            var4 /= var3;
            var5 /= var3;
            var6 /= var3;

            for (var7 = 0; var7 < var2.length; ++var7)
            {
                if ((var2[var7] & -16777216) == 0)
                {
                    var2[var7] = var4 << 16 | var5 << 8 | var6;
                }
            }
        }
    }

    private int[][] func_147960_a(int[][] p_147960_1_, int p_147960_2_, int p_147960_3_)
    {
        if (!this.field_147966_k)
        {
            return p_147960_1_;
        }
        else
        {
            int[][] var4 = new int[p_147960_1_.length][];

            for (int var5 = 0; var5 < p_147960_1_.length; ++var5)
            {
                int[] var6 = p_147960_1_[var5];

                if (var6 != null)
                {
                    int[] var7 = new int[(p_147960_2_ + 16 >> var5) * (p_147960_3_ + 16 >> var5)];
                    System.arraycopy(var6, 0, var7, 0, var6.length);
                    var4[var5] = TextureUtil.func_147948_a(var7, p_147960_2_ >> var5, p_147960_3_ >> var5, 8 >> var5);
                }
            }

            return var4;
        }
    }

    private void allocateFrameTextureData(int p_130099_1_)
    {
        if (this.framesTextureData.size() <= p_130099_1_)
        {
            for (int var2 = this.framesTextureData.size(); var2 <= p_130099_1_; ++var2)
            {
                this.framesTextureData.add((Object)null);
            }
        }
    }

    private static int[][] func_147962_a(int[][] p_147962_0_, int p_147962_1_, int p_147962_2_, int p_147962_3_)
    {
        int[][] var4 = new int[p_147962_0_.length][];

        for (int var5 = 0; var5 < p_147962_0_.length; ++var5)
        {
            int[] var6 = p_147962_0_[var5];

            if (var6 != null)
            {
                var4[var5] = new int[(p_147962_1_ >> var5) * (p_147962_2_ >> var5)];
                System.arraycopy(var6, p_147962_3_ * var4[var5].length, var4[var5], 0, var4[var5].length);
            }
        }

        return var4;
    }

    public void clearFramesTextureData()
    {
        this.framesTextureData.clear();
    }

    public boolean hasAnimationMetadata()
    {
        return this.animationMetadata != null;
    }

    public void setFramesTextureData(List p_110968_1_)
    {
        this.framesTextureData = p_110968_1_;
    }

    private void resetSprite()
    {
        this.animationMetadata = null;
        this.setFramesTextureData(Lists.newArrayList());
        this.frameCounter = 0;
        this.tickCounter = 0;
    }

    public String toString()
    {
        return "TextureAtlasSprite{name=\'" + this.iconName + '\'' + ", frameCount=" + this.framesTextureData.size() + ", rotated=" + this.rotated + ", x=" + this.originX + ", y=" + this.originY + ", height=" + this.height + ", width=" + this.width + ", u0=" + this.minU + ", u1=" + this.maxU + ", v0=" + this.minV + ", v1=" + this.maxV + '}';
    }
}
