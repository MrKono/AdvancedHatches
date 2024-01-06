package kono.ceu.advancedhatches.common.metatileentities;

import gregicality.multiblocks.common.metatileentities.multiblockpart.MetaTileEntityTieredHatch;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.common.metatileentities.converter.MetaTileEntityConverter;
import kono.ceu.advancedhatches.common.metatileentities.multiblockpart.ceu.MetaTileEntityAdvancedEnergyHatch;
import kono.ceu.advancedhatches.common.metatileentities.multiblockpart.gcym.MetaTileEntityAdvancedParallelHatch;
import kono.ceu.advancedhatches.common.metatileentities.single.MetaTileEntityUltraTransformer;
import net.minecraftforge.fml.common.Loader;

import static gregicality.multiblocks.api.utils.GCYMUtil.gcymId;
import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.TIERED_HATCH;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static kono.ceu.advancedhatches.api.util.AHValues.*;
import static kono.ceu.advancedhatches.api.util.AHValuesConfigurable.*;

public class AHMetaTileEntities {

    //EnergyHatches 25050 - 25147
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

    //Transformers 25006 - 25033
    public static final MetaTileEntityUltraTransformer[] ULTRA_HI_AMP_TRANSFORMER = new MetaTileEntityUltraTransformer[GTValues.V.length - 1];

    //Converter
    public static final MetaTileEntityConverter[][] HI_AMP_CONVERTER = new MetaTileEntityConverter[4][GTValues.UHV + 1];
    public static final MetaTileEntityUltraTransformer[] ULTRA_POWER_TRANSFORMER = new MetaTileEntityUltraTransformer[GTValues.V.length - 1];
    //ParallelHatch 25000- 25005
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_1024;
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_4096;
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_16384;
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_65536;
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_262144;
    public static MetaTileEntityAdvancedParallelHatch ADVANCED_PARALLEL_HATCH_1048576;

    public static void init(){
        /*
        MTE ID
        25000 - 25005 UDV+ Parallel Hatch
        25006 - 25033 Transformers
        25033 - 25049 Free
        25050 - 25147 Energy Hatches
        25148 - 25186 Converter
        25187 - 25207 reserved for UHV 256A Converter & UEV+ Converter
         */
        partsCEu();
        if (Loader.isModLoaded(MODNAME_GCYM)) {
            partsGCYM();
        }
    }


