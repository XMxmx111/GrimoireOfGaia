package gaia.datagen.server;

import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import gaia.GrimoireOfGaia;
import gaia.modifier.AddGaiaSpawnModifier;
import gaia.registry.GaiaRegistry;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GaiaBiomeModifiers {
	private static final TagKey<Biome> NO_DEFAULT_MONSTERS = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("forge", "no_default_monsters"));

	public static Map<ResourceLocation, BiomeModifier> getBiomeModifiers(RegistryOps<JsonElement> ops) {
		Map<ResourceLocation, BiomeModifier> map = Maps.newHashMap();

		List<TagKey<Biome>> overworld = List.of(BiomeTags.IS_OVERWORLD);
		List<TagKey<Biome>> notPeaceful = List.of(BiomeTags.HAS_ANCIENT_CITY, Tags.Biomes.IS_MUSHROOM, NO_DEFAULT_MONSTERS);

		List<TagKey<Biome>> overworldSandy = List.of(BiomeTags.IS_OVERWORLD, Tags.Biomes.IS_SANDY);
		List<TagKey<Biome>> notBadlands = List.of(BiomeTags.IS_BADLANDS);
		map.putAll(generateBiomeModifier(ops, "add_ant_hill",
				overworldSandy, notBadlands,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.ANT_HILL.getEntityType(), 20, 1, 1))
		);

		map.putAll(generateBiomeModifier(ops, "add_ant_salvager",
				overworldSandy, notBadlands,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.ANT_SALVAGER.getEntityType(), 20, 2, 5))
		);

		map.putAll(generateBiomeModifier(ops, "add_anubis",
				overworldSandy, notBadlands,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.ANUBIS.getEntityType(), 20, 2, 4))
		);

		map.putAll(generateBiomeModifier(ops, "add_mummy",
				overworldSandy, notBadlands,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MUMMY.getEntityType(), 100, 2, 4))
		);

		map.putAll(generateBiomeModifier(ops, "add_sphinx",
				overworldSandy, notBadlands,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SPHINX.getEntityType(), 10, 1, 1))
		);

		map.putAll(generateBiomeModifier(ops, "add_arachne",
				overworld, notPeaceful,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.ARACHNE.getEntityType(), 80, 1, 2))
		);

		map.putAll(generateBiomeModifier(ops, "add_bone_knight",
				overworld, notPeaceful,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.BONE_KNIGHT.getEntityType(), 40, 1, 2))
		);

		map.putAll(generateBiomeModifier(ops, "add_creep",
				overworld, notPeaceful,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.CREEP.getEntityType(), 80, 2, 4))
		);

		map.putAll(generateBiomeModifier(ops, "add_deathword",
				overworld, notPeaceful,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.DEATHWORD.getEntityType(), 40, 1, 2))
		);

		map.putAll(generateBiomeModifier(ops, "add_ender_eye",
				overworld, notPeaceful,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.ENDER_EYE.getEntityType(), 40, 2, 4))
		);

		map.putAll(generateBiomeModifier(ops, "add_flesh_lich",
				overworld, notPeaceful,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.FLESH_LICH.getEntityType(), 40, 1, 2))
		);

		map.putAll(generateBiomeModifier(ops, "add_mimic",
				overworld, notPeaceful,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MIMIC.getEntityType(), 40, 1, 1))
		);

		List<TagKey<Biome>> overworldPlateau = List.of(BiomeTags.IS_OVERWORLD, Tags.Biomes.IS_PLATEAU);
		List<TagKey<Biome>> overworldMountain = List.of(BiomeTags.IS_OVERWORLD, Tags.Biomes.IS_MOUNTAIN);
		List<TagKey<Biome>> notColdHotDense = List.of(Tags.Biomes.IS_COLD, Tags.Biomes.IS_HOT, Tags.Biomes.IS_DENSE);
		List<TagKey<Biome>> notHotDense = List.of(Tags.Biomes.IS_HOT, Tags.Biomes.IS_DENSE);
		map.putAll(generateBiomeModifier(ops, "add_banshee",
				overworldPlateau, notColdHotDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.BANSHEE.getEntityType(), 40, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_mountain_banshee",
				overworldMountain, notHotDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.BANSHEE.getEntityType(), 40, 2, 4))
		);

		map.putAll(generateBiomeModifier(ops, "add_dullahan",
				overworldPlateau, notColdHotDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.DULLAHAN.getEntityType(), 100, 4, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_mountain_dullahan",
				overworldMountain, notHotDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.DULLAHAN.getEntityType(), 100, 4, 6))
		);

		map.putAll(generateBiomeModifier(ops, "add_dwarf",
				overworldPlateau, notColdHotDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.DWARF.getEntityType(), 30, 4, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_mountain_dwarf",
				overworldMountain, notHotDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.DWARF.getEntityType(), 30, 4, 6))
		);

		map.putAll(generateBiomeModifier(ops, "add_gryphon",
				overworldPlateau, notColdHotDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.GRYPHON.getEntityType(), 80, 1, 2))
		);
		map.putAll(generateBiomeModifier(ops, "add_mountain_gryphon",
				overworldMountain, notHotDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.GRYPHON.getEntityType(), 100, 1, 2))
		);

		map.putAll(generateBiomeModifier(ops, "add_valkyrie",
				overworldPlateau, notColdHotDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.VALKYRIE.getEntityType(), 10, 1, 2))
		);
		map.putAll(generateBiomeModifier(ops, "add_mountain_valkyrie",
				overworldMountain, notHotDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.VALKYRIE.getEntityType(), 10, 1, 2))
		);

		List<TagKey<Biome>> coldDryEnd = List.of(BiomeTags.IS_END, Tags.Biomes.IS_COLD_END, Tags.Biomes.IS_DRY_END);
		map.putAll(generateBiomeModifier(ops, "add_behender",
				coldDryEnd, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.BEHENDER.getEntityType(), 1, 1, 1))
		);
		map.putAll(generateBiomeModifier(ops, "add_ender_dragon_girl",
				coldDryEnd, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.ENDER_DRAGON_GIRL.getEntityType(), 1, 1, 1))
		);

		List<TagKey<Biome>> overworldBeach = List.of(BiomeTags.IS_OVERWORLD, BiomeTags.IS_BEACH);
		List<TagKey<Biome>> overworldWater = List.of(BiomeTags.IS_OVERWORLD, Tags.Biomes.IS_WATER);
		map.putAll(generateBiomeModifier(ops, "add_cecaelia",
				overworldBeach, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.CECAELIA.getEntityType(), 80, 4, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_water_cecaelia",
				overworldWater, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.CECAELIA.getEntityType(), 80, 4, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_mermaid",
				overworldBeach, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MERMAID.getEntityType(), 40, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_water_mermaid",
				overworldWater, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MERMAID.getEntityType(), 40, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_sharko",
				overworldBeach, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SHARKO.getEntityType(), 40, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_water_sharko",
				overworldWater, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SHARKO.getEntityType(), 40, 2, 4))
		);

		List<TagKey<Biome>> overworldSwamp = List.of(BiomeTags.IS_OVERWORLD, Tags.Biomes.IS_SWAMP);
		map.putAll(generateBiomeModifier(ops, "add_gelatinous_slime",
				overworldSwamp, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.GELATINOUS_SLIME.getEntityType(), 80, 1, 2))
		);
		map.putAll(generateBiomeModifier(ops, "add_naga",
				overworldSwamp, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.NAGA.getEntityType(), 30, 1, 2))
		);
		map.putAll(generateBiomeModifier(ops, "add_siren",
				overworldSwamp, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SIREN.getEntityType(), 60, 4, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_sludge_girl",
				overworldSwamp, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SLUDGE_GIRL.getEntityType(), 100, 2, 4))
		);

		List<TagKey<Biome>> overworldJungle = List.of(BiomeTags.IS_OVERWORLD, BiomeTags.IS_JUNGLE);
		map.putAll(generateBiomeModifier(ops, "add_cobble_golem",
				overworldJungle, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.COBBLE_GOLEM.getEntityType(), 60, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_cobblestone_golem",
				overworldJungle, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.COBBLESTONE_GOLEM.getEntityType(), 60, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_hunter",
				overworldJungle, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.HUNTER.getEntityType(), 60, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_shaman",
				overworldJungle, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SHAMAN.getEntityType(), 60, 2, 4))
		);

		List<TagKey<Biome>> overworldSpookyForest = List.of(BiomeTags.IS_OVERWORLD, BiomeTags.IS_FOREST, Tags.Biomes.IS_SPOOKY);
		map.putAll(generateBiomeModifier(ops, "add_matango",
				overworldSpookyForest, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MATANGO.getEntityType(), 60, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_toad",
				overworldSpookyForest, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.TOAD.getEntityType(), 80, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_witch",
				overworldSpookyForest, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.WITCH.getEntityType(), 60, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_wizard_harpy",
				overworldSpookyForest, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.WIZARD_HARPY.getEntityType(), 60, 1, 2))
		);
		List<TagKey<Biome>> overworldPlains = List.of(BiomeTags.IS_OVERWORLD, Tags.Biomes.IS_PLAINS);
		List<TagKey<Biome>> overworldBadlands = List.of(BiomeTags.IS_OVERWORLD, BiomeTags.IS_BADLANDS);
		List<TagKey<Biome>> notSavanna = List.of(BiomeTags.IS_SAVANNA);
		map.putAll(generateBiomeModifier(ops, "add_plains_centaur",
				overworldPlains, notSavanna,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.CENTAUR.getEntityType(), 20, 4, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_badlands_centaur",
				overworldBadlands, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.CENTAUR.getEntityType(), 20, 4, 6))
		);

		map.putAll(generateBiomeModifier(ops, "add_plains_satyress",
				overworldPlains, notSavanna,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SATYRESS.getEntityType(), 20, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_badlands_satyress",
				overworldBadlands, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SATYRESS.getEntityType(), 20, 2, 4))
		);

		map.putAll(generateBiomeModifier(ops, "add_plains_harpy",
				overworldPlains, notSavanna,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.HARPY.getEntityType(), 100, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_badlands_harpy",
				overworldBadlands, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.HARPY.getEntityType(), 100, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_forest_harpy",
				overworldSpookyForest, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.HARPY.getEntityType(), 100, 2, 4))
		);

		map.putAll(generateBiomeModifier(ops, "add_plains_minotaur",
				overworldPlains, notSavanna,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MINOTAUR.getEntityType(), 10, 1, 1))
		);
		map.putAll(generateBiomeModifier(ops, "add_badlands_minotaur",
				overworldBadlands, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MINOTAUR.getEntityType(), 10, 1, 1))
		);
		map.putAll(generateBiomeModifier(ops, "add_forest_minotaur",
				overworldSpookyForest, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MINOTAUR.getEntityType(), 10, 1, 1))
		);

		map.putAll(generateBiomeModifier(ops, "add_plains_minotaurus",
				overworldPlains, notSavanna,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MINOTAURUS.getEntityType(), 80, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_badlands_minotaurus",
				overworldBadlands, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MINOTAURUS.getEntityType(), 80, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_forest_minotaurus",
				overworldSpookyForest, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.MINOTAURUS.getEntityType(), 80, 2, 4))
		);

		List<TagKey<Biome>> overworldSavanna = List.of(BiomeTags.IS_OVERWORLD, BiomeTags.IS_SAVANNA);
		map.putAll(generateBiomeModifier(ops, "add_goblin",
				overworldSavanna, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.GOBLIN.getEntityType(), 30, 2, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_orc",
				overworldSavanna, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.ORC.getEntityType(), 80, 2, 6))
		);

		List<TagKey<Biome>> nether = List.of(BiomeTags.IS_NETHER);
		map.putAll(generateBiomeModifier(ops, "add_succubus",
				nether, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SUCCUBUS.getEntityType(), 16, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_wither_cow",
				nether, null,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.WITHER_COW.getEntityType(), 12, 2, 4))
		);

		List<TagKey<Biome>> overworldConiferous = List.of(BiomeTags.IS_OVERWORLD, Tags.Biomes.IS_CONIFEROUS);
		List<TagKey<Biome>> notSnowy = List.of(Tags.Biomes.IS_SNOWY);
		map.putAll(generateBiomeModifier(ops, "add_cyclops",
				overworldConiferous, notSnowy,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.CYCLOPS.getEntityType(), 40, 4, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_nine_tails",
				overworldConiferous, notSnowy,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.NINE_TAILS.getEntityType(), 40, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_oni",
				overworldConiferous, notSnowy,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.ONI.getEntityType(), 80, 4, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_yuki_onna",
				overworldConiferous, notSnowy,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.YUKI_ONNA.getEntityType(), 60, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_coniferous_forest_mandragora",
				overworldConiferous, notSnowy,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.CYAN_FLOWER.getEntityType(), 60, 1, 2))
		);

		List<TagKey<Biome>> overworldForest = List.of(BiomeTags.IS_OVERWORLD, BiomeTags.IS_FOREST);
		List<TagKey<Biome>> notConiferousColdHotSparseSpookyDense = List.of(Tags.Biomes.IS_CONIFEROUS, Tags.Biomes.IS_COLD_OVERWORLD, Tags.Biomes.IS_HOT_OVERWORLD,
				Tags.Biomes.IS_SPARSE, Tags.Biomes.IS_SPOOKY, Tags.Biomes.IS_DENSE);
		map.putAll(generateBiomeModifier(ops, "add_bee",
				overworldForest, notConiferousColdHotSparseSpookyDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.BEE.getEntityType(), 80, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_dryad",
				overworldForest, notConiferousColdHotSparseSpookyDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.DRYAD.getEntityType(), 60, 4, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_forest_mandragora",
				overworldForest, notConiferousColdHotSparseSpookyDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.CYAN_FLOWER.getEntityType(), 60, 1, 2))
		);
		map.putAll(generateBiomeModifier(ops, "add_spriggan",
				overworldForest, notConiferousColdHotSparseSpookyDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SPRIGGAN.getEntityType(), 40, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_werecat",
				overworldForest, notConiferousColdHotSparseSpookyDense,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.WERECAT.getEntityType(), 80, 4, 6))
		);

		List<TagKey<Biome>> overworldRareDenseForest = List.of(BiomeTags.IS_OVERWORLD, BiomeTags.IS_FOREST, Tags.Biomes.IS_DENSE, Tags.Biomes.IS_RARE);
		List<TagKey<Biome>> notConiferousColdHotSparseSpooky = List.of(Tags.Biomes.IS_CONIFEROUS, Tags.Biomes.IS_COLD, Tags.Biomes.IS_HOT,
				Tags.Biomes.IS_SPARSE, Tags.Biomes.IS_SPOOKY);
		map.putAll(generateBiomeModifier(ops, "add_dense_forest_bee",
				overworldRareDenseForest, notConiferousColdHotSparseSpooky,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.BEE.getEntityType(), 80, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_dense_forest_mandragora",
				overworldRareDenseForest, notConiferousColdHotSparseSpooky,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.CYAN_FLOWER.getEntityType(), 60, 1, 2))
		);
		map.putAll(generateBiomeModifier(ops, "add_dense_forest_dryad",
				overworldRareDenseForest, notConiferousColdHotSparseSpooky,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.DRYAD.getEntityType(), 60, 4, 6))
		);
		map.putAll(generateBiomeModifier(ops, "add_dense_forest_spriggan",
				overworldRareDenseForest, notConiferousColdHotSparseSpooky,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.SPRIGGAN.getEntityType(), 40, 2, 4))
		);
		map.putAll(generateBiomeModifier(ops, "add_dense_forest_werecat",
				overworldRareDenseForest, notConiferousColdHotSparseSpooky,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.WERECAT.getEntityType(), 80, 4, 6))
		);

		List<TagKey<Biome>> overworldSnowy = List.of(BiomeTags.IS_OVERWORLD, Tags.Biomes.IS_SNOWY);
		List<TagKey<Biome>> notOceanRiverBeachForest = List.of(BiomeTags.IS_OCEAN, BiomeTags.IS_RIVER, BiomeTags.IS_BEACH, BiomeTags.IS_FOREST);
		map.putAll(generateBiomeModifier(ops, "add_kobold",
				overworldSnowy, notOceanRiverBeachForest,
				new MobSpawnSettings.SpawnerData(GaiaRegistry.KOBOLD.getEntityType(), 60, 4, 6))
		);

		return map;
	}

	private static Map<ResourceLocation, BiomeModifier> generateBiomeModifier(RegistryOps<JsonElement> ops,
																			  String name,
																			  @NotNull List<TagKey<Biome>> tags,
																			  @Nullable List<TagKey<Biome>> blacklistTags,
																			  MobSpawnSettings.SpawnerData spawner) {
		final List<HolderSet<Biome>> tagHolders = tags.stream().map(tag -> new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), tag)).collect(Collectors.toList());
		final List<HolderSet<Biome>> blacklistTagHolders = (blacklistTags == null || blacklistTags.isEmpty()) ? List.of() : blacklistTags.stream().map(tag -> new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), tag)).collect(Collectors.toList());
		final BiomeModifier addFeature = AddGaiaSpawnModifier.singleSpawn(tagHolders, blacklistTagHolders, spawner);
		return Map.of(new ResourceLocation(GrimoireOfGaia.MOD_ID, name), addFeature);
	}
}
