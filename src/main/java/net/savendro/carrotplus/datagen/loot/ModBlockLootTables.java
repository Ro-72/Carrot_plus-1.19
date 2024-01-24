package net.savendro.carrotplus.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.savendro.carrotplus.block.ModBlocks;
import net.savendro.carrotplus.block.custom.YamCropBlock;
import net.savendro.carrotplus.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(){
        super (Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    @Override
    protected void generate() {
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.YAM_CROP_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(YamCropBlock.AGE,5));
        this.add(ModBlocks.YAM_CROP_BLOCK.get(), createCropDrops(ModBlocks.YAM_CROP_BLOCK.get(), ModItems.YAM.get(),
                ModItems.YAM_SEEDS.get(), lootitemcondition$builder));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
