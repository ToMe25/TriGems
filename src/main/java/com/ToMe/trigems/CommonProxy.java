package com.ToMe.trigems;

import net.minecraft.block.material.MapColor;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e){
		TriGemsMod.cfg.Init(e);
		if(ConfigHandler.enableChainRecipes) {
			GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_HELMET), new Object[]{
				"TTT",
				"T T",
				'T', Blocks.IRON_BARS
			});
			
			GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_CHESTPLATE), new Object[]{
				"T T",
				"TTT",
				"TTT",
				'T', Blocks.IRON_BARS
			});
			
			GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_LEGGINGS), new Object[]{
				"TTT",
				"T T",
				"T T",
				'T', Blocks.IRON_BARS
			});
			
			GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_BOOTS), new Object[]{
				"T T",
				"T T",
				'T', Blocks.IRON_BARS
			});
		}
		
		if(ConfigHandler.enableTopaz) {
			TriGemsMod.oreTopaz = new GemOre("topaz_ore", 3307);
			OreDictionary.registerOre("oreTopaz", TriGemsMod.oreTopaz);
			//TriGemsMod.blockTopaz = new GemBlock("topaz_block", 3311);
			TriGemsMod.blockTopaz = new GemBlock("topaz_block", 3311, MapColor.YELLOW);
			OreDictionary.registerOre("blockTopaz", TriGemsMod.blockTopaz);
			TriGemsMod.topaz = new Gem("topaz", 3303);
			OreDictionary.registerOre("gemTopaz", TriGemsMod.topaz);
			TriGemsMod.Topaz.setRepairItem(new ItemStack(TriGemsMod.topaz));
			TriGemsMod.TopazA.customCraftingMaterial = TriGemsMod.topaz;
			TriGemsMod.TopazSword = new Sword("topaz_sword", TriGemsMod.Topaz, 3323);
			TriGemsMod.TopazPickaxe = new Pickaxe("topaz_pickaxe", TriGemsMod.Topaz, 3327);
			//TriGemsMod.TopazAxe = new Axe("topaz_axe", TriGemsMod.Topaz, 8.0F, 3331);
			TriGemsMod.TopazAxe = new Axe("topaz_axe", TriGemsMod.Topaz, 8.0F, -3.0F, 3331);//Axe Damage will be Added to 1.0 so 8.0 is same as Diamond!!! Axe Speed will be Added to 4.0 so -3.0 is same as Diamond!!!
			TriGemsMod.TopazShovel = new Shovel("topaz_shovel", TriGemsMod.Topaz, 3335);
			TriGemsMod.TopazHoe = new Hoe("topaz_hoe", TriGemsMod.Topaz, 3339);
			TriGemsMod.TopazHelmet = new Armor("topaz_helmet", TriGemsMod.TopazA, 1, EntityEquipmentSlot.HEAD, 3352);
			TriGemsMod.TopazChest = new Armor("topaz_chestplate", TriGemsMod.TopazA, 1, EntityEquipmentSlot.CHEST, 3353);
			TriGemsMod.TopazLegs = new Armor("topaz_leggings", TriGemsMod.TopazA, 2, EntityEquipmentSlot.LEGS, 3354);
			TriGemsMod.TopazBoots = new Armor("topaz_boots", TriGemsMod.TopazA, 1, EntityEquipmentSlot.FEET, 3355);
			
			GameRegistry.addSmelting(TriGemsMod.oreTopaz, new ItemStack(TriGemsMod.topaz), 0.5F);
			//GameRegistry.addShapelessRecipe(new ItemStack(TriGemsMod.topaz, 9), TriGemsMod.blockTopaz);
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TriGemsMod.topaz, 9), "blockTopaz"));
			
			//GameRegistry.addRecipe(new ItemStack(TriGemsMod.blockTopaz), new Object[]{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.blockTopaz), new Object[] {
				"TTT",
				"TTT",
				"TTT",
				//'T', TriGemsMod.topaz
				'T', "gemTopaz"
			//});
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.TopazPickaxe), new Object[] {
				"GGG",
				" S ",
				" S ",
				'G', "gemTopaz",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.TopazAxe), new Object[]{
				"GG",
				"GS",
				" S",
				'G', "gemTopaz",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.TopazShovel), new Object[]{
				"G",
				"S",
				"S",
				'G', "gemTopaz",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.TopazHoe), new Object[]{
				"GG",
				" S",
				" S",
				'G', "gemTopaz",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.TopazSword), new Object[]{
				"G",
				"G",
				"S",
				'G', "gemTopaz",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.TopazHelmet), new Object[]{
				"TTT",
				"T T",
				'T', "gemTopaz"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.TopazChest), new Object[]{
				"T T",
				"TTT",
				"TTT",
				'T', "gemTopaz"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.TopazLegs), new Object[]{
				"TTT",
				"T T",
				"T T",
				'T', "gemTopaz"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.TopazBoots), new Object[]{
				"T T",
				"T T",
				'T', "gemTopaz"
			}));
		}
		
		if(ConfigHandler.enableRuby) {
			TriGemsMod.oreRuby = new GemOre("ruby_ore", 3304);
			OreDictionary.registerOre("oreRuby", TriGemsMod.oreRuby);
			//TriGemsMod.blockRuby = new GemBlock("ruby_block", 3308);
			TriGemsMod.blockRuby = new GemBlock("ruby_block", 3308, MapColor.RED);
			OreDictionary.registerOre("blockRuby", TriGemsMod.blockRuby);
			TriGemsMod.ruby = new Gem("ruby", 3300);
			OreDictionary.registerOre("gemRuby", TriGemsMod.ruby);
			TriGemsMod.Ruby.setRepairItem(new ItemStack(TriGemsMod.ruby));
			TriGemsMod.RubyA.customCraftingMaterial = TriGemsMod.ruby;
			TriGemsMod.RubySword = new Sword("ruby_sword", TriGemsMod.Ruby, 3320);
			TriGemsMod.RubyPickaxe = new Pickaxe("ruby_pickaxe", TriGemsMod.Ruby, 3324);
			//TriGemsMod.RubyAxe = new Axe("ruby_axe", TriGemsMod.Ruby, 8.0F, 3328);
			TriGemsMod.RubyAxe = new Axe("ruby_axe", TriGemsMod.Ruby, 8.0F, -3.0F, 3328);//Axe Damage will be Added to 1.0 so 8.0 is same as Diamond!!! Axe Speed will be Added to 4.0 so -3.0 is same as Diamond!!!
			TriGemsMod.RubyShovel = new Shovel("ruby_shovel", TriGemsMod.Ruby, 3332);
			TriGemsMod.RubyHoe = new Hoe("ruby_hoe", TriGemsMod.Ruby, 3336);
			TriGemsMod.RubyHelmet = new Armor("ruby_helmet", TriGemsMod.RubyA, 1, EntityEquipmentSlot.HEAD, 3340);
			TriGemsMod.RubyChest = new Armor("ruby_chestplate", TriGemsMod.RubyA, 1, EntityEquipmentSlot.CHEST, 3341);
			TriGemsMod.RubyLegs = new Armor("ruby_leggings", TriGemsMod.RubyA, 2, EntityEquipmentSlot.LEGS, 3342);
			TriGemsMod.RubyBoots = new Armor("ruby_boots", TriGemsMod.RubyA, 1, EntityEquipmentSlot.FEET, 3343);
			
			GameRegistry.addSmelting(TriGemsMod.oreRuby, new ItemStack(TriGemsMod.ruby), 0.5F);
			//GameRegistry.addShapelessRecipe(new ItemStack(TriGemsMod.ruby, 9), TriGemsMod.blockRuby);
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TriGemsMod.ruby, 9), "blockRuby"));
			
			//GameRegistry.addRecipe(new ItemStack(TriGemsMod.blockRuby), new Object[]{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.blockRuby), new Object[] {
				"TTT",
				"TTT",
				"TTT",
				//'T', TriGemsMod.ruby
				'T', "gemRuby"
			//});
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.RubyPickaxe), new Object[] {
				"GGG",
				" S ",
				" S ",
				'G', "gemRuby",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.RubyAxe), new Object[]{
				"GG",
				"GS",
				" S",
				'G', "gemRuby",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.RubyShovel), new Object[]{
				"G",
				"S",
				"S",
				'G', "gemRuby",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.RubyHoe), new Object[]{
				"GG",
				" S",
				" S",
				'G', "gemRuby",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.RubySword), new Object[]{
				"G",
				"G",
				"S",
				'G', "gemRuby",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.RubyHelmet), new Object[]{
				"TTT",
				"T T",
				'T', "gemRuby"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.RubyChest), new Object[]{
				"T T",
				"TTT",
				"TTT",
				'T', "gemRuby"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.RubyLegs), new Object[]{
				"TTT",
				"T T",
				"T T",
				'T', "gemRuby"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.RubyBoots), new Object[]{
				"T T",
				"T T",
				'T', "gemRuby"
			}));
		}
		
		if(ConfigHandler.enableSapphire) {
			TriGemsMod.oreSapphire = new GemOre("sapphire_ore", 3306);
			OreDictionary.registerOre("oreSapphire", TriGemsMod.oreSapphire);
			//TriGemsMod.blockSapphire = new GemBlock("sapphire_block", 3310);
			TriGemsMod.blockSapphire = new GemBlock("sapphire_block", 3310, MapColor.BLUE);
			OreDictionary.registerOre("blockSapphire", TriGemsMod.blockSapphire);
			TriGemsMod.sapphire = new Gem("sapphire", 3302);
			OreDictionary.registerOre("gemSapphire", TriGemsMod.sapphire);
			TriGemsMod.Sapphire.setRepairItem(new ItemStack(TriGemsMod.sapphire));
			TriGemsMod.SapphireA.customCraftingMaterial = TriGemsMod.sapphire;
			TriGemsMod.SapphireSword = new Sword("sapphire_sword", TriGemsMod.Sapphire, 3322);
			TriGemsMod.SapphirePickaxe = new Pickaxe("sapphire_pickaxe", TriGemsMod.Sapphire, 3326);
			//TriGemsMod.SapphireAxe = new Axe("sapphire_axe", TriGemsMod.Sapphire, 8.0F, 3330);
			TriGemsMod.SapphireAxe = new Axe("sapphire_axe", TriGemsMod.Sapphire, 8.0F, -3.0F, 3330);//Axe Damage will be Added to 1.0 so 8.0 is same as Diamond!!! Axe Speed will be Added to 4.0 so -3.0 is same as Diamond!!!
			TriGemsMod.SapphireShovel = new Shovel("sapphire_shovel", TriGemsMod.Sapphire, 3334);
			TriGemsMod.SapphireHoe = new Hoe("sapphire_hoe", TriGemsMod.Sapphire, 3338);
			TriGemsMod.SapphireHelmet = new Armor("sapphire_helmet", TriGemsMod.SapphireA, 1, EntityEquipmentSlot.HEAD, 3348);
			TriGemsMod.SapphireChest = new Armor("sapphire_chestplate", TriGemsMod.SapphireA, 1, EntityEquipmentSlot.CHEST, 3349);
			TriGemsMod.SapphireLegs = new Armor("sapphire_leggings", TriGemsMod.SapphireA, 2, EntityEquipmentSlot.LEGS, 3350);
			TriGemsMod.SapphireBoots = new Armor("sapphire_boots", TriGemsMod.SapphireA, 1, EntityEquipmentSlot.FEET, 3351);
			
			GameRegistry.addSmelting(TriGemsMod.oreSapphire, new ItemStack(TriGemsMod.sapphire), 0.5F);
			//GameRegistry.addShapelessRecipe(new ItemStack(TriGemsMod.sapphire, 9), TriGemsMod.blockSapphire);
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TriGemsMod.sapphire, 9), "blockSapphire"));
			
			//GameRegistry.addRecipe(new ItemStack(TriGemsMod.blockSapphire), new Object[]{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.blockSapphire), new Object[] {
				"TTT",
				"TTT",
				"TTT",
				//'T', TriGemsMod.sapphire
				'T', "gemSapphire"
			//});
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.SapphirePickaxe), new Object[] {
				"GGG",
				" S ",
				" S ",
				'G', "gemSapphire",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.SapphireAxe), new Object[]{
				"GG",
				"GS",
				" S",
				'G', "gemSapphire",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.SapphireShovel), new Object[]{
				"G",
				"S",
				"S",
				'G', "gemSapphire",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.SapphireHoe), new Object[]{
				"GG",
				" S",
				" S",
				'G', "gemSapphire",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.SapphireSword), new Object[]{
				"G",
				"G",
				"S",
				'G', "gemSapphire",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.SapphireHelmet), new Object[]{
				"TTT",
				"T T",
				'T', "gemSapphire"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.SapphireChest), new Object[]{
				"T T",
				"TTT",
				"TTT",
				'T', "gemSapphire"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.SapphireLegs), new Object[]{
				"TTT",
				"T T",
				"T T",
				'T', "gemSapphire"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.SapphireBoots), new Object[]{
				"T T",
				"T T",
				'T', "gemSapphire"
			}));
		}
		
		if(ConfigHandler.enableEmerald) {
			TriGemsMod.Emerald.setRepairItem(new ItemStack(Items.EMERALD));
			TriGemsMod.EmeraldA.customCraftingMaterial = Items.EMERALD;
			TriGemsMod.EmeraldSword = new Sword("emerald_sword", TriGemsMod.Emerald, 3321);
			TriGemsMod.EmeraldPickaxe = new Pickaxe("emerald_pickaxe", TriGemsMod.Emerald, 3325);
			//TriGemsMod.EmeraldAxe = new Axe("emerald_axe", TriGemsMod.Emerald, 8.0F, 3329);
			TriGemsMod.EmeraldAxe = new Axe("emerald_axe", TriGemsMod.Emerald, 8.0F, -3.0F, 3329);//Axe Damage will be Added to 1.0 so 8.0 is same as Diamond!!! Axe Speed will be Added to 4.0 so -3.0 is same as Diamond!!!
			TriGemsMod.EmeraldShovel = new Shovel("emerald_shovel", TriGemsMod.Emerald, 3333);
			TriGemsMod.EmeraldHoe = new Hoe("emerald_hoe", TriGemsMod.Emerald, 3337);
			TriGemsMod.EmeraldHelmet = new Armor("emerald_helmet", TriGemsMod.EmeraldA, 1, EntityEquipmentSlot.HEAD, 3344);
			TriGemsMod.EmeraldChest = new Armor("emerald_chestplate", TriGemsMod.EmeraldA, 1, EntityEquipmentSlot.CHEST, 3345);
			TriGemsMod.EmeraldLegs = new Armor("emerald_leggings", TriGemsMod.EmeraldA, 2, EntityEquipmentSlot.LEGS, 3346);
			TriGemsMod.EmeraldBoots = new Armor("emerald_boots", TriGemsMod.EmeraldA, 1, EntityEquipmentSlot.FEET, 3347);
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.EmeraldPickaxe), new Object[] {
				"GGG",
				" S ",
				" S ",
				'G', "gemEmerald",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.EmeraldAxe), new Object[]{
				"GG",
				"GS",
				" S",
				'G', "gemEmerald",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.EmeraldShovel), new Object[]{
				"G",
				"S",
				"S",
				'G', "gemEmerald",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.EmeraldHoe), new Object[]{
				"GG",
				" S",
				" S",
				'G', "gemEmerald",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.EmeraldSword), new Object[]{
				"G",
				"G",
				"S",
				'G', "gemEmerald",
				//'S', Items.STICK
				'S', "stickWood"
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.EmeraldHelmet), new Object[]{
				"TTT",
				"T T",
				'T', "gemEmerald"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.EmeraldChest), new Object[]{
				"T T",
				"TTT",
				"TTT",
				'T', "gemEmerald"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.EmeraldLegs), new Object[]{
				"TTT",
				"T T",
				"T T",
				'T', "gemEmerald"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TriGemsMod.EmeraldBoots), new Object[]{
				"T T",
				"T T",
				'T', "gemEmerald"
			}));
		}
		
		//TriGemsMod.instance.loadBlocks();
		//TriGemsMod.instance.loadItems();
	}
	
	
	
	public void register() {
		
	}
	
}
