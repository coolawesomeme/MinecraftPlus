package net.minecraftplus_mod;

import java.util.Random;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class PlusWorldGenerator implements IWorldGenerator {

	public static String currentBiome = null;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId)
		  {
		   case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		   case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		  }
		BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
		this.currentBiome = b.biomeName;
	}

	private void generateNether(World world, Random random, int i, int j) {
		
	}
	
	private void generateSurface(World world, Random random, int i, int j) {
		
		for(int q = 0; q < 15; q++)
        {
                int randPosX = i + random.nextInt(15);
                int randPosY = random.nextInt(80);
                int randPosZ = j + random.nextInt(16);
                (new WorldGenMinable(MinecraftPlusBase.embroniumOre.blockID, 12)).generate(world, random, randPosX, randPosY, randPosZ);
        }
        
        //Still being worked on.
        int number = random.nextInt(200);
        if(number == 10){
                int randPosX = i + random.nextInt(15);
                int randPosY = random.nextInt(128);
                int randPosZ = j + random.nextInt(16);
                (new WorldGenPlusSign()).generate(world, random, randPosX, randPosY, randPosZ);
        }
	}
}