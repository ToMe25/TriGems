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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraft.block.SoundType;

public class GemOre extends Block {

	public GemOre(String unlocalizedName, int id) {
		this(unlocalizedName, id, Material.ROCK, 3.0F, 5.0F, 0.0F, "pickaxe", 2, SoundType.STONE);
	}

	public GemOre(String unlocalizedName, int id, Material material, float hardness, float resistance, float lightLevel,
			String tool, int harvestLevel, SoundType soundtype) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(unlocalizedName);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setLightLevel(lightLevel);
		this.setHarvestLevel(tool, harvestLevel);
		this.setSoundType(soundtype);
		ForgeRegistries.BLOCKS.register(this);
		ForgeRegistries.ITEMS
				.register(new ItemBlock(this).setUnlocalizedName(unlocalizedName).setRegistryName(unlocalizedName));
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

	}

	public void RegisterTextur() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(this), 0,
				new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this == TriGemsMod.oreSapphire ? TriGemsMod.sapphire
				: (this == TriGemsMod.oreTopaz ? TriGemsMod.topaz : TriGemsMod.ruby);
	}

	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(
				(IBlockState) this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;

			if (i < 0) {
				i = 0;
			}

			return this.quantityDropped(random) * (i + 1);
		} else {
			return this.quantityDropped(random);
		}
	}

	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		return MathHelper.getInt(rand, 3, 7);
	}

}
