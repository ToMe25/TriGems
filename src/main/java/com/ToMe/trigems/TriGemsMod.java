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

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = TriGemsMod.MODID, name = TriGemsMod.NAME, version = TriGemsMod.VERSION, acceptedMinecraftVersions = TriGemsMod.MCVERSION)
public class TriGemsMod {

	@SidedProxy(clientSide = "com.ToMe.trigems.ClientProxy", serverSide = "com.ToMe.trigems.ServerProxy")
	public static CommonProxy proxy;

	@Instance
	public static TriGemsMod instance = new TriGemsMod();

	public static final String MODID = "trigems";
	public static final String NAME = "TriGems";
	public static final String VERSION = "1.0";
	public static final String MCVERSION = "[1.10,1.10.2]";

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
	}

	@EventHandler
	public void Init(FMLInitializationEvent e) {
		proxy.register();
		GameRegistry.registerWorldGenerator(new GenerationHelper(), 2);

	}

}
