package com.ToMe.trigems;

//import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
//import net.minecraft.block.material.Material;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;

public class GemBlock extends Block {

	//public GemBlock(String unlocalizedName, int id) {
	public GemBlock(String unlocalizedName, int id, MapColor mapColor) {
		//this(unlocalizedName, id, Material.IRON, 5.0F, 10.0F, 0.0F, "pickaxe", 2, SoundType.METAL);
		this(unlocalizedName, id, Material.IRON, 5.0F, 10.0F, 0.0F, "pickaxe", 2, SoundType.METAL, mapColor);
	}

	//public GemBlock(String unlocalizedName, int id, Material material, float hardness, float resistance, float lightLevel, String tool, int harvestLevel, SoundType soundtype) {
	public GemBlock(String unlocalizedName, int id, Material material, float hardness, float resistance, float lightLevel, String tool, int harvestLevel, SoundType soundtype, MapColor mapColor) {
		// TODO Auto-generated constructor stub
		//super(material);
		super(material, mapColor);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(unlocalizedName);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setLightLevel(lightLevel);
		this.setHarvestLevel(tool, harvestLevel);
		this.setSoundType(soundtype);
		//REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
		//Item.REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), new ItemBlock(this).setRegistryName(unlocalizedName));
		ForgeRegistries.BLOCKS.register(this);
		ForgeRegistries.ITEMS.register(new ItemBlock(this).setUnlocalizedName(unlocalizedName).setRegistryName(unlocalizedName));
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}

	public void RegisterTextur() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(this), 0,
				new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
	}

}
