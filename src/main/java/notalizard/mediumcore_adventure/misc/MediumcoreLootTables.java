package notalizard.mediumcore_adventure.misc;


import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import notalizard.mediumcore_adventure.Item.ModItems;

public class MediumcoreLootTables {

    private static final Identifier WITHER_ID = Identifier.ofVanilla("entities/wither");
    private static final Identifier ELDER_GUARDIAN_ID = Identifier.ofVanilla("entities/elder_guardian");
    private static final Identifier PIGLIN_BRUTE_ID = Identifier.ofVanilla("entities/piglin_brute");
    private static final Identifier ENDER_DRAGON_ID = Identifier.ofVanilla("entities/ender_dragon");


    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(ENDER_DRAGON_ID.equals(key.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(WITHER_ID.equals(key.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(ELDER_GUARDIAN_ID.equals(key.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(PIGLIN_BRUTE_ID.equals(key.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(LootTables.SIMPLE_DUNGEON_CHEST.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());
                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)).build());
                tableBuilder.pool(poolBuilder2.build());
            }

            if(LootTables.ABANDONED_MINESHAFT_CHEST.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.03f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());
                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder2.build());
            }

            if(LootTables.BASTION_OTHER_CHEST.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());
                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)).build());
                tableBuilder.pool(poolBuilder2.build());
            }

            if(LootTables.DESERT_PYRAMID_CHEST.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());
                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder2.build());
            }

            if(LootTables.RUINED_PORTAL_CHEST.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.03f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());
                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder2.build());
            }

            if(LootTables.WOODLAND_MANSION_CHEST.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());
                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)).build());
                tableBuilder.pool(poolBuilder2.build());
            }

            if(LootTables.ANCIENT_CITY_CHEST.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());
                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.45f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder2.build());
            }

            if(LootTables.UNDERWATER_RUIN_BIG_CHEST.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());
                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder2.build());
            }

            if(LootTables.STRONGHOLD_LIBRARY_CHEST.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());
                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build());
                tableBuilder.pool(poolBuilder2.build());
            }



        });

        LootTableEvents.REPLACE.register((key, original, source, registries) -> {
            if(LootTables.TRIAL_CHAMBERS_CORRIDOR_POT.equals(key)){
                return LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(ItemEntry.builder(Items.EMERALD).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))).weight(125))
                                        .with(ItemEntry.builder(Items.ARROW).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 8.0F))).weight(100))
                                        .with(ItemEntry.builder(Items.IRON_INGOT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))).weight(100))
                                        .with(ItemEntry.builder(Items.TRIAL_KEY).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).weight(10))
                                        .with(ItemEntry.builder(Items.MUSIC_DISC_CREATOR_MUSIC_BOX).weight(5))
                                        .with(ItemEntry.builder(Items.DIAMOND).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))).weight(5))
                                        .with(ItemEntry.builder(Items.EMERALD_BLOCK).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).weight(5))
                                        .with(ItemEntry.builder(Items.DIAMOND_BLOCK).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).weight(1))
                                        .with(ItemEntry.builder(ModItems.HEART).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).weight(1))
                                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))).weight(8))
                        ).build();
            }

            if(LootTables.TRIAL_CHAMBERS_REWARD_CHEST.equals(key)){
                return LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_RARE_CHEST).weight(8))
                                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_COMMON_CHEST).weight(2))
                        )
                        .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1.0F, 3.0F)).with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_COMMON_CHEST)))
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .conditionally(RandomChanceLootCondition.builder(0.5F))
                                        .with(ItemEntry.builder(ModItems.HEART).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).weight(1))
                                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))).weight(9))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .conditionally(RandomChanceLootCondition.builder(0.25F))
                                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_UNIQUE_CHEST))
                        ).build();
            }

            if(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_CHEST.equals(key)){
                return LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST).weight(8))
                                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON_CHEST).weight(2))
                        )
                        .pool(
                                LootPool.builder().rolls(UniformLootNumberProvider.create(1.0F, 3.0F)).with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON_CHEST))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .conditionally(RandomChanceLootCondition.builder(0.8F))
                                        .with(ItemEntry.builder(ModItems.HEART).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).weight(3))
                                        .with(ItemEntry.builder(ModItems.HEART_FRAGMENT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F))).weight(7))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .conditionally(RandomChanceLootCondition.builder(0.75F))
                                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE_CHEST))
                        ).build();
            }
            return original;
        });
    }
}
