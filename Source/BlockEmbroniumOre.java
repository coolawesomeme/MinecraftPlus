package net.minecraft.src;
 
import java.util.Random;
 
public class BlockEmbroniumOre extends Block {
    protected BlockEmbroniumOre(int i, int j) {
        super(i, j, Material.iron);
    } 
    
    public int idDropped(int i, Random random) {
        return mod_MinecraftPlus.BlockEmbroniumOre.blockID;
    }
}