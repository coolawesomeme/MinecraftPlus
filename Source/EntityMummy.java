package net.minecraft.src;
 
import java.util.Random;

/* PLEASE DO NOT CHANGE ANY VALUES IF YOU DON'T KNOW WHAT YOU ARE DOING.
This file will let you to set values to change the mummy. */

public class EntityMummy extends EntityMob
{
    private static final ItemStack defaultHeldItem;
    
    public EntityMummy (World world)
    {
      // Basically the attributes of the monster.
        super (world);
        texture = "/minecraftplus/mummy.png";  //DO NOT CHANGE
        moveSpeed = 0.8F; // The speed the monster walks
        attackStrength = 4; // The amount of strength the monster has to attack.
    }

    public int getMaxHealth()
    {
      //The health of the monster.
        return 20;
    }

    public void onLivingUpdate()
    {    // If then loop..... setting
        if (worldObj.isDaytime() && !worldObj.isRemote)
        {
            float f = getBrightness(1.0F);
            if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
            {
                /*This is the code to set it on fire, leave blank because we want mummy to live during the day.
                setFire(8);*/
            }
        }
        super.onLivingUpdate();
    }
    
    protected int getDropItemId()
    {
        return mod_MinecraftPlus.ItemBandage.shiftedIndex;
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
        
    }
    
    protected boolean isAIEnabled()
    {
        return false;
    }
    
    protected String getLivingSound()
    {
        return "mob.zombie";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.zombiehurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.zombiedeath";
    }
            
    public ItemStack getHeldItem()
            {
                return defaultHeldItem;
            }

            static
            {
                defaultHeldItem = new ItemStack(Item.swordGold, 1);
            }
        
    
    public boolean interact(EntityPlayer entityplayer)
    {
      Random randomGenerator = new Random();
      int q = randomGenerator.nextInt(5);
      
      if(q == 1){
      ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Arrrghhhghhghghghrhgrghrhgrhgrhgrhg!");
      }
      if(q == 2){
      ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Rawwwwwwwwwrrrrrrrrr!");
      }
      if(q == 3){
      ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Arghrghgrhgrhgrhrghrrhrgggggrhhhh!");
      }
      if(q >= 4){
      ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Uuuuhhuhuhuhuhuhuhhhhhhhhhhh!");
      }
        
        return true;
    }
    
    public void onDeath(EntityPlayer entityplayer, DamageSource par1DamageSource, EntitySkeleton entityskeleton, EntityMummy entitymummy, int par2)
    {
        //Check to see what's in the current slot.
        ItemStack currentItem = entityplayer.inventory.getCurrentItem(); 
          
            if(currentItem == null || currentItem.itemID == Item.shears.shiftedIndex)
            {
            setDead();
            entityskeleton = new EntitySkeleton(worldObj);
            entityskeleton.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
            worldObj.spawnEntityInWorld(entityskeleton);
            }
    }
    
}
