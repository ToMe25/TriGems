package com.ToMe.trigems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
//import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Armor extends ItemArmor {
	
	public Armor(String unlocalizedName, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, int id) {//int armorType) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(unlocalizedName);
		//REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
		ForgeRegistries.ITEMS.register(this);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	public void RegisterTextur(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
	}
}