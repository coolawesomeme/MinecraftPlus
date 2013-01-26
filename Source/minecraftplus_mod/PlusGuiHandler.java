package net.minecraftplus_mod;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class PlusGuiHandler implements IGuiHandler {
	public static PlusGuiHandler instance;
	
	public static int splashScreenID = 0;
	
        //returns an instance of the Container you made earlier
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
                return null;
        }

        //returns an instance of the Gui you made earlier
        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        	String var1 = this.getRandomSplashscreenMessage();
        	if(id == splashScreenID){
    			return new GuiSplashscreen(var1);
    		}else if(id == -1){
    			return null;
    		}
    		
        	return null;
        }
        
        private String getRandomSplashscreenMessage(){
        	Random random = new Random();
        	int messageChooser = random.nextInt(3);
        	if(messageChooser <= 1){
        		int randInt1 = random.nextInt(16);
        		if(randInt1 <= 1)
        			return "Come with me if you want to live.";
        		else if(randInt1 == 2)
        			return "Help me "+ Minecraft.getMinecraft().thePlayer.username +", you're my only hope!";
        		else if(randInt1 == 3)
        			return "Hasta la Vista, baby.";
        		else if(randInt1 == 4)
        			return "The name's Bond. James Bond.";
        		else if(randInt1 == 5)
        			return "I'm the king of the world!";
        		else if(randInt1 == 6)
        			return "IT'S ALIVE!";
        		else if(randInt1 == 7)
        			return "I've a feeling we're not in Kansas anymore.";
        		else if(randInt1 == 8)
        			return "May the force be with you...";
        		else if(randInt1 == 9)
        			return "... Ah, Houston, we've had a problem.";
        		else if(randInt1 == 10)
        			return "JE PARLE UN PEU FRANCAIS!";
        		else if(randInt1 == 11)
        			return "SHUT UP AND TAKE MY MONEY!";
        		else if(randInt1 == 12)
        			return "Your mod is bad, and you should feel bad!";
        		else if(randInt1 == 13)
        			return "Your splashscreen is bad, and you should feel bad!";
        		else if(randInt1 == 14)
        			return "Live long and prosper.";
        		else if(randInt1 == 15)
        			return MinecraftColors.randomLetters + MinecraftColors.randomLetters + MinecraftColors.randomLetters + MinecraftColors.randomLetters;
        		else if(randInt1 >= 15)
        			return "And that, kids, is how I met your mother.";
    		}else if(messageChooser == 2){
    			int randInt2 = random.nextInt(7);
    			if(randInt2 <= 1)
    				return "[" + MinecraftColors.lightRed + "PROTIP" + MinecraftColors.reset + "]: Don't ever dig straight down.";
    			else if(randInt2 == 2)
    				return "[" + MinecraftColors.lightRed + "PROTIP" + MinecraftColors.reset + "]: The chicken is a spy! (Or not.)";
    			else if(randInt2 == 3)
    				return "[" + MinecraftColors.lightRed + "PROTIP" + MinecraftColors.reset + "]: Always bring a bucket o' water. ALWAYS.";
    			else if(randInt2 == 4)
    				return "[" + MinecraftColors.lightRed + "PROTIP" + MinecraftColors.reset + "]: TNT cannons can blow themselves up.";
    			else if(randInt2 == 5)
    				return "[" + MinecraftColors.lightRed + "PROTIP" + MinecraftColors.reset + "]: Half-slabs are sprayed with mob-protection spray! (Mobs won't spawn there.)";
    			else if(randInt2 >= 6)
    				return "[" + MinecraftColors.lightRed + "PROTIP" + MinecraftColors.reset + "]: Creepers go boom-boom.";
    		}else if(messageChooser >= 3){
    			
    		}
        	return "coolawesomeme is awesome!"; //Default error case
        }
}