package notalizard.mediumcore_adventure;

import net.fabricmc.api.ModInitializer;

import notalizard.mediumcore_adventure.Item.ModItems;
import notalizard.mediumcore_adventure.event.CommonEvents;
import notalizard.mediumcore_adventure.misc.MediumcoreDataManager;
import notalizard.mediumcore_adventure.misc.MediumcoreLootTables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MediumcoreAdventureMod implements ModInitializer {
	public static final String MOD_ID = "mediumcore-adventure";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final MediumcoreConfig CONFIG = new MediumcoreConfig();

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		MediumcoreDataManager.init();
		CommonEvents.onInitialize();
		MediumcoreLootTables.modifyLootTables();
	}
}