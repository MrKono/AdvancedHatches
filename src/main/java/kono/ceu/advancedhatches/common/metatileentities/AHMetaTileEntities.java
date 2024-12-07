package kono.ceu.advancedhatches.common.metatileentities;

import gregicality.multiblocks.common.metatileentities.multiblockpart.MetaTileEntityTieredHatch;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityRotorHolder;
import kono.ceu.advancedhatches.AHConfig;
import kono.ceu.advancedhatches.AdvancedHatchesLog;
import kono.ceu.advancedhatches.common.metatileentities.multiblockpart.ceu.*;
import kono.ceu.advancedhatches.common.metatileentities.multiblockpart.gcym.MetaTileEntityAdvancedParallelHatch;
import kono.ceu.advancedhatches.common.metatileentities.single.MetaTileEntityAdvancedTransformer;

import static gregicality.multiblocks.api.utils.GCYMUtil.gcymId;
import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.TIERED_HATCH;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static kono.ceu.advancedhatches.api.util.AHValues.*;
import static kono.ceu.advancedhatches.api.util.AHValuesConfigurable.*;

public class AHMetaTileEntities {

    public static int startId = AHConfig.Id.startId;

    //EnergyHatches 25050 - 25147
    //EnergyInput
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_INPUT_4A_LOW = new MetaTileEntityMultiAmpEnergyHatch[4]; //ULV-HV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_INPUT_4A_HIGH = new MetaTileEntityMultiAmpEnergyHatch[4]; //UEV-OpV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_INPUT_16A_LOW = new MetaTileEntityMultiAmpEnergyHatch[5]; //ULV-EV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_INPUT_16A_HIGH = new MetaTileEntityMultiAmpEnergyHatch[4]; //UEV-OpV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_INPUT_64A_LOW = new MetaTileEntityMultiAmpEnergyHatch[5]; //ULV-EV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_INPUT_64A = new MetaTileEntityMultiAmpEnergyHatch[9]; //IV-OpV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_INPUT_256A_LOW = new MetaTileEntityMultiAmpEnergyHatch[6]; //ULV-IV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_INPUT_256A = new MetaTileEntityMultiAmpEnergyHatch[8]; //LuV-OpV

    //EnergyOutput
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_OUTPUT_4A_LOW = new MetaTileEntityMultiAmpEnergyHatch[4]; //ULV-HV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_OUTPUT_4A_HIGH = new MetaTileEntityMultiAmpEnergyHatch[4]; //UEV-OpV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_OUTPUT_16A_LOW = new MetaTileEntityMultiAmpEnergyHatch[5]; //ULV-EV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_OUTPUT_16A_HIGH = new MetaTileEntityMultiAmpEnergyHatch[4]; //UEV-OpV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_OUTPUT_64A_LOW = new MetaTileEntityMultiAmpEnergyHatch[5]; //ULV-EV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_OUTPUT_64A = new MetaTileEntityMultiAmpEnergyHatch[9]; //IV-OpV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_OUTPUT_256A_LOW = new MetaTileEntityMultiAmpEnergyHatch[6]; //ULV-IV
    public static final MetaTileEntityMultiAmpEnergyHatch[] ENERGY_OUTPUT_256A = new MetaTileEntityMultiAmpEnergyHatch[8]; //LuV-OpV

    // SubStation
    public static final MetaTileEntityAdvancedSubstationEnergyHatch[] SUBSTATION_ENERGY_INPUT_102A_LOW = new MetaTileEntityAdvancedSubstationEnergyHatch[6]; //ULV-IV
    public static final MetaTileEntityAdvancedSubstationEnergyHatch[] SUBSTATION_ENERGY_INPUT_1024A = new MetaTileEntityAdvancedSubstationEnergyHatch[8]; //LuV-OpV
    public static final MetaTileEntityAdvancedSubstationEnergyHatch[] SUBSTATION_ENERGY_OUTPUT_1024A_LOW = new MetaTileEntityAdvancedSubstationEnergyHatch[6]; //ULV-IV
    public static final MetaTileEntityAdvancedSubstationEnergyHatch[] SUBSTATION_ENERGY_OUTPUT_1024A = new MetaTileEntityAdvancedSubstationEnergyHatch[8]; //LuV-OpV

    //Transformers 25006 - 25033
    public static final MetaTileEntityAdvancedTransformer[] HI_POWER_TRANSFORMER = new MetaTileEntityAdvancedTransformer[GTValues.V.length - 1];
    public static final MetaTileEntityAdvancedTransformer[] EXTREME_POWER_TRANSFORMER = new MetaTileEntityAdvancedTransformer[GTValues.V.length - 1];

