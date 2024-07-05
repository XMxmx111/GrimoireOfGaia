package gaia.item.shield;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.function.Supplier;

public class TieredShieldItem extends ShieldItem {
	private final LazyLoadedValue<Ingredient> repairIngredient;

	public TieredShieldItem(Item.Properties properties, Supplier<Ingredient> ingredientSupplier) {
		super(properties);
		DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
		this.repairIngredient = new LazyLoadedValue<>(ingredientSupplier);
	}

	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return repairIngredient.get().test(repair) || super.isValidRepairItem(toRepair, repair);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ItemAbility ItemAbility) {
		return ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(ItemAbility);
	}
}
