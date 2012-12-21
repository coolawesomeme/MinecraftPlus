package net.minecraftplus_mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class PlusTab extends CreativeTabs{
	public PlusTab(String label) {
	    super(label);
	}
	
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(MinecraftPlusBase.embroniumBlock);
	}
}
