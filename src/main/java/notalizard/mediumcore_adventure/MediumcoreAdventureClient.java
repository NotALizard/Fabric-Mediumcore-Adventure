package notalizard.mediumcore_adventure;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;

public class MediumcoreAdventureClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, tooltipContext, tooltipType, lines) -> {
            if(stack.isIn(MediumcoreTags.RESTORES_MAX_HEALTH)) {
                lines.add(Text.literal("❤ Restores Max Health").withColor(Colors.LIGHT_RED));
            }
        });
    }
}
