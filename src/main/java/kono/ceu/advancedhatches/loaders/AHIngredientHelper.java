package kono.ceu.advancedhatches.loaders;

import static gregtech.common.items.MetaItems.*;

import gregtech.api.GTValues;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;

public class AHIngredientHelper {

    private static String Error(int voltage) {
        return "Out of voltage: " + GTValues.VN[voltage];
    }

    public static Material voltageMaterial(int voltage) {
        return switch (voltage) {
            case 0 -> Materials.WroughtIron;
            case 1 -> Materials.Steel;
            case 2 -> Materials.Aluminium;
            case 3 -> Materials.StainlessSteel;
            case 4 -> Materials.Titanium;
            case 5 -> Materials.TungstenSteel;
            case 6 -> Materials.RhodiumPlatedPalladium;
            case 7 -> Materials.NaquadahAlloy;
            case 8 -> Materials.Darmstadtium;
            case 9 -> Materials.Neutronium;
            default -> throw new IllegalStateException("Out of Voltage: " + GTValues.VN[voltage]);
        };
    }

    public static Material voltagePartsMaterial(int voltage) {
        return switch (voltage) {
            case 0 -> Materials.Lead;
            case 1 -> Materials.Tin;
            case 2 -> Materials.Copper;
            case 3 -> Materials.Gold;
            case 4 -> Materials.Aluminium;
            case 5 -> Materials.Tungsten;
            case 6 -> Materials.NiobiumTitanium;
            case 7 -> Materials.VanadiumGallium;
            case 8 -> Materials.YttriumBariumCuprate;
            case 9 -> Materials.Europium;
            default -> throw new IllegalStateException(Error(voltage));
        };
    }

    public static MetaItem<?>.MetaValueItem PICs(int voltage) {
        return switch (voltage) {
            case 0, 1, 2 -> ULTRA_LOW_POWER_INTEGRATED_CIRCUIT;
            case 3 -> LOW_POWER_INTEGRATED_CIRCUIT;
            case 4 -> POWER_INTEGRATED_CIRCUIT;
            case 5, 6 -> HIGH_POWER_INTEGRATED_CIRCUIT;
            case 7, 8, 9 -> ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT;
            default -> throw new IllegalStateException(Error(voltage));
        };
    }

    public static MetaItem<?>.MetaValueItem PICWs(int voltage) {
        return switch (voltage) {
            case 0, 1, 2 -> ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER;
            case 3 -> LOW_POWER_INTEGRATED_CIRCUIT_WAFER;
            case 4 -> POWER_INTEGRATED_CIRCUIT_WAFER;
            case 5, 6 -> HIGH_POWER_INTEGRATED_CIRCUIT_WAFER;
            case 7, 8, 9 -> ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT_WAFER;
            default -> throw new IllegalStateException(Error(voltage));
        };
    }

    public static MetaItem<?>.MetaValueItem Pump(int voltage) {
        return switch (voltage) {
            case 0, 1 -> ELECTRIC_PUMP_LV;
            case 2 -> ELECTRIC_PUMP_MV;
            case 3 -> ELECTRIC_PUMP_HV;
            case 4 -> ELECTRIC_PUMP_EV;
            case 5 -> ELECTRIC_PUMP_IV;
            case 6 -> ELECTRIC_PUMP_LuV;
            case 7 -> ELECTRIC_PUMP_ZPM;
            case 8 -> ELECTRIC_PUMP_UV;
            default -> throw new IllegalStateException(Error(voltage));
        };
    }

    public static MetaItem<?>.MetaValueItem VoltageCoil(int voltage) {
        return switch (voltage) {
            case 0 -> VOLTAGE_COIL_ULV;
            case 1 -> VOLTAGE_COIL_LV;
            case 2 -> VOLTAGE_COIL_MV;
            case 3 -> VOLTAGE_COIL_HV;
            case 4 -> VOLTAGE_COIL_EV;
            case 5 -> VOLTAGE_COIL_IV;
            case 6 -> VOLTAGE_COIL_LuV;
            case 7 -> VOLTAGE_COIL_ZPM;
            case 8, 9 -> VOLTAGE_COIL_UV;
            default -> throw new IllegalStateException(Error(voltage));
        };
    }

    public static Material tier(int voltage) {
        return switch (voltage) {
            case 0 -> MarkerMaterials.Tier.ULV;
            case 1 -> MarkerMaterials.Tier.LV;
            case 2 -> MarkerMaterials.Tier.MV;
            case 3 -> MarkerMaterials.Tier.HV;
            case 4 -> MarkerMaterials.Tier.EV;
            case 5 -> MarkerMaterials.Tier.IV;
            case 6 -> MarkerMaterials.Tier.LuV;
            case 7 -> MarkerMaterials.Tier.ZPM;
            case 8 -> MarkerMaterials.Tier.UV;
            case 9 -> MarkerMaterials.Tier.UHV;
            default -> throw new IllegalStateException("Out of Voltage: " + GTValues.VN[voltage]);
        };
    }

    public static Material lossless(int voltage) {
        return switch (voltage) {
            case 0 -> Materials.RedAlloy;
            case 1 -> Materials.ManganesePhosphide;
            case 2 -> Materials.MagnesiumDiboride;
            case 3 -> Materials.MercuryBariumCalciumCuprate;
            case 4 -> Materials.UraniumTriplatinum;
            case 5 -> Materials.SamariumIronArsenicOxide;
            case 6 -> Materials.IndiumTinBariumTitaniumCuprate;
            case 7 -> Materials.UraniumRhodiumDinaquadide;
            case 8 -> Materials.EnrichedNaquadahTriniumEuropiumDuranide;
            case 9 -> Materials.RutheniumTriniumAmericiumNeutronate;
            default -> throw new IllegalStateException(Error(voltage));
        };
    }
}
