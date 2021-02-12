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

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;

public class ConfigHandler {

	private CommentedFileConfig cfg;
	private final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

	public static final String CATEGORY_GENERAL = "general";

	public static BooleanValue enableChainRecipes;
	public static BooleanValue enableTopaz;
	public static BooleanValue enableRuby;
	public static BooleanValue enableSapphire;
	public static BooleanValue enableEmerald;
	public static IntValue generationrate_Topaz;
	public static IntValue generationrate_Ruby;
	public static IntValue generationrate_Sapphire;
	public static IntValue generationrate_Emerald;
	public static IntValue maxheight_Topaz;
	public static IntValue maxheight_Ruby;
	public static IntValue maxheight_Sapphire;
	public static IntValue maxheight_Emerald;
	public static IntValue minheight_Topaz;
	public static IntValue minheight_Ruby;
	public static IntValue minheight_Sapphire;
	public static IntValue minheight_Emerald;

	public void Init() {
		cfg = CommentedFileConfig.builder(new File(FMLPaths.CONFIGDIR.get().toString(), TriGemsMod.MODID + ".toml"))
				.sync().autosave().build();
		cfg.load();
		initConfig();
		ForgeConfigSpec spec = builder.build();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, spec, cfg.getFile().getName());
		spec.setConfig(cfg);
	}

	public void initConfig() {
		enableChainRecipes = getBoolean("enableChainRecipes", CATEGORY_GENERAL, true,
				"Enables / Dissables the Recipes for Vanilla Chain Armor.");
		enableTopaz = getBoolean("enableTopaz", CATEGORY_GENERAL, true,
				"Enables / Dissables the Topaz Ore, Gem, Block, Tools and Armor.");
		enableRuby = getBoolean("enableRuby", CATEGORY_GENERAL, true,
				"Enables / Dissables the Ruby Ore, Gem, Block, Tools and Armor.");
		enableSapphire = getBoolean("enableSapphire", CATEGORY_GENERAL, true,
				"Enables / Dissables the Sapphire Ore, Gem, Block, Tools and Armor.");
		enableEmerald = getBoolean("enableEmerald", CATEGORY_GENERAL, true,
				"Enables / Dissables the Emerald Tools and Armor.");
		generationrate_Topaz = getInt("generationrate_Topaz", CATEGORY_GENERAL, 7, 0, 16,
				"The Generation Rate for Topaz Ore.(Set to 0 to disable.)");
		generationrate_Ruby = getInt("generationrate_Ruby", CATEGORY_GENERAL, 6, 0, 16,
				"The Generation Rate for Ruby Ore.(Set to 0 to disable.)");
		generationrate_Sapphire = getInt("generationrate_Sapphire", CATEGORY_GENERAL, 5, 0, 16,
				"The Generation Rate for Sapphire Ore.(Set to 0 to disable.)");
		generationrate_Emerald = getInt("generationrate_Emerald", CATEGORY_GENERAL, 4, 0, 16,
				"This Mod Generates Emerald Ores additional to the Vanilla Generation. The Generation Rate for Emerald Ore.(Set to 0 to disable the additional Generation.)");
		maxheight_Topaz = getInt("maxheight_Topaz", CATEGORY_GENERAL, 16, 0, 255,
				"The Maximum Height for Topaz Ore Generation.");
		maxheight_Ruby = getInt("maxheight_Ruby", CATEGORY_GENERAL, 16, 0, 255,
				"The Maximum Height for Ruby Ore Generation.");
		maxheight_Sapphire = getInt("maxheight_Sapphire", CATEGORY_GENERAL, 16, 0, 255,
				"The Maximum Height for Sapphire Ore Generation.");
		maxheight_Emerald = getInt("maxheight_Emerald", CATEGORY_GENERAL, 16, 0, 255,
				"This Mod Generates Emerald Ores additional to the Vanilla Generation. The Maximum Height for Emerald Ore Generation.");
		minheight_Topaz = getInt("minheight_Topaz", CATEGORY_GENERAL, 0, 0, 255,
				"The Minimum Height for Topaz Ore Generation.");
		minheight_Ruby = getInt("minheight_Ruby", CATEGORY_GENERAL, 0, 0, 255,
				"The Minimum Height for Ruby Ore Generation.");
		minheight_Sapphire = getInt("minheight_Sapphire", CATEGORY_GENERAL, 0, 0, 255,
				"The Minimum Height for Sapphire Ore Generation.");
		minheight_Emerald = getInt("minheight_Emerald", CATEGORY_GENERAL, 0, 0, 255,
				"This Mod Generates Emerald Ores additional to the Vanilla Generation. The Minimum Height for Emerald Ore Generation.");
	}

	private BooleanValue getBoolean(String name, String category, boolean defaultValue, String comment) {
		String path = category + "." + name;
		return builder.comment(comment, "Default: " + defaultValue).define(path, defaultValue);
	}

	private IntValue getInt(String name, String category, int defaultValue, int min, int max, String comment) {
		String path = category + "." + name;
		return builder.comment(comment, "Default: " + defaultValue).defineInRange(path, defaultValue, min, max);
	}

}
