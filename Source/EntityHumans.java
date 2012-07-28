package net.minecraft.src;
 
/* PLEASE DO NOT CHANGE ANY VALUES IF YOU DON'T KNOW WHAT YOU ARE DOING.
This file will let you to set values to change the Humans. */

import java.util.Random;
import java.util.List;

public class EntityHumans extends EntityCreature
{
    
    public EntityHumans (World world)
    {
      // Basically the attributes of the monster.
        super (world);
        texture = "/mob/char.png";  //DO NOT CHANGE
        moveSpeed = 0.7F; // The speed the mob walks
    }
    
    public int getMaxHealth()
    {
      //The health of the creature.
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
    
    protected void dropFewItems()
    {
        dropItem(Block.plantRed.blockID, 1);
        
        Random randomGenerator = new Random();
        int rarity = randomGenerator.nextInt(51);
        
        if(rarity == 9){
        dropItem(Item.cookie.shiftedIndex, 1);
        }
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        return 2;
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
    
    protected boolean canDespawn()
    {
        return true;
    }
    
    public boolean interact(EntityPlayer entityplayer)
    {
        Random randomGenerator = new Random();
        int p = randomGenerator.nextInt(31);
        
        if(p <= 1){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Hi, my name is Steve!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 2){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("I don't know how I got here.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 3){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Do you know who coolawesomeme is?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("I heard he's pretty cool.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 4){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("42 is the answer to life, the universe and everything.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 5){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("I like pie!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 6){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("psssssst... Have you seen Herobrine?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Legend says he is Notch's half-brother and is quite deadly.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 7){
        boolean var4 = ModLoader.getMinecraftInstance().theWorld.isDaytime();
        boolean var2 = ModLoader.getMinecraftInstance().theWorld.isRaining();
        boolean var3 = ModLoader.getMinecraftInstance().theWorld.isThundering();
        if(var2 == true && var3 == false && var4 == true){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("It's raining/ snowing right now!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(var2 == true && var3 == true && var4 == true){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("It's raining and thundering right now!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(var2 == false && var3 == false && var4 == true){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("It's sunny/ cloudy right now!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(var2 == true && var3 == false && var4 == false){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("It's raining/ snowing right now!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(var2 == true && var3 == true && var4 == false){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("It's raining and thundering right now!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(var2 == false && var3 == false && var4 == false){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("It's cloudy right now!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        }
        if(p == 8){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("How many times have you right-clicked on me?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 9){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("jeb_!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 10){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("\u00A74N" + "\u00A76Y" + "\u00A7eA" + "\u00A72N" + " \u00A7bC" + "\u00A73A" + "\u00A75T" + "\u00A7f!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 11){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Send this link to your friends:");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("http://bit.ly/MCPlus");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 12){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Reddit is awesome!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 13){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("/r/Minecraft !");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 14){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("/r/MinecraftPlus !");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 15){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Minecraft Forums!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 16){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Notch!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 17){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("My cabbages!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 18){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Han shot first!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 19){
        String username = ModLoader.getMinecraftInstance().thePlayer.username;
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage(username + ", I AM YOUR FATHER!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 20){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("MEMES... MEMES EVERYWHERE!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 21){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("There iz too many cats on the intranetz.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 22){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("The cake is a lie.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 23){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("THEY SEE ME ROLLING");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("THEY HATIN'");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 24){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("... Is the cake a lie?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 25){
        String username = ModLoader.getMinecraftInstance().thePlayer.username;
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Hi, " + "\u00A7b" + username + "\u00A7f!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Nice weather we're having, eh?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 26){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cool Story Bro...");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Tell it again.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 27){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("We got all the right friends in all the right places, so yeah we're going down!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 28){
        String username = ModLoader.getMinecraftInstance().thePlayer.username;
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Hi, " + "\u00A7b" + username + "\u00A7f!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Nice weather we're having, eh?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p == 29){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("I am a creeper in disguise. (Or am I?)");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("SSSsss...");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("BOOOOOOOM!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        if(p >= 30){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("...");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        return true;
    }

    public static ItemStack heldItem;
    
    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    public ItemStack getHeldItem()
    {
        return heldItem;
    }
    
    static{
        
        heldItem = new ItemStack(Block.plantRed, 1);
    }
    
}
