package net.minecraft.world;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import net.minecraft.nbt.NBTTagCompound;

public class GameRules
{
    private TreeMap theGameRules = new TreeMap();
    private static final String __OBFID = "CL_00000136";

    public GameRules()
    {
        this.addGameRule("doFireTick", "true");
        this.addGameRule("mobGriefing", "true");
        this.addGameRule("keepInventory", "false");
        this.addGameRule("doMobSpawning", "true");
        this.addGameRule("doMobLoot", "true");
        this.addGameRule("doTileDrops", "true");
        this.addGameRule("commandBlockOutput", "true");
        this.addGameRule("naturalRegeneration", "true");
        this.addGameRule("doDaylightCycle", "true");
    }

    /**
     * Define a game rule and its default value.
     */
    public void addGameRule(String p_82769_1_, String p_82769_2_)
    {
        this.theGameRules.put(p_82769_1_, new GameRules.Value(p_82769_2_));
    }

    public void setOrCreateGameRule(String p_82764_1_, String p_82764_2_)
    {
        GameRules.Value var3 = (GameRules.Value)this.theGameRules.get(p_82764_1_);

        if (var3 != null)
        {
            var3.setValue(p_82764_2_);
        }
        else
        {
            this.addGameRule(p_82764_1_, p_82764_2_);
        }
    }

    /**
     * Gets the string Game Rule value.
     */
    public String getGameRuleStringValue(String p_82767_1_)
    {
        GameRules.Value var2 = (GameRules.Value)this.theGameRules.get(p_82767_1_);
        return var2 != null ? var2.getGameRuleStringValue() : "";
    }

    /**
     * Gets the boolean Game Rule value.
     */
    public boolean getGameRuleBooleanValue(String p_82766_1_)
    {
        GameRules.Value var2 = (GameRules.Value)this.theGameRules.get(p_82766_1_);
        return var2 != null ? var2.getGameRuleBooleanValue() : false;
    }

    /**
     * Return the defined game rules as NBT.
     */
    public NBTTagCompound writeGameRulesToNBT()
    {
        NBTTagCompound var1 = new NBTTagCompound();
        Iterator var2 = this.theGameRules.keySet().iterator();

        while (var2.hasNext())
        {
            String var3 = (String)var2.next();
            GameRules.Value var4 = (GameRules.Value)this.theGameRules.get(var3);
            var1.setString(var3, var4.getGameRuleStringValue());
        }

        return var1;
    }

    /**
     * Set defined game rules from NBT.
     */
    public void readGameRulesFromNBT(NBTTagCompound p_82768_1_)
    {
        Set var2 = p_82768_1_.func_150296_c();
        Iterator var3 = var2.iterator();

        while (var3.hasNext())
        {
            String var4 = (String)var3.next();
            String var6 = p_82768_1_.getString(var4);
            this.setOrCreateGameRule(var4, var6);
        }
    }

    /**
     * Return the defined game rules.
     */
    public String[] getRules()
    {
        return (String[])this.theGameRules.keySet().toArray(new String[0]);
    }

    /**
     * Return whether the specified game rule is defined.
     */
    public boolean hasRule(String p_82765_1_)
    {
        return this.theGameRules.containsKey(p_82765_1_);
    }

    static class Value
    {
        private String valueString;
        private boolean valueBoolean;
        private int valueInteger;
        private double valueDouble;
        private static final String __OBFID = "CL_00000137";

        public Value(String p_i1949_1_)
        {
            this.setValue(p_i1949_1_);
        }

        public void setValue(String p_82757_1_)
        {
            this.valueString = p_82757_1_;
            this.valueBoolean = Boolean.parseBoolean(p_82757_1_);

            try
            {
                this.valueInteger = Integer.parseInt(p_82757_1_);
            }
            catch (NumberFormatException var4)
            {
                ;
            }

            try
            {
                this.valueDouble = Double.parseDouble(p_82757_1_);
            }
            catch (NumberFormatException var3)
            {
                ;
            }
        }

        public String getGameRuleStringValue()
        {
            return this.valueString;
        }

        public boolean getGameRuleBooleanValue()
        {
            return this.valueBoolean;
        }
    }
}
