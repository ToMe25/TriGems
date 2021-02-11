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
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class TriGemsBlock extends Block {
	
	private ToolType harvestTool;
	private int harvestLevel;
	private boolean isBeacon;
	public Item blockItem;

	public TriGemsBlock(String registryName, MaterialColor materialColor, boolean isOre) {
		this(registryName, isOre ? Material.ROCK : Material.IRON, isOre ? 3.0F : 5.0F, isOre ? 5.0F : 10.0F, 0, ToolType.PICKAXE, 2, isOre ? SoundType.STONE : SoundType.METAL, materialColor, !isOre);
	}

	public TriGemsBlock(String registryName, Material material, float hardness, float resistance, int lightLevel, ToolType harvestTool, int harvestLevel, SoundType soundType, MaterialColor materialColor, boolean isBeaconBase) {
		super(Properties.create(material, materialColor).hardnessAndResistance(hardness, resistance).lightValue(lightLevel).sound(soundType));
		this.harvestTool = harvestTool;
		this.harvestLevel = harvestLevel;
		this.isBeacon = isBeaconBase;
		setRegistryName(registryName);
		blockItem = new BlockItem(this, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(getRegistryName());
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

}
