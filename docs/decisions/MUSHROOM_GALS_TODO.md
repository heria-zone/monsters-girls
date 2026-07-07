# Mushroom Gals — Implementation TODO

**Last updated:** 2026-06-14  
**Based on:** Code audit of `monsters_girls-1.21.1` Common + Fabric modules  
**Status:** Infrastructure complete. Entity types registered. Feature implementation in progress.

---

## What's Already Done

| Family | Skins | Registered | Spawn | Genesis | Taming | Planting |
|---|---|---|---|---|---|---|
| Amanita | ✅ Red, Yellow, Pharia | ✅ | ✅ Forests/jungle/lush caves | ✅ Red mushroom (Overworld) | ✅ Cookie | ✅ Red mushroom |
| Brown | ✅ Boletus, Orange Birch, Ruby, Scarlatina | ✅ | ✅ Conifer/birch/dark forest/meadow | ✅ Brown mushroom (Overworld) | ✅ Cookie | ✅ Brown mushroom |
| Infernal | ✅ Red, Yellow | ✅ | ✅ Nether Wastes | ✅ Red/brown mushroom (Nether) | ✅ Cookie | ❌ |

All others: registered as entity types and renderers — but no spawn, no genesis, no taming, no bowl, no planting, no effects.

---

## Shared Work — Do This First

These touch every family. Build once, use everywhere.

### 1. Bowl Interaction System
Right-clicking a tamed mushroom gal with an empty `Bowl` gives a stew and consumes the bowl.

- [ ] Add a `BowlFeature` (or handle in `MushroomEntity.handleSpecificInteractions`) that checks for `Items.BOWL` in hand
- [ ] On success: remove bowl from hand, give the family-specific stew item, play sound
- [ ] Must be owner-only (check `isOwnedBy(player)`)
- [ ] Wire stew item reference into each family's `MushroomType` definition (or use a feature with a stew provider)
- [ ] Stew items needed (see Items section below)

### 2. Mushroom Stew Items
New items to register in `MonstersItems` + food properties in `MonstersFood`:

| Item key | Given by | Effect |
|---|---|---|
| `suspicious_stew_mushroom` | Amanita | Random flower effect (re-use vanilla suspicious stew logic or pick from a flower list) |
| `mushroom_stew` | Brown | Already vanilla — can use `Items.MUSHROOM_STEW` directly |
| `nether_stew` | Crimson, Infernal, Warped | Fire resistance |
| `poisonous_stew` | Inkcap | Poison |
| `molten_stew` | Molten | Blazing effect |
| `puffball_stew` | Puffball | Puffy effect (jump boost + slow falling) |
| `snowball_stew` | Snowball | Chilly effect (freeze/slow) |
| `soul_wanderer_stew` | Soul Wanderer | Soul Wanderer's touch (wither inflicted on next attack + regen) |

Note: Brown can simply give vanilla `Items.MUSHROOM_STEW` — no new item needed.  
Note: Suspicious stew for Amanita — consider giving the actual vanilla `Items.SUSPICIOUS_STEW` with a random flower effect applied via NBT on creation.

### 3. Custom Mob Effects
New `MobEffect` entries needed before stews can apply them:

| Effect | Mechanic |
|---|---|
| **Poisonous** | Player poisons enemies they attack or who attack them; player immune to poison |
| **Chilly** | Player freezes/slows enemies they attack; player immune to freeze |
| **Blazing** | Player immune to fire; player sets attacked enemies on fire |
| **Soul Wanderer's Touch** | Player inflicts wither on attacked enemies + short regen; player immune to wither |
| **Puffy** | High jump boost + slow falling |

These live in a new `MonstersEffects` registry class (Common module). Potions for each are a stretch goal — stews first.

### 4. `BiomesUtils` additions

- [ ] `NetherBiomes` — `NETHER_WASTES`, `CRIMSON_FOREST`, `WARPED_FOREST`, `SOUL_SAND_VALLEY`, `BASALT_DELTAS`, `NETHER_WASTES`
- [ ] `SnowyBiomes` — `ICE_SPIKES`, `SNOWY_PLAINS`, `SNOWY_TAIGA`, `FROZEN_PEAKS`, `JAGGED_PEAKS`, `SNOWY_SLOPES`
- [ ] `EndBiomes` — `THE_END`, `END_HIGHLANDS`, `END_MIDLANDS`, `SMALL_END_ISLANDS`, `END_BARRENS`
- [ ] `SoulSandValleyBiomes` — just `SOUL_SAND_VALLEY` (could be inline, but a constant is consistent)

---

## Per-Family Work

