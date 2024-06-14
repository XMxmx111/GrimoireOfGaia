package gaia.item.accessory;

import gaia.GrimoireOfGaia;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class KnucklesItem extends AbstractAccessoryItem {
	private static final int damage = 2;
	private static final ResourceLocation BOOST_UUID = ResourceLocation.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "knuckles_damage_boost");
	private static final AttributeModifier BOOST = new AttributeModifier(BOOST_UUID, (double) damage, Operation.ADD_VALUE);

	public KnucklesItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, context, list, flag);
		list.add(Component.translatable("text.grimoireofgaia.charm.tag").withStyle(ChatFormatting.YELLOW));

		if (Screen.hasShiftDown()) {
			list.add(Component.translatable("text.grimoireofgaia.charm.damage", damage));
		} else {
			list.add(Component.translatable("text.grimoireofgaia.hold_shift").withStyle(ChatFormatting.ITALIC));
		}
	}

	@Override
	public boolean isModifier() {
		return true;
	}

	@Override
	public void doEffect(LivingEntity player, ItemStack stack) {
	}

	@Override
	public void applyModifier(LivingEntity player, ItemStack stack) {
		AttributeInstance attribute = player.getAttribute(Attributes.ATTACK_DAMAGE);
		if (!attribute.hasModifier(BOOST_UUID)) {
			attribute.addTransientModifier(BOOST);
		}
	}

	@Override
	public void removeModifier(LivingEntity player, ItemStack stack) {
		AttributeInstance attribute = player.getAttribute(Attributes.ATTACK_DAMAGE);
		if (attribute.hasModifier(BOOST_UUID)) {
			attribute.removeModifier(BOOST_UUID);
		}
	}
}
