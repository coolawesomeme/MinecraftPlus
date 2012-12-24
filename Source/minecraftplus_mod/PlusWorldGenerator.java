package net.minecraftplus_mod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class PlusWorldGenerator implements IWorldGenerator {
	
	public static String currentBiome = "null";
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
		this.currentBiome = b.biomeName;
		switch (world.provider.dimensionId)
		  {
		   case -1: generateNether(world, random, chunkX*16, chunkZ*16, currentBiome);
		   case 0: generateSurface(world, random, chunkX*16, chunkZ*16, currentBiome);
		  }
	}

	private void generateNether(World world, Random random, int i, int j, String currentBiome) {
		
	}
	
	private void generateSurface(World world, Random random, int i, int j, String currentBiome) {
		
		if(currentBiome == "Desert" || currentBiome == "DesertHills" || currentBiome == "Beach"){
			for(int q = 0; q < 1; q++)
	        {
	                int randPosX = i + random.nextInt(15);
	                int randPosY = random.nextInt(80);
	                int randPosZ = j + random.nextInt(16);
	                int yPosNew = randPosY - 1;
	                if(world.getBlockId(randPosX, yPosNew, randPosZ) == Block.grass.blockID || world.getBlockId(randPosX, yPosNew, randPosZ) == Block.sand.blockID){
	                	(new TreePalm()).generate(world, random, randPosX, randPosY, randPosZ);
	                }
	        }
		}
		
		for(int q = 0; q < 3; q++)
        {
                int randPosX = i + random.nextInt(15);
                int randPosY = random.nextInt(80);
                int randPosZ = j + random.nextInt(16);
                (new WorldGenMinable(MinecraftPlusBase.embroniumOre.blockID, 12)).generate(world, random, randPosX, randPosY, randPosZ);
        }
        
		int number = random.nextInt(16);
        if(number == 10){
                int randPosX = i + random.nextInt(15);
                int randPosY = random.nextInt(128);
                int randPosZ = j + random.nextInt(16);
                (new WorldGenMint(MinecraftPlusBase.mintBlock.blockID, 4)).generate(world, random, randPosX, randPosY, randPosZ);
        }
		
        //Still being worked on.
        int number1 = random.nextInt(200);
        if(number1 == 10){
                int randPosX = i + random.nextInt(15);
                int randPosY = random.nextInt(128);
                int randPosZ = j + random.nextInt(16);
                (new WorldGenPlusSign()).generate(world, random, randPosX, randPosY, randPosZ);
        }
	}
}
