package net.minecraftplus_mod;

import java.util.Random;


import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockHealBlock extends BlockNormal {
	
    public BlockHealBlock(int i, int j) {
        super(i, j, Material.wood);
    }

    public int idDropped(int i, Random random) {
        return MinecraftPlusBase.healBlock.blockID;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((float)par2 + f, par3, (float)par4 + f, (float)(par2 + 1) - f, (float)(par3 + 1) - f, (float)(par4 + 1) - f);
    }

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	boolean failed = false;
    	try{
    		((EntityPlayer)par5Entity).heal(2);
    	}catch(Exception e){
    		e.printStackTrace();
    		failed = true;
    	}
    	if(failed){
    	try{
    	par5Entity.attackEntityFrom(null, -2);
    	}catch(Exception e){
    		e.printStackTrace();
    	}}
    }
    
    
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	par5EntityPlayer.heal(4);
        return true;
    }
}