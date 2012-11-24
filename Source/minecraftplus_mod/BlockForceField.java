package net.minecraftplus_mod;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockForceField extends BlockNormal {
	public Minecraft minecraft;
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
            }
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(hasBeenActivated == true){
    	blockRemove(world, i, j, k);
        entityplayer.addChatMessage("Forcefield De-activating!");
        hasBeenActivated = false;
        }
    }

     public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
        {
    	 if(hasBeenActivated == true){
         blockRemove(world, i, j, k);
         hasBeenActivated = false;
    	 }
        }

    public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
    	if(hasBeenActivated == true){
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
        //4 points
                world.setBlockWithNotify(x + 8, y, z, 0);
                world.setBlockWithNotify(x - 8, y, z, 0);
                world.setBlockWithNotify(x, y, z + 8, 0);
                world.setBlockWithNotify(x, y, z - 8, 0);
                // 2 blocks around four points
                world.setBlockWithNotify(x + 1, y, z + 8, 0);
                world.setBlockWithNotify(x - 1, y, z + 8, 0);
                world.setBlockWithNotify(x + 1, y, z - 8, 0);
                world.setBlockWithNotify(x - 1, y, z - 8, 0);
                world.setBlockWithNotify(x + 8, y, z + 1, 0);
                world.setBlockWithNotify(x - 8, y, z + 1, 0);
                world.setBlockWithNotify(x + 8, y, z - 1, 0);
                //Left
                world.setBlockWithNotify(x - 8, y, z - 1, 0);
                world.setBlockWithNotify(x - 8, y, z - 8, 0);
                world.setBlockWithNotify(x - 8, y, z - 7, 0);
                world.setBlockWithNotify(x - 8, y, z - 6, 0);
                world.setBlockWithNotify(x - 8, y, z - 5, 0);
                world.setBlockWithNotify(x - 8, y, z - 4, 0);
                world.setBlockWithNotify(x - 8, y, z - 3, 0);
                world.setBlockWithNotify(x - 8, y, z - 2, 0);
                world.setBlockWithNotify(x - 8, y, z + 8, 0);
                world.setBlockWithNotify(x - 8, y, z + 7, 0);
                world.setBlockWithNotify(x - 8, y, z + 6, 0);
                world.setBlockWithNotify(x - 8, y, z + 5, 0);
                world.setBlockWithNotify(x - 8, y, z + 4, 0);
                world.setBlockWithNotify(x - 8, y, z + 3, 0);
                world.setBlockWithNotify(x - 8, y, z + 2, 0);
                //Right
                world.setBlockWithNotify(x + 8, y, z - 8, 0);
                world.setBlockWithNotify(x + 8, y, z - 7, 0);
                world.setBlockWithNotify(x + 8, y, z - 6, 0);
                world.setBlockWithNotify(x + 8, y, z - 5, 0);
                world.setBlockWithNotify(x + 8, y, z - 4, 0);
                world.setBlockWithNotify(x + 8, y, z - 3, 0);
                world.setBlockWithNotify(x + 8, y, z - 2, 0);
                world.setBlockWithNotify(x + 8, y, z + 8, 0);
                world.setBlockWithNotify(x + 8, y, z + 7, 0);
                world.setBlockWithNotify(x + 8, y, z + 6, 0);
                world.setBlockWithNotify(x + 8, y, z + 5, 0);
                world.setBlockWithNotify(x + 8, y, z + 4, 0);
                world.setBlockWithNotify(x + 8, y, z + 3, 0);
                world.setBlockWithNotify(x + 8, y, z + 2, 0);
                //Top
                world.setBlockWithNotify(x - 8, y, z + 8, 0);
                world.setBlockWithNotify(x - 7, y, z + 8, 0);
                world.setBlockWithNotify(x - 6, y, z + 8, 0);
                world.setBlockWithNotify(x - 5, y, z + 8, 0);
                world.setBlockWithNotify(x - 4, y, z + 8, 0);
                world.setBlockWithNotify(x - 3, y, z + 8, 0);
                world.setBlockWithNotify(x - 2, y, z + 8, 0);
                world.setBlockWithNotify(x + 8, y, z + 8, 0);
                world.setBlockWithNotify(x + 7, y, z + 8, 0);
                world.setBlockWithNotify(x + 6, y, z + 8, 0);
                world.setBlockWithNotify(x + 5, y, z + 8, 0);
                world.setBlockWithNotify(x + 4, y, z + 8, 0);
                world.setBlockWithNotify(x + 3, y, z + 8, 0);
                world.setBlockWithNotify(x + 2, y, z + 8, 0);
                //Bottom
                world.setBlockWithNotify(x - 8, y, z - 8, 0);
                world.setBlockWithNotify(x - 7, y, z - 8, 0);
                world.setBlockWithNotify(x - 6, y, z - 8, 0);
                world.setBlockWithNotify(x - 5, y, z - 8, 0);
                world.setBlockWithNotify(x - 4, y, z - 8, 0);
                world.setBlockWithNotify(x - 3, y, z - 8, 0);
                world.setBlockWithNotify(x - 2, y, z - 8, 0);
                world.setBlockWithNotify(x + 8, y, z - 8, 0);
                world.setBlockWithNotify(x + 7, y, z - 8, 0);
                world.setBlockWithNotify(x + 6, y, z - 8, 0);
                world.setBlockWithNotify(x + 5, y, z - 8, 0);
                world.setBlockWithNotify(x + 4, y, z - 8, 0);
                world.setBlockWithNotify(x + 3, y, z - 8, 0);
                world.setBlockWithNotify(x + 2, y, z - 8, 0);

                //Second Layer
                        //4 points
                                world.setBlockWithNotify(x + 8, y + 1, z, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z, 0);
                                world.setBlockWithNotify(x, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x, y + 1, z - 8, 0);
                                // 2 blocks around four points
                                world.setBlockWithNotify(x + 1, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x - 1, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x + 1, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x - 1, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z + 1, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z + 1, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z - 1, 0);
                                //Left
                                world.setBlockWithNotify(x - 8, y + 1, z - 1, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z - 7, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z - 6, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z - 5, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z - 4, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z - 3, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z - 2, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z + 7, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z + 6, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z + 5, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z + 4, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z + 3, 0);
                                world.setBlockWithNotify(x - 8, y + 1, z + 2, 0);
                                //Right
                                world.setBlockWithNotify(x + 8, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z - 7, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z - 6, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z - 5, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z - 4, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z - 3, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z - 2, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z + 7, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z + 6, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z + 5, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z + 4, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z + 3, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z + 2, 0);
                                //Top
                                world.setBlockWithNotify(x - 8, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x - 7, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x - 6, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x - 5, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x - 4, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x - 3, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x - 2, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x + 7, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x + 6, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x + 5, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x + 4, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x + 3, y + 1, z + 8, 0);
                                world.setBlockWithNotify(x + 2, y + 1, z + 8, 0);
                                //Bottom
                                world.setBlockWithNotify(x - 8, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x - 7, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x - 6, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x - 5, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x - 4, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x - 3, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x - 2, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x + 8, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x + 7, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x + 6, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x + 5, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x + 4, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x + 3, y + 1, z - 8, 0);
                                world.setBlockWithNotify(x + 2, y + 1, z - 8, 0);
            }

    public void blockCreate(World world, int x, int y, int z)
    {
        //4 points
        world.setBlockWithNotify(x + 8, y, z, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        // 2 blocks around four points
        world.setBlockWithNotify(x + 1, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 1, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 1, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 1, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z + 1, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z + 1, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z - 1, MinecraftPlusBase.shieldBlock.blockID);
        //Left
        world.setBlockWithNotify(x - 8, y, z - 1, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z - 7, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z - 6, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z - 5, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z - 4, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z - 3, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z - 2, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z + 7, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z + 6, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z + 5, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z + 4, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z + 3, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 8, y, z + 2, MinecraftPlusBase.shieldBlock.blockID);
        //Right
        world.setBlockWithNotify(x + 8, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z - 7, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z - 6, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z - 5, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z - 4, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z - 3, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z - 2, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z + 7, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z + 6, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z + 5, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z + 4, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z + 3, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z + 2, MinecraftPlusBase.shieldBlock.blockID);
        //Top
        world.setBlockWithNotify(x - 8, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 7, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 6, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 5, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 4, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 3, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 2, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 7, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 6, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 5, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 4, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 3, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 2, y, z + 8, MinecraftPlusBase.shieldBlock.blockID);
        //Bottom
        world.setBlockWithNotify(x - 8, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 7, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 6, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 5, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 4, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 3, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x - 2, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 8, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 7, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 6, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 5, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 4, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 3, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);
        world.setBlockWithNotify(x + 2, y, z - 8, MinecraftPlusBase.shieldBlock.blockID);

        //Second Layer
                //4 points
                        world.setBlockWithNotify(x + 8, y + 1, z, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        // 2 blocks around four points
                        world.setBlockWithNotify(x + 1, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 1, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 1, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 1, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z + 1, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z + 1, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z - 1, MinecraftPlusBase.shieldBlock.blockID);
                        //Left
                        world.setBlockWithNotify(x - 8, y + 1, z - 1, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z - 7, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z - 6, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z - 5, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z - 4, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z - 3, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z - 2, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z + 7, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z + 6, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z + 5, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z + 4, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z + 3, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 8, y + 1, z + 2, MinecraftPlusBase.shieldBlock.blockID);
                        //Right
                        world.setBlockWithNotify(x + 8, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z - 7, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z - 6, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z - 5, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z - 4, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z - 3, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z - 2, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z + 7, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z + 6, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z + 5, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z + 4, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z + 3, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z + 2, MinecraftPlusBase.shieldBlock.blockID);
                        //Top
                        world.setBlockWithNotify(x - 8, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 7, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 6, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 5, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 4, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 3, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 2, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 7, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 6, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 5, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 4, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 3, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 2, y + 1, z + 8, MinecraftPlusBase.shieldBlock.blockID);
                        //Bottom
                        world.setBlockWithNotify(x - 8, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 7, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 6, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 5, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 4, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 3, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x - 2, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 8, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 7, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 6, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 5, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 4, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 3, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
                        world.setBlockWithNotify(x + 2, y + 1, z - 8, MinecraftPlusBase.shieldBlock.blockID);
            }

    public int idDropped(int i, Random random) {
        return MinecraftPlusBase.forceFieldBlock.blockID;
    }
}
