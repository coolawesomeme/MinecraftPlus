package net.minecraftplus_mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PlusAddonRegister {
	
	private static String[] addonsRegistered;
	private static String[] addonAuthors;
	private static String[] addonVersions;
	private static String[] addonVersionsCompatibility;
	private static List addonsList;
	private static int addonNumber = 0;
	private static HashMap authors;
	private static HashMap versions;
	private static HashMap compatibilities;

	/** Returns if addons are allowed or not.
	 * @return true */
	public static boolean getAddonsAllowed(){
		return true;
	}
	
	/** Register your addons with this.
	 * @param 
	 * @param 
	 * @param 
	 * @param  */
	public static void registerModAddon(String par1AddonName, String par2Author, String par3Version, String par4MinecraftPlusVersionCompatibility){
		addonNumber++;
		addonsRegistered[addonNumber] = par1AddonName;
		addonAuthors[addonNumber] = par2Author;
		addonVersions[addonNumber] = par3Version;
		addonVersionsCompatibility[addonNumber] = par4MinecraftPlusVersionCompatibility;
		
		HashMap<String, String> authors = new HashMap<String, String>();
		authors.put(par1AddonName, par2Author);
		
		HashMap<String, String> versions = new HashMap<String, String>();
		versions.put(par1AddonName, par3Version);
		
		HashMap<String, String> compatibilities = new HashMap<String, String>();
		compatibilities.put(par1AddonName, par4MinecraftPlusVersionCompatibility);
	}
	
	/** Returns list of registered addons.
	 * @return List of Addons */
	public static List getRegisteredAddons(){
		List<String> addonsList = new ArrayList<String>(Arrays.asList(addonsRegistered));
		return addonsList;
	}
	
	/** Returns number of registered addons.
	 * @return Number of Addons */
	public static int getAddonNumber(){
		return addonNumber;
	}
	
	/** Returns the addon author based on what addon you input.
	 * @param
	 * @return Inputed Addon's Author */
	public static String getAddonAuthor(String par1AddonName){
		return (String) authors.get(par1AddonName);
	}
	
	/** Returns the addon version based on what addon you input.
	 * @param
	 * @return Inputed Addon's Version */
	public static String getAddonVersion(String par1AddonName){
		return (String) versions.get(par1AddonName);
	}
	
	/** Returns the addon to Minecraft+ compatibility based on what addon you input.
	 * @param
	 * @return Inputed Addon's Minecraft+ Compatibility */
	public static String getAddonCompatibility(String par1AddonName){
		return (String) compatibilities.get(par1AddonName);
	}
}
