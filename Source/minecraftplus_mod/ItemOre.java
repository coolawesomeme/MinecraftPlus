package net.minecraftplus_mod;

import net.minecraft.item.Item;

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