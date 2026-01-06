package notalizard.mediumcore_adventure;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRuleCategory;
import net.minecraft.world.rule.GameRules;

public class GameRuleRegistry {
    private static final Identifier MEDIUMCORE_RULE_IDENTIFIER = Identifier.of(MediumcoreAdventureMod.MOD_ID, "mediumcore_mode");
    private static GameRule<Boolean> MEDIUMCORE_RULE;

    public static void setup() {
        MEDIUMCORE_RULE = GameRuleBuilder.forBoolean(false).category(GameRuleCategory.PLAYER).buildAndRegister(MEDIUMCORE_RULE_IDENTIFIER);
    }

    public static boolean isMediumCoreMode(GameRules gameRules){
        return MEDIUMCORE_RULE != null && gameRules.getValue(MEDIUMCORE_RULE);
    }

    public static void setMediumcoreMode(GameRules gameRules, boolean mediumcore, MinecraftServer minecraftServer) {
        if(MEDIUMCORE_RULE != null){
            gameRules.setValue(MEDIUMCORE_RULE, mediumcore, minecraftServer);
        }
    }
}
