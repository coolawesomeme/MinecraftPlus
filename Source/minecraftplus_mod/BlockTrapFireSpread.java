package net.minecraftplus_mod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockTrapFireSpread extends Block {
	private boolean hasBeenActivated = false;

    protected BlockTrapFireSpread(int i, int j) {
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
            return 62;
        }
        else if (par1 == 0)
        {
            return 62;
        }
        else
        {
            return 46;
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
            }
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(hasBeenActivated == true){
    	blockRemove(world, i, j, k);
        entityplayer.addChatMessage("Trap De-activating!");
        }
    }

     public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
        {
    	 if(hasBeenActivated == true){
         blockRemove(world, i, j, k);
    	 }
        }

    public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
    	if(hasBeenActivated == true){
    	blockRemove(world, i, j, k);
    	}
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        blockCreate(par1World, par2, par3, par4);
        par5EntityPlayer.addChatMessage("Trap Activating!");
        hasBeenActivated = true;

        return true;
    }

    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
    	blockCreate(par1World, par2, par3, par4);
        hasBeenActivated = true;
    }

    public void blockRemove(World world, int x, int y, int z)
    {
    	
    }

    public void blockCreate(World world, int x, int y, int z)
    {
      int missed = 0;
      Random random = new Random();
      int b_1 = random.nextInt(2);
      int b_2 = random.nextInt(2);
      int b_3 = random.nextInt(2);
      int b_4 = random.nextInt(2);
      int b_5 = random.nextInt(2);
      int b_6 = random.nextInt(2);
      int b_7 = random.nextInt(2);
      int b_8 = random.nextInt(2);
      if(b_1 == 1){
    	  world.setBlockWithNotify(x + 1, y, z, Block.fire.blockID);
      }else{
    	 missed++; 
      }
      if(b_2 == 1){
    	  world.setBlockWithNotify(x - 1, y, z, Block.fire.blockID);
      }else{
    	  missed++;
      }
      if(b_3 == 1){
    	  world.setBlockWithNotify(x, y, z - 1, Block.fire.blockID);
      }else{
    	  missed++;
      }
      if(b_4 == 1){
    	  world.setBlockWithNotify(x, y, z - 1, Block.fire.blockID);
      }else{
    	  missed++;
      }
      if(b_5 == 1){
    	  world.setBlockWithNotify(x + 1, y, z + 1, Block.fire.blockID);
      }else{
    	  missed++;
      }
      if(b_6 == 1){
    	  world.setBlockWithNotify(x - 1 , y, z + 1, Block.fire.blockID);
      }else{
    	  missed++;
      }
      if(b_7 == 1){
    	  world.setBlockWithNotify(x + 1, y, z - 1, Block.fire.blockID);
      }else{
    	  missed++;
      }
      if(b_8 == 1){
    	  world.setBlockWithNotify(x - 1, y, z - 1, Block.fire.blockID);
      }else{
    	  missed++;
      }
      String b = PlusWorldGenerator.currentBiome;
      if(b == "Desert" || b == "DesertHills"){
      world.setBlockAndMetadataWithNotify(x - 2, y, z, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x + 2, y, z, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x, y, z - 2, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x, y, z + 2, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x - 2, y, z + 1, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x - 2, y, z - 1, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x + 2, y, z + 1, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x + 2, y, z - 1, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x + 1, y, z + 2, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x + 1, y, z - 2, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x - 1, y, z + 2, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x - 1, y, z - 2, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x - 2, y, z - 2, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x - 2, y, z + 2, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x + 2, y, z - 2, Block.tallGrass.blockID, 0);
      world.setBlockAndMetadataWithNotify(x + 2, y, z + 2, Block.tallGrass.blockID, 0);
      } else if(b == "Hell" || b == "Sky"){
      world.setBlockWithNotify(x - 2, y, z, Block.fire.blockID);
      world.setBlockWithNotify(x + 2, y, z, Block.fire.blockID);
      world.setBlockWithNotify(x, y, z - 2, Block.fire.blockID);
      world.setBlockWithNotify(x, y, z + 2, Block.fire.blockID);
      world.setBlockWithNotify(x - 2, y, z + 1, Block.fire.blockID);
      world.setBlockWithNotify(x - 2, y, z - 1, Block.fire.blockID);
      world.setBlockWithNotify(x + 2, y, z + 1, Block.fire.blockID);
      world.setBlockWithNotify(x + 2, y, z - 1, Block.fire.blockID);
      world.setBlockWithNotify(x + 1, y, z + 2, Block.fire.blockID);
      world.setBlockWithNotify(x + 1, y, z - 2, Block.fire.blockID);
      world.setBlockWithNotify(x - 1, y, z + 2, Block.fire.blockID);
      world.setBlockWithNotify(x - 1, y, z - 2, Block.fire.blockID);
      world.setBlockWithNotify(x - 2, y, z - 2, Block.fire.blockID);
      world.setBlockWithNotify(x - 2, y, z + 2, Block.fire.blockID);
      world.setBlockWithNotify(x + 2, y, z - 2, Block.fire.blockID);
      world.setBlockWithNotify(x + 2, y, z + 2, Block.fire.blockID);
      } else{
      world.setBlockAndMetadataWithNotify(x - 2, y, z, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x + 2, y, z, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x, y, z - 2, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x, y, z + 2, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x - 2, y, z + 1, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x - 2, y, z - 1, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x + 2, y, z + 1, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x + 2, y, z - 1, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x + 1, y, z + 2, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x + 1, y, z - 2, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x - 1, y, z + 2, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x - 1, y, z - 2, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x - 2, y, z - 2, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x - 2, y, z + 2, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x + 2, y, z - 2, Block.tallGrass.blockID, 1);
      world.setBlockAndMetadataWithNotify(x + 2, y, z + 2, Block.tallGrass.blockID, 1);
      }
      
      if(missed >= 7){
    	  redoBlockCreate(world, x, y, z);
      } else{
    	  missed = 0;
      }
    }

    private void redoBlockCreate(World world, int x, int y, int z) {
		blockCreate(world, x, y, z);
	}

	public int idDropped(int i, Random random) {
        return MinecraftPlusBase.trapBlockFireSpread.blockID;
    }
}
