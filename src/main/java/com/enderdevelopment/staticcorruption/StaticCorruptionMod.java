package com.enderdevelopment.staticcorruption;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class StaticCorruptionMod implements ModInitializer {
    public static final String MOD_ID = "staticcorruption";
    public static final Item STATIC_CORE = Registry.register(
            Registries.ITEM,
            Identifier.of(MOD_ID, "static_core"),
            new StaticCoreItem(new Item.Settings().maxCount(16))
    );

    @Override
    public void onInitialize() {
        StaticCorruptionTicker.register();
    }
}
