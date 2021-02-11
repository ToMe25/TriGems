package com.ToMe.trigems;

//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
//import net.minecraft.client.resources.model.ModelResourceLocation;
//import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.PickaxeItem;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.common.registry.ForgeRegistries;
//import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class is needed for 1.14.2!
 */
//public class Pickaxe extends ItemPickaxe {
public class Pickaxe extends PickaxeItem {
	
	public Pickaxe(String registryName, IItemTier material) {
		this(registryName, material, 1, -2.8F);
	}
	
	//public Pickaxe(String unlocalizedName, ToolMaterial material, int id) {
	public Pickaxe(String registryName, IItemTier material, int damage, float speed) {
	    //super(material);
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
