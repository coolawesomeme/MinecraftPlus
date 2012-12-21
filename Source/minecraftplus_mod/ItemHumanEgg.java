package net.minecraftplus_mod;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Deprecated
public class ItemHumanEgg extends Item
{
	public String getTextureFile()
	{
		return "/minecraftplus/spritesheet_items.png";
	}
	
    public ItemHumanEgg(int par1)
    {
         super(par1);
         maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    { 
    	if(true)
        {
            entityplayer.addChatMessage("\u00A7bMummy Spawned!");
            EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName("Mummy", entityplayer.worldObj);
            entityliving.setLocationAndAngles(i, j + 1, k, 0F, 0F);
            entityplayer.worldObj.spawnEntityInWorld(entityliving);
            itemstack.damageItem(1, entityplayer);
            entityplayer.swingItem();
        }
      
        return true;
    }
}