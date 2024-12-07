package kono.ceu.advancedhatches.common.metatileentities.multiblockpart.ceu;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.impl.NotifiableItemStackHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.items.behaviors.TurbineRotorBehavior;
import gregtech.common.metatileentities.multi.electric.generator.MetaTileEntityLargeTurbine;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityRotorHolder;

public class MetaTileEntityPowerEnhancedRotorHolder extends MetaTileEntityRotorHolder {

    private final int maxSpeed;

    private final InventoryRotorHolder inventory;
    private int currentSpeed;
    private boolean isRotorSpinning;
    private boolean frontFaceFree;

    public MetaTileEntityPowerEnhancedRotorHolder(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, tier);
        this.inventory = new InventoryRotorHolder();
        this.maxSpeed = 3000 + 1500 * tier;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityPowerEnhancedRotorHolder(metaTileEntityId, getTier());
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        if (TooltipHelper.isShiftDown() && TooltipHelper.isCtrlDown()) {
            tooltip.add(I18n.format("advancedhatches.machine.rotor_holder.power.tooltip", 50));
            tooltip.add(I18n.format("advancedhatches.machine.rotor_holder.speed.tooltip", 50));
        }
    }

    @Override
    public void update() {
        super.update();
        if (!this.getWorld().isRemote) {
            if (this.getOffsetTimer() % 20L == 0L) {
                boolean isFrontFree = this.checkTurbineFaceFree();
                if (isFrontFree != this.frontFaceFree) {
                    this.frontFaceFree = isFrontFree;
                    this.writeCustomData(GregtechDataCodes.FRONT_FACE_FREE, (buf) -> {
                        buf.writeBoolean(this.frontFaceFree);
                    });
                }
            }

            MetaTileEntityLargeTurbine controller = (MetaTileEntityLargeTurbine) this.getController();
            if (controller != null && controller.isActive()) {
                if (this.currentSpeed < this.maxSpeed) {
                    this.setCurrentSpeed(this.currentSpeed + 1);
                }

                if (this.getOffsetTimer() % 20L == 0L) {
                    this.damageRotor(1 + controller.getNumMaintenanceProblems());
                }
            } else if (!this.hasRotor()) {
                this.setCurrentSpeed(0);
            } else if (this.currentSpeed > 0) {
                this.setCurrentSpeed(Math.max(0, this.currentSpeed - 3));
            }

        }
    }

    @Override
    public boolean isFrontFaceFree() {
        return this.frontFaceFree;
    }

    private boolean checkTurbineFaceFree() {
        EnumFacing facing = this.getFrontFacing();
        boolean permuteXZ = facing.getAxis() == EnumFacing.Axis.Z;
        BlockPos centerPos = this.getPos().offset(facing);

        for (int x = -1; x < 2; ++x) {
            for (int y = -1; y < 2; ++y) {
                BlockPos blockPos = centerPos.add(permuteXZ ? x : 0, y, permuteXZ ? 0 : x);
                IBlockState blockState = this.getWorld().getBlockState(blockPos);
                if (!blockState.getBlock().isAir(blockState, this.getWorld(), blockPos)) {
                    return false;
                }
            }
        }

        return true;
    }

    void setCurrentSpeed(int speed) {
        if (this.currentSpeed != speed) {
            this.currentSpeed = speed;
            this.setRotorSpinning(this.currentSpeed > 0);
            this.markDirty();
        }
    }

    void setRotorSpinning(boolean spinning) {
        if (this.isRotorSpinning != spinning) {
            this.isRotorSpinning = spinning;
            this.writeCustomData(GregtechDataCodes.IS_ROTOR_LOOPING, (buf) -> {
                buf.writeBoolean(this.isRotorSpinning);
            });
        }
    }

    @Override
    public int getRotorSpeed() {
        return this.currentSpeed;
    }

    @Override
    public int getRotorPower() {
        return (int) (inventory.getRotorPower() * 1.5);
    }

    @Override
    public int getMaxRotorHolderSpeed() {
        return this.maxSpeed;
    }

    private class InventoryRotorHolder extends NotifiableItemStackHandler {

        public InventoryRotorHolder() {
            super(MetaTileEntityPowerEnhancedRotorHolder.this, 1, null, false);
        }

        @Nullable
        private ItemStack getTurbineStack() {
            if (!hasRotor())
                return null;
            return getStackInSlot(0);
        }

        @Nullable
        private TurbineRotorBehavior getTurbineBehavior() {
            ItemStack stack = getStackInSlot(0);
            if (stack.isEmpty()) return null;

            return TurbineRotorBehavior.getInstanceFor(stack);
        }

        private int getRotorPower() {
            if (!hasRotor()) return -1;

            // noinspection ConstantConditions
            return getTurbineBehavior().getRotorPower(getTurbineStack());
        }
    }
}
