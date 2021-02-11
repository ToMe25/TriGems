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

import com.ToMe.trigems.datagen.DataGenerators;

import net.minecraft.block.Block;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(value = TriGemsMod.MODID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TriGemsMod {

	public static final String MODID = "trigems";
	public static final String NAME = "TriGems";
	public static final String VERSION = "1.0";
	public static final String MCVERSION = "[1.16,)";

	public static ConfigHandler cfg = new ConfigHandler();

	// Items
	// TOPAZ
	public static Item topaz;
	public static Item TopazPickaxe;
	public static Item TopazAxe;
	public static Item TopazShovel;
	public static Item TopazHoe;
	public static Item TopazSword;
	// RUBY
	public static Item ruby;
	public static Item RubyPickaxe;
	public static Item RubyAxe;
	public static Item RubyShovel;
	public static Item RubyHoe;
	public static Item RubySword;
	// SAPHIRE
	public static Item sapphire;
	public static Item SapphirePickaxe;
	public static Item SapphireAxe;
	public static Item SapphireShovel;
	public static Item SapphireHoe;
	public static Item SapphireSword;
	// EMERALD
	public static Item EmeraldPickaxe;
	public static Item EmeraldAxe;
	public static Item EmeraldShovel;
	public static Item EmeraldHoe;
	public static Item EmeraldSword;

	// Armor
	public static Item RubyHelmet;
	public static Item RubyChest;
	public static Item RubyLegs;
	public static Item RubyBoots;
	public static Item EmeraldHelmet;
	public static Item EmeraldChest;
	public static Item EmeraldLegs;
	public static Item EmeraldBoots;
	public static Item SapphireHelmet;
	public static Item SapphireChest;
	public static Item SapphireLegs;
	public static Item SapphireBoots;
	public static Item TopazHelmet;
	public static Item TopazChest;
	public static Item TopazLegs;
	public static Item TopazBoots;

	// Blocks
	public static TriGemsBlock oreTopaz;
	public static TriGemsBlock blockTopaz;
	public static TriGemsBlock oreRuby;
	public static TriGemsBlock blockRuby;
	public static TriGemsBlock oreSapphire;
	public static TriGemsBlock blockSapphire;

	public TriGemsMod() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(DataGenerators::gatherData);
		cfg.Init();
	}

	@SubscribeEvent
	public static void Init(FMLCommonSetupEvent e) {
		GenerationHelper.registerWorldGenerator();
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e) {
		IForgeRegistry<Item> registry = e.getRegistry();
		if (ConfigHandler.enableTopaz) {
			TriGemsMod.topaz = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(MODID,
					"topaz");
			TriGemsMod.TopazSword = new SwordItem(ToolTiers.TOPAZ, 3, 2.4F,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "topaz_sword");
			TriGemsMod.TopazPickaxe = new PickaxeItem(ToolTiers.TOPAZ, 1, 2.8F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "topaz_pickaxe");
			TriGemsMod.TopazAxe = new AxeItem(ToolTiers.TOPAZ, 5.0F, -3.0F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "topaz_axe");
			TriGemsMod.TopazShovel = new ShovelItem(ToolTiers.TOPAZ, 1.5F, -3.0F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "topaz_shovel");
			TriGemsMod.TopazHoe = new HoeItem(ToolTiers.TOPAZ, -3, 0.0F, new Item.Properties().group(ItemGroup.TOOLS))
					.setRegistryName(MODID, "topaz_hoe");
			TriGemsMod.TopazHelmet = new ArmorItem(ArmorTiers.TOPAZ, EquipmentSlotType.HEAD,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "topaz_helmet");
			TriGemsMod.TopazChest = new ArmorItem(ArmorTiers.TOPAZ, EquipmentSlotType.CHEST,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "topaz_chestplate");
			TriGemsMod.TopazLegs = new ArmorItem(ArmorTiers.TOPAZ, EquipmentSlotType.LEGS,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "topaz_leggings");
			TriGemsMod.TopazBoots = new ArmorItem(ArmorTiers.TOPAZ, EquipmentSlotType.FEET,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "topaz_boots");
			registry.registerAll(topaz, TopazSword, TopazPickaxe, TopazAxe, TopazShovel, TopazHoe, TopazHelmet,
					TopazChest, TopazLegs, TopazBoots);// Items
			registry.registerAll(blockTopaz.blockItem, oreTopaz.blockItem);// Blocks
		}

		if (ConfigHandler.enableRuby) {
			TriGemsMod.ruby = new Item(new Item.Properties().group(ItemGroup.MATERIALS))
					.setRegistryName(new ResourceLocation(MODID, "ruby"));
			TriGemsMod.RubySword = new SwordItem(ToolTiers.RUBY, 3, 2.4F, new Item.Properties().group(ItemGroup.COMBAT))
					.setRegistryName(MODID, "ruby_sword");
			TriGemsMod.RubyPickaxe = new PickaxeItem(ToolTiers.RUBY, 1, 2.8F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "ruby_pickaxe");
			TriGemsMod.RubyAxe = new AxeItem(ToolTiers.RUBY, 5.0F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS))
					.setRegistryName(MODID, "ruby_axe");
			TriGemsMod.RubyShovel = new ShovelItem(ToolTiers.RUBY, 1.5F, -3.0F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "ruby_shovel");
			TriGemsMod.RubyHoe = new HoeItem(ToolTiers.RUBY, -3, 0.0F, new Item.Properties().group(ItemGroup.TOOLS))
					.setRegistryName(MODID, "ruby_hoe");
			TriGemsMod.RubyHelmet = new ArmorItem(ArmorTiers.RUBY, EquipmentSlotType.HEAD,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "ruby_helmet");
			TriGemsMod.RubyChest = new ArmorItem(ArmorTiers.RUBY, EquipmentSlotType.CHEST,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "ruby_chestplate");
			TriGemsMod.RubyLegs = new ArmorItem(ArmorTiers.RUBY, EquipmentSlotType.LEGS,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "ruby_leggings");
			TriGemsMod.RubyBoots = new ArmorItem(ArmorTiers.RUBY, EquipmentSlotType.FEET,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "ruby_boots");
			registry.registerAll(ruby, RubySword, RubyPickaxe, RubyAxe, RubyShovel, RubyHoe, RubyHelmet, RubyChest,
					RubyLegs, RubyBoots);// Items
			registry.registerAll(blockRuby.blockItem, oreRuby.blockItem);// Blocks
		}

		if (ConfigHandler.enableSapphire) {
			TriGemsMod.sapphire = new Item(new Item.Properties().group(ItemGroup.MATERIALS))
					.setRegistryName(new ResourceLocation(MODID, "sapphire"));
			TriGemsMod.SapphireSword = new SwordItem(ToolTiers.SAPPHIRE, 3, 2.4F,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "sapphire_sword");
			TriGemsMod.SapphirePickaxe = new PickaxeItem(ToolTiers.SAPPHIRE, 1, 2.8F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "sapphire_pickaxe");
			TriGemsMod.SapphireAxe = new AxeItem(ToolTiers.SAPPHIRE, 5.0F, -3.0F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "sapphire_axe");
			TriGemsMod.SapphireShovel = new ShovelItem(ToolTiers.SAPPHIRE, 1.5F, -3.0F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "sapphire_shovel");
			TriGemsMod.SapphireHoe = new HoeItem(ToolTiers.SAPPHIRE, -3, 0.0F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "sapphire_hoe");
			TriGemsMod.SapphireHelmet = new ArmorItem(ArmorTiers.SAPPHIRE, EquipmentSlotType.HEAD,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "sapphire_helmet");
			TriGemsMod.SapphireChest = new ArmorItem(ArmorTiers.SAPPHIRE, EquipmentSlotType.CHEST,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "sapphire_chestplate");
			TriGemsMod.SapphireLegs = new ArmorItem(ArmorTiers.SAPPHIRE, EquipmentSlotType.LEGS,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "sapphire_leggings");
			TriGemsMod.SapphireBoots = new ArmorItem(ArmorTiers.SAPPHIRE, EquipmentSlotType.FEET,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "sapphire_boots");
			registry.registerAll(sapphire, SapphireSword, SapphirePickaxe, SapphireAxe, SapphireShovel, SapphireHoe,
					SapphireHelmet, SapphireChest, SapphireLegs, SapphireBoots);// Items
			registry.registerAll(blockSapphire.blockItem, oreSapphire.blockItem);// Blocks
		}

		if (ConfigHandler.enableEmerald) {
			TriGemsMod.EmeraldSword = new SwordItem(ToolTiers.EMERALD, 3, 2.4F,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "emerald_sword");
			TriGemsMod.EmeraldPickaxe = new PickaxeItem(ToolTiers.EMERALD, 1, 2.8F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "emerald_pickaxe");
			TriGemsMod.EmeraldAxe = new AxeItem(ToolTiers.EMERALD, 5.0F, -3.0F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "emerald_axe");
			TriGemsMod.EmeraldShovel = new ShovelItem(ToolTiers.EMERALD, 1.5F, -3.0F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "emerald_shovel");
			TriGemsMod.EmeraldHoe = new HoeItem(ToolTiers.EMERALD, -3, 0.0F,
					new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(MODID, "emerald_hoe");
			TriGemsMod.EmeraldHelmet = new ArmorItem(ArmorTiers.EMERALD, EquipmentSlotType.HEAD,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "emerald_helmet");
			TriGemsMod.EmeraldChest = new ArmorItem(ArmorTiers.EMERALD, EquipmentSlotType.CHEST,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "emerald_chestplate");
			TriGemsMod.EmeraldLegs = new ArmorItem(ArmorTiers.EMERALD, EquipmentSlotType.LEGS,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "emerald_leggings");
			TriGemsMod.EmeraldBoots = new ArmorItem(ArmorTiers.EMERALD, EquipmentSlotType.FEET,
					new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "emerald_boots");
			registry.registerAll(EmeraldSword, EmeraldPickaxe, EmeraldAxe, EmeraldShovel, EmeraldHoe, EmeraldHelmet,
					EmeraldChest, EmeraldLegs, EmeraldBoots);
		}
	}

	@SubscribeEvent
	public static void registerBlcks(RegistryEvent.Register<Block> e) {
		IForgeRegistry<Block> registry = e.getRegistry();
		if (ConfigHandler.enableTopaz) {
			oreTopaz = new TriGemsBlock("topaz_ore", MaterialColor.STONE, true);
			blockTopaz = new TriGemsBlock("topaz_block", MaterialColor.YELLOW, false);
			registry.registerAll(oreTopaz, blockTopaz);
		}

		if (ConfigHandler.enableRuby) {
			oreRuby = new TriGemsBlock("ruby_ore", MaterialColor.STONE, true);
			blockRuby = new TriGemsBlock("ruby_block", MaterialColor.RED, false);
			registry.registerAll(oreRuby, blockRuby);
		}

		if (ConfigHandler.enableSapphire) {
			oreSapphire = new TriGemsBlock("sapphire_ore", MaterialColor.STONE, true);
			blockSapphire = new TriGemsBlock("sapphire_block", MaterialColor.BLUE, false);
			registry.registerAll(oreSapphire, blockSapphire);
		}
	}

}
