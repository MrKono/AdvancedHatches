package kono.ceu.advancedhatches.common.metatileentities;

import gregicality.multiblocks.common.metatileentities.multiblockpart.MetaTileEntityTieredHatch;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import kono.ceu.advancedhatches.common.metatileentities.multiblockpart.ceu.MetaTileEntityAdvancedEnergyHatch;
import kono.ceu.advancedhatches.common.metatileentities.multiblockpart.gcym.MetaTileEntityAdvancedParallelHatch;
import net.minecraftforge.fml.common.Loader;

import static gregicality.multiblocks.api.utils.GCYMUtil.gcymId;
import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.TIERED_HATCH;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static kono.ceu.advancedhatches.api.util.AHValues.*;
import static kono.ceu.advancedhatches.api.util.AHValuesConfigurable.*;

public class AHMetaTileEntities {

    //CEu
    //EnergyInput
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_INPUT_4A_LOW = new MetaTileEntityAdvancedEnergyHatch[4]; //ULV, LV, MV, HV
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_INPUT_4A_HIGH = new MetaTileEntityAdvancedEnergyHatch[5]; //UEV, UIV, UXV, OpV, MAX
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_INPUT_16A_LOW = new MetaTileEntityAdvancedEnergyHatch[5]; //ULV, LV, MV, HV, EV
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_INPUT_16A_HIGH = new MetaTileEntityAdvancedEnergyHatch[5]; //UEV, UIV, UXV, OpV, MAX
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_INPUT_64A = new MetaTileEntityAdvancedEnergyHatch[GTValues.V.length];
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_INPUT_128A = new MetaTileEntityAdvancedEnergyHatch[GTValues.V.length];

    //EnergyOutput
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_OUTPUT_4A_LOW = new MetaTileEntityAdvancedEnergyHatch[4]; //ULV, LV, MV, HV
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_OUTPUT_4A_HIGH = new MetaTileEntityAdvancedEnergyHatch[5]; //UEV, UIV, UXV, OpV, MAX
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_OUTPUT_16A_LOW = new MetaTileEntityAdvancedEnergyHatch[5]; //ULV, LV, MV, HV, EV
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_OUTPUT_16A_HIGH = new MetaTileEntityAdvancedEnergyHatch[5]; //UEV, UIV, UXV, OpV, MAX
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_OUTPUT_64A = new MetaTileEntityAdvancedEnergyHatch[GTValues.V.length];
    public static final MetaTileEntityAdvancedEnergyHatch[] ENERGY_OUTPUT_128A = new MetaTileEntityAdvancedEnergyHatch[GTValues.V.length];

    //GCYM
    //ParallelHatch
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_1024;
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_4096;
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_16384;
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_65536;
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_262144;
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_1048576;

    public static void init(){
        partsCEu();
        if (Loader.isModLoaded(MODNAME_GCYM)) {
            partsGCYM();
        }
    }


