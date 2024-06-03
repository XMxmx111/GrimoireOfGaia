package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GaiaTags {
	public static final TagKey<Item> DIMENSIONAL_BOXES = ItemTags.create(new ResourceLocation(GrimoireOfGaia.MOD_ID, "dimensional_boxes"));
	public static final TagKey<Item> GOLDEN_TOOLS = ItemTags.create(new ResourceLocation(GrimoireOfGaia.MOD_ID, "golden_tools"));
	public static final TagKey<Block> INCORRECT_FOR_BOOK_TOOL = BlockTags.create(new ResourceLocation(GrimoireOfGaia.MOD_ID, "incorrect_for_book_tool"));
	public static final TagKey<Block> INCORRECT_FOR_CURSED_METAL_TOOL = BlockTags.create(new ResourceLocation(GrimoireOfGaia.MOD_ID, "incorrect_for_cursed_metal_tool"));
	public static final TagKey<Block> GAIA_SPAWABLE_ON = BlockTags.create(new ResourceLocation(GrimoireOfGaia.MOD_ID, "gaia_spawnable_on"));
	public static final TagKey<Block> FLOWER_SPAWNABLE_ON = BlockTags.create(new ResourceLocation(GrimoireOfGaia.MOD_ID, "flower_spawnable_on"));

	public static final TagKey<Item> TOOLS = ItemTags.create(new ResourceLocation("forge", "tools"));
	public static final TagKey<Item> RECORDS = ItemTags.create(new ResourceLocation("forge", "records"));
	public static final TagKey<Item> TOOLS_AXES = ItemTags.create(new ResourceLocation("forge", "tools/axes"));
	public static final TagKey<Item> TOOLS_SHOVELS = ItemTags.create(new ResourceLocation("forge", "tools/shovels"));
	public static final TagKey<Item> NUGGETS_DIAMOND = ItemTags.create(new ResourceLocation("forge", "nuggets/diamond"));
	public static final TagKey<Item> NUGGETS_EMERALD = ItemTags.create(new ResourceLocation("forge", "nuggets/emerald"));
}
