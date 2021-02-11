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

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;

public class Armor extends ItemArmor {

	public Armor(String unlocalizedName, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType,
			int id) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
	}

	public void RegisterTextur() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0,
				new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
	}
}
