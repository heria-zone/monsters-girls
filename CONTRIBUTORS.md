# Monsters & Girls — Contributors

This file records everyone who has made a meaningful contribution to Monsters & Girls. Copyright in each contribution belongs to its author.

---

## Project Owner & Original Creator

**b_art_ek**

Creator and owner of [Monsters & Girls](https://www.curseforge.com/minecraft/mc-mods/monsters-girls). The original concept, species design, art assets, and Forge implementation originate from their work. This repository is the Fabric port and 1.21.1 rebuild — a collaboration under b_art_ek's ownership.

---

## Platform Developers

**MSymbios** ([@MSymbios](https://github.com/MSymbios)) — *Heria Zone* — **Fabric Developer**

Fabric port (1.18.2–1.20.4) and complete 1.21.1 rebuild on HZLib:
- Full codebase rebuild on HZLib entity framework (1.21.1)
- 29 separate entity classes → 12 unified family classes via `MonstersFamily<T>`
- `EmanationFeature` system — Molten, Snowball, Soul Wanderer, Gourdragora passive abilities
- `ExchangeFeature` system — bowl interaction rules (Amanita, Brown)
- `OverlayFeature` system — emissive glow, Halloween costumes, Gourdragora carving
- `GenesisFeature` system — declarative genesis block + dimension + biome filter
- `BellyLevel` enum — structured belly progression replacing TextureID offset encoding
- `SizeVariantFeature` on Gourdragora — dynamic hitboxes and stat multipliers per size
- `ConditionalAppearanceFeature` — biome-conditional spawn texture selection
- New species: Globberie (3 variants), Fluffball (flying Puffball subspecies), Gourdragora Lumina
- Spook Cream variant added
- Bee expanded from 1 class to 5 variants
- Full block set: Snowball Mushroom wood set, Ender Willow wood set, genesis trigger blocks
- Custom mob effects: Chilly, Blazing, Soul Wanderer's Touch, Puffy, Poisonous
- Centralised `MonstersSounds` registry

---

## Contributors

*No external contributions yet.*

---

## Platform Notes

| Platform | Developer |
|---|---|
| Forge | b_art_ek (original) |
| Fabric | MSymbios / Heria Zone |
| Bedrock | *Other collaborators — to be listed* |

---

## How to Read This File

Each entry lists:
- **Name** and GitHub handle
- **What they built** — specific systems, species, or features
- Copyright in each contribution belongs to the contributor

For contribution guidelines, see [`CONTRIBUTING.md`](CONTRIBUTING.md).
