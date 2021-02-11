package com.ToMe.trigems;

import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraft.block.Block;
//import net.minecraft.block.material.MapColor;
//import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
//import net.minecraft.client.Minecraft;
import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.ArmorItem;
//import net.minecraft.item.AxeItem;
//import net.minecraft.item.HoeItem;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.init.Blocks;
//import net.minecraft.init.Items;
//import net.minecraft.init.SoundEvents;
//import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.PickaxeItem;
//import net.minecraft.item.ShovelItem;
//import net.minecraft.item.SwordItem;
//import net.minecraft.item.Item.ToolMaterial;
//import net.minecraft.item.ItemArmor.ArmorMaterial;
//import net.minecraft.item.ItemBlock;
//import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
//import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
//import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
//import net.minecraftforge.fml.common.Mod.EventHandler;
//import net.minecraftforge.fml.common.Mod.Instance;
//import net.minecraftforge.fml.common.SidedProxy;
//import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import net.minecraftforge.oredict.OreDictionary;
//import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;

//@Mod(modid = "trigems", name = "TriGems", version="1.0")
//@Mod(modid = TriGemsMod.MODID, name = TriGemsMod.NAME, version = TriGemsMod.NAME, acceptedMinecraftVersions = TriGemsMod.MCVERSION)//VERSION = NAME
//@Mod(modid = TriGemsMod.MODID, name = TriGemsMod.NAME, version = TriGemsMod.VERSION, acceptedMinecraftVersions = TriGemsMod.MCVERSION)
@Mod(value = TriGemsMod.MODID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TriGemsMod {
	
	//@SidedProxy(clientSide="com.ToMe.trigems.ClientProxy", serverSide="com.ToMe.trigems.ServerProxy")
	//public static CommonProxy proxy;
	public static CommonProxy proxy = new CommonProxy();
	
	//@Instance
	//public static TriGemsMod instance = new TriGemsMod();
	
	public static final String MODID = "trigems";
	public static final String NAME = "TriGems";
	public static final String VERSION = "1.0";
	public static final String MCVERSION = "[1.14,1.14.4]";
	
	public static ConfigHandler cfg = new ConfigHandler();
	
	//Items
	//TOPAZ
	//public static Gem topaz;
	public static Item topaz;
	//public static Pickaxe TopazPickaxe;
	public static Item TopazPickaxe;
	//public static Axe TopazAxe;
	public static Item TopazAxe;
	//public static Shovel TopazShovel;
	public static Item TopazShovel;
	//public static Hoe TopazHoe;
	public static Item TopazHoe;
	//public static Sword TopazSword;
	public static Item TopazSword;
	//RUBY
	//public static Gem ruby;
	public static Item ruby;
	//public static Pickaxe RubyPickaxe;
	public static Item RubyPickaxe;
	//public static Axe RubyAxe;
	public static Item RubyAxe;
	//public static Shovel RubyShovel;
	public static Item RubyShovel;
	//public static Hoe RubyHoe;
	public static Item RubyHoe;
	//public static Sword RubySword;
	public static Item RubySword;
	//SAPHIRE
	//public static Gem sapphire;
	public static Item sapphire;
	//public static Pickaxe SapphirePickaxe;
	public static Item SapphirePickaxe;
	//public static Axe SapphireAxe;
	public static Item SapphireAxe;
	//public static Shovel SapphireShovel;
	public static Item SapphireShovel;
	//public static Hoe SapphireHoe;
	public static Item SapphireHoe;
	//public static Sword SapphireSword;
	public static Item SapphireSword;
	//EMERALD
	//public static Pickaxe EmeraldPickaxe;
	public static Item EmeraldPickaxe;
	//public static Axe EmeraldAxe;
	public static Item EmeraldAxe;
	//public static Shovel EmeraldShovel;
	public static Item EmeraldShovel;
	//public static Hoe EmeraldHoe;
	public static Item EmeraldHoe;
	//public static Sword EmeraldSword;
	public static Item EmeraldSword;
	
	//Armor
	//public static Armor RubyHelmet;
	public static Item RubyHelmet;
	//public static Armor RubyChest;
	public static Item RubyChest;
	//public static Armor RubyLegs;
	public static Item RubyLegs;
	//public static Armor RubyBoots;
	public static Item RubyBoots;
	//public static Armor EmeraldHelmet;
	public static Item EmeraldHelmet;
	//public static Armor EmeraldChest;
	public static Item EmeraldChest;
	//public static Armor EmeraldLegs;
	public static Item EmeraldLegs;
	//public static Armor EmeraldBoots;
	public static Item EmeraldBoots;
	//public static Armor SapphireHelmet;
	public static Item SapphireHelmet;
	//public static Armor SapphireChest;
	public static Item SapphireChest;
	//public static Armor SapphireLegs;
	public static Item SapphireLegs;
	//public static Armor SapphireBoots;
	public static Item SapphireBoots;
	//public static Armor TopazHelmet;
	public static Item TopazHelmet;
	//public static Armor TopazChest;
	public static Item TopazChest;
	//public static Armor TopazLegs;
	public static Item TopazLegs;
	//public static Armor TopazBoots;
	public static Item TopazBoots;
	
	//Blocks
	//public static GemOre oreTopaz;
	public static TriGemsBlock oreTopaz;
	//public static GemBlock blockTopaz;
	public static TriGemsBlock blockTopaz;
	//public static GemOre oreRuby;
	public static TriGemsBlock oreRuby;
	//public static GemBlock blockRuby;
	public static TriGemsBlock blockRuby;
	//public static GemOre oreSapphire;
	public static TriGemsBlock oreSapphire;
	//public static GemBlock blockSapphire;
	public static TriGemsBlock blockSapphire;
	
	//Materials
	//public static ToolMaterial Topaz = EnumHelper.addToolMaterial("topaz", 3, 1500, 8.0F, 2.5F, 10);
	//public static ToolMaterial Ruby = EnumHelper.addToolMaterial("ruby", 3, 1500, 8.0F, 3.0F, 10);
	//public static ToolMaterial Sapphire = EnumHelper.addToolMaterial("sapphire", 3, 1500, 8.0F, 3.5F, 10);
	//public static ToolMaterial Emerald = EnumHelper.addToolMaterial("emerald", 3, 1500, 15.0F, 4.0F, 30);
	//public static ArmorMaterial TopazA = EnumHelper.addArmorMaterial("topaz_armor", "trigems:topaz", 32, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F);
	//public static ArmorMaterial RubyA = EnumHelper.addArmorMaterial("ruby_armor", "trigems:ruby", 33, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	//public static ArmorMaterial SapphireA = EnumHelper.addArmorMaterial("sapphire_armor", "trigems:sapphire", 34, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);
	//public static ArmorMaterial EmeraldA = EnumHelper.addArmorMaterial("emerald_armor", "trigems:emerald", 35, new int[] {3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
	
	//@EventHandler
	//public void preInit(FMLPreInitializationEvent e){
	public TriGemsMod() {
		//proxy.preInit(e);
		//proxy.preInit();
		MinecraftForge.EVENT_BUS.register(this);
		cfg.Init();
		//loadItems();
		//loadBlocks();
	}
	
	//@EventHandler
	@SubscribeEvent
	//public void Init(FMLInitializationEvent e){
	public static void Init(FMLCommonSetupEvent e) {
		
		//proxy.register();
		//loadRecipes();
		//GameRegistry.registerWorldGenerator(new GenerationHelper(), 2);
		GenerationHelper.registerWorldGenerator();
		//if(ConfigHandler.enableTopaz) {
			//GameRegistry.addSmelting(TriGemsMod.oreTopaz, new ItemStack(TriGemsMod.topaz), 0.5F);
		//}
		//if(ConfigHandler.enableRuby) {
			//GameRegistry.addSmelting(TriGemsMod.oreRuby, new ItemStack(TriGemsMod.ruby), 0.5F);
		//}
		//if(ConfigHandler.enableSapphire) {
			//GameRegistry.addSmelting(TriGemsMod.oreSapphire, new ItemStack(TriGemsMod.sapphire), 0.5F);
		//}
		
	}
	
	/*@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}*/
	
	@SubscribeEvent
	//public void registerItems(RegistryEvent.Register<Item> e) {
	public static void registerItems(RegistryEvent.Register<Item> e) {
		IForgeRegistry<Item> registry = e.getRegistry();
		//loadItems();
		if(ConfigHandler.enableTopaz) {
			//TriGemsMod.topaz = new Gem("topaz", 3303);
			TriGemsMod.topaz = new Gem("topaz");
			//OreDictionary.registerOre("gemTopaz", TriGemsMod.topaz);
			//TriGemsMod.Topaz.setRepairItem(new ItemStack(TriGemsMod.topaz));
			//TriGemsMod.TopazA.customCraftingMaterial = TriGemsMod.topaz;
			//TriGemsMod.TopazA.repairMaterial = new ItemStack(TriGemsMod.topaz);
			//TriGemsMod.TopazSword = new Sword("topaz_sword", TriGemsMod.Topaz, 3323);
			TriGemsMod.TopazSword = new Sword("topaz_sword", ToolTiers.TOPAZ);
			//TriGemsMod.TopazSword = new SwordItem(ToolTiers.TOPAZ, 3, 2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "topaz_sword");
			//TriGemsMod.TopazPickaxe = new Pickaxe("topaz_pickaxe", TriGemsMod.Topaz, 3327);
			TriGemsMod.TopazPickaxe = new Pickaxe("topaz_pickaxe", ToolTiers.TOPAZ);
			//TriGemsMod.TopazPickaxe = new PickaxeItem(ToolTiers.TOPAZ, 1, 2.8F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "topaz_pickaxe");
			//TriGemsMod.TopazAxe = new Axe("topaz_axe", TriGemsMod.Topaz, 8.0F, 3331);
			//TriGemsMod.TopazAxe = new Axe("topaz_axe", TriGemsMod.Topaz, 8.0F, -3.0F, 3331);//Axe Damage will be Added to 1.0 so 8.0 is same as Diamond!!! Axe Speed will be Added to 4.0 so -3.0 is same as Diamond!!!
			TriGemsMod.TopazAxe = new Axe("topaz_axe", ToolTiers.TOPAZ, 5.0F, -3.0F);
			//TriGemsMod.TopazAxe = new AxeItem(ToolTiers.TOPAZ, 5.0F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "topaz_axe");
			//TriGemsMod.TopazShovel = new Shovel("topaz_shovel", TriGemsMod.Topaz, 3335);
			TriGemsMod.TopazShovel = new Shovel("topaz_shovel", ToolTiers.TOPAZ);
			//TriGemsMod.TopazShovel = new ShovelItem(ToolTiers.TOPAZ, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "topaz_shovel");
			//TriGemsMod.TopazHoe = new Hoe("topaz_hoe", TriGemsMod.Topaz, 3339);
			TriGemsMod.TopazHoe = new Hoe("topaz_hoe", ToolTiers.TOPAZ, 0.0F);
			//TriGemsMod.TopazHoe = new HoeItem(ToolTiers.TOPAZ, 0.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "topaz_hoe");
			//TriGemsMod.TopazHelmet = new Armor("topaz_helmet", TriGemsMod.TopazA, 1, EntityEquipmentSlot.HEAD, 3352);
			TriGemsMod.TopazHelmet = new Armor("topaz_helmet", ArmorTiers.TOPAZ, EquipmentSlotType.HEAD);
			//TriGemsMod.TopazHelmet = new ArmorItem(ArmorTiers.TOPAZ, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "topaz_helmet");
			//TriGemsMod.TopazChest = new Armor("topaz_chestplate", TriGemsMod.TopazA, 1, EntityEquipmentSlot.CHEST, 3353);
			TriGemsMod.TopazChest = new Armor("topaz_chestplate", ArmorTiers.TOPAZ, EquipmentSlotType.CHEST);
			//TriGemsMod.TopazChest = new ArmorItem(ArmorTiers.TOPAZ, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "topaz_chestplate");
			//TriGemsMod.TopazLegs = new Armor("topaz_leggings", TriGemsMod.TopazA, 2, EntityEquipmentSlot.LEGS, 3354);
			TriGemsMod.TopazLegs = new Armor("topaz_leggings", ArmorTiers.TOPAZ, EquipmentSlotType.LEGS);
			//TriGemsMod.TopazLegs = new ArmorItem(ArmorTiers.TOPAZ, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "topaz_leggings");
			//TriGemsMod.TopazBoots = new Armor("topaz_boots", TriGemsMod.TopazA, 1, EntityEquipmentSlot.FEET, 3355);
			TriGemsMod.TopazBoots = new Armor("topaz_boots", ArmorTiers.TOPAZ, EquipmentSlotType.FEET);
			//TriGemsMod.TopazBoots = new ArmorItem(ArmorTiers.TOPAZ, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "topaz_boots");
			registry.registerAll(topaz, TopazSword, TopazPickaxe, TopazAxe, TopazShovel, TopazHoe,
					TopazHelmet, TopazChest, TopazLegs, TopazBoots);//Items
			registry.registerAll(blockTopaz.blockItem, oreTopaz.blockItem);//Blocks
		}
		if(ConfigHandler.enableRuby) {
			//TriGemsMod.ruby = new Gem("ruby", 3300);
			TriGemsMod.ruby = new Gem("ruby");
			//OreDictionary.registerOre("gemRuby", TriGemsMod.ruby);
			//TriGemsMod.Ruby.setRepairItem(new ItemStack(TriGemsMod.ruby));
			//TriGemsMod.RubyA.customCraftingMaterial = TriGemsMod.ruby;
			//TriGemsMod.RubyA.repairMaterial = new ItemStack(TriGemsMod.ruby);
			//TriGemsMod.RubySword = new Sword("ruby_sword", TriGemsMod.Ruby, 3320);
			TriGemsMod.RubySword = new Sword("ruby_sword", ToolTiers.RUBY);
			//TriGemsMod.RubySword = new SwordItem(ToolTiers.RUBY, 3, 2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "ruby_sword");
			//TriGemsMod.RubyPickaxe = new Pickaxe("ruby_pickaxe", TriGemsMod.Ruby, 3324);
			TriGemsMod.RubyPickaxe = new Pickaxe("ruby_pickaxe", ToolTiers.RUBY);
			//TriGemsMod.RubyPickaxe = new PickaxeItem(ToolTiers.RUBY, 1, 2.8F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "ruby_pickaxe");
			//TriGemsMod.RubyAxe = new Axe("ruby_axe", TriGemsMod.Ruby, 8.0F, 3328);
			//TriGemsMod.RubyAxe = new Axe("ruby_axe", TriGemsMod.Ruby, 8.0F, -3.0F, 3328);//Axe Damage will be Added to 1.0 so 8.0 is same as Diamond!!! Axe Speed will be Added to 4.0 so -3.0 is same as Diamond!!!
			TriGemsMod.RubyAxe = new Axe("ruby_axe", ToolTiers.RUBY, 5.0F, -3.0F);
			//TriGemsMod.RubyAxe = new AxeItem(ToolTiers.RUBY, 5.0F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "ruby_axe");
			//TriGemsMod.RubyShovel = new Shovel("ruby_shovel", TriGemsMod.Ruby, 3332);
			TriGemsMod.RubyShovel = new Shovel("ruby_shovel", ToolTiers.RUBY);
			//TriGemsMod.RubyShovel = new ShovelItem(ToolTiers.RUBY, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "ruby_shovel");
			//TriGemsMod.RubyHoe = new Hoe("ruby_hoe", TriGemsMod.Ruby, 3336);
			TriGemsMod.RubyHoe = new Hoe("ruby_hoe", ToolTiers.RUBY, 0.0F);
			//TriGemsMod.RubyHoe = new HoeItem(ToolTiers.RUBY, 0.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "ruby_hoe");
			//TriGemsMod.RubyHelmet = new Armor("ruby_helmet", TriGemsMod.RubyA, 1, EntityEquipmentSlot.HEAD, 3340);
			TriGemsMod.RubyHelmet = new Armor("ruby_helmet", ArmorTiers.RUBY, EquipmentSlotType.HEAD);
			//TriGemsMod.RubyHelmet = new ArmorItem(ArmorTiers.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "ruby_helmet");
			//TriGemsMod.RubyChest = new Armor("ruby_chestplate", TriGemsMod.RubyA, 1, EntityEquipmentSlot.CHEST, 3341);
			TriGemsMod.RubyChest = new Armor("ruby_chestplate", ArmorTiers.RUBY, EquipmentSlotType.CHEST);
			//TriGemsMod.RubyChest = new ArmorItem(ArmorTiers.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "ruby_chestplate");
			//TriGemsMod.RubyLegs = new Armor("ruby_leggings", TriGemsMod.RubyA, 2, EntityEquipmentSlot.LEGS, 3342);
			TriGemsMod.RubyLegs = new Armor("ruby_leggings", ArmorTiers.RUBY, EquipmentSlotType.LEGS);
			//TriGemsMod.RubyLegs = new ArmorItem(ArmorTiers.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "ruby_leggings");
			//TriGemsMod.RubyBoots = new Armor("ruby_boots", TriGemsMod.RubyA, 1, EntityEquipmentSlot.FEET, 3343);
			TriGemsMod.RubyBoots = new Armor("ruby_boots", ArmorTiers.RUBY, EquipmentSlotType.FEET);
			//TriGemsMod.RubyBoots = new ArmorItem(ArmorTiers.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "ruby_boots");
			registry.registerAll(ruby, RubySword, RubyPickaxe, RubyAxe, RubyShovel, RubyHoe,
					RubyHelmet, RubyChest, RubyLegs, RubyBoots);//Items
			registry.registerAll(blockRuby.blockItem, oreRuby.blockItem);//Blocks
		}
		if(ConfigHandler.enableSapphire) {
			//TriGemsMod.sapphire = new Gem("sapphire", 3302);
			TriGemsMod.sapphire = new Gem("sapphire");
			//OreDictionary.registerOre("gemSapphire", TriGemsMod.sapphire);
			//TriGemsMod.Sapphire.setRepairItem(new ItemStack(TriGemsMod.sapphire));
			//TriGemsMod.SapphireA.customCraftingMaterial = TriGemsMod.sapphire;
			//TriGemsMod.SapphireA.repairMaterial = new ItemStack(TriGemsMod.sapphire);
			//TriGemsMod.SapphireSword = new Sword("sapphire_sword", TriGemsMod.Sapphire, 3322);
			TriGemsMod.SapphireSword = new Sword("sapphire_sword", ToolTiers.SAPPHIRE);
			//TriGemsMod.SapphireSword = new SwordItem(ToolTiers.SAPPHIRE, 3, 2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "sapphire_sword");
			//TriGemsMod.SapphirePickaxe = new Pickaxe("sapphire_pickaxe", TriGemsMod.Sapphire, 3326);
			TriGemsMod.SapphirePickaxe = new Pickaxe("sapphire_pickaxe", ToolTiers.SAPPHIRE);
			//TriGemsMod.SapphirePickaxe = new PickaxeItem(ToolTiers.SAPPHIRE, 1, 2.8F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "sapphire_pickaxe");
			//TriGemsMod.SapphireAxe = new Axe("sapphire_axe", TriGemsMod.Sapphire, 8.0F, 3330);
			//TriGemsMod.SapphireAxe = new Axe("sapphire_axe", TriGemsMod.Sapphire, 8.0F, -3.0F, 3330);//Axe Damage will be Added to 1.0 so 8.0 is same as Diamond!!! Axe Speed will be Added to 4.0 so -3.0 is same as Diamond!!!
			TriGemsMod.SapphireAxe = new Axe("sapphire_axe", ToolTiers.SAPPHIRE, 5.0F, -3.0F);
			//TriGemsMod.SapphireAxe = new AxeItem(ToolTiers.SAPPHIRE, 5.0F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "sapphire_axe");
			//TriGemsMod.SapphireShovel = new Shovel("sapphire_shovel", TriGemsMod.Sapphire, 3334);
			TriGemsMod.SapphireShovel = new Shovel("sapphire_shovel", ToolTiers.SAPPHIRE);
			//TriGemsMod.SapphireShovel = new ShovelItem(ToolTiers.SAPPHIRE, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "sapphire_shovel");
			//TriGemsMod.SapphireHoe = new Hoe("sapphire_hoe", TriGemsMod.Sapphire, 3338);
			TriGemsMod.SapphireHoe = new Hoe("sapphire_hoe", ToolTiers.SAPPHIRE, 0.0F);
			//TriGemsMod.SapphireHoe = new HoeItem(ToolTiers.SAPPHIRE, 0.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "sapphire_hoe");
			//TriGemsMod.SapphireHelmet = new Armor("sapphire_helmet", TriGemsMod.SapphireA, 1, EntityEquipmentSlot.HEAD, 3348);
			TriGemsMod.SapphireHelmet = new Armor("sapphire_helmet", ArmorTiers.SAPPHIRE, EquipmentSlotType.HEAD);
			//TriGemsMod.SapphireHelmet = new ArmorItem(ArmorTiers.SAPPHIRE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "sapphire_helmet");
			//TriGemsMod.SapphireChest = new Armor("sapphire_chestplate", TriGemsMod.SapphireA, 1, EntityEquipmentSlot.CHEST, 3349);
			TriGemsMod.SapphireChest = new Armor("sapphire_chestplate", ArmorTiers.SAPPHIRE, EquipmentSlotType.CHEST);
			//TriGemsMod.SapphireChest = new ArmorItem(ArmorTiers.SAPPHIRE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "sapphire_chestplate");
			//TriGemsMod.SapphireLegs = new Armor("sapphire_leggings", TriGemsMod.SapphireA, 2, EntityEquipmentSlot.LEGS, 3350);
			TriGemsMod.SapphireLegs = new Armor("sapphire_leggings", ArmorTiers.SAPPHIRE, EquipmentSlotType.LEGS);
			//TriGemsMod.SapphireLegs = new ArmorItem(ArmorTiers.SAPPHIRE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "sapphire_leggings");
			//TriGemsMod.SapphireBoots = new Armor("sapphire_boots", TriGemsMod.SapphireA, 1, EntityEquipmentSlot.FEET, 3351);
			TriGemsMod.SapphireBoots = new Armor("sapphire_boots", ArmorTiers.SAPPHIRE, EquipmentSlotType.FEET);
			//TriGemsMod.SapphireBoots = new ArmorItem(ArmorTiers.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "sapphire_boots");
			registry.registerAll(sapphire, SapphireSword, SapphirePickaxe, SapphireAxe, SapphireShovel, SapphireHoe,
					SapphireHelmet, SapphireChest, SapphireLegs, SapphireBoots);//Items
			registry.registerAll(blockSapphire.blockItem, oreSapphire.blockItem);//Blocks
		}
		if(ConfigHandler.enableEmerald) {
			//TriGemsMod.Emerald.setRepairItem(new ItemStack(Items.EMERALD));
			//TriGemsMod.EmeraldA.customCraftingMaterial = Items.EMERALD;
			//TriGemsMod.EmeraldA.repairMaterial = new ItemStack(Items.EMERALD);
			//TriGemsMod.EmeraldSword = new Sword("emerald_sword", TriGemsMod.Emerald, 3321);
			TriGemsMod.EmeraldSword = new Sword("emerald_sword", ToolTiers.EMERALD);
			//TriGemsMod.EmeraldSword = new SwordItem(ToolTiers.EMERALD, 3, 2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "emerald_sword");
			//TriGemsMod.EmeraldPickaxe = new Pickaxe("emerald_pickaxe", TriGemsMod.Emerald, 3325);
			TriGemsMod.EmeraldPickaxe = new Pickaxe("emerald_pickaxe", ToolTiers.EMERALD);
			//TriGemsMod.EmeraldPickaxe = new PickaxeItem(ToolTiers.EMERALD, 1, 2.8F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "emerald_pickaxe");
			//TriGemsMod.EmeraldAxe = new Axe("emerald_axe", TriGemsMod.Emerald, 8.0F, 3329);
			//TriGemsMod.EmeraldAxe = new Axe("emerald_axe", TriGemsMod.Emerald, 8.0F, -3.0F, 3329);//Axe Damage will be Added to 1.0 so 8.0 is same as Diamond!!! Axe Speed will be Added to 4.0 so -3.0 is same as Diamond!!!
			TriGemsMod.EmeraldAxe = new Axe("emerald_axe", ToolTiers.EMERALD, 5.0F, -3.0F);
			//TriGemsMod.EmeraldAxe = new AxeItem(ToolTiers.EMERALD, 5.0F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "emerald_axe");
			//TriGemsMod.EmeraldShovel = new Shovel("emerald_shovel", TriGemsMod.Emerald, 3333);
			TriGemsMod.EmeraldShovel = new Shovel("emerald_shovel", ToolTiers.EMERALD);
			//TriGemsMod.EmeraldShovel = new ShovelItem(ToolTiers.EMERALD, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "emerald_shovel");
			//TriGemsMod.EmeraldHoe = new Hoe("emerald_hoe", TriGemsMod.Emerald, 3337);
			TriGemsMod.EmeraldHoe = new Hoe("emerald_hoe", ToolTiers.EMERALD, 0.0F);
			//TriGemsMod.EmeraldHoe = new HoeItem(ToolTiers.EMERALD, 0.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "emerald_hoe");
			//TriGemsMod.EmeraldHelmet = new Armor("emerald_helmet", TriGemsMod.EmeraldA, 1, EntityEquipmentSlot.HEAD, 3344);
			TriGemsMod.EmeraldHelmet = new Armor("emerald_helmet", ArmorTiers.EMERALD, EquipmentSlotType.HEAD);
			//TriGemsMod.EmeraldHelmet = new ArmorItem(ArmorTiers.EMERALD, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "emerald_helmet");
			//TriGemsMod.EmeraldChest = new Armor("emerald_chestplate", TriGemsMod.EmeraldA, 1, EntityEquipmentSlot.CHEST, 3345);
			TriGemsMod.EmeraldChest = new Armor("emerald_chestplate", ArmorTiers.EMERALD, EquipmentSlotType.CHEST);
			//TriGemsMod.EmeraldChest = new ArmorItem(ArmorTiers.EMERALD, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "emerald_chestplate");
			//TriGemsMod.EmeraldLegs = new Armor("emerald_leggings", TriGemsMod.EmeraldA, 2, EntityEquipmentSlot.LEGS, 3346);
			TriGemsMod.EmeraldLegs = new Armor("emerald_leggings", ArmorTiers.EMERALD, EquipmentSlotType.LEGS);
			//TriGemsMod.EmeraldLegs = new ArmorItem(ArmorTiers.EMERALD, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "emerald_leggings");
			//TriGemsMod.EmeraldBoots = new Armor("emerald_boots", TriGemsMod.EmeraldA, 1, EntityEquipmentSlot.FEET, 3347);
			TriGemsMod.EmeraldBoots = new Armor("emerald_boots", ArmorTiers.EMERALD, EquipmentSlotType.FEET);
			//TriGemsMod.EmeraldBoots = new ArmorItem(ArmorTiers.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "emerald_boots");
			registry.registerAll(EmeraldSword, EmeraldPickaxe, EmeraldAxe, EmeraldShovel, EmeraldHoe,
					EmeraldHelmet, EmeraldChest, EmeraldLegs, EmeraldBoots);
		}
	}
	
	@SubscribeEvent
	//public void registerBlcks(RegistryEvent.Register<Block> e) {
	public static void registerBlcks(RegistryEvent.Register<Block> e) {
		IForgeRegistry<Block> registry = e.getRegistry();
		//loadBlocks();
		if(ConfigHandler.enableTopaz) {
			//TriGemsMod.oreTopaz = new GemOre("topaz_ore", 3307);
			//TriGemsMod.oreTopaz = new GemOre("topaz_ore");
			oreTopaz = new TriGemsBlock("topaz_ore", MaterialColor.STONE, true);
			//OreDictionary.registerOre("oreTopaz", TriGemsMod.oreTopaz);
			//TriGemsMod.blockTopaz = new GemBlock("topaz_block", 3311);
			//TriGemsMod.blockTopaz = new GemBlock("topaz_block", 3311, MapColor.YELLOW);
			//TriGemsMod.blockTopaz = new GemBlock("topaz_block", MaterialColor.YELLOW);
			blockTopaz = new TriGemsBlock("topaz_block", MaterialColor.YELLOW, false);
			//OreDictionary.registerOre("blockTopaz", TriGemsMod.blockTopaz);
			registry.registerAll(oreTopaz, blockTopaz);
		}
		if(ConfigHandler.enableRuby) {
			//TriGemsMod.oreRuby = new GemOre("ruby_ore", 3304);
			//TriGemsMod.oreRuby = new GemOre("ruby_ore");
			oreRuby = new TriGemsBlock("ruby_ore", MaterialColor.STONE, true);
			//OreDictionary.registerOre("oreRuby", TriGemsMod.oreRuby);
			//TriGemsMod.blockRuby = new GemBlock("ruby_block", 3308);
			//TriGemsMod.blockRuby = new GemBlock("ruby_block", 3308, MapColor.RED);
			//TriGemsMod.blockRuby = new GemBlock("ruby_block", MaterialColor.RED);
			blockRuby = new TriGemsBlock("ruby_block", MaterialColor.RED, false);
			//OreDictionary.registerOre("blockRuby", TriGemsMod.blockRuby);
			registry.registerAll(oreRuby, blockRuby);
		}
		if(ConfigHandler.enableSapphire) {
			//TriGemsMod.oreSapphire = new GemOre("sapphire_ore", 3306);
			//TriGemsMod.oreSapphire = new GemOre("sapphire_ore");
			oreSapphire = new TriGemsBlock("sapphire_ore", MaterialColor.STONE, true);
			//OreDictionary.registerOre("oreSapphire", TriGemsMod.oreSapphire);
			//TriGemsMod.blockSapphire = new GemBlock("sapphire_block", 3310);
			//TriGemsMod.blockSapphire = new GemBlock("sapphire_block", 3310, MapColor.BLUE);
			//TriGemsMod.blockSapphire = new GemBlock("sapphire_block", MaterialColor.BLUE);
			blockSapphire = new TriGemsBlock("sapphire_block", MaterialColor.BLUE, false);
			//OreDictionary.registerOre("blockSapphire", TriGemsMod.blockSapphire);
			registry.registerAll(oreSapphire, blockSapphire);
		}
	}
	
	@SubscribeEvent
	//public void registerRecipeConditions(RegistryEvent.Register<IRecipeSerializer<?>> e) {
	public static void registerRecipeConditions(RegistryEvent.Register<IRecipeSerializer<?>> e) {
		//CraftingHelper.register(ConfigCondition.Serializer.INSTANCE);
		try {
			//CraftingHelper.register(ConfigCondition.Serializer.INSTANCE);
			Class<?> IConditionSerializer = Class.forName("net.minecraftforge.common.crafting.conditions.IConditionSerializer");
			Method register = CraftingHelper.class.getMethod("register", IConditionSerializer);
			Object conditionSerializer = Proxy.newProxyInstance(IConditionSerializer.getClassLoader(),
					new Class[] { IConditionSerializer }, new RecipeConditionInvocationHandler());
			register.invoke(null, conditionSerializer);
		} catch (Throwable e2) {
			try {
				//condition("config_condition", json -> {
                    //String itemName = JSONUtils.getString(json, "item");
                    //return () -> ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
                //});
				Class<?> IConditionSerializer = Class.forName("net.minecraftforge.common.crafting.IConditionSerializer");
				Method register = CraftingHelper.class.getMethod("register", ResourceLocation.class, IConditionSerializer);
				Object conditionSerializer = Proxy.newProxyInstance(IConditionSerializer.getClassLoader(),
						new Class[] { IConditionSerializer }, new RecipeConditionInvocationHandler());
				register.invoke(null, new ResourceLocation(MODID, "config_condition"), conditionSerializer);
			} catch (Throwable e3) {
				e2.printStackTrace();
				e3.printStackTrace();
			}
		}
	}
	
	/*@SuppressWarnings("rawtypes")
	private static IConditionSerializer condition(String name, IConditionSerializer condition) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> IConditionSerializer = Class.forName("net.minecraftforge.common.crafting.IConditionSerializer");
		Method register = CraftingHelper.class.getMethod("register", ResourceLocation.class, IConditionSerializer);
		return (IConditionSerializer) register.invoke(null, new ResourceLocation(MODID, name), condition);
	}*/
	
	/**public void loadRecipes(){
		
		GameRegistry.addSmelting(TriGemsMod.oreTopaz, new ItemStack(TriGemsMod.topaz), 0.5F);
		GameRegistry.addSmelting(TriGemsMod.oreRuby, new ItemStack(TriGemsMod.ruby), 0.5F);
		GameRegistry.addSmelting(TriGemsMod.oreSapphire, new ItemStack(TriGemsMod.sapphire), 0.5F);
		
		/**GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TopazPickaxe), new Object[] {
			"GGG",
			" S ",
			" S ",
			'G', "gemTopaz",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RubyPickaxe), new Object[] {
			"GGG",
			" S ",
			" S ",
			'G', "gemRuby",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SapphirePickaxe), new Object[] {
			"GGG",
			" S ",
			" S ",
			'G', "gemSapphire",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(EmeraldPickaxe), new Object[]{
			"GGG",
			" S ",
			" S ",
			'G', "gemEmerald",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ItemStack(blockTopaz), new Object[]{
			"TTT",
			"TTT",
			"TTT",
			'T', topaz
		});
		
		GameRegistry.addRecipe(new ItemStack(blockRuby), new Object[]{
			"RRR",
			"RRR",
			"RRR",
			'R', ruby
		});
		
		GameRegistry.addRecipe(new ItemStack(blockSapphire), new Object[]{
			"SSS",
			"SSS",
			"SSS",
			'S', sapphire
		});
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TopazAxe), new Object[]{
			"GG",
			"GS",
			" S",
			'G', "gemTopaz",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RubyAxe), new Object[]{
			"GG",
			"GS",
			" S",
			'G', "gemRuby",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SapphireAxe), new Object[]{
			"GG",
			"GS",
			" S",
			'G', "gemSapphire",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(EmeraldAxe), new Object[]{
			"GG",
			"GS",
			" S",
			'G', "gemEmerald",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TopazShovel), new Object[]{
			"G",
			"S",
			"S",
			'G', "gemTopaz",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RubyShovel), new Object[]{
			"G",
			"S",
			"S",
			'G', "gemRuby",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SapphireShovel), new Object[]{
			"G",
			"S",
			"S",
			'G', "gemSapphire",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(EmeraldShovel), new Object[]{
			"G",
			"S",
			"S",
			'G', "gemEmerald",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TopazHoe), new Object[]{
			"GG",
			" S",
			" S",
			'G', "gemTopaz",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RubyHoe), new Object[]{
			"GG",
			" S",
			" S",
			'G', "gemRuby",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SapphireHoe), new Object[]{
			"GG",
			" S",
			" S",
			'G', "gemSapphire",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(EmeraldHoe), new Object[]{
			"GG",
			" S",
			" S",
			'G', "gemEmerald",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TopazSword), new Object[]{
			"G",
			"G",
			"S",
			'G', "gemTopaz",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RubySword), new Object[]{
			"G",
			"G",
			"S",
			'G', "gemRuby",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SapphireSword), new Object[]{
			"G",
			"G",
			"S",
			'G', "gemSapphire",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(EmeraldSword), new Object[]{
			"G",
			"G",
			"S",
			'G', "gemEmerald",
			'S', Items.STICK
		}));
		
		GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_HELMET), new Object[]{
			"III",
			"I I",
			'I', Blocks.IRON_BARS
		});
		
		GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_CHESTPLATE), new Object[]{
			"I I",
			"III",
			"III",
			'I', Blocks.IRON_BARS
		});
		
		GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_LEGGINGS), new Object[]{
			"III",
			"I I",
			"I I",
			'I', Blocks.IRON_BARS
		});
		
		GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_BOOTS), new Object[]{
			"I I",
			"I I",
			'I', Blocks.IRON_BARS
		});
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TopazHelmet), new Object[]{
			"TTT",
			"T T",
			'T', "gemTopaz"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TopazChest), new Object[]{
			"T T",
			"TTT",
			"TTT",
			'T', "gemTopaz"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TopazLegs), new Object[]{
			"TTT",
			"T T",
			"T T",
			'T', "gemTopaz"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TopazBoots), new Object[]{
			"T T",
			"T T",
			'T', "gemTopaz"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RubyHelmet), new Object[]{
			"RRR",
			"R R",
			'R', "gemRuby"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RubyChest), new Object[]{
			"R R",
			"RRR",
			"RRR",
			'R', "gemRuby"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RubyLegs), new Object[]{
			"RRR",
			"R R",
			"R R",
			'R', "gemRuby"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RubyBoots), new Object[]{
			"R R",
			"R R",
			'R', "gemRuby"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SapphireHelmet), new Object[]{
			"SSS",
			"S S",
			'S', "gemSapphire"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SapphireChest), new Object[]{
			"S S",
			"SSS",
			"SSS",
			'S', "gemSapphire"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SapphireLegs), new Object[]{
			"SSS",
			"S S",
			"S S",
			'S', "gemSapphire"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SapphireBoots), new Object[]{
			"S S",
			"S S",
			'S', "gemSapphire"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(EmeraldHelmet), new Object[]{
			"EEE",
			"E E",
			'E', "gemEmerald"
		}));
			
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(EmeraldChest), new Object[]{
			"E E",
			"EEE",
			"EEE",
			'E', "gemEmerald"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(EmeraldLegs), new Object[]{
			"EEE",
			"E E",
			"E E",
			'E', "gemEmerald"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(EmeraldBoots), new Object[]{
			"E E",
			"E E",
			'E', "gemEmerald"
		}));
		
		GameRegistry.addShapelessRecipe(new ItemStack(topaz, 9), blockTopaz);
		GameRegistry.addShapelessRecipe(new ItemStack(ruby, 9), blockRuby);
		GameRegistry.addShapelessRecipe(new ItemStack(sapphire, 9), blockSapphire);*//**
		
	}
	
	public void loadItems(){
		
		ruby = new Gem("ruby", 3300);
		OreDictionary.registerOre("gemRuby", ruby);
		sapphire = new Gem("sapphire", 3302);
		OreDictionary.registerOre("gemSapphire", sapphire);
		topaz = new Gem("topaz", 3303);
		OreDictionary.registerOre("gemTopaz", topaz);
		RubySword = new Sword("ruby_sword", Ruby, 3320);
		EmeraldSword = new Sword("emerald_sword", Emerald, 3321);
		SapphireSword = new Sword("sapphire_sword", Sapphire, 3322);
		TopazSword = new Sword("topaz_sword", Topaz, 3323);
		RubyPickaxe = new Pickaxe("ruby_pickaxe", Ruby, 3324);
		EmeraldPickaxe = new Pickaxe("emerald_pickaxe", Emerald, 3325);
		SapphirePickaxe = new Pickaxe("sapphire_pickaxe", Sapphire, 3326);
		TopazPickaxe = new Pickaxe("topaz_pickaxe", Topaz, 3327);
		RubyAxe = new Axe("ruby_axe", Ruby, 8.0F, 3328);
		EmeraldAxe = new Axe("emerald_axe", Emerald, 8.0F, 3329);
		SapphireAxe = new Axe("sapphire_axe", Sapphire, 8.0F, 3330);
		TopazAxe = new Axe("topaz_axe", Topaz, 8.0F, 3331);
		RubyShovel = new Shovel("ruby_shovel", Ruby, 3332);
		EmeraldShovel = new Shovel("emerald_shovel", Emerald, 3333);
		SapphireShovel = new Shovel("sapphire_shovel", Sapphire, 3334);
		TopazShovel = new Shovel("topaz_shovel", Topaz, 3335);
		RubyHoe = new Hoe("ruby_hoe", Ruby, 3336);
		EmeraldHoe = new Hoe("emerald_hoe", Emerald, 3337);
		SapphireHoe = new Hoe("sapphire_hoe", Emerald, 3338);
		TopazHoe = new Hoe("topaz_hoe", Emerald, 3339);
		RubyHelmet = new Armor("ruby_helmet", RubyA, 1, EntityEquipmentSlot.HEAD, 3340);
		RubyChest = new Armor("ruby_chestplate", RubyA, 1, EntityEquipmentSlot.CHEST, 3341);
		RubyLegs = new Armor("ruby_leggings", RubyA, 2, EntityEquipmentSlot.LEGS, 3342);
		RubyBoots = new Armor("ruby_boots", RubyA, 1, EntityEquipmentSlot.FEET, 3343);
		EmeraldHelmet = new Armor("emerald_helmet", EmeraldA, 1, EntityEquipmentSlot.HEAD, 3344);
		EmeraldChest = new Armor("emerald_chestplate", EmeraldA, 1, EntityEquipmentSlot.CHEST, 3345);
		EmeraldLegs = new Armor("emerald_leggings", EmeraldA, 2, EntityEquipmentSlot.LEGS, 3346);
		EmeraldBoots = new Armor("emerald_boots", EmeraldA, 1, EntityEquipmentSlot.FEET, 3347);
		SapphireHelmet = new Armor("sapphire_helmet", SapphireA, 1, EntityEquipmentSlot.HEAD, 3348);
		SapphireChest = new Armor("sapphire_chestplate", SapphireA, 1, EntityEquipmentSlot.CHEST, 3349);
		SapphireLegs = new Armor("sapphire_leggings", SapphireA, 2, EntityEquipmentSlot.LEGS, 3350);
		SapphireBoots = new Armor("sapphire_boots", SapphireA, 1, EntityEquipmentSlot.FEET, 3351);
		TopazHelmet = new Armor("topaz_helmet", TopazA, 1, EntityEquipmentSlot.HEAD, 3352);
		TopazChest = new Armor("topaz_chestplate", TopazA, 1, EntityEquipmentSlot.CHEST, 3353);
		TopazLegs = new Armor("topaz_leggings", TopazA, 2, EntityEquipmentSlot.LEGS, 3354);
		TopazBoots = new Armor("topaz_boots", TopazA, 1, EntityEquipmentSlot.FEET, 3355);
		
	}
	
	public void loadBlocks() {
		//oreRuby = new GemOre("ruby_ore", 3304, ruby);
		//ruby.REGISTRY.register(3304, new ResourceLocation("trigems:" + oreRuby.getUnlocalizedName().substring(5)), new ItemBlock(oreRuby).setRegistryName(oreRuby.getRegistryName()));
		oreRuby = new GemOre("ruby_ore", 3304);
		OreDictionary.registerOre("oreRuby", oreRuby);
		blockRuby = new GemBlock("ruby_block", 3308);
		//ruby.REGISTRY.register(3308, new ResourceLocation("trigems:" + blockRuby.getUnlocalizedName().substring(5)), new ItemBlock(blockRuby).setRegistryName(blockRuby.getRegistryName()));
		OreDictionary.registerOre("blockRuby", blockRuby);
		//oreSapphire = new GemOre("sapphire_ore", 3306, sapphire);
		//sapphire.REGISTRY.register(3306, new ResourceLocation("trigems:" + oreSapphire.getUnlocalizedName().substring(5)), new ItemBlock(oreSapphire).setRegistryName(oreSapphire.getRegistryName()));
		oreSapphire = new GemOre("sapphire_ore", 3306);
		OreDictionary.registerOre("oreSapphire", oreSapphire);
		blockSapphire = new GemBlock("sapphire_block", 3310);
		//sapphire.REGISTRY.register(3310, new ResourceLocation("trigems:" + blockSapphire.getUnlocalizedName().substring(5)), new ItemBlock(blockSapphire).setRegistryName(blockSapphire.getRegistryName()));
		OreDictionary.registerOre("blockSapphire", blockSapphire);
		//oreTopaz = new GemOre("topaz_ore", 3307, topaz);
		//topaz.REGISTRY.register(3307, new ResourceLocation("trigems:" + oreTopaz.getUnlocalizedName().substring(5)), new ItemBlock(oreTopaz).setRegistryName(oreTopaz.getRegistryName()));
		oreTopaz = new GemOre("topaz_ore", 3307);
		OreDictionary.registerOre("oreTopaz", oreTopaz);
		blockTopaz = new GemBlock("topaz_block", 3311);
		//topaz.REGISTRY.register(3311, new ResourceLocation("trigems:" + blockTopaz.getUnlocalizedName().substring(5)), new ItemBlock(blockTopaz).setRegistryName(blockTopaz.getRegistryName()));
		OreDictionary.registerOre("blockTopaz", blockTopaz);
	}*/
	
	private static class RecipeConditionInvocationHandler implements InvocationHandler {

		private static final ResourceLocation NAME = new ResourceLocation("trigems", "config_condition");
		private String option;
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			String name = method.getName();
			//if(method.getName().equals("parse") && args.length == 1) {
			if(name.equals("parse") && args.length == 1) {
				if(args[0] instanceof JsonObject) {
					return parse((JsonObject) args[0]);
				}
			}
			else if(name.equals("write") && args.length == 2) {
				if(args[0] instanceof JsonObject && args[1] instanceof RecipeConditionInvocationHandler) {
					((JsonObject) args[0]).addProperty("option", ((RecipeConditionInvocationHandler) args[1]).option);
				}
				else {
					System.out.println(args[1].getClass());
				}
			}
			else if(name.equals("read") && args.length == 1) {
				if(args[0] instanceof JsonObject) {
					try {
						Class<?> ICondition = Class.forName("net.minecraftforge.common.crafting.conditions.ICondition");
						Object condition = Proxy.newProxyInstance(ICondition.getClassLoader(),
								new Class[] { ICondition }, new RecipeConditionInvocationHandler());
						((RecipeConditionInvocationHandler) Proxy.getInvocationHandler(condition)).option = JSONUtils.getString((JsonObject) args[0], "option");
						return condition;
					} catch (Throwable e2) {
						e2.printStackTrace();
					}
				}
			}
			else if(name.equals("getID")) {
				return NAME;
			}
			else if(name.equals("test")) {
				return test();
			}
			else if(name.equals("toString")) {
				if(option != null) {
					return "config_condition(\"" + option + "\")";
				}
				else {
					return super.toString();
				}
			}
			return null;
		}
		
		private boolean test() {
			if(option.equalsIgnoreCase("chain")) {
				return ConfigHandler.enableChainRecipes;
			}
			else if(option.equalsIgnoreCase("topaz")) {
				return ConfigHandler.enableTopaz;
			}
			else if(option.equalsIgnoreCase("ruby")) {
				return ConfigHandler.enableRuby;
			}
			else if(option.equalsIgnoreCase("sapphire")) {
				return ConfigHandler.enableSapphire;
			}
			else if(option.equalsIgnoreCase("emerald")) {
				return ConfigHandler.enableEmerald;
			}
			else {
				return false;
			}
		}
		
		private BooleanSupplier parse(JsonObject json) {
			String option = JSONUtils.getString(json, "option");
			if(option.equalsIgnoreCase("chain")) {
				return () -> ConfigHandler.enableChainRecipes;
			}
			else if(option.equalsIgnoreCase("topaz")) {
				return () -> ConfigHandler.enableTopaz;
			}
			else if(option.equalsIgnoreCase("ruby")) {
				return () -> ConfigHandler.enableRuby;
			}
			else if(option.equalsIgnoreCase("sapphire")) {
				return () -> ConfigHandler.enableSapphire;
			}
			else if(option.equalsIgnoreCase("emerald")) {
				return () -> ConfigHandler.enableEmerald;
			}
			else {
				//System.out.println(json.get("option"));
				return () -> false;
			}
		}
		
	}
	
}
