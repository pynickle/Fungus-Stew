package com.euphony.fungus_stew.fabric;

import com.euphony.fungus_stew.FungusStew;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public final class FungusStewFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FungusStew.init();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register((entries) -> {
            entries.addAfter(Items.MUSHROOM_STEM, FungusStew.FUNGUS_STEW_ITEM.get());
        });
    }
}
