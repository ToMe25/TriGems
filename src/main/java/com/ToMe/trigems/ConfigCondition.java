package com.ToMe.trigems;

//import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
//import net.minecraftforge.common.crafting.IConditionFactory;
//import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

/**
 * This class is currently unused.
 */
//public class ConfigCondition implements IConditionFactory {
public class ConfigCondition implements ICondition {

    private static final ResourceLocation NAME = new ResourceLocation("trigems", "config_condition");
    private String option;
    
    public ConfigCondition(String option) {
    	this.option = option;
    }
    
	/*@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		//System.out.println(context.toString() + "; " + json.toString());
		//if(json.get("option").toString().equalsIgnoreCase("chain")) {
		if(json.get("option").toString().replaceAll("\"", "").equalsIgnoreCase("chain")) {
			//System.out.println(json.get("option"));
			return () -> ConfigHandler.enableChainRecipes;
		}
		//else if(json.get("option").toString().equalsIgnoreCase("topaz")) {
		else if(json.get("option").toString().replaceAll("\"", "").equalsIgnoreCase("topaz")) {
			return () -> ConfigHandler.enableTopaz;
		}
		//else if(json.get("option").toString().equalsIgnoreCase("ruby")) {
		else if(json.get("option").toString().replaceAll("\"", "").equalsIgnoreCase("ruby")) {
			return () -> ConfigHandler.enableRuby;
		}
		//else if(json.get("option").toString().equalsIgnoreCase("sapphire")) {
		else if(json.get("option").toString().replaceAll("\"", "").equalsIgnoreCase("sapphire")) {
			return () -> ConfigHandler.enableSapphire;
		}
		//else if(json.get("option").toString().equalsIgnoreCase("emerald")) {
		else if(json.get("option").toString().replaceAll("\"", "").equalsIgnoreCase("emerald")) {
			return () -> ConfigHandler.enableEmerald;
		}
		else {
			//System.out.println(json.get("option"));
			return () -> false;
		}
	}*/

	@Override
	public ResourceLocation getID() {
		return NAME;
	}

	@Override
	public boolean test() {
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
	
	@Override
	public String toString() {
		return "config_condition(\"" + option + "\")";
	}
	
	/**
	 * This class is currently unused.
	 */
	public static class Serializer implements IConditionSerializer<ConfigCondition> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void write(JsonObject json, ConfigCondition value)
        {
            json.addProperty("option", value.option);
        }

        @Override
        public ConfigCondition read(JsonObject json)
        {
            return new ConfigCondition(JSONUtils.getString(json, "option"));
        }

        @Override
        public ResourceLocation getID()
        {
            return ConfigCondition.NAME;
        }
    }
	
}