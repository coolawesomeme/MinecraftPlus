package net.minecraftplus_mod;
 
/* PLEASE DO NOT CHANGE ANY VALUES IF YOU DON'T KNOW WHAT YOU ARE DOING.
This file will let you to set values to change the Humans. */

import java.util.Random;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityAIAvoidEntity;
import net.minecraft.src.EntityAIFollowGolem;
import net.minecraft.src.EntityAIMoveIndoors;
import net.minecraft.src.EntityAIMoveTwardsRestriction;
import net.minecraft.src.EntityAIOpenDoor;
import net.minecraft.src.EntityAIPlay;
import net.minecraft.src.EntityAIRestrictOpenDoor;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIVillagerMate;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAIWatchClosest2;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityHuman extends EntityCreature
{
	public Minecraft minecraft;
	private static final ItemStack defaultHeldItem;
    private static int messageNumber = 31;
    private static int messageNumber2 = messageNumber;
    private static String[] customMessage = null;
    private static int addedMessageNumber = 0;
    private int lastRarity = messageNumber - 1;
    public EntityPlayer player;
	
    public EntityHuman (World world)
    {
      // Basically the attributes of the monster.
        super(world);
        texture = "/mob/char.png";  //DO NOT CHANGE
        moveSpeed = 0.7F; // The speed the mob walks
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMummy.class, 8.0F, 0.3F, 0.35F));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTwardsRestriction(this, 0.3F));
        this.tasks.addTask(6, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(6, new EntityAIWatchClosest2(this, EntityVillager.class, 5.0F, 0.02F));
        this.tasks.addTask(6, new EntityAIWatchClosest2(this, EntityHuman.class, 5.0F, 0.02F));
        this.tasks.addTask(6, new EntityAIWander(this, 0.3F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    
    }
    
    public boolean isAIEnabled(){
    	return true;
    }
    
    public int getMaxHealth()
    {
      //The health of the creature.
        return 20;
    }
    
    public static void addHumanMessage(String par1String){
    	customMessage[addedMessageNumber] = par1String;
    	addedMessageNumber++;
    	messageNumber2++;
    }
    
    public void onLivingUpdate()
    {    // If then loop..... setting
        if (worldObj.isDaytime() && !worldObj.isRemote)
        {
            float f = getBrightness(1.0F);
            if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
            {
                /*setFire(8);*/
            }
        }
        super.onLivingUpdate();
    }
    
    protected void dropFewItems()
    {
        
        Random randomGenerator = new Random();
        int rarity = randomGenerator.nextInt(31);
        
        dropItem(Block.plantRed.blockID, 1);
        
        if(rarity == 9){
        dropItem(Item.cookie.shiftedIndex, 1);
        }
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    protected String getLivingSound()
    {
        return "none";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "none";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "none";
    }
    
    public boolean interact(EntityPlayer entityplayer)
    {
        Random randomGenerator = new Random();
        int p = randomGenerator.nextInt(messageNumber2);
        
        if(p <= 1){
        entityplayer.addChatMessage("Hi, my name is Steve!");
        entityplayer.addChatMessage("");
        }
        if(p == 2){
        entityplayer.addChatMessage("I don't know how I got here.");
        entityplayer.addChatMessage("");
        }
        if(p == 3){
        entityplayer.addChatMessage("Do you know who coolawesomeme is?");
        entityplayer.addChatMessage("I heard he's pretty cool.");
        entityplayer.addChatMessage("");
        }
        if(p == 4){
        entityplayer.addChatMessage("42 is the answer to life, the universe and everything.");
        entityplayer.addChatMessage("");
        }
        if(p == 5){
        entityplayer.addChatMessage("I like pie!");
        entityplayer.addChatMessage("");
        }
        if(p == 6){
        entityplayer.addChatMessage("psssssst... Have you seen Herobrine?");
        entityplayer.addChatMessage("Legend says he is Notch's half-brother and is quite deadly.");
        entityplayer.addChatMessage("");
        }
        if(p == 7){
        boolean var4 = minecraft.theWorld.isDaytime();
        boolean var2 = minecraft.theWorld.isRaining();
        boolean var3 = minecraft.theWorld.isThundering();
        if(var2 == true && var3 == false && var4 == true){
        entityplayer.addChatMessage("It's raining/ snowing right now!");
        entityplayer.addChatMessage("");
        }
        if(var2 == true && var3 == true && var4 == true){
        entityplayer.addChatMessage("It's raining and thundering right now!");
        entityplayer.addChatMessage("");
        }
        if(var2 == false && var3 == false && var4 == true){
        entityplayer.addChatMessage("It's sunny/ cloudy right now!");
        entityplayer.addChatMessage("");
        }
        if(var2 == true && var3 == false && var4 == false){
        entityplayer.addChatMessage("It's raining/ snowing right now!");
        entityplayer.addChatMessage("");
        }
        if(var2 == true && var3 == true && var4 == false){
        entityplayer.addChatMessage("It's raining and thundering right now!");
        entityplayer.addChatMessage("");
        }
        if(var2 == false && var3 == false && var4 == false){
        entityplayer.addChatMessage("It's cloudy right now!");
        entityplayer.addChatMessage("");
        }
        }
        if(p == 8){
        entityplayer.addChatMessage("How many times have you right-clicked on me?");
        entityplayer.addChatMessage("");
        }
        if(p == 9){
        entityplayer.addChatMessage("jeb_!");
        entityplayer.addChatMessage("");
        }
        if(p == 10){
        entityplayer.addChatMessage("\u00A74N" + "\u00A76Y" + "\u00A7eA" + "\u00A72N" + " \u00A7bC" + "\u00A73A" + "\u00A75T" + "\u00A7f!");
        entityplayer.addChatMessage("");
        }
        if(p == 11){
        entityplayer.addChatMessage("Send this link to your friends:");
        entityplayer.addChatMessage("http://bit.ly/MCPlus");
        entityplayer.addChatMessage("");
        }
        if(p == 12){
        entityplayer.addChatMessage("Reddit is awesome!");
        entityplayer.addChatMessage("");
        }
        if(p == 13){
        entityplayer.addChatMessage("/r/Minecraft !");
        entityplayer.addChatMessage("");
        }
        if(p == 14){
        entityplayer.addChatMessage("/r/MinecraftPlus !");
        entityplayer.addChatMessage("");
        }
        if(p == 15){
        entityplayer.addChatMessage("Minecraft Forums!");
        entityplayer.addChatMessage("");
        }
        if(p == 16){
        entityplayer.addChatMessage("Notch!");
        entityplayer.addChatMessage("");
        }
        if(p == 17){
        entityplayer.addChatMessage("My cabbages!");
        entityplayer.addChatMessage("");
        }
        if(p == 18){
        entityplayer.addChatMessage("Han shot first!");
        entityplayer.addChatMessage("");
        }
        if(p == 19){
        String username = entityplayer.username;
        entityplayer.addChatMessage(username.toUpperCase() + ", I AM YOUR FATHER!");
        entityplayer.addChatMessage("");
        }
        if(p == 20){
        entityplayer.addChatMessage("MEMES... MEMES EVERYWHERE!");
        entityplayer.addChatMessage("");
        }
        if(p == 21){
        entityplayer.addChatMessage("There iz too many cats on the intranetz.");
        entityplayer.addChatMessage("");
        }
        if(p == 22){
        entityplayer.addChatMessage("The cake is a lie.");
        entityplayer.addChatMessage("");
        }
        if(p == 23){
        entityplayer.addChatMessage("THEY SEE ME ROLLING");
        entityplayer.addChatMessage("THEY HATIN'");
        entityplayer.addChatMessage("");
        }
        if(p == 24){
        String username = entityplayer.username;
        entityplayer.addChatMessage("Help me, " + username + ", you're my only hope!");
        entityplayer.addChatMessage("");
        }
        if(p == 25){
        String username = entityplayer.username;
        entityplayer.addChatMessage("Hi, " + "\u00A7b" + username + "\u00A7f!");
        entityplayer.addChatMessage("Nice weather we're having, eh?");
        entityplayer.addChatMessage("");
        }
        if(p == 26){
        entityplayer.addChatMessage("Cool Story Bro...");
        entityplayer.addChatMessage("Tell it again.");
        entityplayer.addChatMessage("");
        }
        if(p == 27){
        entityplayer.addChatMessage("We got all the right friends in all the right places, so yeah we're going down!");
        entityplayer.addChatMessage("");
        }
        if(p == 28){
        String username = entityplayer.username;
        entityplayer.addChatMessage("Hi, " + "\u00A7b" + username + "\u00A7f!");
        entityplayer.addChatMessage("Nice weather we're having, eh?");
        entityplayer.addChatMessage("");
        }
        if(p == 29){
        entityplayer.addChatMessage("I am a creeper in disguise. (Or am I?)");
        entityplayer.addChatMessage("SSSsss...");
        entityplayer.addChatMessage("BOOOOOOOM!");
        entityplayer.addChatMessage("");
        }
        if(p == 30){
        entityplayer.addChatMessage("...");
        entityplayer.addChatMessage("");
        }
        for(int i = 0; i < addedMessageNumber; i++){
        if(p == lastRarity++){
        entityplayer.addChatMessage(customMessage[i]);
        entityplayer.addChatMessage("");
        lastRarity++;
        }
        }
        return super.interact(entityplayer);
    }
    
    public ItemStack getHeldItem()
    {
        return defaultHeldItem;
    }

    static
    {
    	defaultHeldItem = new ItemStack(Block.plantRed, 1);
    }
}
