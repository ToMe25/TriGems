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
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
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
	public static final String MCVERSION = "[1.14,1.14.4]";

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
		if (ConfigHandler.enableTopaz.get()) {
			TriGemsMod.topaz = new Gem("topaz");
			TriGemsMod.TopazSword = new Sword("topaz_sword", ToolTiers.TOPAZ);
			TriGemsMod.TopazPickaxe = new Pickaxe("topaz_pickaxe", ToolTiers.TOPAZ);
			TriGemsMod.TopazAxe = new Axe("topaz_axe", ToolTiers.TOPAZ, 5.0F, -3.0F);
			TriGemsMod.TopazShovel = new Shovel("topaz_shovel", ToolTiers.TOPAZ);
			TriGemsMod.TopazHoe = new Hoe("topaz_hoe", ToolTiers.TOPAZ, 0.0F);
			TriGemsMod.TopazHelmet = new Armor("topaz_helmet", ArmorTiers.TOPAZ, EquipmentSlotType.HEAD);
			TriGemsMod.TopazChest = new Armor("topaz_chestplate", ArmorTiers.TOPAZ, EquipmentSlotType.CHEST);
			TriGemsMod.TopazLegs = new Armor("topaz_leggings", ArmorTiers.TOPAZ, EquipmentSlotType.LEGS);
			TriGemsMod.TopazBoots = new Armor("topaz_boots", ArmorTiers.TOPAZ, EquipmentSlotType.FEET);
			registry.registerAll(topaz, TopazSword, TopazPickaxe, TopazAxe, TopazShovel, TopazHoe, TopazHelmet,
					TopazChest, TopazLegs, TopazBoots);// Items
			registry.registerAll(blockTopaz.blockItem, oreTopaz.blockItem);// Blocks
		}

		if (ConfigHandler.enableRuby.get()) {
			TriGemsMod.ruby = new Gem("ruby");
			TriGemsMod.RubySword = new Sword("ruby_sword", ToolTiers.RUBY);
			TriGemsMod.RubyPickaxe = new Pickaxe("ruby_pickaxe", ToolTiers.RUBY);
			TriGemsMod.RubyAxe = new Axe("ruby_axe", ToolTiers.RUBY, 5.0F, -3.0F);
			TriGemsMod.RubyShovel = new Shovel("ruby_shovel", ToolTiers.RUBY);
			TriGemsMod.RubyHoe = new Hoe("ruby_hoe", ToolTiers.RUBY, 0.0F);
			TriGemsMod.RubyHelmet = new Armor("ruby_helmet", ArmorTiers.RUBY, EquipmentSlotType.HEAD);
			TriGemsMod.RubyChest = new Armor("ruby_chestplate", ArmorTiers.RUBY, EquipmentSlotType.CHEST);
			TriGemsMod.RubyLegs = new Armor("ruby_leggings", ArmorTiers.RUBY, EquipmentSlotType.LEGS);
			TriGemsMod.RubyBoots = new Armor("ruby_boots", ArmorTiers.RUBY, EquipmentSlotType.FEET);
			registry.registerAll(ruby, RubySword, RubyPickaxe, RubyAxe, RubyShovel, RubyHoe, RubyHelmet, RubyChest,
					RubyLegs, RubyBoots);// Items
			registry.registerAll(blockRuby.blockItem, oreRuby.blockItem);// Blocks
		}

		if (ConfigHandler.enableSapphire.get()) {
			TriGemsMod.sapphire = new Gem("sapphire");
			TriGemsMod.SapphireSword = new Sword("sapphire_sword", ToolTiers.SAPPHIRE);
			TriGemsMod.SapphirePickaxe = new Pickaxe("sapphire_pickaxe", ToolTiers.SAPPHIRE);
			TriGemsMod.SapphireAxe = new Axe("sapphire_axe", ToolTiers.SAPPHIRE, 5.0F, -3.0F);
			TriGemsMod.SapphireShovel = new Shovel("sapphire_shovel", ToolTiers.SAPPHIRE);
			TriGemsMod.SapphireHoe = new Hoe("sapphire_hoe", ToolTiers.SAPPHIRE, 0.0F);
			TriGemsMod.SapphireHelmet = new Armor("sapphire_helmet", ArmorTiers.SAPPHIRE, EquipmentSlotType.HEAD);
			TriGemsMod.SapphireChest = new Armor("sapphire_chestplate", ArmorTiers.SAPPHIRE, EquipmentSlotType.CHEST);
			TriGemsMod.SapphireLegs = new Armor("sapphire_leggings", ArmorTiers.SAPPHIRE, EquipmentSlotType.LEGS);
			TriGemsMod.SapphireBoots = new Armor("sapphire_boots", ArmorTiers.SAPPHIRE, EquipmentSlotType.FEET);
			registry.registerAll(sapphire, SapphireSword, SapphirePickaxe, SapphireAxe, SapphireShovel, SapphireHoe,
					SapphireHelmet, SapphireChest, SapphireLegs, SapphireBoots);// Items
			registry.registerAll(blockSapphire.blockItem, oreSapphire.blockItem);// Blocks
		}

		if (ConfigHandler.enableEmerald.get()) {
			TriGemsMod.EmeraldSword = new Sword("emerald_sword", ToolTiers.EMERALD);
			TriGemsMod.EmeraldPickaxe = new Pickaxe("emerald_pickaxe", ToolTiers.EMERALD);
			TriGemsMod.EmeraldAxe = new Axe("emerald_axe", ToolTiers.EMERALD, 5.0F, -3.0F);
			TriGemsMod.EmeraldShovel = new Shovel("emerald_shovel", ToolTiers.EMERALD);
			TriGemsMod.EmeraldHoe = new Hoe("emerald_hoe", ToolTiers.EMERALD, 0.0F);
			TriGemsMod.EmeraldHelmet = new Armor("emerald_helmet", ArmorTiers.EMERALD, EquipmentSlotType.HEAD);
			TriGemsMod.EmeraldChest = new Armor("emerald_chestplate", ArmorTiers.EMERALD, EquipmentSlotType.CHEST);
			TriGemsMod.EmeraldLegs = new Armor("emerald_leggings", ArmorTiers.EMERALD, EquipmentSlotType.LEGS);
			TriGemsMod.EmeraldBoots = new Armor("emerald_boots", ArmorTiers.EMERALD, EquipmentSlotType.FEET);
			registry.registerAll(EmeraldSword, EmeraldPickaxe, EmeraldAxe, EmeraldShovel, EmeraldHoe, EmeraldHelmet,
					EmeraldChest, EmeraldLegs, EmeraldBoots);
		}
	}

	@SubscribeEvent
	public static void registerBlcks(RegistryEvent.Register<Block> e) {
		IForgeRegistry<Block> registry = e.getRegistry();
		if (ConfigHandler.enableTopaz.get()) {
			oreTopaz = new TriGemsBlock("topaz_ore", MaterialColor.STONE, true);
			blockTopaz = new TriGemsBlock("topaz_block", MaterialColor.YELLOW, false);
			registry.registerAll(oreTopaz, blockTopaz);
		}

		if (ConfigHandler.enableRuby.get()) {
			oreRuby = new TriGemsBlock("ruby_ore", MaterialColor.STONE, true);
			blockRuby = new TriGemsBlock("ruby_block", MaterialColor.RED, false);
			registry.registerAll(oreRuby, blockRuby);
		}

		if (ConfigHandler.enableSapphire.get()) {
			oreSapphire = new TriGemsBlock("sapphire_ore", MaterialColor.STONE, true);
			blockSapphire = new TriGemsBlock("sapphire_block", MaterialColor.BLUE, false);
			registry.registerAll(oreSapphire, blockSapphire);
		}
	}

	@SubscribeEvent
	public static void registerRecipeConditions(RegistryEvent.Register<IRecipeSerializer<?>> e) {
		// neccessary to make one jar work in 1.14.2 and 1.14.4
		ConfigConditionHandler.register(e);
	}

}
