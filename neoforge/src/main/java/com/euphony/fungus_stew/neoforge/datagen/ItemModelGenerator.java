package com.euphony.fungus_stew.neoforge.datagen;

import com.euphony.fungus_stew.FungusStew;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
    ExistingFileHelper existingFileHelper;

    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FungusStew.MOD_ID, existingFileHelper);
        this.existingFileHelper = existingFileHelper;
    }

    @Override
    protected void registerModels() {
        basicItem(FungusStew.FUNGUS_STEW_ITEM.get());
    }
}
