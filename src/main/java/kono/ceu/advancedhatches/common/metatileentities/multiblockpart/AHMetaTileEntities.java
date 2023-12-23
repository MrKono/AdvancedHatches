package kono.ceu.advancedhatches.common.metatileentities.multiblockpart;

import gregicality.multiblocks.common.metatileentities.multiblockpart.MetaTileEntityTieredHatch;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.texture.Textures;
import kono.ceu.advancedhatches.common.metatileentities.multiblockpart.ceu.MetaTileEntityAdvancedEnergyHatch;
import kono.ceu.advancedhatches.common.metatileentities.multiblockpart.gcym.MetaTileEntityAdvancedParallelHatch;
import net.minecraftforge.fml.common.Loader;

import static gregicality.multiblocks.api.utils.GCYMUtil.gcymId;
import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.TIERED_HATCH;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static kono.ceu.advancedhatches.api.util.AHValues.MOD_NAME_GSYM;
import static kono.ceu.advancedhatches.api.util.AHValues.ahId;

public class AHMetaTileEntities {

    //CEu
    //EnergyInput
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_INPUT_64A = new MetaTileEntityAdvancedEnergyHatch[GTValues.V.length];
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_INPUT_256A = new MetaTileEntityAdvancedEnergyHatch[GTValues.V.length];
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_INPUT_1024A = new MetaTileEntityAdvancedEnergyHatch[GTValues.V.length];

    //EnergyOutput
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_OUTPUT_64A = new MetaTileEntityAdvancedEnergyHatch[GTValues.V.length];
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_OUTPUT_256A = new MetaTileEntityAdvancedEnergyHatch[GTValues.V.length];
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_OUTPUT_1024A = new MetaTileEntityAdvancedEnergyHatch[GTValues.V.length];

    public static final SimpleMachineMetaTileEntity[] TEST = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];

    //GCYM
    //ParallelHatch
    public static final MetaTileEntityAdvancedParallelHatch[] ADVANCED_PARALLEL_HATCH = new MetaTileEntityAdvancedParallelHatch[6];

    public static void init(){
        partsCEu();
        if (Loader.isModLoaded(MOD_NAME_GSYM)) {
            partsGCYM();
        }
    }


    public static void partsCEu() {
        for (int i = 0; i < TEST.length; i++) {
            TEST[i] = registerMetaTileEntity(24000 + i, new SimpleMachineMetaTileEntity(ahId("test_machine." + GTValues.VN[i].toLowerCase()), RecipeMaps.MACERATOR_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, i, true));
        }
        //Energy Hatches
        for (int i = 0; i < GTValues.V.length; i++) {
            String in = "energy_hatch.input_";
            String out = "energy_hatch.output_";
            String voltageName = GTValues.VN[i].toLowerCase();
            //64A In 25050 - 25064
            ENERGY_INPUT_64A[i] = registerMetaTileEntity(25050 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "64a." + voltageName), i, 64, false));
            //64A Out 25065 - 25079
            ENERGY_OUTPUT_64A[i] = registerMetaTileEntity(25065 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "64a." + voltageName), i, 64, true));
            //256A In 25080 - 25094
            ENERGY_INPUT_256A[i] = registerMetaTileEntity(25080 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "256a." + voltageName), i, 256, false));
            //256A Out 25095 - 25109
            ENERGY_OUTPUT_256A[i] = registerMetaTileEntity(25095 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "256a." + voltageName), i, 256, true));
            //1024A In 25110 - 25124
            ENERGY_INPUT_1024A[i] = registerMetaTileEntity(25110 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "1024a." + voltageName), i, 1024, false));
            //1024A Out 25125 - 25139
            ENERGY_OUTPUT_1024A[i] = registerMetaTileEntity(25125 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "1024a." + voltageName), i, 1024, true));
        }
    }

    public static void partsGCYM() {
        if (!GregTechAPI.isHighTier()) {
            for (int i = GTValues.UEV; i < TIERED_HATCH.length; i++) {
                TIERED_HATCH[i] = registerMetaTileEntity(2054 + i,
                        new MetaTileEntityTieredHatch(gcymId(String.format("tiered_hatch.%s", GTValues.VN[i])), i));
            }
        }
        for (int i = 0; i < ADVANCED_PARALLEL_HATCH.length; i++) {
            int tier = GTValues.UHV + i;
            ADVANCED_PARALLEL_HATCH[i] = registerMetaTileEntity(25000 + i, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[tier])), tier));

        }
    }
}
