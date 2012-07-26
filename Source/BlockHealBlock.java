package net.minecraft.src;

import java.util.Random;
 
public class BlockHealBlock extends Block {
    protected BlockHealBlock(int i, int j) {
        super(i, j, Material.iron);
    }

    public int idDropped(int i, Random random) {
        return mod_MinecraftPlus.BlockHealBlock.blockID;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBoxFromPool((float)par2 + f, par3, (float)par4 + f, (float)(par2 + 1) - f, (float)(par3 + 1) - f, (float)(par4 + 1) - f);
    }
        
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
    if(ModLoader.getMinecraftInstance().thePlayer.health < 20)
    {
        ModLoader.getMinecraftInstance().thePlayer.heal(1);
    }
    }

}