package net.minecraft.src;
 
import java.util.Random;
 
public class BlockEmbroniumBlock extends Block {

    protected BlockEmbroniumBlock(int i, int j) {
        super(i, j, Material.iron);
        setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
    }
   
    public int idDropped(int i, Random random) {
        return mod_MinecraftPlus.BlockEmbroniumBlock.blockID;
    }
}