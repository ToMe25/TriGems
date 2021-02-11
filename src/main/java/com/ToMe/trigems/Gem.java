package com.ToMe.trigems;

//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.client.resources.model.ModelResourceLocation;
//import net.minecraft.command.PlayerSelector;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
//import net.minecraft.potion.PotionEffect;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.common.registry.ForgeRegistries;
//import net.minecraftforge.fml.common.registry.GameRegistry;

public class Gem extends Item {
	
	//public Gem(String unlocalizedName, int id){
	public Gem(String registryName) {
		//super();
		super((new Item.Properties()).group(ItemGroup.MATERIALS));
		//this.setUnlocalizedName(unlocalizedName);
		//this.setRegistryName(unlocalizedName);
		setRegistryName(registryName);
		//REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
		//ForgeRegistries.ITEMS.register(this);
		//this.setCreativeTab(CreativeTabs.MATERIALS);
		
	}
	
	/*@Override
	public boolean isBeaconPayment(ItemStack stack) {
		// TODO Auto-generated method stub
		//return super.isBeaconPayment(stack);
		return true;
	}*/
	
	/*public void RegisterTextur(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
		
	}*/
	
}
