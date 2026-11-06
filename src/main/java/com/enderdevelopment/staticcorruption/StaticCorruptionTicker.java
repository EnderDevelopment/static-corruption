package com.enderdevelopment.staticcorruption;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;

public final class StaticCorruptionTicker {
    public static final String CORRUPTED_TAG = "staticcorruption.corrupted";

    private StaticCorruptionTicker() {
    }

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(StaticCorruptionTicker::tickWorld);
    }

    private static void tickWorld(ServerWorld world) {
        for (LivingEntity entity : world.getEntitiesByClass(
                LivingEntity.class,
                new Box(world.getWorldBorder().getBoundWest(), world.getBottomY(), world.getWorldBorder().getBoundNorth(),
                        world.getWorldBorder().getBoundEast(), world.getTopY(), world.getWorldBorder().getBoundSouth()),
                candidate -> candidate.getCommandTags().contains(CORRUPTED_TAG))) {
            spawnStatic(world, entity);
            if (entity.age % 40 == 0) {
                entity.damage(world, world.getDamageSources().magic(), 1.0f);
                for (LivingEntity nearby : world.getEntitiesByClass(LivingEntity.class, entity.getBoundingBox().expand(2.5),
                        candidate -> candidate != entity && candidate.isAlive())) {
                    nearby.damage(world, world.getDamageSources().magic(), 1.0f);
                }
            }
        }
    }

    private static void spawnStatic(ServerWorld world, LivingEntity entity) {
        double height = entity.getHeight();
        world.spawnParticles(ParticleTypes.ELECTRIC_SPARK, entity.getX(), entity.getY() + height * 0.6, entity.getZ(),
                3, entity.getWidth() * 0.45, height * 0.4, entity.getWidth() * 0.45, 0.03);
    }
}
