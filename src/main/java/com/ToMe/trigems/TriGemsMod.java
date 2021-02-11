package com.ToMe.trigems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

//@Mod(modid = "trigems", name = "TriGems", version="1.0")
//@Mod(modid = TriGemsMod.MODID, name = TriGemsMod.NAME, version = TriGemsMod.NAME, acceptedMinecraftVersions = TriGemsMod.MCVERSION)//VERSION = NAME
@Mod(modid = TriGemsMod.MODID, name = TriGemsMod.NAME, version = TriGemsMod.VERSION, acceptedMinecraftVersions = TriGemsMod.MCVERSION)
public class TriGemsMod {
	
	@SidedProxy(clientSide="com.ToMe.trigems.ClientProxy", serverSide="com.ToMe.trigems.ServerProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static TriGemsMod instance = new TriGemsMod();
	
	public static final String MODID = "trigems";
	public static final String NAME = "TriGems";
	public static final String VERSION = "1.0";
	public static final String MCVERSION = "[1.10,1.10.2]";
	
	public static ConfigHandler cfg = new ConfigHandler();
	
	//Items
	//TOPAZ
	public static Gem topaz;
	public static Pickaxe TopazPickaxe;
	public static Axe TopazAxe;
	public static Shovel TopazShovel;
	public static Hoe TopazHoe;
	public static Sword TopazSword;
	//RUBY
	public static Gem ruby;
	public static Pickaxe RubyPickaxe;
	public static Axe RubyAxe;
	public static Shovel RubyShovel;
	public static Hoe RubyHoe;
	public static Sword RubySword;
	//SAPHIRE
	public static Gem sapphire;
	public static Pickaxe SapphirePickaxe;
	public static Axe SapphireAxe;
	public static Shovel SapphireShovel;
	public static Hoe SapphireHoe;
	public static Sword SapphireSword;
	//EMERALD
	public static Pickaxe EmeraldPickaxe;
	public static Axe EmeraldAxe;
	public static Shovel EmeraldShovel;
	public static Hoe EmeraldHoe;
	public static Sword EmeraldSword;
	
	//Armor
	public static Armor RubyHelmet;
	public static Armor RubyChest;
	public static Armor RubyLegs;
	public static Armor RubyBoots;
	public static Armor EmeraldHelmet;
	public static Armor EmeraldChest;
	public static Armor EmeraldLegs;
	public static Armor EmeraldBoots;
	public static Armor SapphireHelmet;
	public static Armor SapphireChest;
	public static Armor SapphireLegs;
	public static Armor SapphireBoots;
	public static Armor TopazHelmet;
	public static Armor TopazChest;
	public static Armor TopazLegs;
	public static Armor TopazBoots;
	
	//Blocks
	public static GemOre oreTopaz;
	public static GemBlock blockTopaz;
	public static GemOre oreRuby;
	public static GemBlock blockRuby;
	public static GemOre oreSapphire;
	public static GemBlock blockSapphire;
	
	//Materials
	public static ToolMaterial Topaz = EnumHelper.addToolMaterial("topaz", 3, 1500, 8.0F, 2.5F, 10);
	public static ToolMaterial Ruby = EnumHelper.addToolMaterial("ruby", 3, 1500, 8.0F, 3.0F, 10);
	public static ToolMaterial Sapphire = EnumHelper.addToolMaterial("sapphire", 3, 1500, 8.0F, 3.5F, 10);
	public static ToolMaterial Emerald = EnumHelper.addToolMaterial("emerald", 3, 1500, 15.0F, 4.0F, 30);
	public static ArmorMaterial TopazA = EnumHelper.addArmorMaterial("topaz_armor", "trigems:topaz", 32, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F);
	public static ArmorMaterial RubyA = EnumHelper.addArmorMaterial("ruby_armor", "trigems:ruby", 33, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	public static ArmorMaterial SapphireA = EnumHelper.addArmorMaterial("sapphire_armor", "trigems:sapphire", 34, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);
	public static ArmorMaterial EmeraldA = EnumHelper.addArmorMaterial("emerald_armor", "trigems:emerald", 35, new int[] {3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		proxy.preInit(e);
		//loadItems();
		//loadBlocks();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		
		proxy.register();
		//loadRecipes();
		GameRegistry.registerWorldGenerator(new GenerationHelper(), 2);
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
	/**public void loadRecipes(){
		
		GameRegistry.addSmelting(TriGemsMod.oreTopaz, new ItemStack(TriGemsMod.topaz), 0.5F);
		GameRegistry.addSmelting(TriGemsMod.oreRuby, new ItemStack(TriGemsMod.ruby), 0.5F);
		GameRegistry.addSmelting(TriGemsMod.oreSapphire, new ItemStack(TriGemsMod.sapphire), 0.5F);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TopazPickaxe), new Object[] {
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
		GameRegistry.addShapelessRecipe(new ItemStack(sapphire, 9), blockSapphire);
		
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
		//oreTopaz= new GemOre("topaz_ore", 3307, topaz);
		//topaz.REGISTRY.register(3307, new ResourceLocation("trigems:" + oreTopaz.getUnlocalizedName().substring(5)), new ItemBlock(oreTopaz).setRegistryName(oreTopaz.getRegistryName()));
		oreTopaz = new GemOre("topaz_ore", 3307);
		OreDictionary.registerOre("oreTopaz", oreTopaz);
		blockTopaz = new GemBlock("topaz_block", 3311);
		//topaz.REGISTRY.register(3311, new ResourceLocation("trigems:" + blockTopaz.getUnlocalizedName().substring(5)), new ItemBlock(blockTopaz).setRegistryName(blockTopaz.getRegistryName()));
		OreDictionary.registerOre("blockTopaz", blockTopaz);
	}*/
	
}
