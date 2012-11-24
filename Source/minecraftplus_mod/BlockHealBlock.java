package net.minecraftplus_mod;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockHealBlock extends BlockNormal {
	
	public Minecraft minecraft;
	
    protected BlockHealBlock(int i, int j) {
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

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
    	if(!minecraft.thePlayer.capabilities.isCreativeMode){
    		if(minecraft.thePlayer.getHealth() <= 20){
    			minecraft.thePlayer.setHealth(minecraft.thePlayer.getHealth() + 2);
    		} else if(minecraft.thePlayer.getHealth() == 21){
    			minecraft.thePlayer.setHealth(minecraft.thePlayer.getHealth() + 1);
    		}
    	}
    }
}