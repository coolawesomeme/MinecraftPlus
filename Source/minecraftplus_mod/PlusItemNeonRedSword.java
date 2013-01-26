package net.minecraftplus_mod;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class PlusItemNeonRedSword extends PlusItemSword{

	public PlusItemNeonRedSword(int par1, EnumToolMaterial par2EnumToolMaterial, int par3Damage) {
		super(par1, par2EnumToolMaterial, par3Damage);
	}

	/**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
    	par2EntityLiving.setFire(5);
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }
	
}
