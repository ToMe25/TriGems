package com.ToMe.trigems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Pickaxe extends ItemPickaxe {
	
	public Pickaxe(String unlocalizedName, ToolMaterial material, int id) {
	    super(material);
	    this.setUnlocalizedName(unlocalizedName);
	    this.setRegistryName(unlocalizedName);
	    //REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
	    ForgeRegistries.ITEMS.register(this);
	    this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	public void RegisterTextur(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
		
	}
	
}
