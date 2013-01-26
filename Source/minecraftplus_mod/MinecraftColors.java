package net.minecraftplus_mod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;

/** Not sure about the rest, but the colors *should* work.*/
public class MinecraftColors {

	@SideOnly(Side.CLIENT)
	private static Minecraft minecraft;
	
	public static String darkRed = "\u00A74";
	public static String lightRed = "\u00A7c";
	public static String brown = "\u00A76";
	public static String yellow = "\u00A7e";
	public static String darkGreen = "\u00A72";
	public static String lightGreen = "\u00A7a";
	public static String darkBlue = "\u00A71";
	public static String lightBlue = "\u00A7b";
	public static String turquois = "\u00A73";
	public static String purple = "\u00A79";
	public static String darkPink = "\u00A75";
	public static String lightPink = "\u00A7d";
	public static String white = "\u00A7f";
	public static String darkGray = "\u00A78";
	public static String lightGray = "\u00A77";
	public static String black = "\u00A70";
	public static String bold = "\u00A7L";
	public static String italics = "\u00A7o";
	public static String underlined = "\u00A7n";
	public static String stroked = "\u00A7m";
	public static String randomLetters = "\u00A7k";
	public static String reset = "\u00A7R";
	
	@SideOnly(Side.CLIENT)
	public static void addChatToPlayerWithColor(String colorCode, String message){
		minecraft.thePlayer.addChatMessage(colorCode + message);
	}
	
	public static String messageWithColor(String color, String message){
		return color + message;
	}
	
}
