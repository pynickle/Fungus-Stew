package com.euphony.fungus_stew;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public final class FungusStew {
    public static final String MOD_ID = "fungus_stew";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> FUNGUS_STEW_ITEM = register("fungus_stew",
            new Item.Properties().stacksTo(1).food(
                    new FoodProperties.Builder()
                            .nutrition(6).saturationModifier(0.6F)
                            .usingConvertsTo(Items.BOWL)
                            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 1.0F)
                            .build()
            ));

    public static RegistrySupplier<Item> register(String name, Item.Properties properties) {
        return ITEMS.register(name, () -> new Item(properties));
    }

    public static void init() {
        ITEMS.register();
    }
}
