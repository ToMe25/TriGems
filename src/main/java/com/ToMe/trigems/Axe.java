package com.ToMe.trigems;

//import net.minecraft.client.Minecraft;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.client.resources.model.ModelResourceLocation;
//import net.minecraft.item.ItemAxe;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.common.registry.ForgeRegistries;
//import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class is needed for 1.14.2!
 */
//public class Axe extends ItemAxe {
public class Axe extends AxeItem {
	
	//public Axe(String unlocalizedName, ToolMaterial material, float Damage, int id) {
	//public Axe(String unlocalizedName, ToolMaterial material, float Damage, float Speed, int id) {
	public Axe(String registryName, IItemTier material, float damage, float speed) {
	    //super(material, Damage, 3.0F);
		//super(material, Damage, Speed);
		super(material, damage, speed, (new Item.Properties()).group(ItemGroup.TOOLS));
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
