package gaia.attachment;

import gaia.GrimoireOfGaia;
import gaia.attachment.friended.Friended;
import gaia.entity.AbstractGaiaEntity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class AttachmentHandler {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, GrimoireOfGaia.MOD_ID);

	private static final Supplier<AttachmentType<Friended>> FRIENDED = ATTACHMENT_TYPES.register(
			"friended", () -> AttachmentType.builder(Friended::new).build()
	);

	public static Friended getFriended(LivingEntity livingEntity) {
		if(livingEntity instanceof AbstractGaiaEntity) {
			return livingEntity.getData(FRIENDED);
		} else {
			return null; //Do not attach this to non-gaia entities
		}
	}
}
