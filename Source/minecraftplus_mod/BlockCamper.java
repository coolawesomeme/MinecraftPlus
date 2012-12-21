package net.minecraftplus_mod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockCamper extends BlockNormal {
	private boolean hasBeenActivated = false;

    protected BlockCamper(int i, int j) {
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
    	if(hasBeenActivated){
        blockRemove(world, i, j, k);
        entityplayer.addChatMessage("Tent De-activating!");
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
        entityplayer.addChatMessage("Tent Block Activating!");
        hasBeenActivated = true;
        return true;
    }

    public void blockRemove(World world, int x, int y, int z)
    {
    	int nullBlock = MinecraftPlusBase.nullBlock.blockID;
    	//Wall - Level 1
    	world.setBlockWithNotify(x + 2, y + 1, z, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 1, z, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 1, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 1, z - 2, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 1, z + 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 1, z + 2, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 1, z - 1, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 1, z - 1, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 1, z + 1, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 1, z + 1, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 1, z + 2, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 1, z + 2, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 1, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 1, z - 2, nullBlock);
    	world.setBlockWithNotify(x, y + 1, z - 2, nullBlock);

    	//Wall - Level 2
    	world.setBlockWithNotify(x + 2, y + 2, z, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 2, z, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 2, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 2, z - 2, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 2, z + 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 2, z + 2, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 2, z - 1, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 2, z - 1, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 2, z + 1, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 2, z + 1, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 2, z + 2, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 2, z + 2, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 2, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 2, z - 2, nullBlock);
    	world.setBlockWithNotify(x, y + 2, z - 2, nullBlock);

    	//Wall - Level 3
    	world.setBlockWithNotify(x + 2, y + 3, z, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 3, z, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 3, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 3, z - 2, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 3, z + 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 3, z + 2, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 3, z - 1, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 3, z - 1, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 3, z + 1, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 3, z + 1, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 3, z + 2, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 3, z + 2, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 3, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 3, z - 2, nullBlock);
    	world.setBlockWithNotify(x, y + 3, z + 2, nullBlock);
    	world.setBlockWithNotify(x, y + 3, z - 2, nullBlock);

    	//Roof
    	world.setBlockAndMetadataWithNotify(x + 2, y + 4, z, nullBlock, nullBlock);
    	world.setBlockAndMetadataWithNotify(x - 2, y + 4, z, nullBlock, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 4, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 4, z - 2, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 4, z + 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 4, z + 2, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 4, z - 1, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 4, z - 1, nullBlock);
    	world.setBlockWithNotify(x + 2, y + 4, z + 1, nullBlock);
    	world.setBlockWithNotify(x - 2, y + 4, z + 1, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 4, z + 2, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 4, z + 2, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 4, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 4, z - 2, nullBlock);
    	world.setBlockWithNotify(x, y + 4, z + 2, nullBlock);
    	world.setBlockWithNotify(x, y + 4, z - 2, nullBlock);
    	world.setBlockWithNotify(x, y + 4, z, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 4, z, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 4, z, nullBlock);
    	world.setBlockWithNotify(x, y + 4, z + 1, nullBlock);
    	world.setBlockWithNotify(x, y + 4, z - 1, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 4, z + 1, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 4, z + 1, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 4, z - 1, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 4, z - 1, nullBlock);

    	//Floor
    	world.setBlockWithNotify(x + 1, y, z - 1, nullBlock);
    	world.setBlockAndMetadataWithNotify(x - 1, y, z - 1, nullBlock, 2);
    	world.setBlockWithNotify(x, y, z - 1, nullBlock);
    	world.setBlockWithNotify(x + 1, y, z, nullBlock);
    	world.setBlockWithNotify(x - 1, y, z, nullBlock);
    	world.setBlockWithNotify(x + 1, y, z + 1, nullBlock);
    	world.setBlockWithNotify(x - 1, y, z + 1, nullBlock);
    	world.setBlockWithNotify(x, y, z + 1, nullBlock);
    	world.setBlockWithNotify(x, y, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y, z, nullBlock);
    	world.setBlockWithNotify(x + 2, y, z, nullBlock);
    	world.setBlockWithNotify(x, y, z + 2, nullBlock);
    	world.setBlockWithNotify(x, y, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y, z + 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y, z - 2, nullBlock);
    	world.setBlockWithNotify(x + 2, y, z + 2, nullBlock);
    	world.setBlockWithNotify(x + 2, y, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 2, y, z + 1, nullBlock);
    	world.setBlockWithNotify(x - 2, y, z - 1, nullBlock);
    	world.setBlockWithNotify(x + 2, y, z + 1, nullBlock);
    	world.setBlockWithNotify(x + 2, y, z - 1, nullBlock);
    	world.setBlockWithNotify(x - 1, y, z + 2, nullBlock);
    	world.setBlockWithNotify(x + 1, y, z - 2, nullBlock);
    	world.setBlockWithNotify(x - 1, y, z - 2, nullBlock);
    	world.setBlockWithNotify(x + 1, y, z + 2, nullBlock);

    	//Other Blocks

    	world.setBlockWithNotify(x, y + 2, z + 2, nullBlock);
    	world.setBlockWithNotify(x, y + 1, z + 2, nullBlock);
    	world.setBlockWithNotify(x, y, z + 3, nullBlock);
    	world.setBlockWithNotify(x - 1, y, z + 3, nullBlock);
    	world.setBlockWithNotify(x + 1, y, z + 3, nullBlock);
    	world.setBlockWithNotify(x, y, z + 4, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 1, z, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 1, z + 1, nullBlock);
    	world.setBlockWithNotify(x, y + 3, z + 1, nullBlock);
    	world.setBlockWithNotify(x + 1, y + 3, z - 1, nullBlock);
    	world.setBlockWithNotify(x - 1, y + 3, z - 1, nullBlock);
            }

    public void blockCreate(World world, int x, int y, int z)
    {
        //Wall - Level 1
        world.setBlockWithNotify(x + 2, y + 1, z, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 1, z, Block.planks.blockID);
        world.setBlockAndMetadataWithNotify(x + 2, y + 1, z - 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 1, z - 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x + 2, y + 1, z + 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 1, z + 2, Block.wood.blockID, 0);
        world.setBlockWithNotify(x + 2, y + 1, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 1, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y + 1, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 1, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 1, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 1, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 1, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 1, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 1, z - 2, Block.thinGlass.blockID);

        //Wall - Level 2
        world.setBlockWithNotify(x + 2, y + 2, z, Block.thinGlass.blockID);
        world.setBlockWithNotify(x - 2, y + 2, z, Block.thinGlass.blockID);
        world.setBlockAndMetadataWithNotify(x + 2, y + 2, z - 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 2, z - 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x + 2, y + 2, z + 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 2, z + 2, Block.wood.blockID, 0);
        world.setBlockWithNotify(x + 2, y + 2, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 2, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y + 2, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 2, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 2, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 2, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 2, z - 2, Block.thinGlass.blockID);
        world.setBlockWithNotify(x - 1, y + 2, z - 2, Block.thinGlass.blockID);
        world.setBlockWithNotify(x, y + 2, z - 2, Block.thinGlass.blockID);

        //Wall - Level 3
        world.setBlockWithNotify(x + 2, y + 3, z, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 3, z, Block.planks.blockID);
        world.setBlockAndMetadataWithNotify(x + 2, y + 3, z - 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 3, z - 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x + 2, y + 3, z + 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 3, z + 2, Block.wood.blockID, 0);
        world.setBlockWithNotify(x + 2, y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y + 3, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 3, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 3, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 3, z - 2, Block.thinGlass.blockID);

        //Roof
        world.setBlockAndMetadataWithNotify(x + 2, y + 4, z, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 4, z, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x + 2, y + 4, z - 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 4, z - 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x + 2, y + 4, z + 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 4, z + 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x + 2, y + 4, z - 1, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 4, z - 1, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x + 2, y + 4, z + 1, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 2, y + 4, z + 1, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x + 1, y + 4, z + 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 1, y + 4, z + 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x + 1, y + 4, z - 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x - 1, y + 4, z - 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x, y + 4, z + 2, Block.wood.blockID, 0);
        world.setBlockAndMetadataWithNotify(x, y + 4, z - 2, Block.wood.blockID, 0);
        world.setBlockWithNotify(x, y + 4, z, Block.glass.blockID);
        world.setBlockWithNotify(x + 1, y + 4, z, Block.glass.blockID);
        world.setBlockWithNotify(x - 1, y + 4, z, Block.glass.blockID);
        world.setBlockWithNotify(x, y + 4, z + 1, Block.glass.blockID);
        world.setBlockWithNotify(x, y + 4, z - 1, Block.glass.blockID);
        world.setBlockWithNotify(x + 1, y + 4, z + 1, Block.glass.blockID);
        world.setBlockWithNotify(x - 1, y + 4, z + 1, Block.glass.blockID);
        world.setBlockWithNotify(x + 1, y + 4, z - 1, Block.glass.blockID);
        world.setBlockWithNotify(x - 1, y + 4, z - 1, Block.glass.blockID);

        //Floor
        world.setBlockWithNotify(x + 1, y, z - 1, Block.workbench.blockID);
        world.setBlockAndMetadataWithNotify(x - 1, y, z - 1, Block.stoneOvenIdle.blockID, 2);
        world.setBlockWithNotify(x, y, z - 1, Block.chest.blockID);
        world.setBlockWithNotify(x + 1, y, z, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y, z, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x, y, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x, y, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y, z, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y, z, Block.planks.blockID);
        world.setBlockWithNotify(x, y, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x, y, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y, z + 2, Block.wood.blockID);
        world.setBlockWithNotify(x - 2, y, z - 2, Block.wood.blockID);
        world.setBlockWithNotify(x + 2, y, z + 2, Block.wood.blockID);
        world.setBlockWithNotify(x + 2, y, z - 2, Block.wood.blockID);
        world.setBlockWithNotify(x - 2, y, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y, z + 2, Block.planks.blockID);

        //Other Blocks

        world.setBlockAndMetadataWithNotify(x, y + 2, z + 2, Block.doorWood.blockID, 15);
        world.setBlockAndMetadataWithNotify(x, y + 1, z + 2, Block.doorWood.blockID, 3);
        world.setBlockWithNotify(x, y, z + 3, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y, z + 3, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y, z + 3, Block.planks.blockID);
        world.setBlockWithNotify(x, y, z + 4, Block.planks.blockID);
        world.setBlockAndMetadataWithNotify(x - 1, y + 1, z, Block.bed.blockID, 14);
        world.setBlockAndMetadataWithNotify(x - 1, y + 1, z + 1, Block.bed.blockID, 2);
        world.setBlockWithNotify(x, y + 3, z + 1, Block.torchWood.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z - 1, Block.torchWood.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z - 1, Block.torchWood.blockID);
            }

    public int idDropped(int i, Random random) {
        return MinecraftPlusBase.camperBlock.blockID;
    }
}
