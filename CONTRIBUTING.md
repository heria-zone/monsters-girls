# Contributing to Monsters & Girls (Fabric)

Thank you for considering a contribution. This covers everything you need before you start.

---

## About This Repository

This repository hosts the **Fabric port** of Monsters & Girls, originally created by **b_art_ek** for Forge. The 1.21.1 version is a complete rebuild on HZLib, developed under b_art_ek's ownership with creative freedom granted to the Fabric team.

**Before contributing, understand the scope:**
- This repo covers Fabric only
- New species or major design changes are collaborative decisions involving the project owner (b_art_ek)
- Bug fixes, performance improvements, and HZLib system improvements can proceed without prior discussion
- New species implementations or significant behaviour changes should be discussed in an issue first

---

## Your Credit, Your Copyright

**The copyright in your contribution stays with you.** Contributions are credited in [`CONTRIBUTORS.md`](CONTRIBUTORS.md) with your name, handle, and a description of what you built.

---

## Setting Up

The 1.21.1 version lives inside the [reboot-lovely-robot monorepo](https://github.com/heria-zone/reboot-lovely-robot) under `sources/monsters/monsters_girls-1.21.1/`.

```bash
git clone https://github.com/heria-zone/reboot-lovely-robot
cd sources/monsters/monsters_girls-1.21.1
```

**Requirements:**
- JDK 21
- HZLib (included in monorepo at `sources/common/hzlib-1.21.1/`)

**Build:**
```bash
./gradlew :monsters-fabric:build
```

---

## What You Can Contribute

**Bug fixes** — go straight to a PR. No prior discussion needed.

**New HZLib system wiring** — if a mushroom family is missing its bowl interaction, spawn rules, or EmanationFeature wiring, refer to [`docs/decisions/MUSHROOM_GALS_TODO.md`](docs/decisions/MUSHROOM_GALS_TODO.md) for the tracked work.

**New species** — open an issue first. New species require creative direction alignment with b_art_ek before implementation begins.

**New species variants** — adding a new variant (new texture, new biome spawn condition) to an existing family is lower friction. Still worth discussing in an issue before implementing.

**Art and textures** — art contributions are welcome and will be credited. New art must align with the existing visual style.

---

## Code Standards

All entity families extend `MonstersFamily<T>` → `NativeEntityFamily<T>` (HZLib). Features are composable — use the existing feature system (`EmanationFeature`, `ExchangeFeature`, `GenesisFeature`, `PlantingFeature`, `FoodFeature`) rather than overriding entity methods directly.

For the HZLib feature API, see [`docs/api/`](docs/api/).

---

## Commit Messages

```
ADD:   New species, feature, or block
FIX:   Bug fix
REF:   Refactor without behaviour change
REM:   Removal
DOCS:  Documentation only
CFG:   Build or config change
NULL:  Trivial formatting
```

---

## Opening a Pull Request

- One logical change per PR
- Fabric build must complete without warnings
- Update `CHANGELOG.md` under `[Unreleased]`
- Fill in the PR template checklist

---

## Reporting a Security Issue

See [`SECURITY.md`](SECURITY.md). Do not open a public issue.

---

## Questions

[Heria Zone Discord](https://discord.gg/ZmCPM22FCK) — `#dev` channel.
