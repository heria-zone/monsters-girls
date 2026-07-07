<!-- Thanks for contributing to Monsters & Girls (Fabric)! Fill this out before requesting review. -->

## What Does This PR Do?

<!-- One-line summary. -->

## Why?

<!-- What problem does this solve or what does it add? -->
Closes #

## Type of Change

- [ ] Bug fix
- [ ] New species variant
- [ ] New species *(requires prior discussion with b_art_ek)*
- [ ] HZLib feature wiring (EmanationFeature / ExchangeFeature / GenesisFeature etc.)
- [ ] New block or item
- [ ] Refactor (no behaviour change)
- [ ] Documentation only

## How Has This Been Tested?

- Minecraft version: `___`
- Loader: Fabric
- Test case: <!-- Describe what you tested -->

## Checklist

- [ ] Fabric build completes without warnings
- [ ] `CHANGELOG.md` updated under `[Unreleased]`
- [ ] Follows HZLib feature composition pattern — no direct entity method overrides where a feature exists
- [ ] New species or major behaviour changes were discussed in an issue first
- [ ] No string literals used as NBT keys — `DataField<T>` handles only
