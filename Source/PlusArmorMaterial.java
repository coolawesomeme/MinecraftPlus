package net.minecraft.src;
  
import java.util.Random;
 
public enum PlusArmorMaterial
{
    EMBRONIUM("EMBRONIUM", 25, 29, new int[] {
            3, 8, 6, 3
            }, 9),
    IRONMAN("IRONMAN", 25, 29, new int[] {
            3, 8, 6, 3
            }, 9),;
    
    private int maxDamageFactor;
    private int damageReductionAmountArray[];
    private int enchantability;
   
 
    private PlusArmorMaterial(String s, int i, int j, int ai[], int k)
    {
        maxDamageFactor = j;
        damageReductionAmountArray = ai;
        enchantability = k;
    }
 
    public int func_40576_a(int i)
    {
        return ItemArmor.getMaxDamageArray()[i] * maxDamageFactor;
    }
        public int getDamageReductionAmount(int i)
    {
        return damageReductionAmountArray[i];
    }
 
    public int getEnchantability()
    {
        return enchantability;
    }
   
    }