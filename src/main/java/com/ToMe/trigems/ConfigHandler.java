package com.ToMe.trigems;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;

//import net.minecraftforge.common.config.Configuration;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	//private File cfgFile;
	//protected Configuration cfg;
	private CommentedFileConfig cfg;
	private final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
	private Map<String, ConfigValue<?>> values = new HashMap<String, ConfigValue<?>>();
	
	public static final String CATEGORY_GENERAL = "general";
	
	//public static boolean enableChainRecipes;
	//public static boolean enableTopaz;
	//public static boolean enableRuby;
	//public static boolean enableSapphire;
	//public static boolean enableEmerald;
	public static boolean enableChainRecipes = true;
	public static boolean enableTopaz = true;
	public static boolean enableRuby = true;
	public static boolean enableSapphire = true;
	public static boolean enableEmerald = true;
	//public static boolean oregen_overworld_only = false;
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
	
	//public void Init(FMLPreInitializationEvent e) {
	public void Init() {
		//cfgFile = e.getSuggestedConfigurationFile();
		//cfg = new Configuration(cfgFile);
		//try {
			//initConfig();
		//} finally {
			// TODO: handle finally clause
			//if(cfg.hasChanged()) {
				//cfg.save();
			//}
		//}
		cfg = CommentedFileConfig.builder(new File(FMLPaths.CONFIGDIR.get().toString(), TriGemsMod.MODID + ".toml")).sync().autosave().build();
		cfg.load();
		initConfig();
		ForgeConfigSpec spec = builder.build();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, spec, cfg.getFile().getName());
		spec.setConfig(cfg);
		loadConfig();
	}
	
	public void initConfig() {
		//enableChainRecipes = cfg.getBoolean("enableChainRecipes", Configuration.CATEGORY_GENERAL, true, "Enables / Dissables the Recipes for Vanilla Chain Armor.");
		//enableTopaz = cfg.getBoolean("enableTopaz", Configuration.CATEGORY_GENERAL, true, "Enables / Dissables the Topaz Ore, Gem, Block, Tools and Armor.");
		//enableRuby = cfg.getBoolean("enableRuby", Configuration.CATEGORY_GENERAL, true, "Enables / Dissables the Ruby Ore, Gem, Block, Tools and Armor.");
		//enableSapphire = cfg.getBoolean("enableSapphire", Configuration.CATEGORY_GENERAL, true, "Enables / Dissables the Sapphire Ore, Gem, Block, Tools and Armor.");
		//enableEmerald = cfg.getBoolean("enableEmerald", Configuration.CATEGORY_GENERAL, true, "Enables / Dissables the Emerald Tools and Armor.");
		//enableChainRecipes = cfg.getBoolean("enableChainRecipes", Configuration.CATEGORY_GENERAL, enableChainRecipes, "Enables / Dissables the Recipes for Vanilla Chain Armor.");
		getBoolean("enableChainRecipes", CATEGORY_GENERAL, enableChainRecipes, "Enables / Dissables the Recipes for Vanilla Chain Armor.");
		//enableTopaz = cfg.getBoolean("enableTopaz", Configuration.CATEGORY_GENERAL, enableTopaz, "Enables / Dissables the Topaz Ore, Gem, Block, Tools and Armor.");
		getBoolean("enableTopaz", CATEGORY_GENERAL, enableTopaz, "Enables / Dissables the Topaz Ore, Gem, Block, Tools and Armor.");
		//enableRuby = cfg.getBoolean("enableRuby", Configuration.CATEGORY_GENERAL, enableRuby, "Enables / Dissables the Ruby Ore, Gem, Block, Tools and Armor.");
		getBoolean("enableRuby", CATEGORY_GENERAL, enableRuby, "Enables / Dissables the Ruby Ore, Gem, Block, Tools and Armor.");
		//enableSapphire = cfg.getBoolean("enableSapphire", Configuration.CATEGORY_GENERAL, enableSapphire, "Enables / Dissables the Sapphire Ore, Gem, Block, Tools and Armor.");
		getBoolean("enableSapphire", CATEGORY_GENERAL, enableSapphire, "Enables / Dissables the Sapphire Ore, Gem, Block, Tools and Armor.");
		//enableEmerald = cfg.getBoolean("enableEmerald", Configuration.CATEGORY_GENERAL, enableEmerald, "Enables / Dissables the Emerald Tools and Armor.");
		getBoolean("enableEmerald", CATEGORY_GENERAL, enableEmerald, "Enables / Dissables the Emerald Tools and Armor.");
		//oregen_overworld_only = cfg.getBoolean("oregen_overworld_only", Configuration.CATEGORY_GENERAL, oregen_overworld_only, "if this is set to true ores will only be generated if the chunkGenerator is an instance of \"ChunkGeneratorOverworld\". if it's set to false ores will be generated if the chunkGenerator isn't a instance of \"ChunkGeneratorHell\" or \"ChunkGeneratorEnd\", that means in more Mod dimensions.");
		//generationrate_Topaz = cfg.getInt("generationrate_Topaz", Configuration.CATEGORY_GENERAL, generationrate_Topaz, 0, 16, "The Generation Rate for Topaz Ore.(Set to 0 to disable.)");
		getInt("generationrate_Topaz", CATEGORY_GENERAL, generationrate_Topaz, 0, 16, "The Generation Rate for Topaz Ore.(Set to 0 to disable.)");
		//generationrate_Ruby = cfg.getInt("generationrate_Ruby", Configuration.CATEGORY_GENERAL, generationrate_Ruby, 0, 16, "The Generation Rate for Ruby Ore.(Set to 0 to disable.)");
		getInt("generationrate_Ruby", CATEGORY_GENERAL, generationrate_Ruby, 0, 16, "The Generation Rate for Ruby Ore.(Set to 0 to disable.)");
		//generationrate_Sapphire = cfg.getInt("generationrate_Sapphire", Configuration.CATEGORY_GENERAL, generationrate_Sapphire, 0, 16, "The Generation Rate for Sapphire Ore.(Set to 0 to disable.)");
		getInt("generationrate_Sapphire", CATEGORY_GENERAL, generationrate_Sapphire, 0, 16, "The Generation Rate for Sapphire Ore.(Set to 0 to disable.)");
		//generationrate_Emerald = cfg.getInt("generationrate_Emerald", Configuration.CATEGORY_GENERAL, generationrate_Emerald, 0, 16, "This Mod Generates Emerald Ores additional to the Vanilla Generation. The Generation Rate for Emerald Ore.(Set to 0 to disable the additional Generation.)");
		getInt("generationrate_Emerald", CATEGORY_GENERAL, generationrate_Emerald, 0, 16, "This Mod Generates Emerald Ores additional to the Vanilla Generation. The Generation Rate for Emerald Ore.(Set to 0 to disable the additional Generation.)");
		//maxheight_Topaz = cfg.getInt("maxheight_Topaz", Configuration.CATEGORY_GENERAL, maxheight_Topaz, 0, 255, "The Maximum Height for Topaz Ore Generation.");
		getInt("maxheight_Topaz", CATEGORY_GENERAL, maxheight_Topaz, 0, 255, "The Maximum Height for Topaz Ore Generation.");
		//maxheight_Ruby = cfg.getInt("maxheight_Ruby", Configuration.CATEGORY_GENERAL, maxheight_Ruby, 0, 255, "The Maximum Height for Ruby Ore Generation.");
		getInt("maxheight_Ruby", CATEGORY_GENERAL, maxheight_Ruby, 0, 255, "The Maximum Height for Ruby Ore Generation.");
		//maxheight_Sapphire = cfg.getInt("maxheight_Sapphire", Configuration.CATEGORY_GENERAL, maxheight_Sapphire, 0, 255, "The Maximum Height for Sapphire Ore Generation.");
		getInt("maxheight_Sapphire", CATEGORY_GENERAL, maxheight_Sapphire, 0, 255, "The Maximum Height for Sapphire Ore Generation.");
		//maxheight_Emerald = cfg.getInt("maxheight_Emerald", Configuration.CATEGORY_GENERAL, maxheight_Emerald, 0, 255, "This Mod Generates Emerald Ores additional to the Vanilla Generation. The Maximum Height for Emerald Ore Generation.");
		getInt("maxheight_Emerald", CATEGORY_GENERAL, maxheight_Emerald, 0, 255, "This Mod Generates Emerald Ores additional to the Vanilla Generation. The Maximum Height for Emerald Ore Generation.");
		//minheight_Topaz = cfg.getInt("minheight_Topaz", Configuration.CATEGORY_GENERAL, minheight_Topaz, 0, 255, "The Minimum Height for Topaz Ore Generation.");
		getInt("minheight_Topaz", CATEGORY_GENERAL, minheight_Topaz, 0, 255, "The Minimum Height for Topaz Ore Generation.");
		//minheight_Ruby = cfg.getInt("minheight_Ruby", Configuration.CATEGORY_GENERAL, minheight_Ruby, 0, 255, "The Minimum Height for Ruby Ore Generation.");
		getInt("minheight_Ruby", CATEGORY_GENERAL, minheight_Ruby, 0, 255, "The Minimum Height for Ruby Ore Generation.");
		//minheight_Sapphire = cfg.getInt("minheight_Sapphire", Configuration.CATEGORY_GENERAL, minheight_Sapphire, 0, 255, "The Minimum Height for Sapphire Ore Generation.");
		getInt("minheight_Sapphire", CATEGORY_GENERAL, minheight_Sapphire, 0, 255, "The Minimum Height for Sapphire Ore Generation.");
		//minheight_Emerald = cfg.getInt("minheight_Emerald", Configuration.CATEGORY_GENERAL, minheight_Emerald, 0, 255, "This Mod Generates Emerald Ores additional to the Vanilla Generation. The Minimum Height for Emerald Ore Generation.");
		getInt("minheight_Emerald", CATEGORY_GENERAL, minheight_Emerald, 0, 255, "This Mod Generates Emerald Ores additional to the Vanilla Generation. The Minimum Height for Emerald Ore Generation.");
	}
	
	private void loadConfig() {
		enableChainRecipes = getBooleanValue("enableChainRecipes", CATEGORY_GENERAL);
		enableTopaz = getBooleanValue("enableTopaz", CATEGORY_GENERAL);
		enableRuby = getBooleanValue("enableRuby", CATEGORY_GENERAL);
		enableSapphire = getBooleanValue("enableSapphire", CATEGORY_GENERAL);
		enableEmerald = getBooleanValue("enableEmerald", CATEGORY_GENERAL);
		generationrate_Topaz = getIntValue("generationrate_Topaz", CATEGORY_GENERAL);
		generationrate_Ruby = getIntValue("generationrate_Ruby", CATEGORY_GENERAL);
		generationrate_Sapphire = getIntValue("generationrate_Sapphire", CATEGORY_GENERAL);
		generationrate_Emerald = getIntValue("generationrate_Emerald", CATEGORY_GENERAL);
		maxheight_Topaz = getIntValue("maxheight_Topaz", CATEGORY_GENERAL);
		maxheight_Ruby = getIntValue("maxheight_Ruby", CATEGORY_GENERAL);
		maxheight_Sapphire = getIntValue("maxheight_Sapphire", CATEGORY_GENERAL);
		maxheight_Emerald = getIntValue("maxheight_Emerald", CATEGORY_GENERAL);
		minheight_Topaz = getIntValue("minheight_Topaz", CATEGORY_GENERAL);
		minheight_Ruby = getIntValue("minheight_Ruby", CATEGORY_GENERAL);
		minheight_Sapphire = getIntValue("minheight_Sapphire", CATEGORY_GENERAL);
		minheight_Emerald = getIntValue("minheight_Emerald", CATEGORY_GENERAL);
	}
	
	private void getBoolean(String name, String category, boolean defaultValue, String comment) {
		String path = category + "." + name;
		BooleanValue value = builder.comment(comment, "Default: " + defaultValue).define(path, defaultValue);
		values.put(path, value);
	}
	
	private void getInt(String name, String category, int defaultValue, int min, int max, String comment) {
		String path = category + "." + name;
		IntValue value = builder.comment(comment, "Default: " + defaultValue).defineInRange(path, defaultValue, min, max);
		values.put(path, value);
	}
	
	private boolean getBooleanValue(String name, String category) {
		String path = category + "." + name;
		if(values.containsKey(path)) {
			ConfigValue<?> value = values.get(path);
			if(value instanceof BooleanValue) {
				return ((BooleanValue) value).get();
			}
		}
		return false;
	}
	
	private int getIntValue(String name, String category) {
		String path = category + "." + name;
		if(values.containsKey(path)) {
			ConfigValue<?> value = values.get(path);
			if(value instanceof IntValue) {
				return ((IntValue) value).get();
			}
		}
		return 0;
	}
	
}