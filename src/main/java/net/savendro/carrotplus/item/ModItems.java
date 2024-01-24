package net.savendro.carrotplus.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.savendro.carrotplus.Carrotplus;
import net.savendro.carrotplus.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Carrotplus.MOD_ID);
    public static final RegistryObject<Item> BAKED_CARROT= ITEMS.register("baked_carrot",
            () -> new Item(new Item.Properties().food(ModFoods.BAKED_CARROT)));

    public static final RegistryObject<Item> YAM= ITEMS.register("yam",
            () -> new Item(new Item.Properties().food(ModFoods.YAM)));
    public static final RegistryObject<Item> BAKED_YAM= ITEMS.register("baked_yam",
            () -> new Item(new Item.Properties().food(ModFoods.BAKED_YAM)));
    public static final RegistryObject<Item> COPPERED_POTATO= ITEMS.register("coppered_potato",
            () -> new Item(new Item.Properties().food(ModFoods.COPPERED_POTATO)));
    public static final RegistryObject<Item> YAM_SEEDS= ITEMS.register("yam_seeds",
            () -> new ItemNameBlockItem(ModBlocks.YAM_CROP_BLOCK.get(), new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
