package com.ToMe.trigems;

import net.minecraft.entity.passive.EntityVillager.EmeraldForItems;
import net.minecraftforge.fml.common.Mod.Instance;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void register() {
		//Topaz
		if(ConfigHandler.enableTopaz) {
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
		/**TriGemsMod.TopazPickaxe.RegisterTextur();
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
		TriGemsMod.blockTopaz.RegisterTextur();*/
		
		//Ruby
		if(ConfigHandler.enableRuby) {
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
		/**TriGemsMod.RubyPickaxe.RegisterTextur();
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
		TriGemsMod.blockRuby.RegisterTextur();*/
		
		//Sapphire
		if(ConfigHandler.enableSapphire) {
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
		/**TriGemsMod.SapphirePickaxe.RegisterTextur();
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
		TriGemsMod.blockSapphire.RegisterTextur();*/
		
		//Emerald
		if(ConfigHandler.enableEmerald) {
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
		/**TriGemsMod.EmeraldPickaxe.RegisterTextur();
		TriGemsMod.EmeraldAxe.RegisterTextur();
		TriGemsMod.EmeraldShovel.RegisterTextur();
		TriGemsMod.EmeraldHoe.RegisterTextur();
		TriGemsMod.EmeraldSword.RegisterTextur();
		TriGemsMod.EmeraldHelmet.RegisterTextur();
		TriGemsMod.EmeraldChest.RegisterTextur();
		TriGemsMod.EmeraldLegs.RegisterTextur();
		TriGemsMod.EmeraldBoots.RegisterTextur();*/
	}
	
}