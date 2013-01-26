package net.minecraftplus_mod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface PlusAddonBase {

	/**
	 * The addon making class. Implement it.
	 * @author coolawesomeme
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface Addon {
		/**The name of the addon. */
	    String addonName();
	    
	    /**The author of the addon. */
	    String addonAuthor();
	    
	    /** The version of the addon. */
	    String addonVersion();
	    
	    /** Addon to mod compatibility. */
	    String forMinecraftPlus();
	}
}
