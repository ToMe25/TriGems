/**
 * This class is distributed as a part of the Trigems mod.(https://github.com/ToMe25/TriGems)
 * Copyright (C) 2018-2021  ToMe25
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ToMe.trigems;

import net.minecraft.block.Block;

import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.ModLoader;

public class GenerationHelper {

	private static ConfiguredFeature<?, ?> TOPAZ_ORE_FEATURE;
	private static ConfiguredFeature<?, ?> RUBY_ORE_FEATURE;
	private static ConfiguredFeature<?, ?> SAPPHIRE_ORE_FEATURE;
	private static ConfiguredFeature<?, ?> EMERALD_ORE_FEATURE;

	public static void registerWorldGenerator() {
		if (ModLoader.isLoadingStateValid()) {
			if (ConfigHandler.enableTopaz.get()) {
				TOPAZ_ORE_FEATURE = createConfiguredFeature(TriGemsMod.oreTopaz, 8, ConfigHandler.minheight_Topaz.get(),
						ConfigHandler.maxheight_Topaz.get(), ConfigHandler.generationrate_Topaz.get(), Feature.ORE);
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
						new ResourceLocation(TriGemsMod.MODID, "topaz_ore"), TOPAZ_ORE_FEATURE);
			}
			if (ConfigHandler.enableRuby.get()) {
				RUBY_ORE_FEATURE = createConfiguredFeature(TriGemsMod.oreRuby, 8, ConfigHandler.minheight_Ruby.get(),
						ConfigHandler.maxheight_Ruby.get(), ConfigHandler.generationrate_Ruby.get(), Feature.ORE);
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
						new ResourceLocation(TriGemsMod.MODID, "ruby_ore"), RUBY_ORE_FEATURE);
			}
			if (ConfigHandler.enableSapphire.get()) {
				SAPPHIRE_ORE_FEATURE = createConfiguredFeature(TriGemsMod.oreSapphire, 8,
						ConfigHandler.minheight_Sapphire.get(), ConfigHandler.maxheight_Topaz.get(),
						ConfigHandler.generationrate_Sapphire.get(), Feature.ORE);
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
						new ResourceLocation(TriGemsMod.MODID, "sapphire_ore"), SAPPHIRE_ORE_FEATURE);
			}
			if (ConfigHandler.enableEmerald.get()) {
				EMERALD_ORE_FEATURE = createConfiguredFeature(Blocks.EMERALD_ORE, 8,
						ConfigHandler.minheight_Emerald.get(), ConfigHandler.maxheight_Emerald.get(),
						ConfigHandler.generationrate_Emerald.get(), Feature.ORE);
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
						new ResourceLocation(TriGemsMod.MODID, "emerald_ore"), EMERALD_ORE_FEATURE);
			}
		}
	}

	private static ConfiguredFeature<?, ?> createConfiguredFeature(Block block, int size, int minHeight, int maxHeight,
			int perChunk, Feature<OreFeatureConfig> feature) {
		return feature
				.withConfiguration(
						new OreFeatureConfig(FillerBlockType.BASE_STONE_OVERWORLD, block.getDefaultState(), size))
				.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, minHeight, maxHeight)))
				.square().func_242731_b(perChunk);
	}

	public static void onBiomeLoad(BiomeLoadingEvent event) {
		if (event.getCategory() != Category.THEEND && event.getCategory() != Category.NETHER) {
			BiomeGenerationSettingsBuilder generation = event.getGeneration();
			if (TOPAZ_ORE_FEATURE != null) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, TOPAZ_ORE_FEATURE);
			}
			if (RUBY_ORE_FEATURE != null) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RUBY_ORE_FEATURE);
			}
			if (SAPPHIRE_ORE_FEATURE != null) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SAPPHIRE_ORE_FEATURE);
			}
			if (EMERALD_ORE_FEATURE != null) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, EMERALD_ORE_FEATURE);
			}
		}
	}

}
