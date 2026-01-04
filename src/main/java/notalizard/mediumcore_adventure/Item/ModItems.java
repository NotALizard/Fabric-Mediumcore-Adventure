package notalizard.mediumcore_adventure.Item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import notalizard.mediumcore_adventure.MediumcoreAdventure;

public class ModItems {

    public static final Item HEART = registerItem("heart", new Item.Settings().rarity(Rarity.EPIC).maxCount(1).food(new FoodComponent(4,9.6f,true)).component(DataComponentTypes.CONSUMABLE, ConsumableComponent.builder().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 3600, 1),1.0f)).build()));
    public static final Item HEART_FRAGMENT = registerItem("heart_fragment", new Item.Settings().rarity(Rarity.RARE).maxCount(16));

    private static Item registerItem(String name, Item.Settings itemSettings){
        Identifier id = Identifier.of(MediumcoreAdventure.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = itemSettings.registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    public static void registerModItems(){
        MediumcoreAdventure.LOGGER.info("Registering Mod Items for " + MediumcoreAdventure.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(HEART);
            entries.add(HEART_FRAGMENT);
        });
    }
}
