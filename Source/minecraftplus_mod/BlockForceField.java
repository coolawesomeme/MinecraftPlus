package net.minecraftplus_mod;

import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockForceField extends BlockNormal {
	private boolean hasBeenActivated = false;

    protected BlockForceField(int i, int j) {
        super(i, j, Material.wood);
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
        entityplayer.addChatMessage("Forcefield De-activating!");
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

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        blockCreate(par1World, par2, par3, par4);
        par5EntityPlayer.addChatMessage("Forcefield Activating!");
        hasBeenActivated = true;

        return true;
    }

    public void blockRemove(World world, int x, int y, int z)
    {
    	int nullBlock = MinecraftPlusBase.nullBlock.blockID;
        //4 points
                world.setBlock(x + 8, y, z, nullBlock);
                world.setBlock(x - 8, y, z, nullBlock);
                world.setBlock(x, y, z + 8, nullBlock);
                world.setBlock(x, y, z - 8, nullBlock);
                // 2 blocks around four points
                world.setBlock(x + 1, y, z + 8, nullBlock);
                world.setBlock(x - 1, y, z + 8, nullBlock);
                world.setBlock(x + 1, y, z - 8, nullBlock);
                world.setBlock(x - 1, y, z - 8, nullBlock);
                world.setBlock(x + 8, y, z + 1, nullBlock);
                world.setBlock(x - 8, y, z + 1, nullBlock);
                world.setBlock(x + 8, y, z - 1, nullBlock);
                //Left
                world.setBlock(x - 8, y, z - 1, nullBlock);
                world.setBlock(x - 8, y, z - 8, nullBlock);
                world.setBlock(x - 8, y, z - 7, nullBlock);
                world.setBlock(x - 8, y, z - 6, nullBlock);
                world.setBlock(x - 8, y, z - 5, nullBlock);
                world.setBlock(x - 8, y, z - 4, nullBlock);
                world.setBlock(x - 8, y, z - 3, nullBlock);
                world.setBlock(x - 8, y, z - 2, nullBlock);
                world.setBlock(x - 8, y, z + 8, nullBlock);
                world.setBlock(x - 8, y, z + 7, nullBlock);
                world.setBlock(x - 8, y, z + 6, nullBlock);
                world.setBlock(x - 8, y, z + 5, nullBlock);
                world.setBlock(x - 8, y, z + 4, nullBlock);
                world.setBlock(x - 8, y, z + 3, nullBlock);
                world.setBlock(x - 8, y, z + 2, nullBlock);
                //Right
                world.setBlock(x + 8, y, z - 8, nullBlock);
                world.setBlock(x + 8, y, z - 7, nullBlock);
                world.setBlock(x + 8, y, z - 6, nullBlock);
                world.setBlock(x + 8, y, z - 5, nullBlock);
                world.setBlock(x + 8, y, z - 4, nullBlock);
                world.setBlock(x + 8, y, z - 3, nullBlock);
                world.setBlock(x + 8, y, z - 2, nullBlock);
                world.setBlock(x + 8, y, z + 8, nullBlock);
                world.setBlock(x + 8, y, z + 7, nullBlock);
                world.setBlock(x + 8, y, z + 6, nullBlock);
                world.setBlock(x + 8, y, z + 5, nullBlock);
                world.setBlock(x + 8, y, z + 4, nullBlock);
                world.setBlock(x + 8, y, z + 3, nullBlock);
                world.setBlock(x + 8, y, z + 2, nullBlock);
                //Top
                world.setBlock(x - 8, y, z + 8, nullBlock);
                world.setBlock(x - 7, y, z + 8, nullBlock);
                world.setBlock(x - 6, y, z + 8, nullBlock);
                world.setBlock(x - 5, y, z + 8, nullBlock);
                world.setBlock(x - 4, y, z + 8, nullBlock);
                world.setBlock(x - 3, y, z + 8, nullBlock);
                world.setBlock(x - 2, y, z + 8, nullBlock);
                world.setBlock(x + 8, y, z + 8, nullBlock);
                world.setBlock(x + 7, y, z + 8, nullBlock);
                world.setBlock(x + 6, y, z + 8, nullBlock);
                world.setBlock(x + 5, y, z + 8, nullBlock);
                world.setBlock(x + 4, y, z + 8, nullBlock);
                world.setBlock(x + 3, y, z + 8, nullBlock);
                world.setBlock(x + 2, y, z + 8, nullBlock);
                //Bottom
                world.setBlock(x - 8, y, z - 8, nullBlock);
                world.setBlock(x - 7, y, z - 8, nullBlock);
                world.setBlock(x - 6, y, z - 8, nullBlock);
                world.setBlock(x - 5, y, z - 8, nullBlock);
                world.setBlock(x - 4, y, z - 8, nullBlock);
                world.setBlock(x - 3, y, z - 8, nullBlock);
                world.setBlock(x - 2, y, z - 8, nullBlock);
                world.setBlock(x + 8, y, z - 8, nullBlock);
                world.setBlock(x + 7, y, z - 8, nullBlock);
                world.setBlock(x + 6, y, z - 8, nullBlock);
                world.setBlock(x + 5, y, z - 8, nullBlock);
                world.setBlock(x + 4, y, z - 8, nullBlock);
                world.setBlock(x + 3, y, z - 8, nullBlock);
                world.setBlock(x + 2, y, z - 8, nullBlock);

                //Second Layer
                        //4 points
                                world.setBlock(x + 8, y + 1, z, nullBlock);
                                world.setBlock(x - 8, y + 1, z, nullBlock);
                                world.setBlock(x, y + 1, z + 8, nullBlock);
                                world.setBlock(x, y + 1, z - 8, nullBlock);
                                // 2 blocks around four points
                                world.setBlock(x + 1, y + 1, z + 8, nullBlock);
                                world.setBlock(x - 1, y + 1, z + 8, nullBlock);
                                world.setBlock(x + 1, y + 1, z - 8, nullBlock);
                                world.setBlock(x - 1, y + 1, z - 8, nullBlock);
                                world.setBlock(x + 8, y + 1, z + 1, nullBlock);
                                world.setBlock(x - 8, y + 1, z + 1, nullBlock);
                                world.setBlock(x + 8, y + 1, z - 1, nullBlock);
                                //Left
                                world.setBlock(x - 8, y + 1, z - 1, nullBlock);
                                world.setBlock(x - 8, y + 1, z - 8, nullBlock);
                                world.setBlock(x - 8, y + 1, z - 7, nullBlock);
                                world.setBlock(x - 8, y + 1, z - 6, nullBlock);
                                world.setBlock(x - 8, y + 1, z - 5, nullBlock);
                                world.setBlock(x - 8, y + 1, z - 4, nullBlock);
                                world.setBlock(x - 8, y + 1, z - 3, nullBlock);
                                world.setBlock(x - 8, y + 1, z - 2, nullBlock);
                                world.setBlock(x - 8, y + 1, z + 8, nullBlock);
                                world.setBlock(x - 8, y + 1, z + 7, nullBlock);
                                world.setBlock(x - 8, y + 1, z + 6, nullBlock);
                                world.setBlock(x - 8, y + 1, z + 5, nullBlock);
                                world.setBlock(x - 8, y + 1, z + 4, nullBlock);
                                world.setBlock(x - 8, y + 1, z + 3, nullBlock);
                                world.setBlock(x - 8, y + 1, z + 2, nullBlock);
                                //Right
                                world.setBlock(x + 8, y + 1, z - 8, nullBlock);
                                world.setBlock(x + 8, y + 1, z - 7, nullBlock);
                                world.setBlock(x + 8, y + 1, z - 6, nullBlock);
                                world.setBlock(x + 8, y + 1, z - 5, nullBlock);
                                world.setBlock(x + 8, y + 1, z - 4, nullBlock);
                                world.setBlock(x + 8, y + 1, z - 3, nullBlock);
                                world.setBlock(x + 8, y + 1, z - 2, nullBlock);
                                world.setBlock(x + 8, y + 1, z + 8, nullBlock);
                                world.setBlock(x + 8, y + 1, z + 7, nullBlock);
                                world.setBlock(x + 8, y + 1, z + 6, nullBlock);
                                world.setBlock(x + 8, y + 1, z + 5, nullBlock);
                                world.setBlock(x + 8, y + 1, z + 4, nullBlock);
                                world.setBlock(x + 8, y + 1, z + 3, nullBlock);
                                world.setBlock(x + 8, y + 1, z + 2, nullBlock);
                                //Top
                                world.setBlock(x - 8, y + 1, z + 8, nullBlock);
                                world.setBlock(x - 7, y + 1, z + 8, nullBlock);
                                world.setBlock(x - 6, y + 1, z + 8, nullBlock);
                                world.setBlock(x - 5, y + 1, z + 8, nullBlock);
                                world.setBlock(x - 4, y + 1, z + 8, nullBlock);
                                world.setBlock(x - 3, y + 1, z + 8, nullBlock);
                                world.setBlock(x - 2, y + 1, z + 8, nullBlock);
                                world.setBlock(x + 8, y + 1, z + 8, nullBlock);
                                world.setBlock(x + 7, y + 1, z + 8, nullBlock);
                                world.setBlock(x + 6, y + 1, z + 8, nullBlock);
                                world.setBlock(x + 5, y + 1, z + 8, nullBlock);
                                world.setBlock(x + 4, y + 1, z + 8, nullBlock);
                                world.setBlock(x + 3, y + 1, z + 8, nullBlock);
                                world.setBlock(x + 2, y + 1, z + 8, nullBlock);
                                //Bottom
                                world.setBlock(x - 8, y + 1, z - 8, nullBlock);
                                world.setBlock(x - 7, y + 1, z - 8, nullBlock);
                                world.setBlock(x - 6, y + 1, z - 8, nullBlock);
                                world.setBlock(x - 5, y + 1, z - 8, nullBlock);
                                world.setBlock(x - 4, y + 1, z - 8, nullBlock);
                                world.setBlock(x - 3, y + 1, z - 8, nullBlock);
                                world.setBlock(x - 2, y + 1, z - 8, nullBlock);
                                world.setBlock(x + 8, y + 1, z - 8, nullBlock);
                                world.setBlock(x + 7, y + 1, z - 8, nullBlock);
                                world.setBlock(x + 6, y + 1, z - 8, nullBlock);
                                world.setBlock(x + 5, y + 1, z - 8, nullBlock);
                                world.setBlock(x + 4, y + 1, z - 8, nullBlock);
                                world.setBlock(x + 3, y + 1, z - 8, nullBlock);
                                world.setBlock(x + 2, y + 1, z - 8, nullBlock);
            }

    public void blockCreate(World world, int x, int y, int z)
    {
    	int shield = MinecraftPlusBase.shieldBlock.blockID;
        //4 points
        world.setBlock(x + 8, y, z, shield);
        world.setBlock(x - 8, y, z, shield);
        world.setBlock(x, y, z + 8, shield);
        world.setBlock(x, y, z - 8, shield);
        // 2 blocks around four points
        world.setBlock(x + 1, y, z + 8, shield);
        world.setBlock(x - 1, y, z + 8, shield);
        world.setBlock(x + 1, y, z - 8, shield);
        world.setBlock(x - 1, y, z - 8, shield);
        world.setBlock(x + 8, y, z + 1, shield);
        world.setBlock(x - 8, y, z + 1, shield);
        world.setBlock(x + 8, y, z - 1, shield);
        //Left
        world.setBlock(x - 8, y, z - 1, shield);
        world.setBlock(x - 8, y, z - 8, shield);
        world.setBlock(x - 8, y, z - 7, shield);
        world.setBlock(x - 8, y, z - 6, shield);
        world.setBlock(x - 8, y, z - 5, shield);
        world.setBlock(x - 8, y, z - 4, shield);
        world.setBlock(x - 8, y, z - 3, shield);
        world.setBlock(x - 8, y, z - 2, shield);
        world.setBlock(x - 8, y, z + 8, shield);
        world.setBlock(x - 8, y, z + 7, shield);
        world.setBlock(x - 8, y, z + 6, shield);
        world.setBlock(x - 8, y, z + 5, shield);
        world.setBlock(x - 8, y, z + 4, shield);
        world.setBlock(x - 8, y, z + 3, shield);
        world.setBlock(x - 8, y, z + 2, shield);
        //Right
        world.setBlock(x + 8, y, z - 8, shield);
        world.setBlock(x + 8, y, z - 7, shield);
        world.setBlock(x + 8, y, z - 6, shield);
        world.setBlock(x + 8, y, z - 5, shield);
        world.setBlock(x + 8, y, z - 4, shield);
        world.setBlock(x + 8, y, z - 3, shield);
        world.setBlock(x + 8, y, z - 2, shield);
        world.setBlock(x + 8, y, z + 8, shield);
        world.setBlock(x + 8, y, z + 7, shield);
        world.setBlock(x + 8, y, z + 6, shield);
        world.setBlock(x + 8, y, z + 5, shield);
        world.setBlock(x + 8, y, z + 4, shield);
        world.setBlock(x + 8, y, z + 3, shield);
        world.setBlock(x + 8, y, z + 2, shield);
        //Top
        world.setBlock(x - 8, y, z + 8, shield);
        world.setBlock(x - 7, y, z + 8, shield);
        world.setBlock(x - 6, y, z + 8, shield);
        world.setBlock(x - 5, y, z + 8, shield);
        world.setBlock(x - 4, y, z + 8, shield);
        world.setBlock(x - 3, y, z + 8, shield);
        world.setBlock(x - 2, y, z + 8, shield);
        world.setBlock(x + 8, y, z + 8, shield);
        world.setBlock(x + 7, y, z + 8, shield);
        world.setBlock(x + 6, y, z + 8, shield);
        world.setBlock(x + 5, y, z + 8, shield);
        world.setBlock(x + 4, y, z + 8, shield);
        world.setBlock(x + 3, y, z + 8, shield);
        world.setBlock(x + 2, y, z + 8, shield);
        //Bottom
        world.setBlock(x - 8, y, z - 8, shield);
        world.setBlock(x - 7, y, z - 8, shield);
        world.setBlock(x - 6, y, z - 8, shield);
        world.setBlock(x - 5, y, z - 8, shield);
        world.setBlock(x - 4, y, z - 8, shield);
        world.setBlock(x - 3, y, z - 8, shield);
        world.setBlock(x - 2, y, z - 8, shield);
        world.setBlock(x + 8, y, z - 8, shield);
        world.setBlock(x + 7, y, z - 8, shield);
        world.setBlock(x + 6, y, z - 8, shield);
        world.setBlock(x + 5, y, z - 8, shield);
        world.setBlock(x + 4, y, z - 8, shield);
        world.setBlock(x + 3, y, z - 8, shield);
        world.setBlock(x + 2, y, z - 8, shield);

        //Second Layer
                //4 points
                        world.setBlock(x + 8, y + 1, z, shield);
                        world.setBlock(x - 8, y + 1, z, shield);
                        world.setBlock(x, y + 1, z + 8, shield);
                        world.setBlock(x, y + 1, z - 8, shield);
                        // 2 blocks around four points
                        world.setBlock(x + 1, y + 1, z + 8, shield);
                        world.setBlock(x - 1, y + 1, z + 8, shield);
                        world.setBlock(x + 1, y + 1, z - 8, shield);
                        world.setBlock(x - 1, y + 1, z - 8, shield);
                        world.setBlock(x + 8, y + 1, z + 1, shield);
                        world.setBlock(x - 8, y + 1, z + 1, shield);
                        world.setBlock(x + 8, y + 1, z - 1, shield);
                        //Left
                        world.setBlock(x - 8, y + 1, z - 1, shield);
                        world.setBlock(x - 8, y + 1, z - 8, shield);
                        world.setBlock(x - 8, y + 1, z - 7, shield);
                        world.setBlock(x - 8, y + 1, z - 6, shield);
                        world.setBlock(x - 8, y + 1, z - 5, shield);
                        world.setBlock(x - 8, y + 1, z - 4, shield);
                        world.setBlock(x - 8, y + 1, z - 3, shield);
                        world.setBlock(x - 8, y + 1, z - 2, shield);
                        world.setBlock(x - 8, y + 1, z + 8, shield);
                        world.setBlock(x - 8, y + 1, z + 7, shield);
                        world.setBlock(x - 8, y + 1, z + 6, shield);
                        world.setBlock(x - 8, y + 1, z + 5, shield);
                        world.setBlock(x - 8, y + 1, z + 4, shield);
                        world.setBlock(x - 8, y + 1, z + 3, shield);
                        world.setBlock(x - 8, y + 1, z + 2, shield);
                        //Right
                        world.setBlock(x + 8, y + 1, z - 8, shield);
                        world.setBlock(x + 8, y + 1, z - 7, shield);
                        world.setBlock(x + 8, y + 1, z - 6, shield);
                        world.setBlock(x + 8, y + 1, z - 5, shield);
                        world.setBlock(x + 8, y + 1, z - 4, shield);
                        world.setBlock(x + 8, y + 1, z - 3, shield);
                        world.setBlock(x + 8, y + 1, z - 2, shield);
                        world.setBlock(x + 8, y + 1, z + 8, shield);
                        world.setBlock(x + 8, y + 1, z + 7, shield);
                        world.setBlock(x + 8, y + 1, z + 6, shield);
                        world.setBlock(x + 8, y + 1, z + 5, shield);
                        world.setBlock(x + 8, y + 1, z + 4, shield);
                        world.setBlock(x + 8, y + 1, z + 3, shield);
                        world.setBlock(x + 8, y + 1, z + 2, shield);
                        //Top
                        world.setBlock(x - 8, y + 1, z + 8, shield);
                        world.setBlock(x - 7, y + 1, z + 8, shield);
                        world.setBlock(x - 6, y + 1, z + 8, shield);
                        world.setBlock(x - 5, y + 1, z + 8, shield);
                        world.setBlock(x - 4, y + 1, z + 8, shield);
                        world.setBlock(x - 3, y + 1, z + 8, shield);
                        world.setBlock(x - 2, y + 1, z + 8, shield);
                        world.setBlock(x + 8, y + 1, z + 8, shield);
                        world.setBlock(x + 7, y + 1, z + 8, shield);
                        world.setBlock(x + 6, y + 1, z + 8, shield);
                        world.setBlock(x + 5, y + 1, z + 8, shield);
                        world.setBlock(x + 4, y + 1, z + 8, shield);
                        world.setBlock(x + 3, y + 1, z + 8, shield);
                        world.setBlock(x + 2, y + 1, z + 8, shield);
                        //Bottom
                        world.setBlock(x - 8, y + 1, z - 8, shield);
                        world.setBlock(x - 7, y + 1, z - 8, shield);
                        world.setBlock(x - 6, y + 1, z - 8, shield);
                        world.setBlock(x - 5, y + 1, z - 8, shield);
                        world.setBlock(x - 4, y + 1, z - 8, shield);
                        world.setBlock(x - 3, y + 1, z - 8, shield);
                        world.setBlock(x - 2, y + 1, z - 8, shield);
                        world.setBlock(x + 8, y + 1, z - 8, shield);
                        world.setBlock(x + 7, y + 1, z - 8, shield);
                        world.setBlock(x + 6, y + 1, z - 8, shield);
                        world.setBlock(x + 5, y + 1, z - 8, shield);
                        world.setBlock(x + 4, y + 1, z - 8, shield);
                        world.setBlock(x + 3, y + 1, z - 8, shield);
                        world.setBlock(x + 2, y + 1, z - 8, shield);
            }

    public int idDropped(int i, Random random) {
        return MinecraftPlusBase.forceFieldBlock.blockID;
    }
}
