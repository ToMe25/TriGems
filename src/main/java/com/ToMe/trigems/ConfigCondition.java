package com.ToMe.trigems;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class ConfigCondition implements IConditionFactory {
	
	@Override
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
	}
	
}