package net.minecraftplus_mod;

import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

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

      if(a == MinecraftPlusBase.hiddenBookshelf.blockID || b == MinecraftPlusBase.hiddenBookshelf.blockID || c == MinecraftPlusBase.hiddenBookshelf.blockID || d == MinecraftPlusBase.hiddenBookshelf.blockID || e == MinecraftPlusBase.hiddenBookshelf.blockID || f == MinecraftPlusBase.hiddenBookshelf.blockID){
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
