package net.minecraft.src;


import java.util.Random;


public class BlockCrater extends Block { 
	
	public int fuse;
	
	protected BlockCrater(int i, int j) {
        super(i, j, Material.tnt);
        fuse = 0;
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
             explode(world, i, j, k);
             fuse = 80;
            }
    }
	
	public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
		//
    }
	
	 public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
	    {

	    }
	 
	public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
		explode(world, i, j, k);
    }
	
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
	{
		explode(world, i, j, k);
		fuse = 80;
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Explosion Activating!");
		return blockConstructorCalled;
	}
	
	public void explode(World world, int x, int y, int z)
	{
		if(fuse == 80){
		world.createExplosion(null, x, y, z, 10);
					}
	}
	
	/**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        par1NBTTagCompound.setByte("Fuse", (byte)fuse);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        fuse = par1NBTTagCompound.getByte("Fuse");
    }
    
    public int idDropped(int i, Random random) {
        return mod_MinecraftPlus.BlockCrater.blockID;
    }

}
