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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;

/**
 * This class is incredibly hacky and unsafe, but it is necessary for one jar to
 * work in 1.14.2 and 1.14.4.
 */
public class ConfigConditionHandler implements InvocationHandler {

	private static final ResourceLocation NAME = new ResourceLocation("trigems", "config_condition");
	private String option;

	public static void register(RegistryEvent.Register<IRecipeSerializer<?>> e) {
		try {
			Class<?> IConditionSerializer = Class
					.forName("net.minecraftforge.common.crafting.conditions.IConditionSerializer");
			Method register = CraftingHelper.class.getMethod("register", IConditionSerializer);
			Object conditionSerializer = Proxy.newProxyInstance(IConditionSerializer.getClassLoader(),
					new Class[] { IConditionSerializer }, new ConfigConditionHandler());
			register.invoke(null, conditionSerializer);
		} catch (Throwable e2) {
			try {
				Class<?> IConditionSerializer = Class
						.forName("net.minecraftforge.common.crafting.IConditionSerializer");
				Method register = CraftingHelper.class.getMethod("register", ResourceLocation.class,
						IConditionSerializer);
				Object conditionSerializer = Proxy.newProxyInstance(IConditionSerializer.getClassLoader(),
						new Class[] { IConditionSerializer }, new ConfigConditionHandler());
				register.invoke(null, new ResourceLocation(TriGemsMod.MODID, "config_condition"), conditionSerializer);
			} catch (Throwable e3) {
				e2.printStackTrace();
				e3.printStackTrace();
			}
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String name = method.getName();
		if (name.equals("parse") && args.length == 1) {
			if (args[0] instanceof JsonObject) {
				return parse((JsonObject) args[0]);
			}
		} else if (name.equals("write") && args.length == 2) {
			if (args[0] instanceof JsonObject && args[1] instanceof ConfigConditionHandler) {
				((JsonObject) args[0]).addProperty("option", ((ConfigConditionHandler) args[1]).option);
			}
		} else if (name.equals("read") && args.length == 1) {
			if (args[0] instanceof JsonObject) {
				try {
					Class<?> ICondition = Class.forName("net.minecraftforge.common.crafting.conditions.ICondition");
					Object condition = Proxy.newProxyInstance(ICondition.getClassLoader(), new Class[] { ICondition },
							new ConfigConditionHandler());
					((ConfigConditionHandler) Proxy.getInvocationHandler(condition)).option = JSONUtils
							.getString((JsonObject) args[0], "option");
					return condition;
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		} else if (name.equals("getID")) {
			return NAME;
		} else if (name.equals("test")) {
			return test();
		} else if (name.equals("toString")) {
			if (option != null) {
				return "config_condition(\"" + option + "\")";
			} else {
				return super.toString();
			}
		}
		return null;
	}

	public static JsonObject getJson(String option) {
		JsonObject json = new JsonObject();
		json.addProperty("type", NAME.toString());
		json.addProperty("option", option);
		return json;
	}

	private boolean test() {
		if (option.equalsIgnoreCase("chain")) {
			return ConfigHandler.enableChainRecipes.get();
		} else {
			return false;
		}
	}

	private BooleanSupplier parse(JsonObject json) {
		String option = JSONUtils.getString(json, "option");
		if (option.equalsIgnoreCase("chain")) {
			return () -> ConfigHandler.enableChainRecipes.get();
		} else {
			return () -> false;
		}
	}

}