### Amanita Gal
- [ ] Bowl interaction → give `Items.SUSPICIOUS_STEW` with random flower effect applied via NBT

### Brown Gal
- [ ] Bowl interaction → give `Items.MUSHROOM_STEW`

### Crimson Gal (Red, Pink)
- [x] `SpawnFeature` → Crimson Forest, weight 8, groups 1–2, on `ANIMALS_SPAWNABLE_ON` blocks
- [x] `GenesisFeature` → triggers on `Blocks.CRIMSON_FUNGUS` in Nether
- [x] `FoodFeature` → taming with `Items.COOKIE`
- [x] `PlantingFeature` → plants `Blocks.CRIMSON_FUNGUS` on `Blocks.CRIMSON_NYLIUM`
- [x] `BiomeAppearanceFeature` → Red variant in Crimson Forest, Pink in Nether Wastes
- [x] Bowl interaction → give `nether_stew` (fire resistance)
- [x] Register genesis in `MonstersEntities.registerFeatures()`
- [x] Register spawn in `MonstersWorld.generateSpawn()`

### Infernal Gal (Red, Yellow)
*(Genesis + taming + Nether Wastes spawn already done)*
- [x] `PlantingFeature` → plants `Blocks.RED_MUSHROOM` and `Blocks.BROWN_MUSHROOM` on valid nether blocks
- [x] Bowl interaction → give `nether_stew` (fire resistance)
- [x] Register spawn in `MonstersWorld.generateSpawn()`

### Inkcap Gal (Dark, Pale, White)
*(No natural spawn by design — genesis-only)*
- [x] `GenesisFeature` → triggers on `MonstersBlocks.INKCAP_MUSHROOM` in Overworld
- [x] `FoodFeature` → taming with `Items.COOKIE`
- [x] `PlantingFeature` → plants inkcap mushroom block on `GRASS_BLOCK`, `MYCELIUM`, `PODZOL`
- [x] Bowl interaction → give `poisonous_stew` (poison effect)
- [x] Register genesis in `MonstersEntities.registerFeatures()`
- [ ] **Effect in combat:** on `hurt()` and `doHurtTarget()`, apply **Poisonous** effect to attacker/target

### Molten Gal
- [x] `SpawnFeature` → Basalt Deltas, weight 8, groups 1–2, on `ANIMALS_SPAWNABLE_ON` blocks
- [x] `GenesisFeature` → triggers on `MonstersBlocks.MOLTEN_FUNGUS` in Nether
- [x] `FoodFeature` → taming with `Items.BLAZE_POWDER`
- [x] `PlantingFeature` → plants molten fungi block on `Blocks.MAGMA_BLOCK`, `Blocks.BASALT`, `Blocks.BLACKSTONE`
- [x] Bowl interaction → give `molten_stew` (blazing effect)
- [x] Register genesis in `MonstersEntities.registerFeatures()`
- [x] Register spawn in `MonstersWorld.generateSpawn()`
- [ ] **Effect in combat:** `doHurtTarget()` → set target on fire; entity itself immune to fire
- [ ] **Special:** right-click with raw/cookable food in hand → cook it (give the cooked version, consume the raw)

### Puffball Gal (Default, Pale)
*(Puffball = Ender Gal in code)*
- [x] `SpawnFeature` → End biomes (`THE_END`, `END_HIGHLANDS`, etc.), weight 8, groups 1–2
- [x] `GenesisFeature` → triggers on `MonstersBlocks.ENDER_MUSHROOM` in The End
- [x] `FoodFeature` → taming with `Items.CHORUS_FRUIT`
- [x] `PlantingFeature` → plants ender mushroom block on `Blocks.END_STONE`
- [x] Bowl interaction → give `puffball_stew` (Puffy effect: jump boost + slow falling)
- [x] Register genesis in `MonstersEntities.registerFeatures()`
- [x] Register spawn in `MonstersWorld.generateSpawn()`
- [ ] **Special:** owner gets **Puffy** effect passively while Puffball Gal is nearby/following
- [ ] Note: "Fluffball can fly" — Pale variant may need `FlyTamableEntity` base instead

### Snowball Gal
- [x] `SpawnFeature` → Ice Spikes, Snowy Plains, Frozen Peaks, etc., weight 8, groups 1–2
- [x] `GenesisFeature` → triggers on `MonstersBlocks.SNOWBALL_MUSHROOM` in Overworld
- [x] `FoodFeature` → taming with `Items.SNOWBALL`
- [x] `PlantingFeature` → plants snowball mushroom block on `Blocks.SNOW_BLOCK`, `Blocks.MYCELIUM`
- [x] Bowl interaction → give `snowball_stew` (Chilly effect)
- [x] Register genesis in `MonstersEntities.registerFeatures()`
- [x] Register spawn in `MonstersWorld.generateSpawn()`
- [ ] **Effect in combat:** `doHurtTarget()` → apply freeze/slow to target; entity immune to freeze
- [ ] **Special:** can walk on powder snow without sinking

