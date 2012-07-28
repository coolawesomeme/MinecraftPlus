package net.minecraft.src;
 
import net.minecraft.client.Minecraft;

public class ItemHumanEgg extends Item
{

    public ItemHumanEgg(int i)
    {
        super(i);
         maxStackSize = 1;
         setMaxDamage(4);
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    { 
        if(!world.isRemote)
        {
            entityplayer.addChatMessage("\u00A7bHuman Spawned!");
            EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName("Human", entityplayer.worldObj);
            entityliving.setLocationAndAngles(i, j + 1, k, 0F, 0F);
            entityplayer.worldObj.spawnEntityInWorld(entityliving);
            itemstack.damageItem(1, entityplayer);
            entityplayer.swingItem();
        }
      
        return true;
    }
}