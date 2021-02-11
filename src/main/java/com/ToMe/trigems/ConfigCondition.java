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

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class ConfigCondition implements IConditionFactory {

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		if (json.get("option").toString().replaceAll("\"", "").equalsIgnoreCase("chain")) {
			return () -> ConfigHandler.enableChainRecipes;
		} else if (json.get("option").toString().replaceAll("\"", "").equalsIgnoreCase("topaz")) {
			return () -> ConfigHandler.enableTopaz;
		} else if (json.get("option").toString().replaceAll("\"", "").equalsIgnoreCase("ruby")) {
			return () -> ConfigHandler.enableRuby;
		} else if (json.get("option").toString().replaceAll("\"", "").equalsIgnoreCase("sapphire")) {
			return () -> ConfigHandler.enableSapphire;
		} else if (json.get("option").toString().replaceAll("\"", "").equalsIgnoreCase("emerald")) {
			return () -> ConfigHandler.enableEmerald;
		} else {
			return () -> false;
		}
	}

}
