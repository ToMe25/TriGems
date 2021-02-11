package com.ToMe.trigems;

//import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.init.Blocks;
//import net.minecraft.client.resources.model.ModelResourceLocation;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemBlock;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.util.BlockPos;
//import net.minecraft.util.MathHelper;
//import net.minecraft.world.IBlockAccess;
//import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
//import net.minecraftforge.fml.common.registry.ForgeRegistries;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import net.minecraft.block.BlockOre;
//import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
//import net.minecraft.block.Block.Properties;

/**
 * This class is currently unused.
 */
public class GemOre extends Block{
	
	//private Item drop;
	//private ToolType harvestTool;
	//private int harvestLevel;
	public Item blockItem;
	
	//public GemOre(String unlocalizedName, int id, Item drop) {
	//public GemOre(String unlocalizedName, int id) {
	//public GemOre(String registryName, MaterialColor materialColor) {
	public GemOre(String registryName) {
		//this(unlocalizedName, id, Material.ROCK, 3.0F, 5.0F, 0.0F, "pickaxe", 2, SoundType.STONE, drop);
		//this(unlocalizedName, id, Material.ROCK, 3.0F, 5.0F, 0.0F, "pickaxe", 2, SoundType.STONE);
		//this(registryName, Material.ROCK, 3.0F, 5.0F, 0, ToolType.PICKAXE, 2, SoundType.STONE, materialColor);
		this(registryName, Material.ROCK, 3.0F, 5.0F, 0, ToolType.PICKAXE, 2, SoundType.STONE, MaterialColor.STONE);
	}
	
	//public GemOre(String unlocalizedName, int id, Material material, float hardness, float resistance, float lightLevel, String tool, int harvestLevel, SoundType soundtype, Item drop) {
	//public GemOre(String unlocalizedName, int id, Material material, float hardness, float resistance, float lightLevel, String tool, int harvestLevel, SoundType soundtype) {	
	public GemOre(String registryName, Material material, float hardness, float resistance, int lightLevel, ToolType harvestTool, int harvestLevel, SoundType soundType, MaterialColor materialColor) {
		// TODO Auto-generated constructor stub
		//super(material);
		//super(Properties.create(material, materialColor).hardnessAndResistance(hardness, resistance).lightValue(lightLevel).sound(soundType));
		super(Properties.create(material, materialColor).hardnessAndResistance(hardness, resistance).setLightLevel(state -> lightLevel).sound(soundType));
		//this.drop = drop;
		//this.harvestTool = harvestTool;
		//this.harvestLevel = harvestLevel;
		//this.setUnlocalizedName(unlocalizedName);
		//this.setRegistryName(unlocalizedName);
		//this.setHardness(hardness);
		//this.setResistance(resistance);
		setRegistryName(registryName);
		blockItem = new BlockItem(this, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(getRegistryName());
		//this.setLightLevel(lightLevel);
		//this.setHarvestLevel(tool, harvestLevel);
		//this.setSoundType(soundtype);
		//REGISTRY.register(id, new ResourceLocation("trigems:" + unlocalizedName), this);
		//ForgeRegistries.BLOCKS.register(this);
		//ForgeRegistries.ITEMS.register(new ItemBlock(this).setUnlocalizedName(unlocalizedName).setRegistryName(unlocalizedName));
		//this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
	}

	/**
	 * needed for 1.14.2
	 */
	/*@Override
	public ToolType getHarvestTool(BlockState state) {
		return harvestTool;
	}*/

	/**
	 * needed for 1.14.2
	 */
	/*@Override
	public int getHarvestLevel(BlockState state) {
		return harvestLevel;
	}*/

	/*public void RegisterTextur(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(this), 0, new ModelResourceLocation("trigems:" + this.getUnlocalizedName().substring(5), "inventory"));
	}*/
	
	/*// The 3 functions below, getItemDropped, quantityDroppedWithBonus and damageDropped work together to determine the drops
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		//return drop;
		return this == TriGemsMod.oreSapphire ? TriGemsMod.sapphire: (this == TriGemsMod.oreTopaz ? TriGemsMod.topaz : TriGemsMod.ruby);
	}
	
	public int quantityDropped(Random random) {
		return 1;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			
			if (i < 0) {
				i = 0;
			}
			
			return this.quantityDropped(random) * (i + 1);
		}
		else {
			return this.quantityDropped(random);
		}
	}
	
    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
    
    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
    	// TODO Auto-generated method stub
    	Random rand = world instanceof World ? ((World)world).rand : new Random();
        return MathHelper.getInt(rand, 3, 7);
    }*/
	
}