    public static void partsCEu() {
        /*
        Energy Hatches 25050 - 25
        4A In (ULV - HV, UEV - MAX) 25050 - 25053, 25054 - 25058
        4A Out (ULV - HV, UEV - MAX) 25059 - 25062, 25063 - 25067
        16A In (ULV - EV, UEV - MAX) 25068 - 25072, 25073 - 25077
        16A Out (ULV - EV, UEV - MAX) 25078 - 25082, 25083 - 25087
        64A In 25088 - 25102
        64A Out 25103 - 25117
        128A In 25118 - 25132
        128A Out 25133 - 25147
        */
        int endPos = enabledHighTier ? GTValues.V.length :
                GregTechAPI.isHighTier() ? GTValues.V.length : GTValues.UHV + 1;
        for (int i = 0; i < endPos; i++) {
            String in = "energy_hatch.input_";
            String out = "energy_hatch.output_";
            String voltageName = GTValues.VN[i].toLowerCase();
            if (enabledLowTier && i < GTValues.IV) {
                ENERGY_INPUT_64A[i] = registerMetaTileEntity(25088 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "64a." + voltageName), i, 64, false));
                ENERGY_OUTPUT_64A[i] = registerMetaTileEntity(25103 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "64a." + voltageName), i, 64, true));
                ENERGY_INPUT_128A[i] = registerMetaTileEntity(25118 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "128a." + voltageName), i, 128, false));
                ENERGY_OUTPUT_128A[i] = registerMetaTileEntity(25133 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "128a." + voltageName), i, 128, true));
            }
            if (i >= GTValues.IV) {
                ENERGY_INPUT_64A[i] = registerMetaTileEntity(25088 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "64a." + voltageName), i, 64, false));
                ENERGY_OUTPUT_64A[i] = registerMetaTileEntity(25103 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "64a." + voltageName), i, 64, true));
                ENERGY_INPUT_128A[i] = registerMetaTileEntity(25118 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "128a." + voltageName), i, 128, false));
                ENERGY_OUTPUT_128A[i] = registerMetaTileEntity(25133 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "128a." + voltageName), i, 128, true));
            }
            if (enabledLowTier && i < GTValues.EV) {
                //4A ULV - HV, 25050 - 25053
                ENERGY_INPUT_4A_LOW[i] = registerMetaTileEntity(25050 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "4a." + voltageName), i, 4, false));
                // 25059 - 25062
                ENERGY_OUTPUT_4A_LOW[i] = registerMetaTileEntity(25059 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "4a." + voltageName), i, 4, true));
            }
            if (enabledLowTier && i < GTValues.IV) {
                //01234 ULV - EV 25068 - 25072
                ENERGY_INPUT_16A_LOW[i] = registerMetaTileEntity(25068 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "16a." + voltageName), i, 16, false));
                // 25078 - 15082
                ENERGY_OUTPUT_16A_LOW[i] = registerMetaTileEntity(25078 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "16a." + voltageName), i, 16, true));
            }
            if (enabledHighTier && GTValues.UHV < i) {
                int j = i - 10;
                // 25054 - 25058
                ENERGY_INPUT_4A_HIGH[j] = registerMetaTileEntity(25054 + j, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "4a." + voltageName), i, 4, false));
                // 25063 - 25067
                ENERGY_OUTPUT_4A_HIGH[j] = registerMetaTileEntity(25063 + j, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "4a." + voltageName), i, 4, true));
                // 25073 - 25077
                ENERGY_INPUT_16A_HIGH[j] = registerMetaTileEntity(25073 + j, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "16a." + voltageName), i, 16, false));
                // 25083 - 25087
                ENERGY_OUTPUT_16A_HIGH[j] = registerMetaTileEntity(25083 + j, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "16a." + voltageName), i, 16, true));
            }
        }
    }


    public static void partsGCYM() {
        if (!GregTechAPI.isHighTier() && enabledHighVoltageUnit) {
            for (int i = GTValues.UEV; i < TIERED_HATCH.length; i++) {
                TIERED_HATCH[i] = registerMetaTileEntity(2054 + i,
                        new MetaTileEntityTieredHatch(gcymId(String.format("tiered_hatch.%s", GTValues.VN[i])), i));
            }
        }

        //Parallel Hatches 25000 - 25005
        if (enabledParallel1024) ADVANCED_PARALLEL_HATCH_1024 = registerMetaTileEntity(25000, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[9])), 9));
        if (enabledParallel4096) ADVANCED_PARALLEL_HATCH_4096 = registerMetaTileEntity(25001, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[10])), 10));
        if (enabledParallel16384) ADVANCED_PARALLEL_HATCH_16384 = registerMetaTileEntity(25002, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[11])), 11));
        if (enabledParallel65536) ADVANCED_PARALLEL_HATCH_65536 = registerMetaTileEntity(25003, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[12])), 12));
        if (enabledParallel262144) ADVANCED_PARALLEL_HATCH_262144 = registerMetaTileEntity(25004, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[13])), 13));
        if (enabledParallel1048576) ADVANCED_PARALLEL_HATCH_1048576 = registerMetaTileEntity(25005, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[14])), 14));
    }
}
