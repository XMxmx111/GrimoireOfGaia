package gaia.registry.helper;

import gaia.registry.GaiaRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Helper class for registering mob's with spawn eggs.
 */
public class PropReg<T extends Mob> {
	protected final String name;
	protected final Supplier<EntityType<? extends T>> entityType;
	protected final DeferredItem<Item> spawnEgg;

	/**
	 * @return The registry name of the mob
	 */
	@NotNull
	public String getName() {
		return name;
	}

	/**
	 * @return The entity type registry object of the mob.
	 */
	public EntityType<? extends T> getEntityType() {
		return entityType.get();
	}

	/**
	 * @return The spawn egg item registry object of the mob.
	 */
	public DeferredItem<Item> getSpawnEgg() {
		return spawnEgg;
	}

	public PropReg(String name, EntityType.Builder<T> builder, int backgroundColor, int highlightColor) {
		this.name = name;
		this.entityType = GaiaRegistry.ENTITIES.register(name, () -> builder.build(name));
		this.spawnEgg = GaiaRegistry.ITEMS.register(name + "_spawn_egg", () -> new DeferredSpawnEggItem(this.entityType, backgroundColor, highlightColor,
				new Item.Properties()));
	}
}
