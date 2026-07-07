# Security Policy — Monsters & Girls (Fabric)

## Reporting a Vulnerability

**Do not open a public GitHub issue for security vulnerabilities.**

If you find something in the Fabric version, tell me privately and I'll fix it.

### Primary channel — GitHub Private Vulnerability Reporting

Go to the [Security tab](../../security) of this repository and click **"Report a vulnerability"**. GitHub creates a private draft. No public exposure, no email required.

### Secondary channel — Discord

Send a direct message to **MSymbios** on the [Heria Zone Discord](https://discord.gg/ZmCPM22FCK).

> **Note:** This repository covers the Fabric port only. For issues in the Forge version, contact **b_art_ek** directly.

---

## What Counts as a Security Issue

- **Crash exploits** — malformed entity NBT or genesis items that crash a server or client
- **Save corruption** — entity data migration bugs that silently destroy world state or player inventory
- **Duplication bugs** — genesis powder, spawn items, or entity drops exploitable on multiplayer servers

## What Does NOT Belong Here

- Visual bugs or missing species content → open a [GitHub Issue](../../issues)
- Feature requests → open a [GitHub Issue](../../issues)
- Questions → join [Discord](https://discord.gg/ZmCPM22FCK) `#dev`

---

## What to Include in a Report

- Description of the vulnerability and its impact
- Steps to reproduce
- Mod version, Minecraft version
- Singleplayer or multiplayer
- Other mods installed
- Relevant crash logs

---

## What to Expect

- **Acknowledgement** — within 48 hours
- **Initial assessment** — within 1 week
- **Credit** — if you want to be credited for the find, say so in your report

---

## Supported Versions

| Version | Supported |
|---|---|
| Latest Fabric release | ✅ |
| Older releases | ⚠️ Critical fixes only |
