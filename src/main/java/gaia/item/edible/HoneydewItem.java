package gaia.item.edible;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class HoneydewItem extends EdibleEffectItem {
	public HoneydewItem(Properties properties) {
		super(properties);
	}

	public int getUseDuration(ItemStack stack, LivingEntity livingEntity) {
		return 20;
	}

	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}
}
