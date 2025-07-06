package com.euphony.fungus_stew;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.world.item.component.Consumables.defaultFood;

public final class FungusStew {
    public static final String MOD_ID = "fungus_stew";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> FUNGUS_STEW_ITEM = register("fungus_stew",
            new Item.Properties().stacksTo(1)
                    .usingConvertsTo(Items.BOWL)
                    .food(
                            new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build(),
                            defaultFood().onConsume(
                                    new ApplyStatusEffectsConsumeEffect(
                                            List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0))
                                    )
                            ).build()
                    )
            );

    public static RegistrySupplier<Item> register(String name, Item.Properties properties) {
        return ITEMS.register(name, () -> new Item(properties.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, name)))));
    }

    public static void init() {
        ITEMS.register();
    }
}
