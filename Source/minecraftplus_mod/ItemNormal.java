package net.minecraftplus_mod;

import net.minecraft.item.Item;

public class ItemNormal extends Item
{
		public String getTextureFile()
		{
			return MinecraftPlusBase.item_texture;
		}
		
        public ItemNormal(int par1)
        {
                super(par1);
                maxStackSize = 64;
        }
}