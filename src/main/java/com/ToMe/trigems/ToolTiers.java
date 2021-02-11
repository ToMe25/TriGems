package com.ToMe.trigems;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
//import net.minecraft.util.LazyLoadBase;

public enum ToolTiers implements IItemTier {
	TOPAZ(3, 1500, 8.0F, 2.5F, 10, () -> {
		return Ingredient.fromItems(TriGemsMod.topaz);
	}),
	RUBY(3, 1500, 8.0F, 3.0F, 10, () -> {
		return Ingredient.fromItems(TriGemsMod.ruby);
	}),
	SAPPHIRE(3, 1500, 8.0F, 3.5F, 10, () -> {
		return Ingredient.fromItems(TriGemsMod.sapphire);
	}),
	EMERALD(3, 1500, 15.0F, 4.0F, 30, () -> {
		return Ingredient.fromItems(Items.EMERALD);
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	//private final LazyLoadBase<Ingredient> repairMaterial;
	private final LazyValue<Ingredient> repairMaterial;

	private ToolTiers(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn,
			Supplier<Ingredient> repairMaterialIn) {
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		//this.repairMaterial = new LazyLoadBase<Ingredient>(repairMaterialIn);
		this.repairMaterial = new LazyValue<Ingredient>(repairMaterialIn);
	}

	public int getMaxUses() {
		return this.maxUses;
	}

	public float getEfficiency() {
		return this.efficiency;
	}

	public float getAttackDamage() {
		return this.attackDamage;
	}

	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}

}
