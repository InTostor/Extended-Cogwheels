package com.rabbitminers.extendedgears.cogwheels.legacy;

import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class LegacyShaftlessCogwheelTileEntity extends CustomCogwheelBlockEntity {
    public LegacyShaftlessCogwheelTileEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        // Disable Shaft Shite
    }
}