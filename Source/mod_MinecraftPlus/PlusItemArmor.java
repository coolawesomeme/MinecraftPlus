package net.mod_MinecraftPlus;

import java.util.ArrayList;
import net.minecraft.src.*;
import net.minecraftforge.common.IArmorTextureProvider;

public class PlusItemArmor extends ItemArmor implements IArmorTextureProvider
{

        public PlusItemArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
        {
                super(i, enumarmormaterial, j, k);
        }

        @Override
        public String getTextureFile()
		{
			return "/minecraftplus/spritesheet_items.png";
		}
        
		@Override
		public String getArmorTextureFile(ItemStack itemstack) {
			if(itemstack.itemID == MinecraftPlusBase.embroniumHelmet.shiftedIndex || itemstack.itemID == MinecraftPlusBase.embroniumChest.shiftedIndex || itemstack.itemID == MinecraftPlusBase.embroniumBoots.shiftedIndex)
            {
                            return "/minecraftplus/armor/embroniumarmor_1.png";
            }
            if(itemstack.itemID == MinecraftPlusBase.embroniumPants.shiftedIndex)
            {
                            return "/minecraftplus/armor/embroniumarmor_2.png";
            }
            if(itemstack.itemID == MinecraftPlusBase.ironManHelmet.shiftedIndex || itemstack.itemID == MinecraftPlusBase.ironManChest.shiftedIndex || itemstack.itemID == MinecraftPlusBase.ironManBoots.shiftedIndex)
            {
                            return "/minecraftplus/armor/ironman_1.png";
            }
            if(itemstack.itemID == MinecraftPlusBase.ironManPants.shiftedIndex)
            {
                            return "/minecraftplus/armor/ironmanarmor_2.png";
            }
            return  "/minecraftplus/armor/embronium_2.png";
		}
}