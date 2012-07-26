package net.minecraft.src;

/* PLEASE DO NOT CHANGE ANY VALUES IF YOU DON'T KNOW WHAT YOU ARE DOING.
This file will let you to set values to change the Humans. */
import java.util.Random;
import java.util.List;

public class EntityHumans extends EntityCreature
{
	public static final ItemStack defaultHeldItem;
	
	public EntityHumans (World world)
	{
	  // Basically the attributes of the monster.
		super (world);
		texture = "/mob/char.png";  //DO NOT CHANGE
		moveSpeed = 0.7F; // The speed the mob walks
	}
	
    public int getMaxHealth()
    {
	  //The health of the monster.
        return 20;
    }

    public void onLivingUpdate()
    {	// If then loop..... setting
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
    	dropItem(Item.cookie.shiftedIndex, 1);
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    protected boolean isAIEnabled()
    {
    	return false;
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
    	int j = randomGenerator.nextInt(31);
    	
    	if(j <= 1){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Hi, my name is Steve!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
    	}
    	if(j == 2){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("I don't know how I got here.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
    	}
    	if(j == 3){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Do you know who coolawesomeme is?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("I heard he's pretty cool.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
    	}
    	if(j == 4){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("42 is the answer to life, the universe and everything.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 5){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("I like pie!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 6){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("psssssst... Have you seen Herobrine?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Legend says he is Notch's half-brother and is quite deadly.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 7){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Do you believe in the chicken conspiracy?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 8){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("How many times have you right-clicked on me?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 9){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("jeb_!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 10){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("\u00A74N" + "\u00A76Y" + "\u00A7eA" + "\u00A72N" + " \u00A7bC" + "\u00A73A" + "\u00A75T" + "\u00A7f!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 11){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Send this link to your friends:");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("http://bit.ly/MCPlus");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 12){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Reddit is awesome!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 13){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("/r/Minecraft !");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 14){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("/r/MinecraftPlus !");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 15){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Minecraft Forums!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 16){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Notch!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 17){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Videos by TheCanadianSnipes!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 18){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Textures by Shadow & pacman003!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 19){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Modded by coolawesomeme & nikblaze91!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 20){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("MEMES... MEMES EVERYWHERE!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 21){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("There are too many cats on the intarnetz.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 22){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("The cake is a lie.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 23){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("The cake is not a lie");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 24){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("... Is the cake a lie?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 25){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Want a cookie?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 26){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cool Story Bro...");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Tell it again.");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 27){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Mooooooooooooo!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 28){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Minecraft on Xbox?");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("yay-ya!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j == 29){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("SSSsss...");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("BOOOOOOOM!");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
    	if(j >= 30){
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("...");
        ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
        }
        return true;
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
