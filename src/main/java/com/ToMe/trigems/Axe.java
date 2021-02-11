package com.ToMe.trigems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Axe extends ItemAxe {
	
	//public Axe(String unlocalizedName, ToolMaterial material, float Damage, int id) {
	public Axe(String unlocalizedName, ToolMaterial material, float Damage, float Speed, int id) {
	    //super(material, Damage, 3.0F);
		super(material, Damage, Speed);
	    this.setUnlocalizedName(unlocalizedName);
	    REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
	    this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	public void RegisterTextur(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
		
	}
	
}
