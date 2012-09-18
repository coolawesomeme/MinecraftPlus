package net.minecraft.src;

import java.util.Random;

public class BlockTrap extends Block {
	private boolean hasBeenActivated = false;

    protected BlockTrap(int i, int j) {
        super(i, j, Material.rock);
        this.blockIndexInTexture = 45;
    }

    public int tickRate()
    {
    //How often it refreshes.  If you return 20, that's one second.
            return 10;
    }
    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public int getBlockTextureFromSide(int par1)
    {
        if (par1 == 1)
        {
            return 46;
        }
        else if (par1 == 0)
        {
            return 62;
        }
        else
        {
            return blockIndexInTexture;
        }
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
             ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Trap Activating!");
            }
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(hasBeenActivated == true){
    	blockRemove(world, i, j, k);
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Trap De-activating!");
        }
    }

     public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
        {
    	 if(hasBeenActivated == true){
         blockRemove(world, i, j, k);
         ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Trap De-activating!");
    	 }
        }

    public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
    	if(hasBeenActivated == true){
    	blockRemove(world, i, j, k);
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Trap De-activating!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("\u00a76(Cause: Explosion)");
    	}
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        blockCreate(par1World, par2, par3, par4);
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Trap Activating!");
        hasBeenActivated = true;

        return true;
    }

    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
    	blockCreate(par1World, par2, par3, par4);
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Trap Activating!");
        hasBeenActivated = true;
    }

    public void blockRemove(World world, int x, int y, int z)
    {
        world.setBlockWithNotify(x, y + 1, z, 0);
            }

    public void blockCreate(World world, int x, int y, int z)
    {
    	world.setBlockWithNotify(x, y + 1, z, Block.fire.blockID);
            }

    public int idDropped(int i, Random random) {
        return mod_MinecraftPlus.BlockTrap.blockID;
    }
}
