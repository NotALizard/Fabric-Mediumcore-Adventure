//package notalizard.mediumcore_adventure.mixin;
//
//import net.minecraft.client.gui.hud.InGameHud;
//import net.minecraft.util.Identifier;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.Unique;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(targets = "net.minecraft.client.gui.hud.InGameHud$HeartType")
//public abstract class GuiMixin {
//    @Unique
//    private final Identifier mediumcore$Full =  Identifier.ofVanilla("hud/heart/mediumcore_full");
//    @Unique
//    private final Identifier mediumcore$Half = Identifier.ofVanilla("hud/heart/mediumcore_half");
//    @Unique
//    private final Identifier mediumcore$FullBlinking = Identifier.ofVanilla("hud/heart/mediumcore_full_blinking");
//    @Unique
//    private final Identifier mediumcore$HalfBlinking = Identifier.ofVanilla("hud/heart/mediumcore_half_blinking");
//
//    @Unique
//    private final Identifier mediumcore$Full$Poison =  Identifier.ofVanilla("hud/heart/mediumcore_full_poison");
//    @Unique
//    private final Identifier mediumcore$Half$Poison = Identifier.ofVanilla("hud/heart/mediumcore_half_poison");
//    @Unique
//    private final Identifier mediumcore$FullBlinking$Poison = Identifier.ofVanilla("hud/heart/mediumcore_full_blinking_poison");
//    @Unique
//    private final Identifier mediumcore$HalfBlinking$Poison = Identifier.ofVanilla("hud/heart/mediumcore_half_blinking_poison");
//
//    @Unique
//    private final Identifier mediumcore$Full$Wither =  Identifier.ofVanilla("hud/heart/mediumcore_full_wither");
//    @Unique
//    private final Identifier mediumcore$Half$Wither = Identifier.ofVanilla("hud/heart/mediumcore_half_wither");
//    @Unique
//    private final Identifier mediumcore$FullBlinking$Wither = Identifier.ofVanilla("hud/heart/mediumcore_full_blinking_wither");
//    @Unique
//    private final Identifier mediumcore$HalfBlinking$Wither = Identifier.ofVanilla("hud/heart/mediumcore_half_blinking_wither");
//
//    @Unique
//    private final Identifier mediumcore$Full$Gold =  Identifier.ofVanilla("hud/heart/mediumcore_full_gold");
//    @Unique
//    private final Identifier mediumcore$Half$Gold = Identifier.ofVanilla("hud/heart/mediumcore_half_gold");
//
//    @Unique
//    private final Identifier mediumcore$Full$Frozen =  Identifier.ofVanilla("hud/heart/mediumcore_full_frozen");
//    @Unique
//    private final Identifier mediumcore$Half$Frozen = Identifier.ofVanilla("hud/heart/mediumcore_half_frozen");
//
//    @Unique
//    private final Identifier vanilla$Container = Identifier.ofVanilla("hud/heart/container");
//    @Unique
//    private final Identifier vanilla$Poison = Identifier.ofVanilla("hud/heart/poisoned_full");
//    @Unique
//    private final Identifier vanilla$Wither = Identifier.ofVanilla("hud/heart/withered_full");
//    @Unique
//    private final Identifier vanilla$Gold = Identifier.ofVanilla("hud/heart/absorbing_full");
//    @Unique
//    private final Identifier vanilla$Frozen = Identifier.ofVanilla("hud/heart/frozen_full");
//
//    @Shadow
//    @Final
//    private Identifier fullTexture;
//
//    @Inject(at = @At("HEAD"), method = "getTexture", cancellable = true)
//    public void getTextureMediumcore(boolean hardcore, boolean half, boolean blinking, CallbackInfoReturnable<Identifier> cir){
//        // TODO: check gamemode
//        if(this.fullTexture.equals(vanilla$Container)){
//            return;
//        }
//
//        if(this.fullTexture.equals(vanilla$Poison)){
//            if(half){
//                cir.setReturnValue(blinking ? mediumcore$HalfBlinking$Poison : mediumcore$Half$Poison);
//            }
//            else{
//                cir.setReturnValue(blinking ? mediumcore$FullBlinking$Poison : mediumcore$Full$Poison);
//            }
//        }
//        else if(this.fullTexture.equals(vanilla$Wither)){
//            if(half){
//                cir.setReturnValue(blinking ? mediumcore$HalfBlinking$Wither : mediumcore$Half$Wither);
//            }
//            else{
//                cir.setReturnValue(blinking ? mediumcore$FullBlinking$Wither : mediumcore$Full$Wither);
//            }
//        }
//        else if(this.fullTexture.equals(vanilla$Gold)){
//            if(half){
//                cir.setReturnValue(mediumcore$Half$Gold);
//            }
//            else{
//                cir.setReturnValue(mediumcore$Full$Gold);
//            }
//        }
//        else if(this.fullTexture.equals(vanilla$Frozen)){
//            if(half){
//                cir.setReturnValue(mediumcore$Half$Frozen);
//            }
//            else{
//                cir.setReturnValue(mediumcore$Full$Frozen);
//            }
//        }
//        else{
//            if(half){
//                cir.setReturnValue(blinking ? mediumcore$HalfBlinking : mediumcore$Half);
//            }
//            else{
//                cir.setReturnValue(blinking ? mediumcore$FullBlinking : mediumcore$Full);
//            }
//        }
//    }
//}
