package net.minecraftplus_mod;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy{
	
	@SideOnly(Side.CLIENT)
	public static void registerRenderInformation(){
		preloadTextures();
		RenderingRegistry.registerEntityRenderingHandler(EntityHuman.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHerobrine.class, new RenderBiped(new ModelBiped(), 0.5F));
	}	
	
	public static void preloadTextures() {
		MinecraftForgeClient.preloadTexture(MinecraftPlusBase.item_texture);
		MinecraftForgeClient.preloadTexture(MinecraftPlusBase.block_texture);
		MinecraftForgeClient.preloadTexture("/minecraftplus/logo.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/armor/embroniumarmor_1.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/armor/embroniumarmor_2.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/armor/ironmanarmor_1.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/armor/ironmanarmor_2.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/mobs/herobrine.png");
        MinecraftForgeClient.preloadTexture("/minecraftplus/mobs/mummy.png");
        MinecraftForgeClient.preloadTexture("/mob/char.png");
	}
}
