package net.minecraftplus_mod;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;


public class BlockiBlock extends BlockNormal
{
	
    protected BlockiBlock(int i, int j)
    {
        super(i, j, Material.rock);
    }
    
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
         //Check to see what's in the current slot.
         ItemStack currentItem = entityplayer.inventory.getCurrentItem();
         
         // Embronium Ingot -> Embronium Dust
         if (currentItem != null && currentItem.itemID == MinecraftPlusBase.embroniumIngot.shiftedIndex)
         {
        	 if(!entityplayer.capabilities.isCreativeMode)
        		 entityplayer.inventory.consumeInventoryItem(MinecraftPlusBase.embroniumIngot.shiftedIndex);
             
        	 entityplayer.dropPlayerItem(new ItemStack(MinecraftPlusBase.embroniumDust));
         }

         // Embronium Dust -> Embronium Ingot
         if (currentItem != null && currentItem.itemID == MinecraftPlusBase.embroniumDust.shiftedIndex)
         {
        	 if(!entityplayer.capabilities.isCreativeMode)
        		 entityplayer.inventory.consumeInventoryItem(MinecraftPlusBase.embroniumDust.shiftedIndex);
             
        	 entityplayer.dropPlayerItem(new ItemStack(MinecraftPlusBase.embroniumIngot));
         }

         // Diamond -> Embronium Ingots (5)
         if (currentItem != null && currentItem.itemID == Item.diamond.shiftedIndex)
         {
        	 if(!entityplayer.capabilities.isCreativeMode)
        		 entityplayer.inventory.consumeInventoryItem(Item.diamond.shiftedIndex);
             
        	 entityplayer.dropPlayerItem(new ItemStack(MinecraftPlusBase.embroniumIngot, 5));
         }
         
         return false;
    }
}