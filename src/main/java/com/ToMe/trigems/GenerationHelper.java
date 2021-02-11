package com.ToMe.trigems;

import net.minecraft.block.Block;

//import java.util.Random;

//import com.ibm.icu.text.MessagePattern;

import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.init.Blocks;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
//import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.ModLoader;
//import net.minecraft.world.chunk.IChunkGenerator;
//import net.minecraft.world.chunk.IChunkProvider;
//import net.minecraft.world.gen.ChunkGeneratorEnd;
//import net.minecraft.world.gen.ChunkGeneratorHell;
//import net.minecraft.world.gen.ChunkGeneratorOverworld;
//import net.minecraft.world.gen.IChunkGenerator;
//import net.minecraft.world.gen.ChunkProviderEnd;
//import net.minecraft.world.gen.ChunkProviderHell;
//import net.minecraft.world.gen.ChunkProviderOverworld;
//import net.minecraft.world.gen.ChunkProviderServer;
//import net.minecraft.world.gen.feature.WorldGenMinable;
//import net.minecraft.world.gen.feature.WorldGenerator;
//import net.minecraftforge.fml.common.IWorldGenerator;

//public class GenerationHelper implements IWorldGenerator {
public class GenerationHelper {

	private static ConfiguredFeature<?, ?> TOPAZ_ORE_FEATURE;
	private static ConfiguredFeature<?, ?> RUBY_ORE_FEATURE;
	private static ConfiguredFeature<?, ?> SAPPHIRE_ORE_FEATURE;
	private static ConfiguredFeature<?, ?> EMERALD_ORE_FEATURE;
	
	public static void registerWorldGenerator() {
		if (ModLoader.isLoadingStateValid()) {
			if (ConfigHandler.enableTopaz) {
				TOPAZ_ORE_FEATURE = createConfiguredFeature(TriGemsMod.oreTopaz, 8, ConfigHandler.minheight_Topaz, ConfigHandler.maxheight_Topaz, ConfigHandler.generationrate_Topaz, Feature.ORE);
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(TriGemsMod.MODID, "topaz_ore"), TOPAZ_ORE_FEATURE);
			}
			if (ConfigHandler.enableRuby) {
				RUBY_ORE_FEATURE = createConfiguredFeature(TriGemsMod.oreRuby, 8, ConfigHandler.minheight_Ruby, ConfigHandler.maxheight_Ruby, ConfigHandler.generationrate_Ruby, Feature.ORE);
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(TriGemsMod.MODID, "ruby_ore"), RUBY_ORE_FEATURE);
			}
			if (ConfigHandler.enableSapphire) {
				SAPPHIRE_ORE_FEATURE = createConfiguredFeature(TriGemsMod.oreSapphire, 8, ConfigHandler.minheight_Sapphire, ConfigHandler.maxheight_Topaz, ConfigHandler.generationrate_Sapphire, Feature.ORE);
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(TriGemsMod.MODID, "sapphire_ore"), SAPPHIRE_ORE_FEATURE);
			}
			if (ConfigHandler.enableEmerald) {
				EMERALD_ORE_FEATURE = createConfiguredFeature(Blocks.EMERALD_ORE, 8, ConfigHandler.minheight_Emerald, ConfigHandler.maxheight_Emerald, ConfigHandler.generationrate_Emerald, Feature.ORE);
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(TriGemsMod.MODID, "emerald_ore"), EMERALD_ORE_FEATURE);
			}
		}
		/*for (Biome biome : Biome.BIOMES) {
			if(ConfigHandler.enableTopaz) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								TriGemsMod.oreTopaz.getDefaultState(), 8), Placement.COUNT_RANGE,
						new CountRangeConfig(ConfigHandler.generationrate_Topaz, ConfigHandler.minheight_Topaz,
								ConfigHandler.minheight_Topaz, ConfigHandler.maxheight_Topaz)));
			}
			if(ConfigHandler.enableRuby) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								TriGemsMod.oreRuby.getDefaultState(), 8), Placement.COUNT_RANGE,
						new CountRangeConfig(ConfigHandler.generationrate_Ruby, ConfigHandler.minheight_Ruby,
								ConfigHandler.minheight_Ruby, ConfigHandler.maxheight_Ruby)));
			}
			if(ConfigHandler.enableSapphire) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								TriGemsMod.oreSapphire.getDefaultState(), 8), Placement.COUNT_RANGE,
						new CountRangeConfig(ConfigHandler.generationrate_Sapphire, ConfigHandler.minheight_Sapphire,
								ConfigHandler.minheight_Sapphire, ConfigHandler.maxheight_Sapphire)));
			}
			if(ConfigHandler.enableEmerald) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								Blocks.EMERALD_ORE.getDefaultState(), 8), Placement.COUNT_RANGE,
						new CountRangeConfig(ConfigHandler.generationrate_Emerald, ConfigHandler.minheight_Emerald,
								ConfigHandler.minheight_Emerald, ConfigHandler.maxheight_Emerald)));
			}
		}*/
	}
	
	private static ConfiguredFeature<?, ?> createConfiguredFeature(Block block, int size, int minHeight, int maxHeight, int perChunk, Feature<OreFeatureConfig> feature) {
		return feature.withConfiguration(new OreFeatureConfig(FillerBlockType.BASE_STONE_OVERWORLD, block.getDefaultState(), size))
				.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, minHeight, maxHeight))).square()
				.func_242731_b(perChunk);
    }
	
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		if(event.getCategory() != Category.THEEND && event.getCategory() != Category.NETHER) {
            BiomeGenerationSettingsBuilder generation = event.getGeneration();
			if(TOPAZ_ORE_FEATURE != null) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, TOPAZ_ORE_FEATURE);
			}
			if(RUBY_ORE_FEATURE != null) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RUBY_ORE_FEATURE);
			}
			if(SAPPHIRE_ORE_FEATURE != null) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SAPPHIRE_ORE_FEATURE);
			}
			if(EMERALD_ORE_FEATURE != null) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, EMERALD_ORE_FEATURE);
			}
		}
	}
	
	/*@Override
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
	}*/
	
}