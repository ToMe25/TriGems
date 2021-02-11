package com.ToMe.trigems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Shovel extends ItemSpade {
	
	public Shovel(String unlocalizedName, ToolMaterial material, int id) {
	    super(material);
	    this.setUnlocalizedName(unlocalizedName);
	    REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
	    this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	public void RegisterTextur(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
		
	}
	
}
