package net.minecraft.src;

public class BlockiBlock extends Block
{
	
    protected BlockiBlock(int i, int j)
    {
        super(i, j, Material.rock);
    }
    
    
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
         //Check to see what's in the current slot.
         ItemStack currentItem = entityplayer.inventory.getCurrentItem();
         
         // Embronium Ingot -> Embronium Dust
         if (currentItem == null || currentItem.itemID == mod_MinecraftPlus.ItemEmbroniumIngot.shiftedIndex)
         {
        	 if(entityplayer.inventory.consumeInventoryItem(mod_MinecraftPlus.ItemEmbroniumIngot.shiftedIndex))
         
        	 {
        		 	entityplayer.dropPlayerItem(new ItemStack(mod_MinecraftPlus.ItemEmbroniumDust));
        	 }
         }
         
         // Embronium Dust -> Embronium Ingot
         if (currentItem == null || currentItem.itemID == mod_MinecraftPlus.ItemEmbroniumDust.shiftedIndex)
         {
        	 if(entityplayer.inventory.consumeInventoryItem(mod_MinecraftPlus.ItemEmbroniumDust.shiftedIndex))
         
        	 {
        		 	entityplayer.dropPlayerItem(new ItemStack(mod_MinecraftPlus.ItemEmbroniumIngot));
        	 }
         }
         
         // Diamond -> Embronium Ingot
         if (currentItem == null || currentItem.itemID == Item.diamond.shiftedIndex)
         {
        	 if(entityplayer.inventory.consumeInventoryItem(Item.diamond.shiftedIndex))
         
        	 {
        		 	entityplayer.dropPlayerItem(new ItemStack(mod_MinecraftPlus.ItemEmbroniumIngot));
        	 }
         }
         
         return false;
		
    }
}