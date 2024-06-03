package gaia.item.edible;

import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EdibleEffectItem extends Item {
	public EdibleEffectItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, context, list, flag);
		FoodProperties foodProperties = stack.getFoodProperties(null);
		if (foodProperties != null) {
			for (FoodProperties.PossibleEffect possibleEffect : foodProperties.effects()) {
				MobEffectInstance effect = possibleEffect.effect();
				int totalSeconds = effect.getDuration() / 20;
				int minutes = (totalSeconds % 3600) / 60;
				int seconds = totalSeconds % 60;
				list.add(Component.translatable(effect.getDescriptionId()).append(Component.literal(" (" + minutes + ":" + seconds + ")")).withStyle(ChatFormatting.GRAY));
			}
		}
	}

	protected void rewardEXP(Player player, int value) {
		Level level = player.level();
		ExperienceOrb orb = new ExperienceOrb(level, player.getX(), player.getY() + 1, player.getZ(), value);
		if (!level.isClientSide) {
			level.addFreshEntity(orb);
		}
	}
}
