package net.minecraftplus_mod;

public @interface PlusAddonBase {

	/**
	 * The addon making class. Implement it.
	 * @author coolawesomeme
	 */
	
	public @interface registerAddon {
		/**The name of the addon. */
	    String addonName();
	    
	    /**The author of the addon. */
	    String addonAuthor();
	    
	    /** The version of the addon. */
	    String addonVersion();
	}
}
