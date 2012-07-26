package net.minecraft.src;

import java.util.Random;

public class WorldGenPlusSign extends WorldGenerator
{
        public WorldGenPlusSign()
        {
        }

        public void chest(World world, Random random, int i, int j, int k)
        {
        	world.setBlockWithNotify(i, j, k, Block.chest.blockID);  
        	TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i, j, k);
            if (tileentitychest != null && tileentitychest.getSizeInventory() > 0) {
            ItemStack itemstack = new ItemStack(Item.diamond, 4);
            ItemStack itemstack1 = new ItemStack(Item.swordSteel, 1);
            ItemStack itemstack2 = new ItemStack(Item.cookie, 4);
            ItemStack itemstack3 = new ItemStack(Item.bow, 1);
            ItemStack itemstack4 = new ItemStack(Item.arrow, 16);
            tileentitychest.setInventorySlotContents(4, itemstack3);
            tileentitychest.setInventorySlotContents(12, itemstack);
            tileentitychest.setInventorySlotContents(13, itemstack1);
            tileentitychest.setInventorySlotContents(14, itemstack2);
            tileentitychest.setInventorySlotContents(22, itemstack4);
            }
        }
        
        public boolean generate(World world, Random random, int i, int j, int k)
        {
        	//Glass
            world.setBlockWithNotify(i, j + 1, k, Block.glass.blockID);
            world.setBlockWithNotify(i, j + 2, k, Block.glass.blockID);
            world.setBlockWithNotify(i, j + 3, k, Block.glass.blockID);
            world.setBlockWithNotify(i, j - 1, k, Block.glass.blockID);
            world.setBlockWithNotify(i, j - 2, k, Block.glass.blockID);
            world.setBlockWithNotify(i, j - 3, k, Block.glass.blockID);
            world.setBlockWithNotify(i + 1, j, k, Block.glass.blockID);
            world.setBlockWithNotify(i + 2, j, k, Block.glass.blockID);
            world.setBlockWithNotify(i + 3, j, k, Block.glass.blockID);
            world.setBlockWithNotify(i - 1, j, k, Block.glass.blockID);
            world.setBlockWithNotify(i - 2, j, k, Block.glass.blockID);
            world.setBlockWithNotify(i - 3, j, k, Block.glass.blockID);
            
            //Iron
            world.setBlockWithNotify(i + 1, j + 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 1, j - 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 1, j + 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 1, j - 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 4, j, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 4, j, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i, j + 4, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i, j - 4, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 1, j + 4, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 1, j + 4, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 1, j - 4, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 1, j - 4, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 4, j - 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 4, j + 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 4, j - 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 4, j + 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 3, j + 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 2, j + 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 3, j - 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 2, j - 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 3, j + 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 2, j + 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 2, j - 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 3, j + 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 3, j - 1, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 1, j + 3, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 1, j + 2, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 1, j + 3, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 1, j + 2, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 1, j - 3, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i + 1, j - 2, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 1, j - 3, k, Block.blockSteel.blockID);
            world.setBlockWithNotify(i - 1, j - 2, k, Block.blockSteel.blockID);
            
            chest(world, random, i, j, k);
            
                return true;
                            
        }  
}