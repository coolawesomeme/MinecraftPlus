package net.minecraftplus_mod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EnumGameType;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ClientTickHandler implements ITickHandler 
{
	private boolean notSTARTUP = false;
    public String modver = MinecraftPlusBase.modver;
    public String mcver = MinecraftPlusBase.mcver;
    public String codever = MinecraftPlusBase.codever;
    public String modver2 = "missingno";
    public String modver3 = "missingno";
    public String updateMessage = "missingno";
    public String updateMessage2 = "missingno";
    private boolean isPlayerWearingSpecialArmor = true;
    private boolean isBetaVersion = true;
    private static int clientTickCount = 0;
    private static int clientSecondCount = 0;
    private static int clientTickNumber = 1;
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) 
	{

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) 
	{
		clientTickCount++;
		
		int var1 = 20 * clientTickNumber;
    	if(clientTickCount == var1){
    		clientTickNumber++;
    		clientSecondCount++;
    	}
		
		//Example of using onTick methods such as is used in ModLoader's implementation
		if (type.equals(EnumSet.of(TickType.RENDER)))
        {
            onRenderTick();
        }
        else if (type.equals(EnumSet.of(TickType.CLIENT)))
        {
        	Minecraft mc = Minecraft.getMinecraft();
            GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
            if (guiscreen != null)
            {
                onTickInGUI(mc, guiscreen);
            } else {
                onTickInGame(mc);
            }
        }
	}

	private void onTickInGame(Minecraft minecraft) 
	{
		if(!notSTARTUP){
		initialization(minecraft, 0, 0, 0);
		onClientStartup(minecraft);
		}
	    armorSpecial(minecraft);
	}

	public void initialization(Minecraft minecraft, int i, int j, int k)
    {
        Random randomGenerator = new Random();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int month2 = calendar.get(2) + 1;
        int date = calendar.get(5);
        String month = "missingno";
        String suffix = "missingno";
        
        if(date == 1 || date == 21 || date == 31){
            suffix = "st";
        }
        if(date == 2 || date == 22){
            suffix = "nd";
        }
        if(date == 3 || date == 23){
            suffix = "rd";
        }
        if(date >= 4 && date <= 20 || date >= 24 && date <= 30){
            suffix = "th";
        }
        
        if(month2 == 1){
            month = "Jan.";
        }
        if(month2 == 2){
            month = "Feb.";
        }
        if(month2 == 3){
            month = "Mar.";
        }
        if(month2 == 4){
            month = "Apr.";
        }
        if(month2 == 5){
            month = "May.";
        }
        if(month2 == 6){
            month = "Jun.";
        }
        if(month2 == 7){
            month = "Jul.";
        }
        if(month2 == 8){
            month = "Aug.";
        }
        if(month2 == 9){
            month = "Sep.";
        }
        if(month2 == 10){
            month = "Oct.";
        }
        if(month2 == 11){
            month = "Nov.";
        }
        if(month2 == 12){
            month = "Dec.";
        }
        
        String username = minecraft.thePlayer.username;
        if(notSTARTUP == false){
            
            minecraft.thePlayer.addChatMessage("Minecraft+ " + codever + " \u00A72enabled" + "\u00A7f!");
            
            int s = randomGenerator.nextInt(5);
            if(s <= 1){
            minecraft.thePlayer.addChatMessage("Hello " + username + "!");
            }
            else if(s == 2){
            minecraft.thePlayer.addChatMessage("Hey " + username + "!");
            }
            else if(s == 3){
            minecraft.thePlayer.addChatMessage("Hi " + username + "!");
            }
            else if(s == 4){
            minecraft.thePlayer.addChatMessage("Welcome " + username + "!");
            }
            else if(s == 5){
            minecraft.thePlayer.addChatMessage("Welcome " + username + "!");
            }
            
            minecraft.thePlayer.addChatMessage("Today is " + month + " " + date + suffix + " " + calendar.get(Calendar.YEAR) + ".");
            
            if(!isBetaVersion){
            int counter = 0;
            try {
                // Create a URL for the desired page
                URL url = new URL("https://raw.github.com/coolawesomeme/MinecraftPlus/master/MODUPDATE.txt");

                // Read all the text returned by the server
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((modver2 = in.readLine()) != null) {
    	        // str is one line of text; readLine() strips the newline character(s)
    	    	String[] temp;
    	    	 
    	    	  // delimiter
    	    	  String delimiter = "-";
    	    	  // given string will be split by the argument delimiter provided.
    	    	  temp = modver2.split(delimiter);
            	
            	if(temp[0].equals("null") || temp[0].equals("void") || temp[0].equals("missingno") || temp[0].equals("")){
            		temp[0] = modver;
            		temp[0].equals(modver);
            	}
            	
                System.out.println("Latest mod version found: Minecraft+ " + temp[0] + ".");
                
                if(temp[0].equals(modver)){
                	System.out.println("[MC+] Mod up to date!");
                }
                else{
                minecraft.thePlayer.addChatMessage("");
                minecraft.thePlayer.addChatMessage("An update of " + "Minecraft+ (Version " + temp[0] + ") " + "is available!");
                minecraft.thePlayer.addChatMessage("\u00A7bhttp://bit.ly/MCPlus" + "\u00A7f");
                if(!temp[1].isEmpty()){
                minecraft.thePlayer.addChatMessage(temp[1]);
                } if(!temp[2].isEmpty()){
                minecraft.thePlayer.addChatMessage(temp[2]);
                }
                System.out.println("An update of " + "Minecraft+ (Version " + temp[0] + ") " + "is available!");
                System.out.println("http://bit.ly/MCPlus");
                }
                
                counter++;
            }
            
            in.close();
            } catch (Exception e) {
            	System.err.println("[MC+] Error: " + e);
            }
            } 
            // For internal testing:
            else if(isBetaVersion){
            int counter2 = 0;
              try {
                // Create a URL for the desired page
                URL url = new URL("https://raw.github.com/coolawesomeme/MinecraftPlus/master/MODUPDATE2.txt");

                // Read all the text returned by the server
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                while ((modver3 = in.readLine()) != null) {
        	        // str is one line of text; readLine() strips the newline character(s)
        	    	String[] temp;
        	    	 
        	    	  // delimiter
        	    	  String delimiter = "-";
        	    	  // given string will be split by the argument delimiter provided.
        	    	  temp = modver3.split(delimiter);
                	
                	if(temp[0].equals("null") || temp[0].equals("void") || temp[0].equals("missingno") || temp[0].equals("")){
                		temp[0] = modver;
                		temp[0].equals(modver);
                	}
                	
                    System.out.println("Latest beta mod version found: Minecraft+ " + temp[0] + ".");
                    
                    if(temp[0].equals(modver)){
                    	System.out.println("[MC+] Mod up to date!");
                    }
                    else{
                    minecraft.thePlayer.addChatMessage("");
                    minecraft.thePlayer.addChatMessage("An update of " + "Minecraft+ (Version " + temp[0] + ") " + "is available!");
                    minecraft.thePlayer.addChatMessage("(\u00A7bJust ask coolawesomeme\u00A7f!)");
                    if(temp[1].isEmpty() == false){
                    minecraft.thePlayer.addChatMessage(temp[1]);
                    } if(temp[1].isEmpty() == false){
                    minecraft.thePlayer.addChatMessage(temp[2]);
                    }
                    System.out.println("An update of " + "Minecraft+ (Version " + temp[0] + ") " + "is available!");
                    System.out.println("(Ask coolawesomeme!)");
                    }
                    
                    counter2++;
                }
                
                in.close();
            } catch (Exception e) {
            	System.err.println("[MC+] Error: " + e);
            }
        	}
            notSTARTUP = true;
            
            if (calendar.get(2) + 1 == 4 && calendar.get(5) == 5)
            {
            	minecraft.thePlayer.addChatMessage("");
                minecraft.thePlayer.addChatMessage("Happy birthday, Minecraft+!");
                minecraft.thePlayer.addChatMessage("Today is the day Minecraft+ was published on Minecraft Forums!");
                minecraft.thePlayer.addChatMessage("CELEBRATION!!!!!!!!!!");
                try
                { 
                Process p = Runtime.getRuntime().exec("cmd /c start http://bit.ly/MCPlus"); 
                } 
                catch(Exception e1) {System.err.println(e1);} 
            }if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1)
            {
            	minecraft.thePlayer.addChatMessage("Happy New Year " + calendar.get(Calendar.YEAR) + " from the Minecraft+ team!");
            }if (calendar.get(2) + 1 == 12 && calendar.get(5) == 25)
            {
            	minecraft.thePlayer.addChatMessage("Happy Holidays " + calendar.get(Calendar.YEAR) + " from the Minecraft+ team!");
            }
        }
        }
    
    public void armorSpecial(Minecraft minecraft)
    {
        ItemStack boots = minecraft.thePlayer.inventory.armorInventory[0];
        ItemStack legs = minecraft.thePlayer.inventory.armorInventory[1];
        ItemStack chest = minecraft.thePlayer.inventory.armorInventory[2];
        ItemStack helm = minecraft.thePlayer.inventory.armorInventory[3];
        
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        
        if(helm != null && helm.itemID == MinecraftPlusBase.ironManHelmet.shiftedIndex){
                if(minecraft.thePlayer.canBreatheUnderwater() == false)
                {
                    minecraft.thePlayer.setAir(300);
                }
                flag1 = true;
        }
        if(boots != null && boots.itemID == MinecraftPlusBase.ironManBoots.shiftedIndex){
                minecraft.thePlayer.fallDistance = 0.0F;
                flag2 = true;
        }
        if(chest != null && chest.itemID == MinecraftPlusBase.ironManChest.shiftedIndex){
            minecraft.thePlayer.capabilities.setFlySpeed(0.04F);
            flag3 = true;
        }
        if(legs != null && legs.itemID == MinecraftPlusBase.ironManPants.shiftedIndex){
        	minecraft.thePlayer.fireResistance = 200;
            flag4 = true;
        }
        if(flag1 == true && flag2 == true && flag3 == true && flag4 == true){
            minecraft.thePlayer.capabilities.allowFlying = true;
        }
        else{
        	EnumGameType gameType = minecraft.theWorld.getWorldInfo().getGameType();
        	if(gameType != EnumGameType.CREATIVE){
            minecraft.thePlayer.capabilities.allowFlying = false;
            minecraft.thePlayer.fireResistance = 0;
        	}
        	minecraft.thePlayer.capabilities.setFlySpeed(0.02F);
            isPlayerWearingSpecialArmor = false;
        }
        }
	
	public void onClientStartup(Minecraft minecraft) {}
	
	private void onTickInGUI(Minecraft minecraft, GuiScreen guiscreen) 
	{
		//Do stuff in Gui here
	}

	private void onRenderTick() 
	{
		
	}

	@Override
	public EnumSet<TickType> ticks() 
	{
		//You must return an EnumSet.of();. You will pull an error if you return Null
		return EnumSet.of(TickType.RENDER, TickType.CLIENT);
	}

	@Override
	public String getLabel() 
	{
		//Return whatever label you like
		return "mod_MinecraftPlus.ClientTickHandler";
	}

	public boolean isStartup(){
    	return !notSTARTUP;
    }
    
    public String getMonthAndDate(){
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int month2 = calendar.get(2) + 1;
        int date = calendar.get(5);
        String month = "missingno";
        String suffix = "missingno";
        
        if(date == 1 || date == 21 || date == 31){
            suffix = "st";
        }
        if(date == 2 || date == 22){
            suffix = "nd";
        }
        if(date == 3 || date == 23){
            suffix = "rd";
        }
        if(date >= 4 && date <= 20 || date >= 24 && date <= 30){
            suffix = "th";
        }
        
        if(month2 == 1){
            month = "Jan.";
        }
        if(month2 == 2){
            month = "Feb.";
        }
        if(month2 == 3){
            month = "Mar.";
        }
        if(month2 == 4){
            month = "Apr.";
        }
        if(month2 == 5){
            month = "May.";
        }
        if(month2 == 6){
            month = "Jun.";
        }
        if(month2 == 7){
            month = "Jul.";
        }
        if(month2 == 8){
            month = "Aug.";
        }
        if(month2 == 9){
            month = "Sep.";
        }
        if(month2 == 10){
            month = "Oct.";
        }
        if(month2 == 11){
            month = "Nov.";
        }
        if(month2 == 12){
            month = "Dec.";
        }
    	
		return month + " " + date + suffix;
    }
	
    public boolean getIsPlayerWearingExtraordinaryArmor(){
    	return isPlayerWearingSpecialArmor;
    }
    
    public void setIsPlayerWearingExtraordinaryArmor(boolean yeserno){
    	isPlayerWearingSpecialArmor = yeserno;
    }
    
    public static int getClientTickCount(){
    	return clientTickCount;
    }
    
    public static int getClientSecondCount(){
    	return clientSecondCount;
    }
    
    public static void resetTickCount(){
    	clientTickNumber = 0;
    	clientTickCount = 0;
    }
}
