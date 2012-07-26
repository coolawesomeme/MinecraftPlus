package net.minecraft.src;


import java.util.Random;


public class BlockForceField extends Block { 
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
            }
    }
	
	public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
		blockRemove(world, i, j, k);
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Forcefield De-activating!");
    }
	
	 public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
	    {
		 blockRemove(world, i, j, k);
		 ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Forcefield De-activating!");
	    }
		    	    
	public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
		blockRemove(world, i, j, k);
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Forcefield De-activating!");
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("\u00a76(Cause: Explosion)");
    }
	
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
	{
		blockCreate(world, i, j, k);
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Forcefield Activating!");
		return blockConstructorCalled;
	}
	
	public void blockRemove(World world, int x, int y, int z)
	{
		//4 points
				world.setBlockWithNotify(x + 8, y, z, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				// 2 blocks around four points
				world.setBlockWithNotify(x + 1, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 1, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 1, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 1, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z + 1, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z + 1, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z - 1, mod_MinecraftPlus.BlockNull.blockID);
				//Left
				world.setBlockWithNotify(x - 8, y, z - 1, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z - 7, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z - 6, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z - 5, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z - 4, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z - 3, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z - 2, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z + 7, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z + 6, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z + 5, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z + 4, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z + 3, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 8, y, z + 2, mod_MinecraftPlus.BlockNull.blockID);
				//Right
				world.setBlockWithNotify(x + 8, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z - 7, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z - 6, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z - 5, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z - 4, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z - 3, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z - 2, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z + 7, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z + 6, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z + 5, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z + 4, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z + 3, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z + 2, mod_MinecraftPlus.BlockNull.blockID);
				//Top
				world.setBlockWithNotify(x - 8, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 7, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 6, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 5, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 4, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 3, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 2, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 7, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 6, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 5, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 4, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 3, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 2, y, z + 8, mod_MinecraftPlus.BlockNull.blockID);
				//Bottom
				world.setBlockWithNotify(x - 8, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 7, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 6, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 5, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 4, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 3, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x - 2, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 8, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 7, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 6, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 5, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 4, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 3, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				world.setBlockWithNotify(x + 2, y, z - 8, mod_MinecraftPlus.BlockNull.blockID);
				
				//Second Layer
						//4 points
								world.setBlockWithNotify(x + 8, y + 1, z, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								// 2 blocks around four points
								world.setBlockWithNotify(x + 1, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 1, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 1, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 1, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z + 1, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z + 1, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z - 1, mod_MinecraftPlus.BlockNull.blockID);
								//Left
								world.setBlockWithNotify(x - 8, y + 1, z - 1, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z - 7, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z - 6, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z - 5, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z - 4, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z - 3, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z - 2, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z + 7, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z + 6, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z + 5, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z + 4, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z + 3, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 8, y + 1, z + 2, mod_MinecraftPlus.BlockNull.blockID);
								//Right
								world.setBlockWithNotify(x + 8, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z - 7, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z - 6, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z - 5, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z - 4, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z - 3, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z - 2, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z + 7, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z + 6, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z + 5, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z + 4, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z + 3, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z + 2, mod_MinecraftPlus.BlockNull.blockID);
								//Top
								world.setBlockWithNotify(x - 8, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 7, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 6, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 5, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 4, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 3, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 2, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 7, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 6, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 5, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 4, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 3, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 2, y + 1, z + 8, mod_MinecraftPlus.BlockNull.blockID);
								//Bottom
								world.setBlockWithNotify(x - 8, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 7, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 6, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 5, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 4, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 3, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x - 2, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 8, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 7, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 6, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 5, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 4, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 3, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
								world.setBlockWithNotify(x + 2, y + 1, z - 8, mod_MinecraftPlus.BlockNull.blockID);
			}
	
	public void blockCreate(World world, int x, int y, int z)
	{
		//4 points
		world.setBlockWithNotify(x + 8, y, z, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		// 2 blocks around four points
		world.setBlockWithNotify(x + 1, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 1, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 1, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 1, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z + 1, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z + 1, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z - 1, mod_MinecraftPlus.BlockShield.blockID);
		//Left
		world.setBlockWithNotify(x - 8, y, z - 1, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z - 7, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z - 6, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z - 5, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z - 4, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z - 3, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z - 2, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z + 7, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z + 6, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z + 5, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z + 4, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z + 3, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 8, y, z + 2, mod_MinecraftPlus.BlockShield.blockID);
		//Right
		world.setBlockWithNotify(x + 8, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z - 7, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z - 6, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z - 5, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z - 4, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z - 3, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z - 2, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z + 7, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z + 6, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z + 5, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z + 4, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z + 3, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z + 2, mod_MinecraftPlus.BlockShield.blockID);
		//Top
		world.setBlockWithNotify(x - 8, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 7, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 6, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 5, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 4, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 3, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 2, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 7, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 6, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 5, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 4, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 3, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 2, y, z + 8, mod_MinecraftPlus.BlockShield.blockID);
		//Bottom
		world.setBlockWithNotify(x - 8, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 7, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 6, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 5, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 4, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 3, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x - 2, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 8, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 7, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 6, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 5, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 4, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 3, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		world.setBlockWithNotify(x + 2, y, z - 8, mod_MinecraftPlus.BlockShield.blockID);
		
		//Second Layer
				//4 points
						world.setBlockWithNotify(x + 8, y + 1, z, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						// 2 blocks around four points
						world.setBlockWithNotify(x + 1, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 1, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 1, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 1, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z + 1, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z + 1, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z - 1, mod_MinecraftPlus.BlockShield.blockID);
						//Left
						world.setBlockWithNotify(x - 8, y + 1, z - 1, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z - 7, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z - 6, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z - 5, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z - 4, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z - 3, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z - 2, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z + 7, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z + 6, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z + 5, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z + 4, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z + 3, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 8, y + 1, z + 2, mod_MinecraftPlus.BlockShield.blockID);
						//Right
						world.setBlockWithNotify(x + 8, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z - 7, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z - 6, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z - 5, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z - 4, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z - 3, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z - 2, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z + 7, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z + 6, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z + 5, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z + 4, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z + 3, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z + 2, mod_MinecraftPlus.BlockShield.blockID);
						//Top
						world.setBlockWithNotify(x - 8, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 7, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 6, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 5, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 4, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 3, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 2, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 7, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 6, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 5, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 4, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 3, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 2, y + 1, z + 8, mod_MinecraftPlus.BlockShield.blockID);
						//Bottom
						world.setBlockWithNotify(x - 8, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 7, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 6, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 5, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 4, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 3, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x - 2, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 8, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 7, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 6, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 5, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 4, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 3, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
						world.setBlockWithNotify(x + 2, y + 1, z - 8, mod_MinecraftPlus.BlockShield.blockID);
			}

			
	
	public int idDropped(int i, Random random) {
        return mod_MinecraftPlus.BlockForceField.blockID;
    }
}
