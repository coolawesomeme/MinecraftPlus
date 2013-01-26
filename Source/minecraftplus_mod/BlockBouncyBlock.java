package net.minecraftplus_mod;

import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBouncyBlock extends BlockNormal
{
public BlockBouncyBlock(int i, int j)
{
super(i, j, Material.wood);
                setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
                setLightOpacity(0);
}

        public int idDropped(int i, Random random, int j)
        {
                return MinecraftPlusBase.bouncyBlock.blockID;
        }

        public int quantityDropped(Random random)
        {
                return 1;
        }

        public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
        {
                if (this != Block.stairsBrick || this != Block.stairsBrick.stairsNetherBrick || this != Block.stairsSandStone || this != Block.stairsStoneBrickSmooth || this != Block.stairsWoodBirch || this != Block.stairsWoodJungle || this != Block.stairsWoodSpruce)
                {
                        super.shouldSideBeRendered(iblockaccess, i, j, k, l);
                }
                if (l == 1)
                {
                        return true;
                }
                if (!super.shouldSideBeRendered(iblockaccess, i, j, k, l))
                {
                        return false;
                }
                if (l == 0)
                {
                        return true;
                }
                else
                {
                        return iblockaccess.getBlockId(i, j, k) != blockID;
                }
        }
        public void onEntityWalking(World world, int x, int y, int z,
                Entity entity)
                    {
                            entity.motionY += 2.0;
                    }

        public int getBlockTextureFromSideAndMetadata(int i, int j)
        {
                return getBlockTextureFromSide(i);
        }

        /**
         * Returns the block texture based on the side being looked at.  Args: side
         */
        public int getBlockTextureFromSide(int i)
        {
            if (i == 0)
            {
                    return 0;
            }
            if (i == 1)
            {
                    return 7;
            }
            else
            {
                    return 8;
            }
        }

        /**
         * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
         */
        public boolean renderAsNormalBlock()
        {
            return false;
        }

        /**
         * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
         * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
         */
        public boolean isOpaqueCube()
        {
            return false;
        }

        public int getMobilityFlag()
        {
            return 1;
        }
}
