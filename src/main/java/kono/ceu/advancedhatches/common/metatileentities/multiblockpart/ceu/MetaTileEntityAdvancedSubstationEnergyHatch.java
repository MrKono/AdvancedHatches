package kono.ceu.advancedhatches.common.metatileentities.multiblockpart.ceu;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntitySubstationEnergyHatch;
import kono.ceu.advancedhatches.common.metatileentities.AHMetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityAdvancedSubstationEnergyHatch extends MetaTileEntitySubstationEnergyHatch {

    public MetaTileEntityAdvancedSubstationEnergyHatch(ResourceLocation metaTileEntityId, int tier, int amperage,
                                               boolean isExportHatch) {
        super(metaTileEntityId, tier, amperage, isExportHatch);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityAdvancedSubstationEnergyHatch(metaTileEntityId, getTier(), amperage, isExportHatch);
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {
        if (this == AHMetaTileEntities.SUBSTATION_ENERGY_INPUT_1024A[0]) {
            for (MetaTileEntityAdvancedSubstationEnergyHatch hatch : AHMetaTileEntities.SUBSTATION_ENERGY_INPUT_102A_LOW) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityAdvancedSubstationEnergyHatch hatch : AHMetaTileEntities.SUBSTATION_ENERGY_INPUT_1024A) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityAdvancedSubstationEnergyHatch hatch : AHMetaTileEntities.SUBSTATION_ENERGY_OUTPUT_1024A_LOW) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (MetaTileEntityAdvancedSubstationEnergyHatch hatch : AHMetaTileEntities.SUBSTATION_ENERGY_OUTPUT_1024A) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
        }
    }
}
