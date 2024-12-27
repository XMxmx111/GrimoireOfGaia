package gaia.compat.curios;

import gaia.item.accessory.AbstractAccessoryItem;
import gaia.registry.GaiaRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.List;

public class CuriosCompat {
	public static void registerCapabilities(final RegisterCapabilitiesEvent evt) {
		List<? extends Item> accessoryItems = GaiaRegistry.ITEMS.getEntries().stream()
				.filter(entry -> entry.get() instanceof AbstractAccessoryItem)
				.map(DeferredHolder::get).toList();

		evt.registerItem(
				CuriosCapability.ITEM,
				(stack, context) -> new ICurio() {

					@Override
					public ItemStack getStack() {
						return stack;
					}

					@Override
					public void curioTick(SlotContext slotContext) {
						if (stack.getItem() instanceof AbstractAccessoryItem accessory) {
							accessory.onTick(slotContext.entity(), stack);
						}
					}

					@Override
					public void onEquip(SlotContext slotContext, ItemStack prevStack) {
						if (stack.getItem() instanceof AbstractAccessoryItem accessory) {
							accessory.onEquip(slotContext.entity(), stack);
						}
					}

					@Override
					public void onUnequip(SlotContext slotContext, ItemStack newStack) {
						if (stack.getItem() instanceof AbstractAccessoryItem accessory) {
							accessory.onUnequip(slotContext.entity(), stack);
						}
					}
				}, accessoryItems.toArray(new Item[0]));
	}
}
