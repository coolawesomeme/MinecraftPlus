package net.mod_MinecraftPlus;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;
 
/* PLEASE DO NOT CHANGE ANY VALUES IF YOU DON'T KNOW WHAT YOU ARE DOING.
This file will let you to set values to change the mummy. */

public class EntityHerobrine extends EntityMob
{
	public Minecraft minecraft;
    private static final ItemStack defaultHeldItem;
    
    public EntityHerobrine (World world)
    {
      // Basically the attributes of the monster.
        super (world);
        texture = "/minecraftplus/mobs/herobrine.png";  //DO NOT CHANGE
        moveSpeed = 1F; // The speed the monster walks
        attackStrength = 8; // The amount of strength the monster has to attack.
    }

    public int getMaxHealth()
    {
      //The health of the monster, He is 2.5 times the health of the player.
        return 100;
    }

    public void onLivingUpdate()
    {    // If then loop..... setting
        if (worldObj.isDaytime() && !worldObj.isRemote)
        {
            float f = getBrightness(1.0F);
            if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
            {
                /*This is the code to set it on fire, leave blank because we want Herobrine to live during the day.
                setFire(8);*/
            }
        }
        super.onLivingUpdate();
    }
    
    protected void dropFewItems()
    {
        dropItem(Item.diamond.shiftedIndex, 2);
        dropItem(Item.ingotIron.shiftedIndex, 3);
        dropItem(Item.appleGold.shiftedIndex, 3);
        dropItem(Item.cookie.shiftedIndex, 2);
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
        
    }
    
    public boolean canDespawn()
    {
        return false;
    }
    
    protected String getLivingSound()
    {
        return "none";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "none";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "none";
    }
            
    public ItemStack getHeldItem()
            {
                return defaultHeldItem;
            }

            static
            {
                defaultHeldItem = new ItemStack(Item.swordDiamond, 1);
            }
        
    
    public boolean interact(EntityPlayer entityplayer)
    {
        minecraft.thePlayer.addChatMessage("Run. Run and forget you saw anything.");
        return true;
    }
    
}
