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

import java.util.function.Consumer;

import com.ToMe.trigems.TriGemsMod;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalAdvancement;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ItemExistsCondition;

public class RecipeProvider extends net.minecraft.data.RecipeProvider {

	// Item Tags
	private Tag<Item> gemTopaz = forgeTag("gems/topaz");
	private Tag<Item> blockTopaz = forgeTag("storage_blocks/topaz");
	private Tag<Item> oreTopaz = forgeTag("ores/topaz");
	private Tag<Item> gemRuby = forgeTag("gems/ruby");
	private Tag<Item> blockRuby = forgeTag("storage_blocks/ruby");
	private Tag<Item> oreRuby = forgeTag("ores/ruby");
	private Tag<Item> gemSapphire = forgeTag("gems/sapphire");
	private Tag<Item> blockSapphire = forgeTag("storage_blocks/sapphire");
	private Tag<Item> oreSapphire = forgeTag("ores/sapphire");
	private Tag<Item> gemEmerald = forgeTag("gems/emerald");

	public RecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	private static Tag<Item> forgeTag(String name) {
		return new ItemTags.Wrapper(new ResourceLocation("forge", name));
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		registerChainmailRecipes(consumer);
		registerTopazRecipes(consumer);
		registerRubyRecipes(consumer);
		registerSapphireRecipes(consumer);
		registerEmeraldRecipes(consumer);
	}

