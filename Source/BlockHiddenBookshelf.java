package net.minecraft.src;

import java.util.Random;

public class BlockHiddenBookshelf extends Block
{
    public BlockHiddenBookshelf(int par1, int par2)
    {
        super(par1, par2, Material.portal);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int i)
    {
        return null;
    }

    public boolean isOpaqueCube(World world, int i, int j, int k)
    {
      int a = world.getBlockId(i, j - 1, k);
      int b = world.getBlockId(i, j + 1, k);
      int c = world.getBlockId(i - 1, j, k);
      int d = world.getBlockId(i + 1, j, k);
      int e = world.getBlockId(i, j, k - 1);
      int f = world.getBlockId(i, j, k + 1);

      if(a == mod_MinecraftPlus.BlockHiddenBookshelf.blockID || b == mod_MinecraftPlus.BlockHiddenBookshelf.blockID || c == mod_MinecraftPlus.BlockHiddenBookshelf.blockID || d == mod_MinecraftPlus.BlockHiddenBookshelf.blockID || e == mod_MinecraftPlus.BlockHiddenBookshelf.blockID || f == mod_MinecraftPlus.BlockHiddenBookshelf.blockID){
           return true;
       }

      else{
        return false;
      }
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int par1)
    {
        if (par1 <= 1)
        {
            return 4;
        }
        else
        {
            return blockIndexInTexture;
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 3;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Item.book.shiftedIndex;
    }
}
