package net.minecraftplus_mod;

import java.util.EnumSet;

import net.minecraft.network.rcon.RConConsoleSource;
import net.minecraft.server.MinecraftServer;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler 
{	
	public boolean notServerSTARTUP = false;
	private static int serverTickCount = 0;
	private static int serverSecondCount = 0;
	private static int serverTickNumber = 0;
	
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
    	            onTickInServer();
    	        }
	}

	private void onTickInServer() {
		if(!notServerSTARTUP){
		initialize();
		onServerSTARTUP();
		notServerSTARTUP = true;
		}
	}

	private void initialize() {
			//MinecraftServer.getServer().executeCommand("say Minecraft+ Server Version Enabled!");
			if(!MinecraftServer.getServer().isSinglePlayer()){
				this.executeCommand("say Loading Minecraft+ " + MinecraftPlusBase.codever + "!");
				this.executeCommand("/say Minecraft+ Server version enabled!");
			}
	}

	public String executeCommand(String par1Str)
    {
        PlusConsoleBuffer.consoleBuffer.resetLog();
        MinecraftServer.getServer().getCommandManager().executeCommand(PlusConsoleBuffer.consoleBuffer, par1Str);
        return PlusConsoleBuffer.consoleBuffer.getChatBuffer();
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
