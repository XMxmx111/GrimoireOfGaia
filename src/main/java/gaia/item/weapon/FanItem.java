package gaia.item.weapon;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class FanItem extends Item {

	public FanItem(Properties properties) {
		super(properties.durability(780).rarity(Rarity.RARE));
	}

	public static ItemAttributeModifiers createAttributes(float attackDamage) {
		return ItemAttributeModifiers.builder()
				.add(
						Attributes.ATTACK_DAMAGE,
						new AttributeModifier(
								BASE_ATTACK_DAMAGE_UUID,
								"Weapon modifier",
								(double) attackDamage,
								AttributeModifier.Operation.ADD_VALUE
						),
						EquipmentSlotGroup.MAINHAND
				)
				.add(
						Attributes.ATTACK_SPEED,
						new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double) -2.4000000953674316D, AttributeModifier.Operation.ADD_VALUE),
						EquipmentSlotGroup.MAINHAND
				)
				.build();
	}

	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack repairStack) {
		return repairStack.is(Items.PAPER);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (!attacker.level().isClientSide) {
			stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
		}
		return super.hurtEnemy(stack, target, attacker);
	}

	@Override
	public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity livingEntity) {
		if (!level.isClientSide) {
			stack.hurtAndBreak(2, livingEntity, EquipmentSlot.MAINHAND);
		}

		return true;
	}
}
