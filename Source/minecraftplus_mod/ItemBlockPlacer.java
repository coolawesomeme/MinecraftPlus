package net.minecraftplus_mod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemReed;

public class ItemBlockPlacer extends ItemReed
{
		public String getTextureFile()
		{
			return "/minecraftplus/spritesheet_items.png";
		}
		
        public ItemBlockPlacer(int par1, Block par2)
        {
                super(par1, par2);
                maxStackSize = 16;
        }
}