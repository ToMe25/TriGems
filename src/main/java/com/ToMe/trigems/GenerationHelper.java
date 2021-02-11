package com.ToMe.trigems;

import java.util.Random;

import com.ibm.icu.text.MessagePattern;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
//import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkGeneratorEnd;
import net.minecraft.world.gen.ChunkGeneratorHell;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.IChunkGenerator;
//import net.minecraft.world.gen.ChunkProviderEnd;
//import net.minecraft.world.gen.ChunkProviderHell;
//import net.minecraft.world.gen.ChunkProviderOverworld;
//import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenerationHelper implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		//if (world.provider.getDimension() == 0) { 
		//if(chunkGenerator instanceof ChunkGeneratorOverworld) {
		if((ConfigHandler.oregen_overworld_only && chunkGenerator instanceof ChunkGeneratorOverworld) || (!ConfigHandler.oregen_overworld_only && !(chunkGenerator instanceof ChunkGeneratorHell) && !(chunkGenerator instanceof ChunkGeneratorEnd))) {
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}
	
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if(ConfigHandler.enableTopaz) {
			//generateOre(TriGemsMod.oreTopaz.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), 7);
			//generateOre(TriGemsMod.oreTopaz.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), ConfigHandler.generationrate_Topaz);
			generateOre(TriGemsMod.oreTopaz.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, ConfigHandler.minheight_Topaz, ConfigHandler.maxheight_Topaz, 4 + random.nextInt(4), ConfigHandler.generationrate_Topaz);
		}
		if(ConfigHandler.enableRuby) {
			//generateOre(TriGemsMod.oreRuby.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), 6);
			//generateOre(TriGemsMod.oreRuby.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), ConfigHandler.generationrate_Ruby);
			generateOre(TriGemsMod.oreRuby.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, ConfigHandler.minheight_Ruby, ConfigHandler.maxheight_Ruby, 4 + random.nextInt(4), ConfigHandler.generationrate_Ruby);
		}
		if(ConfigHandler.enableSapphire) {
			//generateOre(TriGemsMod.oreSapphire.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), 5);
			//generateOre(TriGemsMod.oreSapphire.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), ConfigHandler.generationrate_Sapphire);
			generateOre(TriGemsMod.oreSapphire.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, ConfigHandler.minheight_Sapphire, ConfigHandler.maxheight_Sapphire, 4 + random.nextInt(4), ConfigHandler.generationrate_Sapphire);
		}
		if(ConfigHandler.enableEmerald) {
			//generateOre(Blocks.EMERALD_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), 4);
			//generateOre(Blocks.EMERALD_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), ConfigHandler.generationrate_Emerald);
			generateOre(Blocks.EMERALD_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, ConfigHandler.minheight_Emerald, ConfigHandler.maxheight_Emerald, 4 + random.nextInt(4), ConfigHandler.generationrate_Emerald);
		}
		//generateOre(TriGemsMod.oreTopaz.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), 7);
		//generateOre(TriGemsMod.oreRuby.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), 6);
		//generateOre(TriGemsMod.oreSapphire.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), 5);
		//generateOre(Blocks.EMERALD_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, 4 + random.nextInt(4), 4);
	}
	
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
		maxY++;
		int deltaY = maxY - minY;
		
		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
			
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}
	}
	
}