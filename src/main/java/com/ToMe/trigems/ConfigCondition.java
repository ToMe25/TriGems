/**
 * This class is distributed as a part of the Trigems mod.(https://github.com/ToMe25/TriGems)
 * Copyright (C) 2021  ToMe25
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

import com.google.gson.JsonObject;

import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConfigCondition implements ICondition {

	private static final ResourceLocation NAME = new ResourceLocation("trigems", "config_condition");
	private String option;

	public ConfigCondition(String option) {
		this.option = option;
	}

	@Override
	public ResourceLocation getID() {
		return NAME;
	}

	@Override
	public boolean test() {
		if (option.equalsIgnoreCase("chain")) {
			return ConfigHandler.enableChainRecipes.get();
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "config_condition(\"" + option + "\")";
	}

	public static class Serializer implements IConditionSerializer<ConfigCondition> {

		public static final Serializer INSTANCE = new Serializer();

		@Override
		public void write(JsonObject json, ConfigCondition value) {
			json.addProperty("option", value.option);
		}

		@Override
		public ConfigCondition read(JsonObject json) {
			return new ConfigCondition(JSONUtils.getString(json, "option"));
		}

		@Override
		public ResourceLocation getID() {
			return ConfigCondition.NAME;
		}
	}

}
