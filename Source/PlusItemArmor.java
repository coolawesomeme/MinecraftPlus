package net.minecraft.src;
 
public class PlusItemArmor extends ItemArmor
{
 
    private static final int maxDamageArray[] = {
        11, 16, 15, 13
    };
    public final int armorType;
    public final int damageReduceAmount;
    public final int renderIndex;
    private final PlusArmorMaterial material;
 
    public PlusItemArmor(int i, PlusArmorMaterial plusarmormaterial, int j, int k)
    {
        super(i, EnumArmorMaterial.DIAMOND, j, k);
        material = plusarmormaterial;
        armorType = k;
        renderIndex = j;
        damageReduceAmount = plusarmormaterial.getDamageReductionAmount(k);
        setMaxDamage(plusarmormaterial.func_40576_a(k));
        maxStackSize = 1;
    }
 
    public int getItemEnchantability()
    {
        return material.getEnchantability();
    }
 
    static int[] getMaxDamageArray()
    {
        return maxDamageArray;
    }
 
}