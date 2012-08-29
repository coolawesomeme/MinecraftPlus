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

    public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6, Minecraft minecraft, EntityHumans entityhuman)
    {
    	if(minecraft.isSingleplayer())
        {
    		par0World.spawnEntityInWorld(entityhuman);
        	Entity var8 = EntityList.createEntityByName("Human", par0World);
        	var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
        }
    
        return true;
    }
}