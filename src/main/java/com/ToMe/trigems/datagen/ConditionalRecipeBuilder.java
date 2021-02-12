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
package com.ToMe.trigems.datagen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;

/**
 * This is probably incredibly unsafe, but it should never be loaded while the
 * game is running. Only to be used of datagen!
 */
public class ConditionalRecipeBuilder {

	private List<ICondition> conditions = new ArrayList<>();
	private IFinishedRecipe recipe;

	public ConditionalRecipeBuilder addCondition(ICondition condition) {
		conditions.add(condition);
		return this;
	}

	public ConditionalRecipeBuilder setRecipe(Consumer<Consumer<IFinishedRecipe>> recipeBuilder) {
		recipeBuilder.accept(this::setRecipe);
		return this;
	}

	public ConditionalRecipeBuilder setRecipe(IFinishedRecipe recipe) {
		this.recipe = recipe;
		return this;
	}

	public void build(Consumer<IFinishedRecipe> consumer, ResourceLocation id, ResourceLocation advId) {
		if (conditions.isEmpty()) {
			throw new IllegalStateException("Invalid ConditionalRecipeBuilder, No conditions found!");
		}
		if (recipe == null) {
			throw new IllegalStateException("Invalid ConditionalRecipeBuilder, No recipe found!");
		}

		consumer.accept(new Finished(id, conditions, recipe, advId));
	}

	public class Finished implements IFinishedRecipe {

		private final ResourceLocation id;
		private final List<ICondition> conditions;
		private final IFinishedRecipe recipe;
		private final ResourceLocation advId;

		private Finished(ResourceLocation id, List<ICondition> conditions, IFinishedRecipe recipe,
				ResourceLocation advId) {
			this.id = id;
			this.conditions = conditions;
			this.recipe = recipe;
			this.advId = advId;
		}

		/**
		 * Should never be called!
		 */
		@Override
		public void serialize(JsonObject json) {
		}

		@Override
		public ResourceLocation getID() {
			return id;
		}

		/**
		 * Should never be called!
		 */
		@Override
		public IRecipeSerializer<?> getSerializer() {
			return null;
		}

		@Override
		public JsonObject getRecipeJson() {
			JsonObject json = recipe.getRecipeJson();
			JsonArray conditions = new JsonArray();
			for (ICondition c : this.conditions) {
				conditions.add(CraftingHelper.serialize(c));
			}
			json.add("conditions", conditions);
			return json;
		}

		@Override
		public JsonObject getAdvancementJson() {
			return recipe.getAdvancementJson();
		}

		@Override
		public ResourceLocation getAdvancementID() {
			return advId;
		}

	}

}
