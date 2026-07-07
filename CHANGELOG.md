# Changelog

All notable changes to Monsters & Girls will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/)
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [Unreleased]

- Save migration from 1.20.1 format (integer IDs → string variant keys, flat → structured compound)
- Mushroom hat armor items (12 helmet variants from 1.20.1)
- Bowl interaction wiring for remaining mushroom families beyond Amanita and Brown
- Inkcap `doHurtTarget()` poison effect via `EmanationFeature`
- Molten food-cooking special interaction
- Puffball passive Puffy aura (owner jump boost while nearby)
- Snowball powder-snow walk (`onBlockStartBreak` / `shouldSkipMovement` override)
- Soul Wanderer spawn and genesis wiring
- Warped spawn and genesis wiring
- Potion recipes for custom mob effects
- `supportsTummyTexture()` / `handleBellyProgression()` bug fix (Warped belly textures)
- Forge and NeoForge builds

---

## [1.3.0] - 2026-07-04

Complete rebuild on the HZLib entity framework. Minecraft 1.21.1, Fabric only.

> **Save compatibility:** 1.20.1 saves are not compatible with this release. The data
> format changed from integer IDs and flat NBT to string variant keys and structured
> `EntityData` compounds. Migration path tracked in `[Unreleased]`.

### Removed

**Entity type consolidation — 29 separate classes → 12 family classes:**