    public static void partsCEu() {
        int EnergyHatchEndPos = enabledHighTier ? GTValues.V.length :
                GregTechAPI.isHighTier() ? GTValues.V.length : GTValues.UHV + 1;
        for (int i = 0; i < EnergyHatchEndPos; i++) {
            String in = "energy_hatch.input_";
            String out = "energy_hatch.output_";
            String voltageName = GTValues.VN[i].toLowerCase();
            if (enabledLowTier && i < GTValues.IV) {
                ENERGY_INPUT_64A[i] = registerMetaTileEntity(25088 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "64a." + voltageName), i, 64, false));
                ENERGY_OUTPUT_64A[i] = registerMetaTileEntity(25103 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "64a." + voltageName), i, 64, true));
                ENERGY_INPUT_128A[i] = registerMetaTileEntity(25118 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "128a." + voltageName), i, 128, false));
                ENERGY_OUTPUT_128A[i] = registerMetaTileEntity(25133 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "128a." + voltageName), i, 128, true));
            }
            if (i >= GTValues.IV) {
                ENERGY_INPUT_64A[i] = registerMetaTileEntity(25088 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "64a." + voltageName), i, 64, false));
                ENERGY_OUTPUT_64A[i] = registerMetaTileEntity(25103 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "64a." + voltageName), i, 64, true));
                ENERGY_INPUT_128A[i] = registerMetaTileEntity(25118 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "128a." + voltageName), i, 128, false));
                ENERGY_OUTPUT_128A[i] = registerMetaTileEntity(25133 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "128a." + voltageName), i, 128, true));
            }
            if (enabledLowTier && i < GTValues.EV) {
                ENERGY_INPUT_4A_LOW[i] = registerMetaTileEntity(25050 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "4a." + voltageName), i, 4, false));
                ENERGY_OUTPUT_4A_LOW[i] = registerMetaTileEntity(25059 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "4a." + voltageName), i, 4, true));
            }
            if (enabledLowTier && i < GTValues.IV) {
                ENERGY_INPUT_16A_LOW[i] = registerMetaTileEntity(25068 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "16a." + voltageName), i, 16, false));
                ENERGY_OUTPUT_16A_LOW[i] = registerMetaTileEntity(25078 + i, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "16a." + voltageName), i, 16, true));
            }
            if (enabledHighTier && GTValues.UHV < i) {
                int j = i - 10;
                ENERGY_INPUT_4A_HIGH[j] = registerMetaTileEntity(25054 + j, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "4a." + voltageName), i, 4, false));
                ENERGY_OUTPUT_4A_HIGH[j] = registerMetaTileEntity(25063 + j, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "4a." + voltageName), i, 4, true));
                ENERGY_INPUT_16A_HIGH[j] = registerMetaTileEntity(25073 + j, new MetaTileEntityAdvancedEnergyHatch(ahId(in + "16a." + voltageName), i, 16, false));
                ENERGY_OUTPUT_16A_HIGH[j] = registerMetaTileEntity(25083 + j, new MetaTileEntityAdvancedEnergyHatch(ahId(out + "16a." + voltageName), i, 16, true));
            }
        }

        int TransformerEndPos = enabledHighTier ? ULTRA_HI_AMP_TRANSFORMER.length - 1 :
                GregTechAPI.isHighTier() ? ULTRA_HI_AMP_TRANSFORMER.length - 1 : GTValues.UV;
        for (int i = 0; i <= TransformerEndPos; i++) {
            ULTRA_HI_AMP_TRANSFORMER[i] = registerMetaTileEntity(25006 + i, new MetaTileEntityUltraTransformer(
                    ahId("transformer.ultra.hi_amp." + GTValues.VN[i].toLowerCase()), i, 1, 2, 4, 16, 64));
            ULTRA_POWER_TRANSFORMER[i] = registerMetaTileEntity(25020 + i, new MetaTileEntityUltraTransformer(
                    ahId("transformer.ultra.power." + GTValues.VN[i].toLowerCase()), i, 1, 2, 4, 16, 64, 128));
        }

        int[] amp = {32, 64, 128};
        for (int i = 0; i < HI_AMP_CONVERTER[0].length; i++) {
            for (int j = 0; j < 3; j++) {
                String id = "energy_converter.hi_amp." + GTValues.VN[i].toLowerCase() + "." +amp[j] + "a";
                HI_AMP_CONVERTER[j][i] = registerMetaTileEntity(25148 + j + i * 4, new MetaTileEntityConverter(ahId(id), i, amp[j]));
            }
            if (i < HI_AMP_CONVERTER[0].length - 1) {
                String id = "energy_converter.hi_amp." + GTValues.VN[i].toLowerCase() + ".256a";
                HI_AMP_CONVERTER[3][i] = registerMetaTileEntity(25148 + 3 + i * 4, new MetaTileEntityConverter(ahId(id), i, 256));
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

        if (enabledParallel1024) ADVANCED_PARALLEL_HATCH_1024 = registerMetaTileEntity(25000, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[9])), 9));
        if (enabledParallel4096) ADVANCED_PARALLEL_HATCH_4096 = registerMetaTileEntity(25001, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[10])), 10));
        if (enabledParallel16384) ADVANCED_PARALLEL_HATCH_16384 = registerMetaTileEntity(25002, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[11])), 11));
        if (enabledParallel65536) ADVANCED_PARALLEL_HATCH_65536 = registerMetaTileEntity(25003, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[12])), 12));
        if (enabledParallel262144) ADVANCED_PARALLEL_HATCH_262144 = registerMetaTileEntity(25004, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[13])), 13));
        if (enabledParallel1048576) ADVANCED_PARALLEL_HATCH_1048576 = registerMetaTileEntity(25005, new MetaTileEntityAdvancedParallelHatch(ahId(String.format("advanced_parallel_hatch.%s", GTValues.VN[14])), 14));
    }
}