### Soul Wanderer Gal
- [ ] `SpawnFeature` → Soul Sand Valley, weight 6, groups 1–1 (rare)
- [ ] `GenesisFeature` → triggers on a custom `soul_wanderer_fungus` block or `Blocks.SOUL_SOIL`
- [ ] `FoodFeature` → multi-item taming: `Items.ROTTEN_FLESH`, `Items.COOKIE`, `Items.NETHER_WART` (any one of them works)
- [ ] `PlantingFeature` → plants soul wanderer fungus block on `Blocks.SOUL_SAND`, `Blocks.SOUL_SOIL`
- [ ] Bowl interaction → give `soul_wanderer_stew` (Soul Wanderer's Touch effect)
- [ ] **Effect in combat:** `doHurtTarget()` → apply wither to target + give owner short Regeneration; entity immune to wither
- [ ] **Special:** deals 2× damage to undead mobs (check `target instanceof Undead` in `doHurtTarget()`)
- [ ] Register genesis in `MonstersEntities.registerFeatures()`

### Warped Gal (Green slim/tummy, Blue slim/tummy)
- [ ] `SpawnFeature` → Warped Forest, weight 8, groups 1–2
- [ ] `GenesisFeature` → triggers on `Blocks.WARPED_FUNGUS` in Nether
- [ ] `FoodFeature` → taming item (design decision: warped fungus? crimson fungus? cookie?)
- [ ] `PlantingFeature` → plants `Blocks.WARPED_FUNGUS` on `Blocks.WARPED_NYLIUM`
- [ ] Bowl interaction → give `nether_stew` (fire resistance)
- [ ] **Belly system fix:** override `supportsTummyTexture()` to return `true` for Warped — it's the only family with tummy textures authored
- [ ] Fix `handleBellyProgression()` in `MonsterEntity` — currently uses string replacement (`"default"` → `"tummy"`) which breaks for Warped; route through `getTextureVariantForBellyState()` instead
- [ ] Register genesis in `MonstersEntities.registerFeatures()`

---

## Code-Level Fixes (Bugs in Current Code)

These are independent of family work — fix them as part of the same pass:

- [ ] **`supportsTummyTexture()` returns false for all families** — Warped has tummy textures, needs `return true` override or a per-instance flag
- [ ] **`handleBellyProgression()` uses naive string replace** — doesn't call `getTextureVariantForBellyState()`; fix to use the proper method
- [ ] **`configureVariants()` fallback sets `FoodFeature(COOKIE)` on all types** — verify this doesn't accidentally tame families that should be wild-only (Molten, Puffball, Snowball, Soul Wanderer taming items are not cookies)
- [ ] **Brown light-level spawn check commented out** — intentional or forgotten? Decide and either remove the comment or re-enable it

---

## New Blocks Needed

Several families need custom block types that don't exist yet. These go in a new `MonstersBlocks` registry:

| Block | Used by |
|---|---|
| `inkcap_mushroom` | Inkcap genesis trigger + planting target |
| `molten_fungus` | Molten genesis trigger + planting target |
| `ender_mushroom` / `puffball_mushroom` | Puffball genesis trigger + planting target |
| `snowball_mushroom` | Snowball genesis trigger + planting target |
| `soul_wanderer_fungus` | Soul Wanderer genesis trigger + planting target |

These can be simple mushroom-like blocks (non-growing, decorative) until more complex behavior is needed.

---

## Order of Attack

1. **Bowl system + stew items** — shared foundation, unblocks everything
2. **Custom effects** — needed before stews can apply them
3. **Missing biome lists in `BiomesUtils`** — needed before spawn rules can reference them
4. **New blocks** — needed before genesis/planting can work for those families
5. **Crimson + Warped + Infernal** — nether families, all straightforward, no new effects
6. **Inkcap** — poison effect, genesis-only spawn
7. **Snowball** — freeze effect, powder snow walk
8. **Soul Wanderer** — wither+regen effect, undead bonus, multi-item taming
9. **Molten** — fire effect + food cooking special
10. **Puffball** — jump/slow fall passive, possible Pale = fly variant decision
11. **Bug fixes** (belly system, taming fallback) — can happen any time, low risk
