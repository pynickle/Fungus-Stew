package com.euphony.fungus_stew.neoforge;

import com.euphony.fungus_stew.FungusStew;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(FungusStew.MOD_ID)
@EventBusSubscriber(modid = FungusStew.MOD_ID)
public final class FungusStewNeoForge {
    public FungusStewNeoForge() {
        FungusStew.init();
    }

    @SubscribeEvent
    public static void itemGroupModification(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().location().equals(ResourceLocation.withDefaultNamespace("food_and_drinks"))) {
            event.insertAfter(Items.MUSHROOM_STEW.getDefaultInstance(), FungusStew.FUNGUS_STEW_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
