package net.minecraftplus_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

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