	private void registerChainmailRecipes(Consumer<IFinishedRecipe> consumer) {
		// FIXME currently ignoring config option
		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(Items.CHAINMAIL_HELMET).key('#', Items.IRON_BARS).patternLine("###")
						.patternLine("# #").addCriterion("has_item", hasItem(Items.IRON_BARS)),
				hasItem(Items.IRON_BARS), Items.CHAINMAIL_HELMET);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(Items.CHAINMAIL_CHESTPLATE).key('#', Items.IRON_BARS)
						.patternLine("# #").patternLine("###").patternLine("###").addCriterion("has_item",
								hasItem(Items.IRON_BARS)),
				hasItem(Items.IRON_BARS), Items.CHAINMAIL_CHESTPLATE);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(Items.CHAINMAIL_LEGGINGS).key('#', Items.IRON_BARS).patternLine("###")
						.patternLine("# #").patternLine("# #").addCriterion("has_item", hasItem(Items.IRON_BARS)),
				hasItem(Items.IRON_BARS), Items.CHAINMAIL_LEGGINGS);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(Items.CHAINMAIL_BOOTS).key('#', Items.IRON_BARS).patternLine("# #")
						.patternLine("# #").addCriterion("has_item", hasItem(Items.IRON_BARS)),
				hasItem(Items.IRON_BARS), Items.CHAINMAIL_BOOTS);
	}

	private void registerTopazRecipes(Consumer<IFinishedRecipe> consumer) {
		resultExists(consumer, ShapelessRecipeBuilder.shapelessRecipe(TriGemsMod.topaz, 9).addIngredient(blockTopaz)
				.addCriterion("has_item", hasItem(blockTopaz)), hasItem(blockTopaz), TriGemsMod.topaz);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.blockTopaz).key('#', gemTopaz).patternLine("###")
						.patternLine("###").patternLine("###").addCriterion("has_item", hasItem(gemTopaz)),
				hasItem(gemTopaz), TriGemsMod.blockTopaz);

		smeltingBlastingRecipe(consumer, oreTopaz, TriGemsMod.topaz, 0.75F, 200);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.TopazSword).key('#', gemTopaz)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("#").patternLine("#").patternLine("S")
						.addCriterion("has_item", hasItem(gemTopaz)),
				hasItem(gemTopaz), TriGemsMod.TopazSword);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.TopazPickaxe).key('#', gemTopaz)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("###").patternLine(" S ").patternLine(" S ")
						.addCriterion("has_item", hasItem(gemTopaz)),
				hasItem(gemTopaz), TriGemsMod.TopazPickaxe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.TopazAxe).key('#', gemTopaz)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("##").patternLine("S#").patternLine("S ")
						.addCriterion("has_item", hasItem(gemTopaz)),
				hasItem(gemTopaz), TriGemsMod.TopazAxe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.TopazShovel).key('#', gemTopaz)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("#").patternLine("S").patternLine("S")
						.addCriterion("has_item", hasItem(gemTopaz)),
				hasItem(gemTopaz), TriGemsMod.TopazShovel);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.TopazHoe).key('#', gemTopaz)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("##").patternLine("S ").patternLine("S ")
						.addCriterion("has_item", hasItem(gemTopaz)),
				hasItem(gemTopaz), TriGemsMod.TopazHoe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.TopazHelmet).key('#', gemTopaz).patternLine("###")
						.patternLine("# #").addCriterion("has_item", hasItem(gemTopaz)),
				hasItem(gemTopaz), TriGemsMod.TopazHelmet);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.TopazChest).key('#', gemTopaz).patternLine("# #")
						.patternLine("###").patternLine("###").addCriterion("has_item", hasItem(gemTopaz)),
				hasItem(gemTopaz), TriGemsMod.TopazChest);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.TopazLegs).key('#', gemTopaz).patternLine("###")
						.patternLine("# #").patternLine("# #").addCriterion("has_item", hasItem(gemTopaz)),
				hasItem(gemTopaz), TriGemsMod.TopazLegs);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.TopazBoots).key('#', gemTopaz).patternLine("# #")
						.patternLine("# #").addCriterion("has_item", hasItem(gemTopaz)),
				hasItem(gemTopaz), TriGemsMod.TopazBoots);
	}

	private void registerRubyRecipes(Consumer<IFinishedRecipe> consumer) {
		resultExists(consumer, ShapelessRecipeBuilder.shapelessRecipe(TriGemsMod.ruby, 9).addIngredient(blockRuby)
				.addCriterion("has_item", hasItem(blockRuby)), hasItem(blockRuby), TriGemsMod.ruby);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.blockRuby).key('#', gemRuby).patternLine("###")
						.patternLine("###").patternLine("###").addCriterion("has_item", hasItem(gemRuby)),
				hasItem(gemRuby), TriGemsMod.blockRuby);

		smeltingBlastingRecipe(consumer, oreRuby, TriGemsMod.ruby, 0.75F, 200);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.RubySword).key('#', gemRuby)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("#").patternLine("#").patternLine("S")
						.addCriterion("has_item", hasItem(gemRuby)),
				hasItem(gemRuby), TriGemsMod.RubySword);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.RubyPickaxe).key('#', gemRuby)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("###").patternLine(" S ").patternLine(" S ")
						.addCriterion("has_item", hasItem(gemRuby)),
				hasItem(gemRuby), TriGemsMod.RubyPickaxe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.RubyAxe).key('#', gemRuby).key('S', Tags.Items.RODS_WOODEN)
						.patternLine("##").patternLine("S#").patternLine("S ")
						.addCriterion("has_item", hasItem(gemRuby)),
				hasItem(gemRuby), TriGemsMod.RubyAxe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.RubyShovel).key('#', gemRuby)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("#").patternLine("S").patternLine("S")
						.addCriterion("has_item", hasItem(gemRuby)),
				hasItem(gemRuby), TriGemsMod.RubyShovel);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.RubyHoe).key('#', gemRuby).key('S', Tags.Items.RODS_WOODEN)
						.patternLine("##").patternLine("S ").patternLine("S ")
						.addCriterion("has_item", hasItem(gemRuby)),
				hasItem(gemRuby), TriGemsMod.RubyHoe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.RubyHelmet).key('#', gemRuby).patternLine("###")
						.patternLine("# #").addCriterion("has_item", hasItem(gemRuby)),
				hasItem(gemRuby), TriGemsMod.RubyHelmet);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.RubyChest).key('#', gemRuby).patternLine("# #")
						.patternLine("###").patternLine("###").addCriterion("has_item", hasItem(gemRuby)),
				hasItem(gemRuby), TriGemsMod.RubyChest);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.RubyLegs).key('#', gemRuby).patternLine("###")
						.patternLine("# #").patternLine("# #").addCriterion("has_item", hasItem(gemRuby)),
				hasItem(gemRuby), TriGemsMod.RubyLegs);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.RubyBoots).key('#', gemRuby).patternLine("# #")
						.patternLine("# #").addCriterion("has_item", hasItem(gemRuby)),
				hasItem(gemRuby), TriGemsMod.RubyBoots);
	}

	private void registerSapphireRecipes(Consumer<IFinishedRecipe> consumer) {
		resultExists(consumer, ShapelessRecipeBuilder.shapelessRecipe(TriGemsMod.sapphire, 9)
				.addIngredient(blockSapphire).addCriterion("has_item", hasItem(blockSapphire)), hasItem(blockSapphire),
				TriGemsMod.sapphire);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.blockSapphire).key('#', gemSapphire).patternLine("###")
						.patternLine("###").patternLine("###").addCriterion("has_item", hasItem(gemSapphire)),
				hasItem(gemSapphire), TriGemsMod.blockSapphire);

		smeltingBlastingRecipe(consumer, oreSapphire, TriGemsMod.sapphire, 0.75F, 200);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.SapphireSword).key('#', gemSapphire)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("#").patternLine("#").patternLine("S")
						.addCriterion("has_item", hasItem(gemSapphire)),
				hasItem(gemSapphire), TriGemsMod.SapphireSword);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.SapphirePickaxe).key('#', gemSapphire)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("###").patternLine(" S ").patternLine(" S ")
						.addCriterion("has_item", hasItem(gemSapphire)),
				hasItem(gemSapphire), TriGemsMod.SapphirePickaxe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.SapphireAxe).key('#', gemSapphire)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("##").patternLine("S#").patternLine("S ")
						.addCriterion("has_item", hasItem(gemSapphire)),
				hasItem(gemSapphire), TriGemsMod.SapphireAxe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.SapphireShovel).key('#', gemSapphire)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("#").patternLine("S").patternLine("S")
						.addCriterion("has_item", hasItem(gemSapphire)),
				hasItem(gemSapphire), TriGemsMod.SapphireShovel);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.SapphireHoe).key('#', gemSapphire)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("##").patternLine("S ").patternLine("S ")
						.addCriterion("has_item", hasItem(gemSapphire)),
				hasItem(gemSapphire), TriGemsMod.SapphireHoe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.SapphireHelmet).key('#', gemSapphire).patternLine("###")
						.patternLine("# #").addCriterion("has_item", hasItem(gemSapphire)),
				hasItem(gemSapphire), TriGemsMod.SapphireHelmet);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.SapphireChest).key('#', gemSapphire).patternLine("# #")
						.patternLine("###").patternLine("###").addCriterion("has_item", hasItem(gemSapphire)),
				hasItem(gemSapphire), TriGemsMod.SapphireChest);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.SapphireLegs).key('#', gemSapphire).patternLine("###")
						.patternLine("# #").patternLine("# #").addCriterion("has_item", hasItem(gemSapphire)),
				hasItem(gemSapphire), TriGemsMod.SapphireLegs);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.SapphireBoots).key('#', gemSapphire).patternLine("# #")
						.patternLine("# #").addCriterion("has_item", hasItem(gemSapphire)),
				hasItem(gemSapphire), TriGemsMod.SapphireBoots);
	}

	private void registerEmeraldRecipes(Consumer<IFinishedRecipe> consumer) {
		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.EmeraldSword).key('#', gemEmerald)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("#").patternLine("#").patternLine("S")
						.addCriterion("has_item", hasItem(gemEmerald)),
				hasItem(gemEmerald), TriGemsMod.EmeraldSword);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.EmeraldPickaxe).key('#', gemEmerald)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("###").patternLine(" S ").patternLine(" S ")
						.addCriterion("has_item", hasItem(gemEmerald)),
				hasItem(gemEmerald), TriGemsMod.EmeraldPickaxe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.EmeraldAxe).key('#', gemEmerald)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("##").patternLine("S#").patternLine("S ")
						.addCriterion("has_item", hasItem(gemEmerald)),
				hasItem(gemEmerald), TriGemsMod.EmeraldAxe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.EmeraldShovel).key('#', gemEmerald)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("#").patternLine("S").patternLine("S")
						.addCriterion("has_item", hasItem(gemEmerald)),
				hasItem(gemEmerald), TriGemsMod.EmeraldShovel);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.EmeraldHoe).key('#', gemEmerald)
						.key('S', Tags.Items.RODS_WOODEN).patternLine("##").patternLine("S ").patternLine("S ")
						.addCriterion("has_item", hasItem(gemEmerald)),
				hasItem(gemEmerald), TriGemsMod.EmeraldHoe);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.EmeraldHelmet).key('#', gemEmerald).patternLine("###")
						.patternLine("# #").addCriterion("has_item", hasItem(gemEmerald)),
				hasItem(gemEmerald), TriGemsMod.EmeraldHelmet);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.EmeraldChest).key('#', gemEmerald).patternLine("# #")
						.patternLine("###").patternLine("###").addCriterion("has_item", hasItem(gemEmerald)),
				hasItem(gemEmerald), TriGemsMod.EmeraldChest);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.EmeraldLegs).key('#', gemEmerald).patternLine("###")
						.patternLine("# #").patternLine("# #").addCriterion("has_item", hasItem(gemEmerald)),
				hasItem(gemEmerald), TriGemsMod.EmeraldLegs);

		resultExists(consumer,
				ShapedRecipeBuilder.shapedRecipe(TriGemsMod.EmeraldBoots).key('#', gemEmerald).patternLine("# #")
						.patternLine("# #").addCriterion("has_item", hasItem(gemEmerald)),
				hasItem(gemEmerald), TriGemsMod.EmeraldBoots);
	}

	private void smeltingBlastingRecipe(Consumer<IFinishedRecipe> consumer, Tag<Item> input, IItemProvider result,
			float xp, int smeltingDuration) {
		resultExists(consumer,
				CookingRecipeBuilder.smeltingRecipe(Ingredient.fromTag(input), result, xp, smeltingDuration)
						.addCriterion("has_item", hasItem(input)),
				hasItem(input), result, false);

		resultExists(consumer,
				CookingRecipeBuilder.blastingRecipe(Ingredient.fromTag(input), result, xp, smeltingDuration / 2)
						.addCriterion("has_item", hasItem(input)),
				hasItem(input), result, true);
	}

	private void resultExists(Consumer<IFinishedRecipe> consumer, ShapelessRecipeBuilder recipeBuilder,
			ICriterionInstance trigger, IItemProvider result) {
		ConditionalRecipe.builder().addCondition(new ItemExistsCondition(result.asItem().getRegistryName()))
				.addRecipe(recipeBuilder::build)
				.setAdvancement(
						new ResourceLocation(TriGemsMod.MODID,
								"recipes/" + result.asItem().getGroup().getPath() + "/"
										+ result.asItem().getRegistryName().getPath()),
						ConditionalAdvancement.builder()
								.addCondition(new ItemExistsCondition(result.asItem().getRegistryName().toString()))
								.addAdvancement(Advancement.Builder.builder()
										.withParentId(new ResourceLocation("recipes/root"))
										.withRewards(
												AdvancementRewards.Builder.recipe(result.asItem().getRegistryName()))
										.withCriterion("has_item", trigger)
										.withCriterion("has_the_recipe",
												new RecipeUnlockedTrigger.Instance(result.asItem().getRegistryName()))
										.withRequirementsStrategy(IRequirementsStrategy.OR)))
				.build(consumer, new ResourceLocation(TriGemsMod.MODID, result.asItem().getRegistryName().getPath()));
	}

	private void resultExists(Consumer<IFinishedRecipe> consumer, ShapedRecipeBuilder recipeBuilder,
			ICriterionInstance trigger, IItemProvider result) {
		ConditionalRecipe.builder().addCondition(new ItemExistsCondition(result.asItem().getRegistryName()))
				.addRecipe(recipeBuilder::build)
				.setAdvancement(
						new ResourceLocation(TriGemsMod.MODID,
								"recipes/" + result.asItem().getGroup().getPath() + "/"
										+ result.asItem().getRegistryName().getPath()),
						ConditionalAdvancement.builder()
								.addCondition(new ItemExistsCondition(result.asItem().getRegistryName()))
								.addAdvancement(Advancement.Builder.builder()
										.withParentId(new ResourceLocation("recipes/root"))
										.withRewards(
												AdvancementRewards.Builder.recipe(result.asItem().getRegistryName()))
										.withCriterion("has_item", trigger)
										.withCriterion("has_the_recipe",
												new RecipeUnlockedTrigger.Instance(result.asItem().getRegistryName()))
										.withRequirementsStrategy(IRequirementsStrategy.OR)))
				.build(consumer, new ResourceLocation(TriGemsMod.MODID, result.asItem().getRegistryName().getPath()));
	}

	private void resultExists(Consumer<IFinishedRecipe> consumer, CookingRecipeBuilder recipeBuilder,
			ICriterionInstance trigger, IItemProvider result, boolean blasting) {
		ConditionalRecipe.builder().addCondition(new ItemExistsCondition(result.asItem().getRegistryName()))
				.addRecipe(recipeBuilder::build)
				.setAdvancement(
						new ResourceLocation(TriGemsMod.MODID, "recipes/" + result.asItem().getGroup().getPath() + "/"
								+ result.asItem().getRegistryName().getPath() + (blasting ? "_blasting" : "_smelting")),
						ConditionalAdvancement.builder()
								.addCondition(new ItemExistsCondition(result.asItem().getRegistryName()))
								.addAdvancement(Advancement.Builder.builder()
										.withParentId(new ResourceLocation("recipes/root"))
										.withRewards(
												AdvancementRewards.Builder.recipe(result.asItem().getRegistryName()))
										.withCriterion("has_item", trigger)
										.withCriterion("has_the_recipe",
												new RecipeUnlockedTrigger.Instance(result.asItem().getRegistryName()))
										.withRequirementsStrategy(IRequirementsStrategy.OR)))
				.build(consumer, new ResourceLocation(TriGemsMod.MODID,
						result.asItem().getRegistryName().getPath() + (blasting ? "_blasting" : "_smelting")));
	}

	@Override
	public String getName() {
		return "TriGems Recipe Provider";
	}

}
