package net.minecraftplus_mod;

import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenHell;

public class BlockLavaFountain extends BlockNormal {
	private boolean hasBeenActivated = false;

    protected BlockLavaFountain(int i, int j) {
        super(i, j, Material.rock);
    }

    public int tickRate()
    {
    //How often it refreshes.  If you return 20, that's one second.
            return 10;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
            if(l > 0 && Block.blocksList[l].canProvidePower())
            {
        //Which direction the power can come from, i is the x coord, j is y, and k is z.
                    boolean flag = world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j - 1, k);
                    if(flag)
                    {
                            world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
                    }else{
                    	if(hasBeenActivated){
                    		world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
                    	}
                    }
            }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
            if(world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j - 1, k))
            {
             //Whatever you put here is what happens when it's powered
             blockCreate(world, i, j, k);
             hasBeenActivated = true;
            }else if(!world.isBlockIndirectlyGettingPowered(i, j, k) || !world.isBlockIndirectlyGettingPowered(i, j - 1, k))
            {
            	if(hasBeenActivated){
                    //Whatever you put here is what happens when it stops being powered
                    blockRemove(world, i, j, k);
                    hasBeenActivated = false;
                }
            }
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    	if(hasBeenActivated){
        blockRemove(world, i, j, k);
        entityplayer.addChatMessage("Lava Fountain De-activating!");
        hasBeenActivated = false;
    	}
    }

     public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
        {
    	 if(hasBeenActivated){
         blockRemove(world, i, j, k);
         hasBeenActivated = false;
    	 }
        }

    public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
    	if(hasBeenActivated){
        blockRemove(world, i, j, k);
        hasBeenActivated = false;
    	}
    }

    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
        blockCreate(world, i, j, k);
        entityplayer.addChatMessage("Lava Fountain Activating!");
        hasBeenActivated = true;
        return true;
    }

    public void blockRemove(World world, int x, int y, int z)
    {
    	world.setBlockWithNotify(x + 1, y, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 1, y, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x, y, z + 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x, y, z - 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 1, y, z + 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 1, y, z - 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 1, y, z + 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 1, y, z - 1, MinecraftPlusBase.nullBlock.blockID);

    	world.setBlockWithNotify(x, y + 1, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x, y + 2, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x, y + 3, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 1, y + 3, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 1, y + 3, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x, y + 3, z + 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x, y + 3, z - 1, MinecraftPlusBase.nullBlock.blockID);

    	world.setBlockWithNotify(x + 2, y, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 2, y, z + 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 2, y, z + 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 2, y, z - 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 2, y, z - 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 2, y, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y, z + 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y, z + 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y, z - 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y, z - 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x, y, z + 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 1, y, z + 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 1, y, z + 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x, y, z - 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 1, y, z - 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 1, y, z - 2, MinecraftPlusBase.nullBlock.blockID);

    	world.setBlockWithNotify(x + 2, y + 1, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 2, y + 1, z + 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 2, y + 1, z + 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 2, y + 1, z - 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 2, y + 1, z - 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 2, y + 1, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y + 1, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y + 1, z + 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y + 1, z + 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y + 1, z - 1, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y + 1, z - 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 2, y + 1, z, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x, y + 1, z + 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 1, y + 1, z + 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 1, y + 1, z + 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x, y + 1, z - 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x - 1, y + 1, z - 2, MinecraftPlusBase.nullBlock.blockID);
    	world.setBlockWithNotify(x + 1, y + 1, z - 2, MinecraftPlusBase.nullBlock.blockID);
            }

    public void blockCreate(World world, int x, int y, int z)
    {
		world.setBlockWithNotify(x + 1, y, z, Block.glowStone.blockID);
		world.setBlockWithNotify(x - 1, y, z, Block.glowStone.blockID);
		world.setBlockWithNotify(x, y, z + 1, Block.glowStone.blockID);
		world.setBlockWithNotify(x, y, z - 1, Block.glowStone.blockID);
		world.setBlockWithNotify(x + 1, y, z + 1, Block.glowStone.blockID);
		world.setBlockWithNotify(x + 1, y, z - 1, Block.glowStone.blockID);
		world.setBlockWithNotify(x - 1, y, z + 1, Block.glowStone.blockID);
		world.setBlockWithNotify(x - 1, y, z - 1, Block.glowStone.blockID);
		
		world.setBlockWithNotify(x, y + 1, z, Block.cobblestoneWall.blockID);
		world.setBlockWithNotify(x, y + 2, z, Block.cobblestoneWall.blockID);
		world.setBlockWithNotify(x, y + 3, z, Block.lavaMoving.blockID);
		
		world.setBlockWithNotify(x + 2, y, z, Block.netherBrick.blockID);
		world.setBlockWithNotify(x + 2, y, z + 1, Block.netherBrick.blockID);
		world.setBlockWithNotify(x + 2, y, z + 2, Block.netherBrick.blockID);
		world.setBlockWithNotify(x + 2, y, z - 1, Block.netherBrick.blockID);
		world.setBlockWithNotify(x + 2, y, z - 2, Block.netherBrick.blockID);
		world.setBlockWithNotify(x + 2, y, z, Block.netherBrick.blockID);
		world.setBlockWithNotify(x - 2, y, z, Block.netherBrick.blockID);
		world.setBlockWithNotify(x - 2, y, z + 1, Block.netherBrick.blockID);
		world.setBlockWithNotify(x - 2, y, z + 2, Block.netherBrick.blockID);
		world.setBlockWithNotify(x - 2, y, z - 1, Block.netherBrick.blockID);
		world.setBlockWithNotify(x - 2, y, z - 2, Block.netherBrick.blockID);
		world.setBlockWithNotify(x - 2, y, z, Block.netherBrick.blockID);
		world.setBlockWithNotify(x, y, z + 2, Block.netherBrick.blockID);
		world.setBlockWithNotify(x - 1, y, z + 2, Block.netherBrick.blockID);
		world.setBlockWithNotify(x + 1, y, z + 2, Block.netherBrick.blockID);
		world.setBlockWithNotify(x, y, z - 2, Block.netherBrick.blockID);
		world.setBlockWithNotify(x - 1, y, z - 2, Block.netherBrick.blockID);
		world.setBlockWithNotify(x + 1, y, z - 2, Block.netherBrick.blockID);
		
		world.setBlockWithNotify(x + 2, y + 1, z, Block.netherFence.blockID);
		world.setBlockWithNotify(x + 2, y + 1, z + 1, Block.netherFence.blockID);
		world.setBlockWithNotify(x + 2, y + 1, z + 2, Block.netherFence.blockID);
		world.setBlockWithNotify(x + 2, y + 1, z - 1, Block.netherFence.blockID);
		world.setBlockWithNotify(x + 2, y + 1, z - 2, Block.netherFence.blockID);
		world.setBlockWithNotify(x + 2, y + 1, z, Block.netherFence.blockID);
		world.setBlockWithNotify(x - 2, y + 1, z, Block.netherFence.blockID);
		world.setBlockWithNotify(x - 2, y + 1, z + 1, Block.netherFence.blockID);
		world.setBlockWithNotify(x - 2, y + 1, z + 2, Block.netherFence.blockID);
		world.setBlockWithNotify(x - 2, y + 1, z - 1, Block.netherFence.blockID);
		world.setBlockWithNotify(x - 2, y + 1, z - 2, Block.netherFence.blockID);
		world.setBlockWithNotify(x - 2, y + 1, z, Block.netherFence.blockID);
		world.setBlockWithNotify(x, y + 1, z + 2, Block.netherFence.blockID);
		world.setBlockWithNotify(x - 1, y + 1, z + 2, Block.netherFence.blockID);
		world.setBlockWithNotify(x + 1, y + 1, z + 2, Block.netherFence.blockID);
		world.setBlockWithNotify(x, y + 1, z - 2, Block.netherFence.blockID);
		world.setBlockWithNotify(x - 1, y + 1, z - 2, Block.netherFence.blockID);
		world.setBlockWithNotify(x + 1, y + 1, z - 2, Block.netherFence.blockID);
     }

    public int idDropped(int i, Random random) {
        return MinecraftPlusBase.lavaFountainBlock.blockID;
    }
}
