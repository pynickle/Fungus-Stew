package com.euphony.fungus_stew.fabric;

import com.euphony.fungus_stew.FungusStew;
import net.fabricmc.api.ModInitializer;

public final class FungusStewFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FungusStew.init();
    }
}
