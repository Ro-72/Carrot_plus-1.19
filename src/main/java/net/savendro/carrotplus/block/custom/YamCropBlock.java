package net.savendro.carrotplus.block.custom;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.savendro.carrotplus.item.ModItems;

public class YamCropBlock extends CropBlock {
    public static final int MAX_AGE = 5;
    public final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public YamCropBlock(Properties pProperties){
        super(pProperties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.YAM_SEEDS.get();
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }
}
