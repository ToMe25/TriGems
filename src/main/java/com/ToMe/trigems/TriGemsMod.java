/**
 * This class is distributed as a part of the Trigems mod.(https://github.com/ToMe25/TriGems)
 * Copyright (C) 2018-2021  ToMe25
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ToMe.trigems;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = TriGemsMod.MODID, name = TriGemsMod.NAME, version = TriGemsMod.VERSION, acceptedMinecraftVersions = TriGemsMod.MCVERSION)
public class TriGemsMod {

	@SidedProxy(clientSide = "com.ToMe.trigems.ClientProxy", serverSide = "com.ToMe.trigems.ServerProxy")
	public static CommonProxy proxy;

	@Instance
	public static TriGemsMod instance = new TriGemsMod();

	public static final String MODID = "trigems";
	public static final String NAME = "TriGems";
	public static final String VERSION = "1.0";
	public static final String MCVERSION = "[1.12,1.12.2]";

	public static ConfigHandler cfg = new ConfigHandler();

	// Items
	// TOPAZ
	public static Gem topaz;
	public static Pickaxe TopazPickaxe;
	public static Axe TopazAxe;
	public static Shovel TopazShovel;
	public static Hoe TopazHoe;
	public static Sword TopazSword;
	// RUBY
	public static Gem ruby;
	public static Pickaxe RubyPickaxe;
	public static Axe RubyAxe;
	public static Shovel RubyShovel;
	public static Hoe RubyHoe;
	public static Sword RubySword;
	// SAPHIRE
	public static Gem sapphire;
	public static Pickaxe SapphirePickaxe;
	public static Axe SapphireAxe;
	public static Shovel SapphireShovel;
	public static Hoe SapphireHoe;
	public static Sword SapphireSword;
	// EMERALD
	public static Pickaxe EmeraldPickaxe;
	public static Axe EmeraldAxe;
	public static Shovel EmeraldShovel;
	public static Hoe EmeraldHoe;
	public static Sword EmeraldSword;

	// Armor
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

	// Blocks
	public static GemOre oreTopaz;
	public static GemBlock blockTopaz;
	public static GemOre oreRuby;
	public static GemBlock blockRuby;
	public static GemOre oreSapphire;
	public static GemBlock blockSapphire;

	// Materials
	public static ToolMaterial Topaz = EnumHelper.addToolMaterial("topaz", 3, 1500, 8.0F, 2.5F, 10);
	public static ToolMaterial Ruby = EnumHelper.addToolMaterial("ruby", 3, 1500, 8.0F, 3.0F, 10);
	public static ToolMaterial Sapphire = EnumHelper.addToolMaterial("sapphire", 3, 1500, 8.0F, 3.5F, 10);
	public static ToolMaterial Emerald = EnumHelper.addToolMaterial("emerald", 3, 1500, 15.0F, 4.0F, 30);
	public static ArmorMaterial TopazA = EnumHelper.addArmorMaterial("topaz_armor", "trigems:topaz", 32,
			new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F);
	public static ArmorMaterial RubyA = EnumHelper.addArmorMaterial("ruby_armor", "trigems:ruby", 33,
			new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	public static ArmorMaterial SapphireA = EnumHelper.addArmorMaterial("sapphire_armor", "trigems:sapphire", 34,
			new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);
	public static ArmorMaterial EmeraldA = EnumHelper.addArmorMaterial("emerald_armor", "trigems:emerald", 35,
			new int[] { 3, 6, 8, 3 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void Init(FMLInitializationEvent e) {
		proxy.register();
		GameRegistry.registerWorldGenerator(new GenerationHelper(), 2);

		if (ConfigHandler.enableTopaz) {
			GameRegistry.addSmelting(TriGemsMod.oreTopaz, new ItemStack(TriGemsMod.topaz), 0.75F);
		}
		if (ConfigHandler.enableRuby) {
			GameRegistry.addSmelting(TriGemsMod.oreRuby, new ItemStack(TriGemsMod.ruby), 0.75F);
		}
		if (ConfigHandler.enableSapphire) {
			GameRegistry.addSmelting(TriGemsMod.oreSapphire, new ItemStack(TriGemsMod.sapphire), 0.75F);
		}
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> e) {
		if (ConfigHandler.enableTopaz) {
			TriGemsMod.topaz = new Gem("topaz", 3303);
			OreDictionary.registerOre("gemTopaz", TriGemsMod.topaz);
			TriGemsMod.Topaz.setRepairItem(new ItemStack(TriGemsMod.topaz));
			TriGemsMod.TopazA.repairMaterial = new ItemStack(TriGemsMod.topaz);
			TriGemsMod.TopazSword = new Sword("topaz_sword", TriGemsMod.Topaz, 3323);
			TriGemsMod.TopazPickaxe = new Pickaxe("topaz_pickaxe", TriGemsMod.Topaz, 3327);
			TriGemsMod.TopazAxe = new Axe("topaz_axe", TriGemsMod.Topaz, 8.0F, -3.0F, 3331);// Axe Damage will be Added
																							// to 1.0 so 8.0 is same as
																							// Diamond!!! Axe Speed will
																							// be Added to 4.0 so -3.0
																							// is same as Diamond!!!
			TriGemsMod.TopazShovel = new Shovel("topaz_shovel", TriGemsMod.Topaz, 3335);
			TriGemsMod.TopazHoe = new Hoe("topaz_hoe", TriGemsMod.Topaz, 3339);
			TriGemsMod.TopazHelmet = new Armor("topaz_helmet", TriGemsMod.TopazA, 1, EntityEquipmentSlot.HEAD, 3352);
			TriGemsMod.TopazChest = new Armor("topaz_chestplate", TriGemsMod.TopazA, 1, EntityEquipmentSlot.CHEST,
					3353);
			TriGemsMod.TopazLegs = new Armor("topaz_leggings", TriGemsMod.TopazA, 2, EntityEquipmentSlot.LEGS, 3354);
			TriGemsMod.TopazBoots = new Armor("topaz_boots", TriGemsMod.TopazA, 1, EntityEquipmentSlot.FEET, 3355);
		}

		if (ConfigHandler.enableRuby) {
			TriGemsMod.ruby = new Gem("ruby", 3300);
			OreDictionary.registerOre("gemRuby", TriGemsMod.ruby);
			TriGemsMod.Ruby.setRepairItem(new ItemStack(TriGemsMod.ruby));
			TriGemsMod.RubyA.repairMaterial = new ItemStack(TriGemsMod.ruby);
			TriGemsMod.RubySword = new Sword("ruby_sword", TriGemsMod.Ruby, 3320);
			TriGemsMod.RubyPickaxe = new Pickaxe("ruby_pickaxe", TriGemsMod.Ruby, 3324);
			TriGemsMod.RubyAxe = new Axe("ruby_axe", TriGemsMod.Ruby, 8.0F, -3.0F, 3328);// Axe Damage will be Added to
																							// 1.0 so 8.0 is same as
																							// Diamond!!! Axe Speed will
																							// be Added to 4.0 so -3.0
																							// is same as Diamond!!!
			TriGemsMod.RubyShovel = new Shovel("ruby_shovel", TriGemsMod.Ruby, 3332);
			TriGemsMod.RubyHoe = new Hoe("ruby_hoe", TriGemsMod.Ruby, 3336);
			TriGemsMod.RubyHelmet = new Armor("ruby_helmet", TriGemsMod.RubyA, 1, EntityEquipmentSlot.HEAD, 3340);
			TriGemsMod.RubyChest = new Armor("ruby_chestplate", TriGemsMod.RubyA, 1, EntityEquipmentSlot.CHEST, 3341);
			TriGemsMod.RubyLegs = new Armor("ruby_leggings", TriGemsMod.RubyA, 2, EntityEquipmentSlot.LEGS, 3342);
			TriGemsMod.RubyBoots = new Armor("ruby_boots", TriGemsMod.RubyA, 1, EntityEquipmentSlot.FEET, 3343);
		}

		if (ConfigHandler.enableSapphire) {
			TriGemsMod.sapphire = new Gem("sapphire", 3302);
			OreDictionary.registerOre("gemSapphire", TriGemsMod.sapphire);
			TriGemsMod.Sapphire.setRepairItem(new ItemStack(TriGemsMod.sapphire));
			TriGemsMod.SapphireA.repairMaterial = new ItemStack(TriGemsMod.sapphire);
			TriGemsMod.SapphireSword = new Sword("sapphire_sword", TriGemsMod.Sapphire, 3322);
			TriGemsMod.SapphirePickaxe = new Pickaxe("sapphire_pickaxe", TriGemsMod.Sapphire, 3326);
			TriGemsMod.SapphireAxe = new Axe("sapphire_axe", TriGemsMod.Sapphire, 8.0F, -3.0F, 3330);// Axe Damage will
																										// be Added to
																										// 1.0 so 8.0 is
																										// same as
																										// Diamond!!!
																										// Axe Speed
																										// will be Added
																										// to 4.0 so
																										// -3.0 is same
																										// as Diamond!!!
			TriGemsMod.SapphireShovel = new Shovel("sapphire_shovel", TriGemsMod.Sapphire, 3334);
			TriGemsMod.SapphireHoe = new Hoe("sapphire_hoe", TriGemsMod.Sapphire, 3338);
			TriGemsMod.SapphireHelmet = new Armor("sapphire_helmet", TriGemsMod.SapphireA, 1, EntityEquipmentSlot.HEAD,
					3348);
			TriGemsMod.SapphireChest = new Armor("sapphire_chestplate", TriGemsMod.SapphireA, 1,
					EntityEquipmentSlot.CHEST, 3349);
			TriGemsMod.SapphireLegs = new Armor("sapphire_leggings", TriGemsMod.SapphireA, 2, EntityEquipmentSlot.LEGS,
					3350);
			TriGemsMod.SapphireBoots = new Armor("sapphire_boots", TriGemsMod.SapphireA, 1, EntityEquipmentSlot.FEET,
					3351);
		}

		if (ConfigHandler.enableEmerald) {
			TriGemsMod.Emerald.setRepairItem(new ItemStack(Items.EMERALD));
			TriGemsMod.EmeraldA.repairMaterial = new ItemStack(Items.EMERALD);
			TriGemsMod.EmeraldSword = new Sword("emerald_sword", TriGemsMod.Emerald, 3321);
			TriGemsMod.EmeraldPickaxe = new Pickaxe("emerald_pickaxe", TriGemsMod.Emerald, 3325);
			TriGemsMod.EmeraldAxe = new Axe("emerald_axe", TriGemsMod.Emerald, 8.0F, -3.0F, 3329);// Axe Damage will be
																									// Added to 1.0 so
																									// 8.0 is same as
																									// Diamond!!! Axe
																									// Speed will be
																									// Added to 4.0 so
																									// -3.0 is same as
																									// Diamond!!!
			TriGemsMod.EmeraldShovel = new Shovel("emerald_shovel", TriGemsMod.Emerald, 3333);
			TriGemsMod.EmeraldHoe = new Hoe("emerald_hoe", TriGemsMod.Emerald, 3337);
			TriGemsMod.EmeraldHelmet = new Armor("emerald_helmet", TriGemsMod.EmeraldA, 1, EntityEquipmentSlot.HEAD,
					3344);
			TriGemsMod.EmeraldChest = new Armor("emerald_chestplate", TriGemsMod.EmeraldA, 1, EntityEquipmentSlot.CHEST,
					3345);
			TriGemsMod.EmeraldLegs = new Armor("emerald_leggings", TriGemsMod.EmeraldA, 2, EntityEquipmentSlot.LEGS,
					3346);
			TriGemsMod.EmeraldBoots = new Armor("emerald_boots", TriGemsMod.EmeraldA, 1, EntityEquipmentSlot.FEET,
					3347);
		}
	}

	@SubscribeEvent
	public void registerBlcks(RegistryEvent.Register<Block> e) {
		if (ConfigHandler.enableTopaz) {
			TriGemsMod.oreTopaz = new GemOre("topaz_ore", 3307);
			OreDictionary.registerOre("oreTopaz", TriGemsMod.oreTopaz);
			TriGemsMod.blockTopaz = new GemBlock("topaz_block", 3311, MapColor.YELLOW);
			OreDictionary.registerOre("blockTopaz", TriGemsMod.blockTopaz);
		}

		if (ConfigHandler.enableRuby) {
			TriGemsMod.oreRuby = new GemOre("ruby_ore", 3304);
			OreDictionary.registerOre("oreRuby", TriGemsMod.oreRuby);
			TriGemsMod.blockRuby = new GemBlock("ruby_block", 3308, MapColor.RED);
			OreDictionary.registerOre("blockRuby", TriGemsMod.blockRuby);
		}

		if (ConfigHandler.enableSapphire) {
			TriGemsMod.oreSapphire = new GemOre("sapphire_ore", 3306);
			OreDictionary.registerOre("oreSapphire", TriGemsMod.oreSapphire);
			TriGemsMod.blockSapphire = new GemBlock("sapphire_block", 3310, MapColor.BLUE);
			OreDictionary.registerOre("blockSapphire", TriGemsMod.blockSapphire);
		}
	}

}
