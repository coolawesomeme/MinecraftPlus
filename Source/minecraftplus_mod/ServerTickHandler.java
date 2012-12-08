package net.minecraftplus_mod;

import java.util.EnumSet;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.RConConsoleSource;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ServerTickHandler implements ITickHandler 
{	
	public boolean notServerSTARTUP = false;
	private boolean notServerSTARTUP2 = false;
	private static int serverTickCount = 0;
	private static int serverSecondCount = 0;
	private static int serverTickNumber = 1;
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) 
	{

	}
	
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) 
	{
		serverTickCount++;
		
		int var1 = 20 * serverTickNumber;
    	if(serverTickCount == var1){
    		serverTickNumber++;
    		serverSecondCount++;
    	}
		
    	//Example of using onTick methods such as is used in ModLoader's implementation
    	        if (type.equals(EnumSet.of(TickType.SERVER)))
    	        {
    	        	if(!notServerSTARTUP){
    	            onTickInServer();
    	        	}
    	        	if(!notServerSTARTUP2){
    	    			onServerSTARTUP();
    	    			notServerSTARTUP2 = true;
    	    		}
    	        }
	}

	private void onTickInServer() {
		//MinecraftServer.getServer().executeCommand("say Minecraft+ Server Version Enabled!");
		System.out.print("Minecraft+ " + MinecraftPlusBase.codever + " loaded!\n");
		
		notServerSTARTUP = true;
	}

	public void onServerSTARTUP() {}

	@Override
	public EnumSet<TickType> ticks() 
	{
		//Again, you have to return an EnumSet.of() here or you will get a NullPointerException
		return EnumSet.of(TickType.SERVER);//You may add more ticktypes also.
	}

	@Override
	public String getLabel() {
		//Again, return whatever you like here
		return "minecraftplus_mod.ServerTickHandler";
	}
	
	public static int getServerTickCount(){
    	return serverTickCount;
    }
    
    public static int getServerSecondCount(){
    	return serverSecondCount;
    }
    
    public static void resetTickCount(){
    	serverTickNumber = 0;
    	serverTickCount = 0;
    }
}
