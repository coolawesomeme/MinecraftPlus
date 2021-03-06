package net.minecraftplus_mod;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPlusSign extends WorldGenerator
{
        public WorldGenPlusSign()
        {
        }
        
        public boolean generate(World world, Random random, int i, int j, int k)
        {
            if(world.isAirBlock(i, j, k) && world.isAirBlock(i, j - 4, k) && world.isAirBlock(i, j + 4, k) && world.isAirBlock(i - 4, j, k) && world.isAirBlock(i + 4, j, k)){
            //Glass
            world.setBlock(i, j + 1, k, Block.glass.blockID);
            world.setBlock(i, j + 2, k, Block.glass.blockID);
            world.setBlock(i, j + 3, k, Block.glass.blockID);
            world.setBlock(i, j - 1, k, Block.glass.blockID);
            world.setBlock(i, j - 2, k, Block.glass.blockID);
            world.setBlock(i, j - 3, k, Block.glass.blockID);
            world.setBlock(i + 1, j, k, Block.glass.blockID);
            world.setBlock(i + 2, j, k, Block.glass.blockID);
            world.setBlock(i + 3, j, k, Block.glass.blockID);
            world.setBlock(i - 1, j, k, Block.glass.blockID);
            world.setBlock(i - 2, j, k, Block.glass.blockID);
            world.setBlock(i - 3, j, k, Block.glass.blockID);
            
            //Iron
            world.setBlock(i + 1, j + 1, k, Block.blockSteel.blockID);
            world.setBlock(i + 1, j - 1, k, Block.blockSteel.blockID);
            world.setBlock(i - 1, j + 1, k, Block.blockSteel.blockID);
            world.setBlock(i - 1, j - 1, k, Block.blockSteel.blockID);
            world.setBlock(i + 4, j, k, Block.blockSteel.blockID);
            world.setBlock(i - 4, j, k, Block.blockSteel.blockID);
            world.setBlock(i, j + 4, k, Block.blockSteel.blockID);
            world.setBlock(i, j - 4, k, Block.blockSteel.blockID);
            world.setBlock(i - 1, j + 4, k, Block.blockSteel.blockID);
            world.setBlock(i + 1, j + 4, k, Block.blockSteel.blockID);
            world.setBlock(i - 1, j - 4, k, Block.blockSteel.blockID);
            world.setBlock(i + 1, j - 4, k, Block.blockSteel.blockID);
            world.setBlock(i + 4, j - 1, k, Block.blockSteel.blockID);
            world.setBlock(i + 4, j + 1, k, Block.blockSteel.blockID);
            world.setBlock(i - 4, j - 1, k, Block.blockSteel.blockID);
            world.setBlock(i - 4, j + 1, k, Block.blockSteel.blockID);
            world.setBlock(i - 3, j + 1, k, Block.blockSteel.blockID);
            world.setBlock(i - 2, j + 1, k, Block.blockSteel.blockID);
            world.setBlock(i - 3, j - 1, k, Block.blockSteel.blockID);
            world.setBlock(i - 2, j - 1, k, Block.blockSteel.blockID);
            world.setBlock(i + 3, j + 1, k, Block.blockSteel.blockID);
            world.setBlock(i + 2, j + 1, k, Block.blockSteel.blockID);
            world.setBlock(i + 2, j - 1, k, Block.blockSteel.blockID);
            world.setBlock(i + 3, j + 1, k, Block.blockSteel.blockID);
            world.setBlock(i + 3, j - 1, k, Block.blockSteel.blockID);
            world.setBlock(i + 1, j + 3, k, Block.blockSteel.blockID);
            world.setBlock(i + 1, j + 2, k, Block.blockSteel.blockID);
            world.setBlock(i - 1, j + 3, k, Block.blockSteel.blockID);
            world.setBlock(i - 1, j + 2, k, Block.blockSteel.blockID);
            world.setBlock(i + 1, j - 3, k, Block.blockSteel.blockID);
            world.setBlock(i + 1, j - 2, k, Block.blockSteel.blockID);
            world.setBlock(i - 1, j - 3, k, Block.blockSteel.blockID);
            world.setBlock(i - 1, j - 2, k, Block.blockSteel.blockID);
            
            world.setBlock(i, j, k, Block.chest.blockID);  
            TileEntity tileentity = (TileEntityChest)world.getBlockTileEntity(i, j, k);
            TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i, j, k);
            if (tileentitychest != null && tileentitychest.getSizeInventory() > 0) {
                
            	int number = random.nextInt(6);
            	int scored = 0;
            	if(number == 1){
            		//Most useful inventory. This one has been specifically designed by coolawesomeme.
            		//The rest are mostly random.
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
            		((TileEntityChest) tileentity).setInventorySlotContents(4, itemstack3);
            		((TileEntityChest) tileentity).setInventorySlotContents(12, itemstack);
            		((TileEntityChest) tileentity).setInventorySlotContents(13, itemstack1);
            		((TileEntityChest) tileentity).setInventorySlotContents(14, itemstack2);
            		((TileEntityChest) tileentity).setInventorySlotContents(22, itemstack4);
            		scored++;
            	}
            	if(number == 2){
            		ItemStack itemstack = new ItemStack(Item.enderPearl, 2);
            		ItemStack itemstack1 = new ItemStack(Item.beefCooked, 1);
            		ItemStack itemstack2 = new ItemStack(Item.blazePowder, 3);
            		ItemStack itemstack3 = new ItemStack(Item.coal, 1);
            		ItemStack itemstack4 = new ItemStack(Item.fermentedSpiderEye, 4);
            		tileentitychest.setInventorySlotContents(4, itemstack3);
            		tileentitychest.setInventorySlotContents(12, itemstack);
            		tileentitychest.setInventorySlotContents(13, itemstack1);
            		tileentitychest.setInventorySlotContents(14, itemstack2);
            		tileentitychest.setInventorySlotContents(22, itemstack4);
            		((TileEntityChest) tileentity).setInventorySlotContents(4, itemstack3);
            		((TileEntityChest) tileentity).setInventorySlotContents(12, itemstack);
            		((TileEntityChest) tileentity).setInventorySlotContents(13, itemstack1);
            		((TileEntityChest) tileentity).setInventorySlotContents(14, itemstack2);
            		((TileEntityChest) tileentity).setInventorySlotContents(22, itemstack4);
            		scored++;
            	}
            	if(number == 3){
            		ItemStack itemstack = new ItemStack(Item.appleRed, 4);
            		ItemStack itemstack1 = new ItemStack(Item.expBottle, 1);
            		ItemStack itemstack2 = new ItemStack(Item.flintAndSteel, 3);
            		ItemStack itemstack3 = new ItemStack(Item.lightStoneDust, 5);
            		ItemStack itemstack4 = new ItemStack(Item.minecartCrate, 2);
            		tileentitychest.setInventorySlotContents(4, itemstack3);
            		tileentitychest.setInventorySlotContents(12, itemstack);
            		tileentitychest.setInventorySlotContents(13, itemstack1);
            		tileentitychest.setInventorySlotContents(14, itemstack2);
            		tileentitychest.setInventorySlotContents(22, itemstack4);
            		((TileEntityChest) tileentity).setInventorySlotContents(4, itemstack3);
            		((TileEntityChest) tileentity).setInventorySlotContents(12, itemstack);
            		((TileEntityChest) tileentity).setInventorySlotContents(13, itemstack1);
            		((TileEntityChest) tileentity).setInventorySlotContents(14, itemstack2);
            		((TileEntityChest) tileentity).setInventorySlotContents(22, itemstack4);
            		scored++;
            	}
            	if(number == 4){
            		ItemStack itemstack = new ItemStack(Item.dyePowder, 4);
            		ItemStack itemstack1 = new ItemStack(Item.plateLeather, 1);
            		ItemStack itemstack2 = new ItemStack(Item.fireballCharge, 2);
            		ItemStack itemstack3 = new ItemStack(Item.hoeSteel, 1);
            		ItemStack itemstack4 = new ItemStack(Item.fishingRod, 2);
            		tileentitychest.setInventorySlotContents(4, itemstack3);
            		tileentitychest.setInventorySlotContents(12, itemstack);
            		tileentitychest.setInventorySlotContents(13, itemstack1);
            		tileentitychest.setInventorySlotContents(14, itemstack2);
            		tileentitychest.setInventorySlotContents(22, itemstack4);
            		((TileEntityChest) tileentity).setInventorySlotContents(4, itemstack3);
            		((TileEntityChest) tileentity).setInventorySlotContents(12, itemstack);
            		((TileEntityChest) tileentity).setInventorySlotContents(13, itemstack1);
            		((TileEntityChest) tileentity).setInventorySlotContents(14, itemstack2);
            		((TileEntityChest) tileentity).setInventorySlotContents(22, itemstack4);
            		scored++;
            	}
            	if(number == 5 || number == 6){
            		ItemStack itemstack = new ItemStack(Item.slimeBall, 12);
            		ItemStack itemstack1 = new ItemStack(Item.egg, 5);
            		ItemStack itemstack2 = new ItemStack(Item.chickenCooked, 4);
            		ItemStack itemstack3 = new ItemStack(Item.legsLeather, 1);
            		ItemStack itemstack4 = new ItemStack(Item.leather, 16);
            		tileentitychest.setInventorySlotContents(4, itemstack3);
            		tileentitychest.setInventorySlotContents(12, itemstack);
            		tileentitychest.setInventorySlotContents(13, itemstack1);
            		tileentitychest.setInventorySlotContents(14, itemstack2);
            		tileentitychest.setInventorySlotContents(22, itemstack4);
            		((TileEntityChest) tileentity).setInventorySlotContents(4, itemstack3);
            		((TileEntityChest) tileentity).setInventorySlotContents(12, itemstack);
            		((TileEntityChest) tileentity).setInventorySlotContents(13, itemstack1);
            		((TileEntityChest) tileentity).setInventorySlotContents(14, itemstack2);
            		((TileEntityChest) tileentity).setInventorySlotContents(22, itemstack4);
            		scored++;
            		}
            	if(scored == 0){
            		ItemStack itemstack = new ItemStack(MinecraftPlusBase.Tomato, 10);
            		ItemStack itemstack1 = new ItemStack(Item.expBottle, 1);
            		ItemStack itemstack2 = new ItemStack(Item.diamond, 1);
            		ItemStack itemstack3 = new ItemStack(Item.lightStoneDust, 2);
            		ItemStack itemstack4 = new ItemStack(Item.cookie, 2);
            		tileentitychest.setInventorySlotContents(4, itemstack3);
            		tileentitychest.setInventorySlotContents(12, itemstack);
            		tileentitychest.setInventorySlotContents(13, itemstack1);
            		tileentitychest.setInventorySlotContents(14, itemstack2);
            		tileentitychest.setInventorySlotContents(22, itemstack4);
            		((TileEntityChest) tileentity).setInventorySlotContents(4, itemstack3);
            		((TileEntityChest) tileentity).setInventorySlotContents(12, itemstack);
            		((TileEntityChest) tileentity).setInventorySlotContents(13, itemstack1);
            		((TileEntityChest) tileentity).setInventorySlotContents(14, itemstack2);
            		((TileEntityChest) tileentity).setInventorySlotContents(22, itemstack4);
            	}
            	}
            }
            
            return true;
        }  
}