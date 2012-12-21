package net.minecraftplus_mod;

import net.minecraft.item.Item;

public class ItemNormal extends Item
{
		public String getTextureFile()
		{
			return "/minecraftplus/spritesheet_items.png";
		}
		
        public ItemNormal(int par1)
        {
                super(par1);
                maxStackSize = 64;
        }
}