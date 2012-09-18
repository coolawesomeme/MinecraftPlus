package net.minecraft.src;

import java.util.Random;

import net.minecraft.client.Minecraft;

public class BlockCobbleGen extends Block {
	private boolean hasBeenActivated = false;

    protected BlockCobbleGen(int i, int j) {
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
             ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cobblestone Generator Activating!");
            }
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    	if(hasBeenActivated == true){
        blockRemove(world, i, j, k);
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cobblestone Generator De-activating!");
        hasBeenActivated = false;
    	}
    }

     public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
        {
    	 if(hasBeenActivated = true){
         blockRemove(world, i, j, k);
         ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cobblestone Generator De-activating!");
         hasBeenActivated = false;
    	 }
        }

    public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
    	if(hasBeenActivated == true){
        blockRemove(world, i, j, k);
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cobblestone Generator De-activating!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("\u00a76(Cause: Explosion)");
        hasBeenActivated = false;
    	}
    }

    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
        blockCreate(world, i, j, k);
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cobblestone Generator Activating!");
        hasBeenActivated = true;
        return true;
    }

    public void blockRemove(World world, int x, int y, int z)
    {
        //Generator
        world.setBlockWithNotify(x, y, z + 2, 0);
        world.setBlockWithNotify(x, y - 1, z + 3, 0);
        world.setBlockWithNotify(x, y, z + 3, 0);
        world.setBlockWithNotify(x, y, z + 5, 0);
        world.setBlockWithNotify(x, y, z + 4, 0);

        //Wall
        world.setBlockWithNotify(x, y, z + 6, 0);
        world.setBlockWithNotify(x + 1, y, z + 6, 0);
        world.setBlockWithNotify(x - 1, y, z + 6, 0);
        world.setBlockWithNotify(x + 1, y, z + 5, 0);
        world.setBlockWithNotify(x - 1, y, z + 5, 0);
        world.setBlockWithNotify(x + 1, y, z + 4, 0);
        world.setBlockWithNotify(x - 1, y, z + 4, 0);
        world.setBlockWithNotify(x + 1, y, z + 3, 0);
        world.setBlockWithNotify(x - 1, y, z + 3, 0);
        world.setBlockWithNotify(x + 1, y, z + 2, 0);
        world.setBlockWithNotify(x - 1, y, z + 2, 0);
        world.setBlockWithNotify(x + 1, y, z + 1, 0);
        world.setBlockWithNotify(x - 1, y, z + 1, 0);
        world.setBlockWithNotify(x, y, z + 1, 0);

        //Wall Level 2
        world.setBlockWithNotify(x, y - 1, z + 6, 0);
        world.setBlockWithNotify(x + 1, y - 1, z + 6, 0);
        world.setBlockWithNotify(x - 1, y - 1, z + 6, 0);
        world.setBlockWithNotify(x + 1, y - 1, z + 5, 0);
        world.setBlockWithNotify(x - 1, y - 1, z + 5, 0);
        world.setBlockWithNotify(x + 1, y - 1, z + 4, 0);
        world.setBlockWithNotify(x - 1, y - 1, z + 4, 0);
        world.setBlockWithNotify(x + 1, y - 1, z + 3, 0);
        world.setBlockWithNotify(x - 1, y - 1, z + 3, 0);
        world.setBlockWithNotify(x + 1, y - 1, z + 2, 0);
        world.setBlockWithNotify(x - 1, y - 1, z + 2, 0);
        world.setBlockWithNotify(x + 1, y - 1, z + 1, 0);
        world.setBlockWithNotify(x - 1, y - 1, z + 1, 0);
        world.setBlockWithNotify(x, y - 1, z + 1, 0);

        //Other Blocks
        world.setBlockWithNotify(x, y - 1, z + 2, 0);
        world.setBlockWithNotify(x, y - 1, z + 4, 0);
        world.setBlockWithNotify(x, y - 1, z + 5, 0);
        world.setBlockWithNotify(x, y - 2, z + 3, 0);
            }

    public void blockCreate(World world, int x, int y, int z)
    {
        //Generator
        world.setBlockWithNotify(x, y, z + 2, Block.waterMoving.blockID);
        world.setBlockWithNotify(x, y - 1, z + 3, 0);
        world.setBlockWithNotify(x, y, z + 3, 0);
        world.setBlockWithNotify(x, y, z + 5, Block.lavaStill.blockID);
        world.setBlockWithNotify(x, y, z + 4, Block.cobblestone.blockID);

        //Wall
        world.setBlockWithNotify(x, y, z + 6, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y, z + 6, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y, z + 6, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y, z + 5, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y, z + 5, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y, z + 4, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y, z + 4, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y, z + 3, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y, z + 3, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y, z + 2, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y, z + 2, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y, z + 1, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y, z + 1, Block.stone.blockID);
        world.setBlockWithNotify(x, y, z + 1, Block.stone.blockID);

        //Wall Level 2
        world.setBlockWithNotify(x, y - 1, z + 6, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y - 1, z + 6, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y - 1, z + 6, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y - 1, z + 5, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y - 1, z + 5, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y - 1, z + 4, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y - 1, z + 4, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y - 1, z + 3, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y - 1, z + 3, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y - 1, z + 2, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y - 1, z + 2, Block.stone.blockID);
        world.setBlockWithNotify(x + 1, y - 1, z + 1, Block.stone.blockID);
        world.setBlockWithNotify(x - 1, y - 1, z + 1, Block.stone.blockID);
        world.setBlockWithNotify(x, y - 1, z + 1, Block.stone.blockID);

        //Other Blocks
        world.setBlockWithNotify(x, y - 1, z + 2, Block.stone.blockID);
        world.setBlockWithNotify(x, y - 1, z + 4, Block.obsidian.blockID);
        world.setBlockWithNotify(x, y - 1, z + 5, Block.stone.blockID);
        world.setBlockWithNotify(x, y - 2, z + 3, Block.stone.blockID);
            }

    public int idDropped(int i, Random random) {
        return mod_MinecraftPlus.BlockCobbleGen.blockID;
    }
}
