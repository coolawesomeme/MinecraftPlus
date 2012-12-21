package net.minecraftplus_mod;

    import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

    public class BlockRedstoneLampThin extends Block
    {
        /** Whether this lamp block is the powered version. */
        private final boolean powered;

        public BlockRedstoneLampThin(int par1, boolean par2)
        {
            super(par1, 211, Material.redstoneLight);
            this.powered = par2;
            
            setBlockBounds(0.25F, 0F, 0.25F, 0.75F, 1.0F, 0.75F);

            if (par2)
            {
                this.setLightValue(1.0F);
                ++this.blockIndexInTexture;
            }
        }

        /**
         * Called whenever the block is added into the world. Args: world, x, y, z
         */
        public void onBlockAdded(World par1World, int par2, int par3, int par4)
        {
            if (!par1World.isRemote)
            {
                if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
                {
                    par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 4);
                }
                else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
                {
                    par1World.setBlockWithNotify(par2, par3, par4, MinecraftPlusBase.redstoneLampThinActive.blockID);
                }
            }
        }

        /**
         * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
         * their own) Args: x, y, z, neighbor blockID
         */
        public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
        {
            if (!par1World.isRemote)
            {
                if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
                {
                    par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 4);
                }
                else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
                {
                    par1World.setBlockWithNotify(par2, par3, par4, MinecraftPlusBase.redstoneLampThinActive.blockID);
                }
            }
        }

        /**
         * Ticks the block if it's been scheduled
         */
        public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
        {
            if (!par1World.isRemote && this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.setBlockWithNotify(par2, par3, par4, MinecraftPlusBase.redstoneLampThinIdle.blockID);
            }
        }

        /**
         * Returns the ID of the items to drop on destruction.
         */
        public int idDropped(int par1, Random par2Random, int par3)
        {
            return MinecraftPlusBase.redstoneLampThinIdle.blockID;
        }

        /**
         * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
         */
        public int idPicked(World par1World, int par2, int par3, int par4)
        {
            return MinecraftPlusBase.redstoneLampThinIdle.blockID;
        }
        
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
