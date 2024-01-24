package net.savendro.carrotplus.block;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.savendro.carrotplus.Carrotplus;
import net.savendro.carrotplus.block.custom.YamCropBlock;
import net.savendro.carrotplus.item.ModItems;

import java.util.function.Supplier;

import static net.minecraftforge.registries.ForgeRegistries.BLOCKS;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Carrotplus.MOD_ID);
    public static<T extends Block > RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name , toReturn);
        return toReturn;
    }
    private static  <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
    public static final RegistryObject<Block> YAM_CROP_BLOCK = BLOCKS.register("yam_crop", () -> new YamCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

}
