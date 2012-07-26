package net.minecraft.src;

import java.util.Random;

public class BlockBouncyBlock extends Block
{

protected BlockBouncyBlock(int i, int j)
{
super(i, j, Material.wood);
                setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
                setLightOpacity(0);
}



        public int idDropped(int i, Random random, int j)
        {
                return mod_MinecraftPlus.BlockBouncyBlock.blockID;
        }

        public int quantityDropped(Random random)
        {
                return 1;
        }

        public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
        {
                if (this != Block.stairSingle)
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

        public int getBlockTextureFromSideAndMetadata(int i)
        {
                if (i == 0)
                {
                        return mod_MinecraftPlus.EmptyBottom;
                }
                if (i == 1)
                {
                        return mod_MinecraftPlus.BouncyTop;
                }
                else
                {
                        return mod_MinecraftPlus.BouncySides;
                }
        }
        

        /**
         * Returns the block texture based on the side being looked at.  Args: side
         */
        public int getBlockTextureFromSide(int i)
        {
        	if (i == 0)
            {
                    return mod_MinecraftPlus.EmptyBottom;
            }
            if (i == 1)
            {
                    return mod_MinecraftPlus.BouncyTop;
            }
            else
            {
                    return mod_MinecraftPlus.BouncySides;
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
