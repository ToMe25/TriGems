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
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class TriGemsBlock extends Block {

	private ToolType harvestTool;
	private int harvestLevel;
	private boolean isBeacon;
	private boolean dropsXP;
	public Item blockItem;

	public TriGemsBlock(String registryName, MaterialColor materialColor, boolean isOre) {
		this(registryName, isOre ? Material.ROCK : Material.IRON, isOre ? 3.0F : 5.0F, isOre ? 5.0F : 10.0F, 0,
				ToolType.PICKAXE, 2, isOre ? SoundType.STONE : SoundType.METAL, materialColor, !isOre, isOre);
	}

	public TriGemsBlock(String registryName, Material material, float hardness, float resistance, int lightLevel,
			ToolType harvestTool, int harvestLevel, SoundType soundType, MaterialColor materialColor,
			boolean isBeaconBase, boolean dropsXP) {
		super(Properties.create(material, materialColor).hardnessAndResistance(hardness, resistance)
				.lightValue(lightLevel).sound(soundType));
		this.harvestTool = harvestTool;
		this.harvestLevel = harvestLevel;
		this.isBeacon = isBeaconBase;
		this.dropsXP = dropsXP;
		setRegistryName(registryName);
		blockItem = new BlockItem(this, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
				.setRegistryName(getRegistryName());
	}

	@Override
	public boolean isBeaconBase(BlockState state, IWorldReader world, BlockPos pos, BlockPos beacon) {
		return isBeacon;
	}

	/**
	 * needed for 1.14.2
	 */
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return harvestTool;
	}

	/**
	 * needed for 1.14.2
	 */
	@Override
	public int getHarvestLevel(BlockState state) {
		return harvestLevel;
	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		if (!dropsXP || silktouch != 0) {
			return 0;
		}

		return MathHelper.nextInt(RANDOM, 3, 7);
	}

}
