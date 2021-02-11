package com.ToMe.trigems;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ArmorTiers implements IArmorMaterial {
	TOPAZ("trigems:topaz", 32, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, () -> {
		return Ingredient.fromItems(TriGemsMod.topaz);
	}),
	RUBY("trigems:ruby", 33, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
		return Ingredient.fromItems(TriGemsMod.ruby);
	}),
	SAPPHIRE("trigems:sapphire", 34, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, () -> {
		return Ingredient.fromItems(TriGemsMod.sapphire);
	}),
	EMERALD("trigems:emerald", 35, new int[] { 3, 6, 8, 3 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F, () -> {
		return Ingredient.fromItems(Items.EMERALD);
	});

	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyLoadBase<Ingredient> repairMaterial;

	private ArmorTiers(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn,
			SoundEvent equipSoundIn, float thoughness, Supplier<Ingredient> repairMaterialSupplier) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountsIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = equipSoundIn;
		this.toughness = thoughness;
		this.repairMaterial = new LazyLoadBase<Ingredient>(repairMaterialSupplier);
	}

	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}

	@OnlyIn(Dist.CLIENT)
	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}
}