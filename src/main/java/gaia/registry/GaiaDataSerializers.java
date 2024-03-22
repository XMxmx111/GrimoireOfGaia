package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class GaiaDataSerializers {
	public static final DeferredRegister<EntityDataSerializer<?>> DATA_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, GrimoireOfGaia.MOD_ID);

	public static final Supplier<EntityDataSerializer<ResourceLocation>> RESOURCE_LOCATION = DATA_SERIALIZERS.register("resource_location", () ->
			new EntityDataSerializer<ResourceLocation>() {
				@Override
				public void write(FriendlyByteBuf buf, ResourceLocation value) {
					buf.writeResourceLocation(value);
				}

				@Override
				public ResourceLocation read(FriendlyByteBuf buf) {
					return buf.readResourceLocation();
				}

				@Override
				public ResourceLocation copy(ResourceLocation value) {
					return new ResourceLocation(value.getNamespace(), value.getPath());
				}
			}
	);
}