| Removed (1.20.1) | Replaced by (1.21.1) |
|---|---|
| `mandrake_girl_brown`, `mandrake_girl_green` | `MandrakeFamily` (merged into Fructus variant) |
| `mandrake_girl_chorus` | `MandrakeFamily` (Chorus variant) |
| `mandrake_girl_glow_berry` | `MandrakeFamily` (Fructus variant — renamed) |
| `mushroom_girl_red`, `mushroom_girl_yellow` | `MushroomFamily` (Amanita — merged) |
| `mushroom_girl_crimson`, `mushroom_girl_crimson_rare` | `MushroomFamily` (Crimson — rare is now a texture variant) |
| `mushroom_girl_warped`, `mushroom_girl_warped_rare` | `MushroomFamily` (Warped — rare is now a texture variant) |
| `mushroom_girl_ink_cap` | `MushroomFamily` (Inkcaps) |
| `mushroom_girl_ender_puffball` | `MushroomFamily` (Puffball) |
| `mushroom_girl_brown`, `mushroom_girl_infernal`, `mushroom_girl_molten_fungus`, `mushroom_girl_soul_wanderer`, `mushroom_girl_snowball` | Respective `MushroomFamily` entries |
| `gourdragora_girl_pumpkin` (3 size classes) | `GourdragoraFamily` (Golden — sizes via `SizeVariantFeature`) |
| `gourdragora_girl_jack_lantern` (3 size classes) | `GourdragoraFamily` (Jack'o — sizes via `SizeVariantFeature`) |
| `spook_girl_peach`, `spook_girl_teal` | `SpookFamily` (3 variants including new Cream) |
| `wisp_girl_blue`, `wisp_girl_green`, `wisp_girl_yellow` | `WispFamily` (3 variants) |
| `bee_girl` | `BeeFamily` (5 variants) |
| `slime_girl` | `SlimeFamily` |
| 12 mushroom hat helmet items | Not yet ported — tracked in `[Unreleased]` |
| Per-entity `interactMob` overrides | `ExchangeFeature` declarative rules |
| Per-entity bespoke renderer classes for emissive glow | `OverlayFeature` (ALWAYS slot) |
| `TextureID` integer offset for belly state | `BellyLevel` enum + `BellyFeature` |

### Added

**Architecture**
- All entity types migrated from standalone Fabric classes to `MonstersFamily<T>` extending `NativeEntityFamily<T>` (HZLib)
- `NativeEntityType<T>` → `MonstersFamily<T>` rename aligning with ADR_018 ecosystem terminology
- Multi-loader project structure (Fabric active, Forge/NeoForge pending)
- `MonstersEntities` — centralised entity registration via HZLib platform services
- `MonstersSounds` — centralised sound event registry replacing bespoke per-class sound handling

**New Entity Families**
- `GlobberieFamily` — 3 variants (Pink, Pink Twintails, Yellow). New species.
- `MaidenFamily` — new species, single variant
- `MushroomFamily.Fluffball` — flying subspecies of Puffball; `FlyTamableEntity` base; End biomes; rarer spawn weight (4)
- `GourdragoraFamily.Lumina` — new colour family, no 1.20.1 equivalent

**Entity Family Details**

*Mandrake (3 families):*
- `MandrakeFamily` consolidates 4 classes into 3 families: Chorus, Flower, Fructus
- Biome-aware spawn texture selection per variant
- Per-variant ambient sounds; shared hurt and death sounds
- Animation-linked sounds for `sing` and `sing2` (Flower variant)

*Mushroom Gals (11 families):*
- `MushroomFamily` — 11 families covering all biomes and dimensions; each carries composable features
- `ConditionalAppearanceFeature` for biome-conditional spawn texture: Amanita (Pharia/Yellow/Red by biome), Brown (Ruby/Scarlatina/Orange Birch/Boletus by biome)
- `GenesisFeature` per family with dimension and biome filters; most-specific-match resolution
- `PlantingFeature` per family planting native block on appropriate surfaces
- `FoodFeature` for taming; Molten taming item changed Cookie → Blaze Powder; Puffball Cookie → Chorus Fruit
- `EmanationFeature` on Molten (ignite targets), Snowball (slow + freeze), Soul Wanderer (wither + regen + 70% undead bonus)
- `OverlayFeature` ALWAYS slot for emissive glow on Crimson, Molten, Puffball, Fluffball, Snowball, Soul Wanderer
- `OverlayFeature` RANDOM slot for Halloween costumes (pumpkin hats on brown-model families, witch hats on default-model families); CONDITIONAL slot — October only
- `BellyFeature` + `BellyLevel` on Warped (only family with authored belly textures: CHUBBY, TUMMY)
- Multi-item taming for Soul Wanderer: Rotten Flesh, Cookie, or Nether Wart

*Gourdragora (3 families):*
- 6 separate size classes → 3 families with `SizeVariantFeature` + `CompositeAppearanceFeature`
- Dynamic hitboxes: Mini (0.5×0.8), Default (0.8×1.5), Big (1.7×2.5)
- Stat multipliers per size; NBT persistence for size on world reload (was broken in 1.20.1)
- Spawn weights: Mini 40%, Default 40%, Big 20%
- `EmanationFeature` on all three families: survival regen when critically low
- `OverlayFeature` INTERACTIVE slot for carving (shears cycles through 5 stages per size)
- `OverlayFeature` CONDITIONAL slot for `face_cover` on Jack'o when uncarved
- Golden/Lumina: grayscale carving masks with ARGB family tint
- Jack'o: October-only spawn; full-colour carving textures
- Taming items changed: Cake + Bone Meal (was Pumpkin Pie + Bone Meal for Pumpkin/Golden)
- Variant-keyed ambient sounds by size; custom roar on attack

*Other families:*
- `WispFamily` — Wisp instantly kills Vex and Phantom targets; dedicated vex-kill sound event
- `SpookFamily` — Cream variant added
- `BeeFamily` — expanded from 1 class to 5 variants (Default, Firefly, Pixie, Silk Moth, Black Moth)
- `SlimeFamily` — animation-linked `pop` sound event

**New HZLib Systems Used**
- `EmanationFeature` / `EmanationRule` / `EmanationCondition` — rule-based passive abilities without entity method overrides
- `ExchangeFeature` / `ExchangeRule` — declarative item interaction rules; Amanita and Brown bowl → stew
- `OverlayFeature` / `OverlaySlot` — multi-slot composited layer renderer (RANDOM, ALWAYS, CONDITIONAL, INTERACTIVE)
- `BellyLevel` enum — SLIM, CHUBBY, TUMMY, INFLATED, CHUNKY; replaces TextureID offset encoding
- `GenesisFeature` — declarative genesis block + dimension + biome filter with specificity resolution
- `ConditionalAppearanceFeature` — biome-conditional spawn texture selection
- `SizeVariantFeature` + `SizeConfig` — dynamic hitbox per pose with stat multipliers
- `AnimationProfile` — all entities use HZLib profile system; per-entity GeckoLib controller setup removed

**New Blocks**
- Snowball Mushroom wood set (15 blocks)
- Ender Willow wood set (15 blocks)
- Genesis trigger + planting target blocks: Inkcap Mushroom, Molten Fungus, Ender Mushroom, Snowball Mushroom, Soul Wanderer Fungus, Mandrake Flower Plant
- Potted variants for all new plant blocks; Potted Molten Fungus and Soul Wanderer Fungus emit light 4
- Soul Wanderer wood set: non-interactive blocks now emit luminance 5 (was 0 in 1.20.1)

**New Custom Mob Effects**
- `Chilly` — freeze/slow applied by Snowball EmanationFeature
- `Blazing` — fire immunity + ignite targets; applied by Molten EmanationFeature
- `Soul Wanderer's Touch` — wither on targets + regeneration; applied by Soul Wanderer EmanationFeature
- `Puffy` — jump boost + slow falling (partial — stew item registered; passive aura pending)
- `Poisonous` — registered; application pending Inkcap wiring

**Items**
- `mushroom_stew` (vanilla reuse) — Brown Gal bowl exchange output
- `suspicious_stew` (vanilla reuse) — Amanita Gal bowl exchange output (biome-conditional flower effect)

### Fixed

- Gourdragora size stats not persisting across world reload — now written to `EntityData` via `SizeVariantFeature`
- Belly state encoded as `TextureID` integer offset in 1.20.1 — replaced with explicit `BellyLevel` field; no longer entangled with appearance variant

---

## [1.0.0] - 2024

> This entry reconstructed from archive. Exact date not recorded.

Initial public release. Standalone Fabric mod, Minecraft 1.20.1.

### Added

- 29 entity types as separate classes
- `powder_genesis`, `spectral_cake`, `candies` items
- 12 mushroom hat helmet items
- Full block set: Ender Puffball, Molten Fungus, Soul Wanderer wood sets; Inkcap mushroom block variants; 12 huge mushroom blocks; decoration blocks
- Spawn eggs for all 29 entity types

[Unreleased]: https://github.com/heria-zone/monsters-girls/compare/v1.3.0...HEAD
[1.3.0]: https://github.com/heria-zone/monsters-girls/compare/v1.0.0...v1.3.0
[1.0.0]: https://github.com/heria-zone/monsters-girls/releases/tag/v1.0.0
