package com.ToMe.trigems;

//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
//import net.minecraft.client.resources.model.ModelResourceLocation;
//import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemSword;
import net.minecraft.item.SwordItem;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.common.registry.ForgeRegistries;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//import net.minecraftforge.registries.IForgeRegistry;
//import net.minecraftforge.fml.common.registry.RegistryBuilder;

/**
 * This class is needed for 1.14.2!
 */
//public class Sword extends ItemSword {
public class Sword extends SwordItem {
	
	public Sword(String registryName, IItemTier material) {
		this(registryName, material, 3, 2.4F);
	}
	
	//public Sword(String unlocalizedName, ToolMaterial material, int id) {
	public Sword(String registryName, IItemTier material, int damage, float speed) {
	    //super(material);
		super(material, damage, speed, (new Item.Properties()).group(ItemGroup.COMBAT));
	    //this.setUnlocalizedName(unlocalizedName);
	    //this.setRegistryName(unlocalizedName);
	    setRegistryName(registryName);
	    //REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
	    //ForgeRegistries.ITEMS.register(this);
	    //this.setUnlocalizedName(unlocalizedName);
	}
	
	/*public void RegisterTextur(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
		
	}*/
	
}