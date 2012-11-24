package net.minecraftplus_mod;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockStorageOre extends Block 
{
	public String getTextureFile()
	{
		return "/minecraftplus/spritesheet_blocks.png";
	}
	
	public BlockStorageOre(int par1, int par2, Material par3Material) 
	{
		super(par1, par2, par3Material);
	}
}
