package kono.ceu.advancedhatches.common.metatileentities.multiblockpart.ceu;

import gregtech.api.GTValues;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import kono.ceu.advancedhatches.common.metatileentities.AHMetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;


import java.util.List;

public class MetaTileEntityMultiAmpEnergyHatch extends MetaTileEntityEnergyHatch {

    protected final boolean isExportHatch;
    protected final int amperage;
    protected final IEnergyContainer energyContainer;

    public MetaTileEntityMultiAmpEnergyHatch(ResourceLocation metaTileEntityId, int tier, int amperage,
                                             boolean isExportHatch) {
        super(metaTileEntityId, tier, amperage, isExportHatch);

        this.isExportHatch = isExportHatch;
        this.amperage = amperage;
        if (isExportHatch) {
            this.energyContainer = EnergyContainerHandler.emitterContainer(this, GTValues.V[tier] * 64L * amperage,
                    GTValues.V[tier], amperage);
            ((EnergyContainerHandler) this.energyContainer).setSideOutputCondition(s -> s == getFrontFacing());
        } else {
            this.energyContainer = EnergyContainerHandler.receiverContainer(this, GTValues.V[tier] * 16L * amperage,
                    GTValues.V[tier], amperage);
        }
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityMultiAmpEnergyHatch(metaTileEntityId, getTier(), amperage, isExportHatch);
    }

    @Override
    public void update() {
        super.update();
        checkWeatherOrTerrainExplosion(getTier(), getTier() * 10, energyContainer);
    }

    @Override
    public MultiblockAbility<IEnergyContainer> getAbility() {
        return isExportHatch ? MultiblockAbility.OUTPUT_ENERGY : MultiblockAbility.INPUT_ENERGY;
    }

    @Override
    public void registerAbilities(List<IEnergyContainer> abilityList) {
        abilityList.add(energyContainer);
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {
        if (this == AHMetaTileEntities.ENERGY_INPUT_256A[0]) {
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_INPUT_4A_LOW) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_INPUT_4A_HIGH) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_OUTPUT_4A_LOW) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_OUTPUT_4A_HIGH) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_INPUT_16A_LOW) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_INPUT_16A_HIGH) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_OUTPUT_16A_LOW) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_OUTPUT_16A_HIGH) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_INPUT_64A_LOW) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_INPUT_64A) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_OUTPUT_64A_LOW) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_OUTPUT_64A) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_INPUT_256A_LOW) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_INPUT_256A) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_OUTPUT_256A_LOW) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityMultiAmpEnergyHatch hatch : AHMetaTileEntities.ENERGY_OUTPUT_256A) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
        }
    }
}
