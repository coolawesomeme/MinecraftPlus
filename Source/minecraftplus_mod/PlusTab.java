package net.minecraftplus_mod;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;

public class PlusTab extends CreativeTabs{
	public PlusTab(String label) {
	    super(label);
	}
	
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(MinecraftPlusBase.embroniumBlock);
	}
}
