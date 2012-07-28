package net.minecraft.src;
 
// This class is for Vortex Crystals (Please don't change!).
public class ItemVortexCrystal extends Item
{
        public ItemVortexCrystal(int i)
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