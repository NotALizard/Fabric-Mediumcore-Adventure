package notalizard.mediumcore_adventure;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class MediumcoreTags {
    public static final TagKey<Item> RESTORES_MAX_HEALTH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MediumcoreAdventureMod.MOD_ID, "restores_max_health"));

}
