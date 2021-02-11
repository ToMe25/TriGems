package com.ToMe.trigems;

//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
//import net.minecraft.client.resources.model.ModelResourceLocation;
//import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemHoe;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.common.registry.ForgeRegistries;
//import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class is needed for 1.14.2!
 */
//public class Hoe extends ItemHoe {
public class Hoe extends HoeItem {
	
	//public Hoe(String unlocalizedName, ToolMaterial material, int id) {
	public Hoe(String registryName, IItemTier material, float speed) {
	    //super(material);
		super(material, speed, (new Item.Properties()).group(ItemGroup.TOOLS));
	    //this.setUnlocalizedName(unlocalizedName);
	    //this.setRegistryName(unlocalizedName);
		setRegistryName(registryName);
	    //REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
	    //ForgeRegistries.ITEMS.register(this);
	    //this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	/*public void RegisterTextur(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
		
	}*/
	
}