package net.minecraftplus_mod;
 
import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class TreePalm extends WorldGenerator
{
        public TreePalm()
        {
        }
        
        public boolean generate(World world, Random random, int i, int j, int k)
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
            
            return true;
        }  
}