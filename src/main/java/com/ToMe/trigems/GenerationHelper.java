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

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class GenerationHelper {

	public static void registerWorldGenerator() {
		for (Biome biome : Biome.BIOMES) {
			if (ConfigHandler.enableTopaz) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE,
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										TriGemsMod.oreTopaz.getDefaultState(), 8),
								Placement.COUNT_RANGE,
								new CountRangeConfig(ConfigHandler.generationrate_Topaz, ConfigHandler.minheight_Topaz,
										ConfigHandler.minheight_Topaz, ConfigHandler.maxheight_Topaz)));
			}
			if (ConfigHandler.enableRuby) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE,
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										TriGemsMod.oreRuby.getDefaultState(), 8),
								Placement.COUNT_RANGE,
								new CountRangeConfig(ConfigHandler.generationrate_Ruby, ConfigHandler.minheight_Ruby,
										ConfigHandler.minheight_Ruby, ConfigHandler.maxheight_Ruby)));
			}
			if (ConfigHandler.enableSapphire) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								TriGemsMod.oreSapphire.getDefaultState(), 8),
						Placement.COUNT_RANGE,
						new CountRangeConfig(ConfigHandler.generationrate_Sapphire, ConfigHandler.minheight_Sapphire,
								ConfigHandler.minheight_Sapphire, ConfigHandler.maxheight_Sapphire)));
			}
			if (ConfigHandler.enableEmerald) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								Blocks.EMERALD_ORE.getDefaultState(), 8),
						Placement.COUNT_RANGE,
						new CountRangeConfig(ConfigHandler.generationrate_Emerald, ConfigHandler.minheight_Emerald,
								ConfigHandler.minheight_Emerald, ConfigHandler.maxheight_Emerald)));
			}
		}
	}

}
