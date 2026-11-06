package com.enderdevelopment.staticcorruption;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public final class StaticCoreItem extends Item {
    public StaticCoreItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }
        if (entity == user || entity.isRemoved() || entity.getCommandTags().contains(StaticCorruptionTicker.CORRUPTED_TAG)) {
            return ActionResult.PASS;
        }

        entity.addCommandTag(StaticCorruptionTicker.CORRUPTED_TAG);
        entity.setGlowing(true);
        world.playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.HOSTILE, 0.65f, 1.6f);
        world.playSound(null, entity.getBlockPos(), SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.HOSTILE, 0.8f, 1.8f);
        if (!user.isCreative()) {
            stack.decrement(1);
        }
        return ActionResult.SUCCESS;
    }
}
