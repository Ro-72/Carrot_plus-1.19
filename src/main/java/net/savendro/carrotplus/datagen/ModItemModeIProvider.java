package net.savendro.carrotplus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.savendro.carrotplus.Carrotplus;
import net.savendro.carrotplus.item.ModItems;

public class ModItemModeIProvider extends ItemModelProvider {
    public ModItemModeIProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Carrotplus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BAKED_YAM);
        simpleItem(ModItems.YAM);
        simpleItem(ModItems.YAM_SEEDS);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return  withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                        new ResourceLocation(Carrotplus.MOD_ID, "item/" + item.getId().getPath()));

    }
}
