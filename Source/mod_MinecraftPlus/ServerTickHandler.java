package net.mod_MinecraftPlus;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.RConConsoleSource;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

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
		
		if(serverTickCount == 20){
		if(!notServerSTARTUP){
			//MinecraftServer.getServer().executeCommand("say Minecraft+ Server Version Enabled!");
			MinecraftServer.getServer().getCommandManager().executeCommand(PlusConsoleSender.consoleBuffer, "say Minecraft+ Server Version \u00A72Enabled \u00A7f!");
			MinecraftServer.getServer().getCommandManager().executeCommand(PlusConsoleSender.consoleBuffer, "say " + " ");
			notServerSTARTUP = true;
			}
		}
		if(!notServerSTARTUP2){
			onServerSTARTUP();
			notServerSTARTUP = true;
		}
	}

	public void onServerSTARTUP() {}

	@Override
	public EnumSet<TickType> ticks() 
	{
		//Again, you have to return an EnumSet.of() here or you will get a NullPointerException
		return EnumSet.of(TickType.SERVER, TickType.PLAYER);//You may add more ticktypes also.
	}

	@Override
	public String getLabel() {
		//Again, return whatever you like here
		return "Minecraft+.ServerTickHandler";
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
