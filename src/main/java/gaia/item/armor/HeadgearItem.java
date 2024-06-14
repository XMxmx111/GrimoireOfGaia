package gaia.item.armor;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeadgearItem extends Item {

	public HeadgearItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, context, list, flag);
		list.add(Component.translatable("text.grimoireofgaia.headgear.tag").withStyle(ChatFormatting.YELLOW));
	}

	@Nullable
	@Override
	public EquipmentSlot getEquipmentSlot(ItemStack stack) {
		return EquipmentSlot.HEAD;
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		EquipmentSlot slot = player.getEquipmentSlotForItem(stack);
		ItemStack slotStack = player.getItemBySlot(slot);
		if (slotStack.isEmpty()) {
			player.setItemSlot(slot, stack.copy());
			if (!level.isClientSide()) {
				player.awardStat(Stats.ITEM_USED.get(this));
			}

			stack.setCount(0);
			return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
		} else {
			return InteractionResultHolder.fail(stack);
		}
	}
}
