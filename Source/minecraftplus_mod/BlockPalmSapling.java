package net.minecraftplus_mod;

import java.util.Random;


import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockPalmSapling extends BlockFlower
{

    protected BlockPalmSapling(int par1, int par2)
    {
        super(par1, par2);
        float var3 = 0.4F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public String getTextureFile()
	{
		return MinecraftPlusBase.block_texture;
	}
    
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            super.updateTick(par1World, par2, par3, par4, par5Random);

            if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
            {
                int var6 = par1World.getBlockMetadata(par2, par3, par4);

                if ((var6 & 8) == 0)
                {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 | 8);
                }
                else
                {
                    this.growTree(par1World, par2, par3, par4, par5Random);
                }
            }
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return 25;
    }
    
    /**
     * Attempts to grow a sapling into a tree
     */
    public static void growTree(World world, int i, int j, int k, Random par5Random)
    {
    	int wood = MinecraftPlusBase.palmWood.blockID;
    	int leaves = MinecraftPlusBase.palmLeaves.blockID;
    	
    	//Wood
        world.setBlock(i, j, k, wood);
        world.setBlock(i, j + 1, k, wood);
        world.setBlock(i, j + 2, k, wood);
        world.setBlock(i, j + 3, k, wood);
        world.setBlock(i, j + 4, k, wood);
        world.setBlock(i, j + 5, k, wood);
        
        //Branches
        world.setBlock(i + 3, j + 5, k, leaves);
        world.setBlock(i + 3, j + 4, k, leaves);
        
        world.setBlock(i - 3, j + 5, k, leaves);
        world.setBlock(i - 3, j + 4, k, leaves);
        
        world.setBlock(i, j + 5, k + 3, leaves);
        world.setBlock(i, j + 4, k + 3, leaves);
        
        world.setBlock(i, j + 5, k - 3, leaves);
        world.setBlock(i, j + 4, k - 3, leaves);
        
        world.setBlock(i + 2, j + 5, k + 2, leaves);
        world.setBlock(i + 2, j + 4, k + 2, leaves);

        world.setBlock(i + 2, j + 5, k - 2, leaves);
        world.setBlock(i + 2, j + 4, k - 2, leaves);

        world.setBlock(i - 2, j + 5, k + 2, leaves);
        world.setBlock(i - 2, j + 4, k + 2, leaves);

        world.setBlock(i - 2, j + 5, k - 2, leaves);
        world.setBlock(i - 2, j + 4, k - 2, leaves);
        
        //Leaves
        world.setBlock(i, j + 6, k, leaves);
        world.setBlock(i, j + 7, k, leaves);
        world.setBlock(i, j + 6, k + 1, leaves);
        world.setBlock(i, j + 6, k - 1, leaves);
        world.setBlock(i + 1, j + 6, k, leaves);
        world.setBlock(i - 1, j + 6, k, leaves);
        world.setBlock(i + 1, j + 6, k + 1, leaves);
        world.setBlock(i - 1, j + 6, k - 1, leaves);
        world.setBlock(i + 1, j + 6, k - 1, leaves);
        world.setBlock(i - 1, j + 6, k + 1, leaves);
        
        world.setBlock(i + 2, j + 6, k, leaves);
        world.setBlock(i - 2, j + 6, k, leaves);
        world.setBlock(i, j + 6, k + 2, leaves);
        world.setBlock(i, j + 6, k - 2, leaves);
    }

    /**
     * Determines if the same sapling is present at the given location.
     */
    public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5)
    {
        return par1World.getBlockId(par2, par3, par4) == this.blockID && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
    }
}
