package net.mod_MinecraftPlus;
 
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIBreakDoor;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMoveThroughVillage;
import net.minecraft.src.EntityAIMoveTwardsRestriction;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

/* PLEASE DO NOT CHANGE ANY VALUES IF YOU DON'T KNOW WHAT YOU ARE DOING.
This file will let you to set values to change the mummy. */

public class EntityMummy extends EntityMob
{
	public Minecraft minecraft;
    private static final ItemStack defaultHeldItem;
    public EntityPlayer player;
    
    public EntityMummy (World world)
    {
      // Basically the attributes of the monster.
        super (world);
        texture = "/minecraftplus/mobs/mummy.png";  //DO NOT CHANGE
        moveSpeed = 0.1F; // The speed the monster walks
        attackStrength = 6; // The amount of strength the monster has to attack.
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityHuman.class, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
        this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHuman.class, 16.0F, 0, false));
    
    }

    public int getMaxHealth()
    {
      //The health of the monster.
        return 20;
    }
    
    public boolean isAIEnabled(){
    	return true;
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
    
    protected void dropFewItems()
    {
    	Random randomGenerator = new Random();
        int rarity = randomGenerator.nextInt(3);
        int rarity2 = randomGenerator.nextInt(3);
        int rarity3 = randomGenerator.nextInt(10);
        
        if(rarity == 1){
            if(rarity2 == 1){
    	    dropItem(Item.paper.shiftedIndex, 1);
            }
            if(rarity2 == 2){
        	    dropItem(Item.paper.shiftedIndex, 2);
                }
            if(rarity2 == 3){
        	    dropItem(Item.paper.shiftedIndex, 3);
                }
        }
    	
        if(rarity == 2){
            if(rarity2 == 1){
            dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 1);
            }
            if(rarity2 == 2){
                dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 2);
                }
            if(rarity2 == 3){
                dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 3);
                }
        }
        else{
            if(rarity3 == 9){
            	if(rarity2 == 1){
                    dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 1);
                    dropItem(Item.paper.shiftedIndex, 1);
                    }
                if(rarity2 == 2){
                        dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 2);
                        dropItem(Item.paper.shiftedIndex, 2);
                        }
                if(rarity2 == 3){
                        dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 3);
                        dropItem(Item.paper.shiftedIndex, 3);
                        }
        	}
        }
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
        
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
      
      if(q <= 1){
      entityplayer.addChatMessage("Arrrghhhghhghghghrhgrghrhgrhgrhgrhg!");
      }
      if(q == 2){
      entityplayer.addChatMessage("Rawwwwwwwwwrrrrrrrrr!");
      }
      if(q == 3){
      entityplayer.addChatMessage("Arghrghgrhgrhgrhrghrrhrgggggrhhhh!");
      }
      if(q >= 4){
      entityplayer.addChatMessage("Uuuuhhuhuhuhuhuhuhhhhhhhhhhh!");
      }
      
    //Check to see what's in the current slot.
      ItemStack currentItem = entityplayer.inventory.getCurrentItem(); 
      int rarity = randomGenerator.nextInt(2);
      int rarity2 = randomGenerator.nextInt(3);
      int rarity3 = randomGenerator.nextInt(20);
      if (!worldObj.isRemote)
      {  
      if(currentItem == null || currentItem.itemID == Item.shears.shiftedIndex)
      {
      setDead();    
      if(rarity == 1){
          if(rarity2 == 1){
  	    dropItem(Item.paper.shiftedIndex, 1);
          }
          if(rarity2 == 2){
      	    dropItem(Item.paper.shiftedIndex, 2);
              }
          if(rarity2 == 3){
      	    dropItem(Item.paper.shiftedIndex, 3);
              }
      }
  	
      else if(rarity == 2){
          if(rarity2 == 1){
          dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 1);
          }
          if(rarity2 == 2){
              dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 2);
              }
          if(rarity2 == 3){
              dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 3);
              }
      }
      else{
          if(rarity3 == 9){
          	if(rarity2 == 1){
                  dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 1);
                  dropItem(Item.paper.shiftedIndex, 1);
                  }
              if(rarity2 == 2){
                      dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 2);
                      dropItem(Item.paper.shiftedIndex, 2);
                      }
              if(rarity2 == 3){
                      dropItem(MinecraftPlusBase.itemBandage.shiftedIndex, 3);
                      dropItem(Item.paper.shiftedIndex, 3);
                      }
      	}
      }
      EntitySkeleton entityskeleton = new EntitySkeleton(worldObj);
      entityskeleton.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
      entityskeleton.setEntityHealth(getHealth());
      entityskeleton.renderYawOffset = renderYawOffset;
      worldObj.spawnEntityInWorld(entityskeleton);
      }
      }
      
      return super.interact(entityplayer);
    }
    
}
