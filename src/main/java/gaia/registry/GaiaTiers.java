package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.TierSortingRegistry;

import java.util.List;

public class GaiaTiers {
	public static final Tier BOOK = TierSortingRegistry.registerTier(
			new SimpleTier(0, 780, 6.0F, 2.0F, 22,
					GaiaTags.REQUIRES_BOOK_TAG,
					() -> Ingredient.of(GaiaRegistry.QUILL.get())),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "book"), List.of(Tiers.WOOD), List.of());
	public static final Tier CURSED_METAL = TierSortingRegistry.registerTier(
			new SimpleTier(2, 300, 5.0F, 1.0F, 16,
					GaiaTags.REQUIRES_CURSED_METAL_TAG,
					() -> Ingredient.of(Tags.Items.OBSIDIAN)),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "cursed_metal"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
}