    // Rotor Holder
    public static final MetaTileEntityRotorHolder[] ROTOR_HOLDERS_HI = new MetaTileEntityRotorHolder[5]; // UHV - MAX
    public static final MetaTileEntityPowerEnhancedRotorHolder[] POWER_ENHANCED_ROTOR_HOLDERS = new MetaTileEntityPowerEnhancedRotorHolder[9]; //IV+
    public static final MetaTileEntityEfficiencyEnhancedRotorHolder[] EFFICIENCY_ENHANCED_ROTOR_HOLDERS = new MetaTileEntityEfficiencyEnhancedRotorHolder[9]; //IV+
    public static final MetaTileEntityAdvancedRotorHolder[] ADVANCED_ROTOR_HOLDERS = new MetaTileEntityAdvancedRotorHolder[9]; //IV+

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

         */
        partsCEu();
        machine();
        //if (Mods.GregicalityMultiblocks.isModLoaded()) {
            //partsGCYM();
        //}
    }

    // MetaTileEntityID is the value for the default case
    public static void partsCEu() {
        // Energy Hatch & Dynamo Hatch Section
        AdvancedHatchesLog.logger.info("Energy Hatches...");
        int id = startId;
        int EnergyHatchEndPos = GregTechAPI.isHighTier() ? ENERGY_INPUT_HATCH.length - 1 :
                Math.min(ENERGY_INPUT_HATCH.length - 1, GTValues.UV + 2);
        String energy_in = "energy_hatch.input_";
        String energy_out = "energy_hatch.output_";
        // 4A: 25000-25015
        for (int i = 0; i < EnergyHatchEndPos; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            // ULV-HV Input: 25000-25003, ULV-HV Output: 25008-25011
            if (enabledLowTier && i < GTValues.EV) {
                ENERGY_INPUT_4A_LOW[i] = registerMetaTileEntity(id + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_in + "4a." + voltageName), i, 4, false));
                ENERGY_OUTPUT_4A_LOW[i] = registerMetaTileEntity(id + 8 + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_out + "4a." + voltageName), i, 4, true));
            }
            // UEV-OpV Input: 25004-25007, UEV-MAX Output:25012-25015
            if (GregTechAPI.isHighTier() && GTValues.UHV < i) {
                int j = i - 10;
                ENERGY_INPUT_4A_HIGH[j] = registerMetaTileEntity(id + 4 + j,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_in + "4a." + voltageName), i, 4, false));
                ENERGY_OUTPUT_4A_HIGH[j] = registerMetaTileEntity(id + 12 + j,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_out + "4a." + voltageName), i, 4, true));
            }
        }

        id = id + 16; // 20016
        // 16A: 25016-25035
        for (int i = 0; i < EnergyHatchEndPos; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            // ULV-EV Input: 25016-25020, ULV-EV Output: 25025-25029
            if (enabledLowTier && i < GTValues.IV) {
                ENERGY_INPUT_16A_LOW[i] = registerMetaTileEntity(id + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_in + "16a." + voltageName), i, 16, false));
                ENERGY_OUTPUT_16A_LOW[i] = registerMetaTileEntity(id + 9 + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_out + "16a." + voltageName), i, 16, true));
            }
            // UEV+ Input: 25021-25024, UEV+ Output:25030-25033
            if (GregTechAPI.isHighTier() && GTValues.UHV < i) {
                int j = i - 10;
                ENERGY_INPUT_16A_HIGH[j] = registerMetaTileEntity(id + 5 + j,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_in + "16a." + voltageName), i, 16, false));
                ENERGY_OUTPUT_16A_HIGH[j] = registerMetaTileEntity(id + 14 + j,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_out + "16a." + voltageName), i, 16, true));
            }
        }

        // 64A: 20034-20051
        id = id + 18; // 20034
        for (int i = 0;  i < EnergyHatchEndPos; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            // ULV-EV Input: 25034-25038, ULV-EV Output: 25048-25052
            if (enabledLowTier && i < GTValues.IV) {
                ENERGY_INPUT_64A_LOW[i] = registerMetaTileEntity(id + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_in + "64a." + voltageName), i, 64, false));
                ENERGY_OUTPUT_64A_LOW[i] = registerMetaTileEntity(id + 14 + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_out + "64a." + voltageName), i, 64, true));
            }
            // IV-OpV Input: 25039-25047, IV-OpV Output:25053-25061
            if (GTValues.IV <= i) {
                ENERGY_INPUT_64A[i - 5] = registerMetaTileEntity(id + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_in + "64a." + voltageName), i, 64, false));
                ENERGY_OUTPUT_64A[i - 5] = registerMetaTileEntity(id + 14 + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_out + "64a." + voltageName), i, 64, true));
            }
        }

        // 256A: 20062-25099
        id = id + 28; // 20062
        for (int i = 0;  i < EnergyHatchEndPos; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            // ULV-IV Input: 25062-25067, ULV-HV Output: 25076-25081
            if (enabledLowTier && i < GTValues.LuV) {
                ENERGY_INPUT_256A_LOW[i] = registerMetaTileEntity(id + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_in + "256a." + voltageName), i, 256, false));
                ENERGY_OUTPUT_256A_LOW[i] = registerMetaTileEntity(id + 14 + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_out + "256a." + voltageName), i, 256, true));
            }
            // LuV+ Input: 25068-25075, LuV+ Out: 25082-25099
            if (GTValues.LuV <= i) {
                ENERGY_INPUT_256A[i - 6] = registerMetaTileEntity(id + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_in + "256a." + voltageName), i, 256, false));
                ENERGY_OUTPUT_256A[i - 6] = registerMetaTileEntity(id + 14 + i,
                        new MetaTileEntityMultiAmpEnergyHatch(ahId(energy_out + "256a." + voltageName), i, 256, true));
            }
        }

        AdvancedHatchesLog.logger.info("Substation Energy Hatches...");
        // PowerSubstation Energy Hatch & Dynamo Hatch Section, 25100-25127
        id = id + 28; // 250100
        for (int i = 0;  i < EnergyHatchEndPos; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            // ULV-IV Input: 25100-25105, ULV-IV Output: 25114-25119
            if (enabledLowTier && i < GTValues.LuV) {
                SUBSTATION_ENERGY_INPUT_102A_LOW[i] = registerMetaTileEntity(id + i,
                        new MetaTileEntityAdvancedSubstationEnergyHatch(ahId("substation_hatch.input_1024a." + voltageName), i, 1024, false));
                SUBSTATION_ENERGY_OUTPUT_1024A_LOW[i] = registerMetaTileEntity(id + 14 + i,
                        new MetaTileEntityAdvancedSubstationEnergyHatch(ahId("substation_hatch.output_1024a." + voltageName), i, 1024, true));
            }
            // LuV-OpV Input: 25106-25113, LuV-OpV Output:25120-25127
            if (GTValues.LuV <= i) {
                SUBSTATION_ENERGY_INPUT_1024A[i - 6] = registerMetaTileEntity(id + i,
                        new MetaTileEntityAdvancedSubstationEnergyHatch(ahId("substation_hatch.input_1024a." + voltageName), i, 1024, false));
                SUBSTATION_ENERGY_OUTPUT_1024A[i - 6] = registerMetaTileEntity(id + 14 + i,
                        new MetaTileEntityAdvancedSubstationEnergyHatch(ahId("substation_hatch.output_1024a." + voltageName), i, 1024, true));
            }
        }
        // Rotor Holder Section
        id = startId + 156;
        AdvancedHatchesLog.logger.info("Rotor Holders...");

        // UHV-OpV Rotor Holder: 25156-25160
        ROTOR_HOLDERS_HI[0] = registerMetaTileEntity(id, new MetaTileEntityRotorHolder(ahId("rotor_holder.uhv"), GTValues.UHV));
        if (GregTechAPI.isHighTier()) {
            for (int i = 1; i < ROTOR_HOLDERS_HI.length; i++) {
                ROTOR_HOLDERS_HI[i] = registerMetaTileEntity(id + i, new MetaTileEntityRotorHolder(ahId("rotor_holder." + GTValues.VN[i + 9].toLowerCase()), 9 + i));
            }
        }

        // IV-OpV Enhanced Rotor Holders: 25161-25187
        id = id + 5;
        int rotorEndPos = GregTechAPI.isHighTier() ? POWER_ENHANCED_ROTOR_HOLDERS.length: GTValues.UEV - GTValues.IV;
        for (int i = 0; i < rotorEndPos; i ++) {
            int v = i + GTValues.IV;
            String voltage = GTValues.VN[v].toLowerCase();
            // Power Enhanced: 25161-25169
            POWER_ENHANCED_ROTOR_HOLDERS[i] = registerMetaTileEntity(id + i, new MetaTileEntityPowerEnhancedRotorHolder(ahId("rotor_holder.enhanced.power." + voltage), v));
            // Efficiency Enhanced: 25170-25178
            EFFICIENCY_ENHANCED_ROTOR_HOLDERS[i] = registerMetaTileEntity(id + 9 + i, new MetaTileEntityEfficiencyEnhancedRotorHolder(ahId("rotor_holder.enhanced.efficiency." + voltage), v));
            // Advanced 25179-25187
            ADVANCED_ROTOR_HOLDERS[i] = registerMetaTileEntity(id + 18 + i, new MetaTileEntityAdvancedRotorHolder(ahId("rotor_holder.advanced." + voltage), v));
        }
    }

    public static void machine() {
        // Transformer: 25128-25155
        int id = startId + 128;
        int TransformerEndPos = GregTechAPI.isHighTier() ? HI_POWER_TRANSFORMER.length - 1 : GTValues.UV;
        for (int i = 0; i <= TransformerEndPos; i++) {
            HI_POWER_TRANSFORMER[i] = registerMetaTileEntity(id + i, new MetaTileEntityAdvancedTransformer(
                    ahId("transformer.hi_power." + GTValues.VN[i].toLowerCase()), i, 1, 2, 4, 16, 64));
            EXTREME_POWER_TRANSFORMER[i] = registerMetaTileEntity(id + 14 + i, new MetaTileEntityAdvancedTransformer(
                    ahId("transformer.extreme_power." + GTValues.VN[i].toLowerCase()), i, 1, 2, 4, 16, 64, 256));
        }

    }

    /*
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
    */
}
