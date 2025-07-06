package com.euphony.fungus_stew.fabric.client;

import com.euphony.fungus_stew.FungusStew;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public final class FungusStewFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register((entries) -> {
            entries.addBefore(Items.BEETROOT_SOUP, FungusStew.FUNGUS_STEW_ITEM.get());
        });
    }
}
