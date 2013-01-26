package net.minecraftplus_mod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class MinecraftPlusCraftingHandler implements ICraftingHandler 
{
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		if(item.itemID == MinecraftPlusBase.cobbleGenBlock.blockID)
		{
			ItemStack bucketEmpty = new ItemStack(Item.bucketEmpty, 0, 2);
			player.inventory.addItemStackToInventory(bucketEmpty);
		}else if(item.itemID == MinecraftPlusBase.waterFountainBlock.blockID)
		{
			ItemStack bucketEmpty = new ItemStack(Item.bucketEmpty);
			player.inventory.addItemStackToInventory(bucketEmpty);
		}else if(item.itemID == MinecraftPlusBase.lavaFountainBlock.blockID)
		{
			ItemStack bucketEmpty = new ItemStack(Item.bucketEmpty);
			player.inventory.addItemStackToInventory(bucketEmpty);
		}
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
