package notalizard.mediumcore_adventure.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import notalizard.mediumcore_adventure.MediumcoreAdventureMod;
import notalizard.mediumcore_adventure.MediumcoreTags;
import notalizard.mediumcore_adventure.misc.MediumcoreDataManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {
    @Inject(at = @At("HEAD"), method = "finishUsing")
    private void onUseItem(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir){
        if(!(user instanceof ServerPlayerEntity player) || world.isClient()) return;

        if(stack.isIn(MediumcoreTags.RESTORES_MAX_HEALTH) /* TODO: check gamerule */){
            double currentMax = MediumcoreDataManager.getMaxHp(player.getUuid(), player.getEntityWorld().getServer());
            double clampedHealth = Math.clamp(currentMax + MediumcoreAdventureMod.CONFIG.healthIncreasePerHeal, MediumcoreAdventureMod.CONFIG.minimumPlayerHealth, MediumcoreAdventureMod.CONFIG.maxPlayerHealth);
            MediumcoreDataManager.setMaxHp(player.getUuid(), player.getEntityWorld().getServer(), clampedHealth);
        }
    }
}
