package net.minecraft.src;
  
import java.util.Random;
 
public class BlockBoosterBlock extends Block {
    protected BlockBoosterBlock(int i, int j) {
        super(i, j, Material.iron);
        slipperiness = 1.5F;
    }

    public int getBlockTextureFromSideAndMetadata(int i)
    {
            if (i == 0)
            {
                    return mod_MinecraftPlus.BoosterBlock;
            }
            if (i == 1)
            {
                    return mod_MinecraftPlus.BoosterBlock;
            }
            else
            {
                    return mod_MinecraftPlus.EmptyWhite;
            }
    }
    
    public int getBlockTextureFromSide(int i)
    {
        if (i == 0)
        {
                return mod_MinecraftPlus.BoosterBlock;
        }
        if (i == 1)
        {
                return mod_MinecraftPlus.BoosterBlock;
        }
        else
        {
                return mod_MinecraftPlus.EmptyWhite;
        }
    }
    
    public int idDropped(int i, Random random) {
        return mod_MinecraftPlus.BlockBoosterBlock.blockID;
    }
    
}