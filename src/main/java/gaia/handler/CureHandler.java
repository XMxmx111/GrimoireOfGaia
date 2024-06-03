package gaia.handler;

import gaia.item.edible.TaprootItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

public class CureHandler {
	@SubscribeEvent
	public void onEffectAdded(MobEffectEvent.Added event) {
		MobEffectInstance instance = event.getEffectInstance();
		if (!instance.getEffect().value().isBeneficial()) {
			instance.getCures().add(TaprootItem.TAPROOT);
		}
	}
}
