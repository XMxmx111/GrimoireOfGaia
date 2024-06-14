package gaia.item.weapon;

import gaia.registry.GaiaRegistry;
import gaia.util.EnchantUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class FireFanItem extends FanItem {

	public FireFanItem(Properties properties) {
		super(properties);
	}

	@Override
	public void onCraftedBy(ItemStack stack, Level level, Player player) {
		super.onCraftedBy(stack, level, player);
		stack.enchant(EnchantUtil.getEnchantmentHolder(level, Enchantments.FIRE_ASPECT), 2);
		stack.enchant(EnchantUtil.getEnchantmentHolder(level, Enchantments.KNOCKBACK), 1);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return false;
	}

	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack repairStack) {
		return repairStack.is(GaiaRegistry.SOULFIRE.get());
	}
}
