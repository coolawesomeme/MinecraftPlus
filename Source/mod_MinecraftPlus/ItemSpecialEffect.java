package net.mod_MinecraftPlus;

import net.minecraft.src.EnumRarity;
import net.minecraft.src.ItemStack;

public class ItemSpecialEffect extends ItemNormal
{
        public ItemSpecialEffect(int i)
        {
                super(i);
                maxStackSize = 64;              
        }
        
        public boolean hasEffect(ItemStack par1ItemStack)
        {
            return true;
        }
        
        /**
         * Return an item rarity from EnumRarity
         */
        public EnumRarity getRarity(ItemStack par1ItemStack)
        {
            return EnumRarity.rare;
        }
}