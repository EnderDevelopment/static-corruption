# Static Corruption Minecraft Mod

Static Corruption is a Fabric Minecraft mod for 1.21.1 that adds a craftable Static Core and static corruption abilities for living entities. Corrupted entities glow, emit electric sparks, take periodic static damage, and shock nearby living entities.

## Install

Requirements:

- Minecraft Java Edition 1.21.1
- Fabric Loader 0.16.10 or newer
- Fabric API for Minecraft 1.21.1
- Java 21

1. Install Fabric Loader for Minecraft 1.21.1.
2. Install the matching Fabric API jar.
3. Download the mod jar, or build it from the project source.
4. Place the Static Corruption jar in the Minecraft `mods` folder.
5. Launch Minecraft using the Fabric 1.21.1 profile.

To build from source, run the following command in the project directory:

```text
./gradlew build
```

The compiled jar is created in the `build/libs` directory.

## Use

1. Craft a Static Core using the following shaped recipe:

   ```text
   Iron Ingot | Redstone | Iron Ingot
   Redstone    | Diamond  | Redstone
   Iron Ingot | Redstone | Iron Ingot
   ```

2. Hold the Static Core.
3. Use it on a living entity to apply static corruption.
4. The corrupted entity glows and continuously emits electric spark particles.
5. Every two seconds, the corrupted entity takes 1 point of magic damage and damages nearby living entities within 2.5 blocks for 1 point of magic damage.
6. The Static Core is consumed after a successful use unless the player is in creative mode.

A player cannot corrupt themselves, and an entity that is already corrupted cannot be corrupted again. Corruption is stored as an entity command tag and persists with the entity.

---

More Minecraft mod projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/ad66f82f-d3bb-49d1-806d-2006017d8319?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=ad66f82f-d3bb-49d1-806d-2006017d8319
