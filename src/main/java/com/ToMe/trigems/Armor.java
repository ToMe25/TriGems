package com.ToMe.trigems;

//import net.minecraft.client.Minecraft;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.inventory.EntityEquipmentSlot;
//import net.minecraft.client.resources.model.ModelResourceLocation;
//import net.minecraft.item.ItemArmor;
//import net.minecraft.item.ItemArmor.ArmorMaterial;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * This class is needed for 1.14.2!
 */
//public class Armor extends ItemArmor {
public class Armor extends ArmorItem {
	
	//public Armor(String unlocalizedName, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, int id) {//int armorType) {
	public Armor(String registryName, IArmorMaterial material, EquipmentSlotType armorType) {
		//super(material, renderIndex, armorType);
		super(material, armorType, (new Item.Properties()).group(ItemGroup.COMBAT));
		//this.setUnlocalizedName(unlocalizedName);
		//this.setRegistryName(unlocalizedName);
		setRegistryName(registryName);
		//REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
		//ForgeRegistries.ITEMS.register(this);
		//this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	/*public void RegisterTextur(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
	}*/
}