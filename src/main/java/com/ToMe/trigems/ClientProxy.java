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

public class ClientProxy extends CommonProxy {

	@Override
	public void register() {
		// Topaz
		if (ConfigHandler.enableTopaz) {
			TriGemsMod.TopazPickaxe.RegisterTextur();
			TriGemsMod.TopazAxe.RegisterTextur();
			TriGemsMod.TopazShovel.RegisterTextur();
			TriGemsMod.TopazHoe.RegisterTextur();
			TriGemsMod.TopazSword.RegisterTextur();
			TriGemsMod.TopazHelmet.RegisterTextur();
			TriGemsMod.TopazChest.RegisterTextur();
			TriGemsMod.TopazLegs.RegisterTextur();
			TriGemsMod.TopazBoots.RegisterTextur();
			TriGemsMod.topaz.RegisterTextur();
			TriGemsMod.oreTopaz.RegisterTextur();
			TriGemsMod.blockTopaz.RegisterTextur();
		}

		// Ruby
		if (ConfigHandler.enableRuby) {
			TriGemsMod.RubyPickaxe.RegisterTextur();
			TriGemsMod.RubyAxe.RegisterTextur();
			TriGemsMod.RubyShovel.RegisterTextur();
			TriGemsMod.RubyHoe.RegisterTextur();
			TriGemsMod.RubySword.RegisterTextur();
			TriGemsMod.RubyHelmet.RegisterTextur();
			TriGemsMod.RubyChest.RegisterTextur();
			TriGemsMod.RubyLegs.RegisterTextur();
			TriGemsMod.RubyBoots.RegisterTextur();
			TriGemsMod.ruby.RegisterTextur();
			TriGemsMod.oreRuby.RegisterTextur();
			TriGemsMod.blockRuby.RegisterTextur();
		}

		// Sapphire
		if (ConfigHandler.enableSapphire) {
			TriGemsMod.SapphirePickaxe.RegisterTextur();
			TriGemsMod.SapphireAxe.RegisterTextur();
			TriGemsMod.SapphireShovel.RegisterTextur();
			TriGemsMod.SapphireHoe.RegisterTextur();
			TriGemsMod.SapphireSword.RegisterTextur();
			TriGemsMod.SapphireHelmet.RegisterTextur();
			TriGemsMod.SapphireChest.RegisterTextur();
			TriGemsMod.SapphireLegs.RegisterTextur();
			TriGemsMod.SapphireBoots.RegisterTextur();
			TriGemsMod.sapphire.RegisterTextur();
			TriGemsMod.oreSapphire.RegisterTextur();
			TriGemsMod.blockSapphire.RegisterTextur();
		}

		// Emerald
		if (ConfigHandler.enableEmerald) {
			TriGemsMod.EmeraldPickaxe.RegisterTextur();
			TriGemsMod.EmeraldAxe.RegisterTextur();
			TriGemsMod.EmeraldShovel.RegisterTextur();
			TriGemsMod.EmeraldHoe.RegisterTextur();
			TriGemsMod.EmeraldSword.RegisterTextur();
			TriGemsMod.EmeraldHelmet.RegisterTextur();
			TriGemsMod.EmeraldChest.RegisterTextur();
			TriGemsMod.EmeraldLegs.RegisterTextur();
			TriGemsMod.EmeraldBoots.RegisterTextur();
		}
	}

}