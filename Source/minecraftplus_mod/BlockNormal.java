package net.minecraftplus_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNormal extends Block 
{
	public String getTextureFile()
	{
		return MinecraftPlusBase.block_texture;
	}
	
	public BlockNormal(int par1, int par2, Material par3Material) 
	{
		super(par1, par2, par3Material);
	}
	
	public Block setBlockIconCoord(int par1, int par2)
    {
        this.blockIndexInTexture = par1 + par2 * 16;
        return this;
    }
}
