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

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	private File cfgFile;
	protected Configuration cfg;

	public static boolean enableChainRecipes = true;
	public static boolean enableTopaz = true;
	public static boolean enableRuby = true;
	public static boolean enableSapphire = true;
	public static boolean enableEmerald = true;
	public static boolean oregen_overworld_only = false;
	public static int generationrate_Topaz = 7;
	public static int generationrate_Ruby = 6;
	public static int generationrate_Sapphire = 5;
	public static int generationrate_Emerald = 4;
	public static int maxheight_Topaz = 16;
	public static int maxheight_Ruby = 16;
	public static int maxheight_Sapphire = 16;
	public static int maxheight_Emerald = 16;
	public static int minheight_Topaz = 0;
	public static int minheight_Ruby = 0;
	public static int minheight_Sapphire = 0;
	public static int minheight_Emerald = 0;

	public void Init(FMLPreInitializationEvent e) {
		cfgFile = e.getSuggestedConfigurationFile();
		cfg = new Configuration(cfgFile);
		try {
			initConfig();
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}

	public void initConfig() {
		enableChainRecipes = cfg.getBoolean("enableChainRecipes", Configuration.CATEGORY_GENERAL, enableChainRecipes,
				"Enables / Dissables the Recipes for Vanilla Chain Armor.");
		enableTopaz = cfg.getBoolean("enableTopaz", Configuration.CATEGORY_GENERAL, enableTopaz,
				"Enables / Dissables the Topaz Ore, Gem, Block, Tools and Armor.");
		enableRuby = cfg.getBoolean("enableRuby", Configuration.CATEGORY_GENERAL, enableRuby,
				"Enables / Dissables the Ruby Ore, Gem, Block, Tools and Armor.");
		enableSapphire = cfg.getBoolean("enableSapphire", Configuration.CATEGORY_GENERAL, enableSapphire,
				"Enables / Dissables the Sapphire Ore, Gem, Block, Tools and Armor.");
		enableEmerald = cfg.getBoolean("enableEmerald", Configuration.CATEGORY_GENERAL, enableEmerald,
				"Enables / Dissables the Emerald Tools and Armor.");
		oregen_overworld_only = cfg.getBoolean("oregen_overworld_only", Configuration.CATEGORY_GENERAL,
				oregen_overworld_only,
				"if this is set to true ores will only be generated if the chunkGenerator is an instance of \"ChunkProviderOverworld\". if it's set to false ores will be generated if the chunkGenerator isn't a instance of \"ChunkProviderHell\" or \"ChunkProviderEnd\", that means in more Mod dimensions.");
		generationrate_Topaz = cfg.getInt("generationrate_Topaz", Configuration.CATEGORY_GENERAL, generationrate_Topaz,
				0, 16, "The Generation Rate for Topaz Ore.(Set to 0 to disable.)");
		generationrate_Ruby = cfg.getInt("generationrate_Ruby", Configuration.CATEGORY_GENERAL, generationrate_Ruby, 0,
				16, "The Generation Rate for Ruby Ore.(Set to 0 to disable.)");
		generationrate_Sapphire = cfg.getInt("generationrate_Sapphire", Configuration.CATEGORY_GENERAL,
				generationrate_Sapphire, 0, 16, "The Generation Rate for Sapphire Ore.(Set to 0 to disable.)");
		generationrate_Emerald = cfg.getInt("generationrate_Emerald", Configuration.CATEGORY_GENERAL,
				generationrate_Emerald, 0, 16,
				"This Mod Generates Emerald Ores additional to the Vanilla Generation. The Generation Rate for Emerald Ore.(Set to 0 to disable the additional Generation.)");
		maxheight_Topaz = cfg.getInt("maxheight_Topaz", Configuration.CATEGORY_GENERAL, maxheight_Topaz, 0, 255,
				"The Maximum Height for Topaz Ore Generation.");
		maxheight_Ruby = cfg.getInt("maxheight_Ruby", Configuration.CATEGORY_GENERAL, maxheight_Ruby, 0, 255,
				"The Maximum Height for Ruby Ore Generation.");
		maxheight_Sapphire = cfg.getInt("maxheight_Sapphire", Configuration.CATEGORY_GENERAL, maxheight_Sapphire, 0,
				255, "The Maximum Height for Sapphire Ore Generation.");
		maxheight_Emerald = cfg.getInt("maxheight_Emerald", Configuration.CATEGORY_GENERAL, maxheight_Emerald, 0, 255,
				"This Mod Generates Emerald Ores additional to the Vanilla Generation. The Maximum Height for Emerald Ore Generation.");
		minheight_Topaz = cfg.getInt("minheight_Topaz", Configuration.CATEGORY_GENERAL, minheight_Topaz, 0, 255,
				"The Minimum Height for Topaz Ore Generation.");
		minheight_Ruby = cfg.getInt("minheight_Ruby", Configuration.CATEGORY_GENERAL, minheight_Ruby, 0, 255,
				"The Minimum Height for Ruby Ore Generation.");
		minheight_Sapphire = cfg.getInt("minheight_Sapphire", Configuration.CATEGORY_GENERAL, minheight_Sapphire, 0,
				255, "The Minimum Height for Sapphire Ore Generation.");
		minheight_Emerald = cfg.getInt("minheight_Emerald", Configuration.CATEGORY_GENERAL, minheight_Emerald, 0, 255,
				"This Mod Generates Emerald Ores additional to the Vanilla Generation. The Minimum Height for Emerald Ore Generation.");
	}

}