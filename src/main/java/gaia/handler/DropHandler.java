package gaia.handler;

import gaia.Reference;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

public class DropHandler {

	@SubscribeEvent
	public void onLivingDrop(LivingDropsEvent event) {
		LivingEntity livingEntity = event.getEntity();
		if (livingEntity.getPersistentData().contains(Reference.SUMMONED_TAG)) {
			event.getDrops().clear();
		}
	}
}
