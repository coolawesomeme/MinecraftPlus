package net.minecraftplus_mod;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class PlusGuiHandler implements IGuiHandler {
	public static PlusGuiHandler instance;
	
	public static int splashScreenGUIID = 0;
	
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
                return null;
        }

        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        	if(id == splashScreenGUIID){
        		String var1 = this.getRandomSplashscreenMessage();
    			return new GuiSplashscreen(var1);
    		}
        	return null;
        }
        
        private String getRandomSplashscreenMessage(){
        	Random random = new Random();
        	int messageChooser = random.nextInt(3);
        	return (messageChooser <= 1) ? RandomMessage.getRandomMessage() : RandomMessage.getRandomTooltip();
    		
        }
}