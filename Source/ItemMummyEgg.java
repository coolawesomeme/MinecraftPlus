package net.minecraft.src;
 
import net.minecraft.client.Minecraft;

public class ItemMummyEgg extends Item
{

    public ItemMummyEgg(int i)
    {
        super(i);
         maxStackSize = 1;
         setMaxDamage(4);
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
    
    if(world.difficultySetting == 0){
            entityplayer.addChatMessage("\u00a76Mummies cannot be spawned in Peaceful difficulty!");
        }
        
    else{  
        if(!world.isRemote)
        {
            entityplayer.addChatMessage("\u00a76Mummy Spawned!");
            EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName("Mummy", entityplayer.worldObj);
            entityliving.setLocationAndAngles(i, j + 1, k, 0F, 0F);
            entityplayer.worldObj.spawnEntityInWorld(entityliving);
            itemstack.damageItem(1, entityplayer);
            entityplayer.swingItem();
        }
      }
      
        return true;
    }
}