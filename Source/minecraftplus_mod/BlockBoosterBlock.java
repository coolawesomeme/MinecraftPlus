package net.minecraftplus_mod;

import java.util.Random;


import net.minecraft.block.material.Material;

public class BlockBoosterBlock extends BlockNormal {
    public BlockBoosterBlock(int i, int j) {
        super(i, j, Material.iron);
        slipperiness = 1.5F;
    }

    public int getBlockTextureFromSide(int i)
    {
        if (i == 0)
        {
                return 5;
        }
        if (i == 1)
        {
                return 5;
        }
        else
        {
                return 3;
        }
    }

    public int idDropped(int i, Random random) {
        return MinecraftPlusBase.boosterBlock.blockID;
    }
}