package net.minecraft.src;
 
public class PlusItemSpade extends PlusItemTool
{
    private static Block blocksEffectiveAgainst[];

    public PlusItemSpade(int par1, PlusToolMaterial par2PlusToolMaterial)
    {
        super(par1, 1, par2PlusToolMaterial, blocksEffectiveAgainst);
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        if (par1Block == Block.snow)
        {
            return true;
        }

        return par1Block == Block.blockSnow;
    }

    static
    {
        blocksEffectiveAgainst = (new Block[]
                {
                    Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium
                });
    }
}
