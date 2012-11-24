package net.mod_MinecraftPlus;

import net.minecraft.src.ModelBiped;
import net.minecraft.src.RenderBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy{
	
	public static void registerRenderInformation(){
		preloadTextures();
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHuman.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHerobrine.class, new RenderBiped(new ModelBiped(), 0.5F));
	}	
	
	public static void preloadTextures() {
		MinecraftForgeClient.preloadTexture("/minecraftplus/spritesheet_items.png");
		MinecraftForgeClient.preloadTexture("/minecraftplus/spritesheet_blocks.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/armor/embroniumarmor_1.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/armor/embroniumarmor_2.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/armor/ironmanarmor_1.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/armor/ironmanarmor_2.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/mobs/herobrine.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/mobs/mummy.png");
        MinecraftForgeClient.preloadTexture("/mob/char.png");
	}
}