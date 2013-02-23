package net.minecraftplus_mod;

import java.util.Random;


import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockTomatoCrop extends BlockNormal {
	private int Texture;
	
    public BlockTomatoCrop(int id, int texture) {
        super(id, texture, Material.plants);
        //this.setBlockBounds(0.25F, 0F, 0.25F, 0.75F, 1.0F, 0.75F);
        //this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.95F, 0.7F);
        this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F , 1.0F, 0.6F);
        Texture = texture;
        setTickRandomly(true);
    }
        
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }
        
    public int getRenderType() {
        return 1; // Magic number.
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public int getBlockTextureFromSideAndMetadata (int side, int metadata) {
        return Texture + metadata;
    }
    
    @Override
    public void updateTick (World world, int x, int y, int z, Random random) {
        if (world.getBlockMetadata(x, y, z) == 1) {
            return;
        }

        if (random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 25) != 0) {
            return;
        }

        world.setBlockMetadataWithNotify(x, y, z, 1);
    }

    @Override
    public void onNeighborBlockChange (World world, int x, int y, int z,
            int neighborId) {
        if (!canBlockStay(world, x, y, z)) {
            dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockWithNotify(x, y, z, 0);
        }
    }

    @Override
    public boolean canBlockStay (World world, int x, int y, int z) {
        Block soil = blocksList[world.getBlockId(x, y - 1, z)];
        return (world.getFullBlockLightValue(x, y, z) >= 8 || world
                .canBlockSeeTheSky(x, y, z))
                && (soil != null && soil.canSustainPlant(world, x, y - 1, z,
                        ForgeDirection.UP, (IPlantable) MinecraftPlusBase.tomatoSeeds));
    }
    
    public int idDropped(int metadata, Random random, int par2) {
        switch (metadata) {
        case 0:
            return MinecraftPlusBase.tomatoSeeds.shiftedIndex;
        case 1:
            return MinecraftPlusBase.Tomato.shiftedIndex;
        default: // Error case!
            return -1; // no item
        }
    }
    
    public int idPicked (World world, int x, int y, int z) {
        return MinecraftPlusBase.tomatoSeeds.shiftedIndex;
    }
    
    public void growCrop (World world, int x, int y, int z) {
        if (world.getBlockMetadata(x, y, z) != 1) {
        	world.setBlockMetadataWithNotify(x, y, z, 1);
        }
    }
}