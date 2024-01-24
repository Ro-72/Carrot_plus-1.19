package net.savendro.carrotplus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.savendro.carrotplus.Carrotplus;
import net.savendro.carrotplus.block.ModBlocks;
import net.savendro.carrotplus.block.custom.YamCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, Carrotplus.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
makeYamCrop((CropBlock) ModBlocks.YAM_CROP_BLOCK.get(), "yam_stage", "yam_stage");
    }
    public void makeYamCrop(CropBlock block, String modelName, String textureName){
        Function<BlockState, ConfiguredModel[]> function = state -> yamStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] yamStates(BlockState state, CropBlock block,String modelName, String textureName){
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((YamCropBlock) block ).getAgeProperty()),
                new ResourceLocation(Carrotplus.MOD_ID,"block/" + textureName + state.getValue(((YamCropBlock) block).getAgeProperty()))).renderType("cutcut"));
        return  models;
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
