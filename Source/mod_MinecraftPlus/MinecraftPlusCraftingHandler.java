package net.mod_MinecraftPlus;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class MinecraftPlusCraftingHandler implements ICraftingHandler 
{
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		/*if(item.itemID == ExampleMod.exampleItem.shiftedIndex)
		{
			player.addStat(ExampleMod.getExampleItem, 1);
			//You can also add something like this if you want to give people experience for crafting this item
			//An experience argument is already included in GameRegistry.addSmelting();
			player.addExperience(5);
		}*/
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) 
	{
		//This checks to see if an Item taken from a furnace is equal to the smelted version of the Example Block
		/*if(item.itemID == ExampleMod.exampleSmeltingAchievementBlock.blockID)
		{
			//Adds a statistic to the player
			//addStat params (Achievement to add, 1)
			player.addStat(ExampleMod.getExampleSmeltingAchievementBlock, 1);
		}*/
	}

}
