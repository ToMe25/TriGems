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

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.ChunkProviderOverworld;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenerationHelper implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if ((ConfigHandler.oregen_overworld_only && chunkGenerator instanceof ChunkProviderOverworld)
				|| (!ConfigHandler.oregen_overworld_only && !(chunkGenerator instanceof ChunkProviderHell)
						&& !(chunkGenerator instanceof ChunkProviderEnd))) {
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}

	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if (ConfigHandler.enableTopaz) {
			generateOre(TriGemsMod.oreTopaz.getDefaultState(), world, random, chunkX * 16, chunkZ * 16,
					ConfigHandler.minheight_Topaz, ConfigHandler.maxheight_Topaz, 4 + random.nextInt(4),
					ConfigHandler.generationrate_Topaz);
		}
		if (ConfigHandler.enableRuby) {
			generateOre(TriGemsMod.oreRuby.getDefaultState(), world, random, chunkX * 16, chunkZ * 16,
					ConfigHandler.minheight_Ruby, ConfigHandler.maxheight_Ruby, 4 + random.nextInt(4),
					ConfigHandler.generationrate_Ruby);
		}
		if (ConfigHandler.enableSapphire) {
			generateOre(TriGemsMod.oreSapphire.getDefaultState(), world, random, chunkX * 16, chunkZ * 16,
					ConfigHandler.minheight_Sapphire, ConfigHandler.maxheight_Sapphire, 4 + random.nextInt(4),
					ConfigHandler.generationrate_Sapphire);
		}
		if (ConfigHandler.enableEmerald) {
			generateOre(Blocks.EMERALD_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16,
					ConfigHandler.minheight_Emerald, ConfigHandler.maxheight_Emerald, 4 + random.nextInt(4),
					ConfigHandler.generationrate_Emerald);
		}
	}

	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size,
			int chances) {
		maxY++;
		int deltaY = maxY - minY;

		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}
	}

}
