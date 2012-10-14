package net.mod_MinecraftPlus;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemOre extends Item
{
		public String getTextureFile()
		{
			return "/minecraftplus/spritesheet_items.png";
		}
		
        public ItemOre(int par1)
        {
                super(par1);
                maxStackSize = 64;
        }
}