package gaia.registry;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;

public class GaiaTiers {
	public static final Tier BOOK = new SimpleTier(GaiaTags.INCORRECT_FOR_BOOK_TOOL, 780, 6.0F, 2.0F, 22,
			() -> Ingredient.of(GaiaRegistry.QUILL.get()));
	public static final Tier CURSED_METAL = new SimpleTier(GaiaTags.INCORRECT_FOR_CURSED_METAL_TOOL, 300, 5.0F, 1.0F, 16,
			() -> Ingredient.of(Tags.Items.OBSIDIANS));
}
