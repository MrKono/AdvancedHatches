package kono.ceu.advancedhatches.loaders.recipe;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static kono.ceu.advancedhatches.common.metatileentities.AHMetaTileEntities.*;
import static kono.ceu.advancedhatches.loaders.AHIngredientHelper.*;

import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;

public class AHMTEMachineRecipeLoader {

    public static final int sec = 20;
    public static final int min = 60 * sec;

    public static void EnergyHatchesLow() {
        // 4A and 16A: ULV-HV
        for (int i = 0; i < 4; i++) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_INPUT_HATCH[i])
                    .input(OrePrefix.wireGtQuadruple, voltagePartsMaterial(i), 2)
                    .input(OrePrefix.plate, voltageMaterial(i), 2)
                    .output(ENERGY_INPUT_4A_LOW[i])
                    .EUt(VA[EV]).duration(5 * sec).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(TRANSFORMER[i])
                    .input(ENERGY_INPUT_4A_LOW[i])
                    .input(OrePrefix.wireGtOctal, voltagePartsMaterial(i), 2)
                    .input(OrePrefix.plate, voltageMaterial(i), 4)
                    .output(ENERGY_INPUT_16A_LOW[i])
                    .EUt(VA[EV]).duration(10 * sec).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[i])
                    .input(OrePrefix.wireGtQuadruple, voltagePartsMaterial(i), 2)
                    .input(OrePrefix.plate, voltageMaterial(i), 2)
                    .output(ENERGY_OUTPUT_4A_LOW[i])
                    .EUt(VA[EV]).duration(5 * sec).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(TRANSFORMER[i])
                    .input(ENERGY_OUTPUT_4A_LOW[i])
                    .input(OrePrefix.wireGtOctal, voltagePartsMaterial(i), 2)
                    .input(OrePrefix.plate, voltageMaterial(i), 4)
                    .output(ENERGY_OUTPUT_16A_LOW[i])
                    .EUt(VA[EV]).duration(10 * sec).buildAndRegister();
        }
        // 64A: ULV-EV
        for (int i = 0; i < 5; i++) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[i])
                    .input(ENERGY_INPUT_16A_LOW[i])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 2)
                    .input(OrePrefix.plate, voltageMaterial(i), 6)
                    .output(ENERGY_INPUT_64A_LOW[i])
                    .EUt(VA[EV]).duration(20 * sec).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[i])
                    .input(ENERGY_OUTPUT_16A_LOW[i])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 2)
                    .input(OrePrefix.plate, voltageMaterial(i), 6)
                    .output(ENERGY_OUTPUT_64A_LOW[i])
                    .EUt(VA[EV]).duration(20 * sec).buildAndRegister();
        }
        // 256A and 1024A: ULV-IV
        for (int i = 0; i < 6; i++) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_POWER_TRANSFORMER[i])
                    .input(i == 5 ? ENERGY_INPUT_64A[0] : ENERGY_INPUT_64A_LOW[i])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 4)
                    .input(OrePrefix.plate, voltageMaterial(i), 8)
                    .output(ENERGY_INPUT_256A_LOW[i])
                    .EUt(VA[EV]).duration(40 * sec).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_POWER_TRANSFORMER[i])
                    .input(i == 5 ? ENERGY_OUTPUT_64A[0] : ENERGY_OUTPUT_64A_LOW[i])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 4)
                    .input(OrePrefix.plate, voltageMaterial(i), 8)
                    .output(ENERGY_OUTPUT_256A_LOW[i])
                    .EUt(VA[EV]).duration(40 * sec).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXTREME_POWER_TRANSFORMER[i])
                    .input(ENERGY_INPUT_256A_LOW[i])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 16)
                    .input(OrePrefix.plate, voltageMaterial(i), 10)
                    .output(SUBSTATION_ENERGY_INPUT_102A_LOW[i])
                    .EUt(VA[EV]).duration(80 * sec).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXTREME_POWER_TRANSFORMER[i])
                    .input(ENERGY_OUTPUT_256A_LOW[i])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 16)
                    .input(OrePrefix.plate, voltageMaterial(i), 10)
                    .output(SUBSTATION_ENERGY_OUTPUT_1024A_LOW[i])
                    .EUt(VA[EV]).duration(80 * sec).buildAndRegister();
        }
    }

    public static void EnergyHatches() {
        // 64A: IV-UHV
        for (int i = IV; i < UHV + 1; i++) {
            ModHandler.addShapelessRecipe("convert_to_" + GTValues.VN[i].toLowerCase() + "_64a_energy_hatch",
                    ENERGY_INPUT_64A[i - 5].getStackForm(), SUBSTATION_ENERGY_INPUT_HATCH[i - 5].getStackForm());
            ModHandler.addShapelessRecipe("convert_" + GTValues.VN[i].toLowerCase() + "_64a_dynamo_hatch",
                    ENERGY_OUTPUT_64A[i - 5].getStackForm(), SUBSTATION_ENERGY_OUTPUT_HATCH[i - 5].getStackForm());
            ModHandler.addShapelessRecipe("convert_to_" + GTValues.VN[i].toLowerCase() + "_64a_substation_energy_hatch",
                    SUBSTATION_ENERGY_INPUT_HATCH[i - 5].getStackForm(), ENERGY_INPUT_64A[i - 5].getStackForm());
            ModHandler.addShapelessRecipe("convert_" + GTValues.VN[i].toLowerCase() + "_64a_substation_dynamo_hatch",
                    SUBSTATION_ENERGY_OUTPUT_HATCH[i - 5].getStackForm(), ENERGY_OUTPUT_64A[i - 5].getStackForm());
        }

        // 256A and 1024A: LuV-UHV
        for (int i = LuV; i < UHV + 1; i++) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_POWER_TRANSFORMER[i])
                    .input(ENERGY_INPUT_64A[i - 6])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 4)
                    .input(OrePrefix.plate, voltageMaterial(i), 8)
                    .output(ENERGY_INPUT_256A[i - 6])
                    .EUt(VA[EV]).duration(40 * sec).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_POWER_TRANSFORMER[i])
                    .input(ENERGY_OUTPUT_64A[i - 6])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 4)
                    .input(OrePrefix.plate, voltageMaterial(i), 8)
                    .output(ENERGY_OUTPUT_256A[i - 6])
                    .EUt(VA[EV]).duration(40 * sec).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXTREME_POWER_TRANSFORMER[i])
                    .input(ENERGY_INPUT_256A[i - 6])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 16)
                    .input(OrePrefix.plate, voltageMaterial(i), 10)
                    .output(SUBSTATION_ENERGY_INPUT_1024A[i - 6])
                    .EUt(VA[EV]).duration(80 * sec).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXTREME_POWER_TRANSFORMER[i])
                    .input(ENERGY_OUTPUT_256A[i - 6])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 16)
                    .input(OrePrefix.plate, voltageMaterial(i), 10)
                    .output(SUBSTATION_ENERGY_OUTPUT_1024A[i - 6])
                    .EUt(VA[EV]).duration(80 * sec).buildAndRegister();
        }
    }

    public static void Transformers() {
        for (int i = 0; i < GTValues.UHV; i++) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[i])
                    .input(Pump(i))
                    .input(OrePrefix.cableGtOctal, voltagePartsMaterial(i + 1), 4)
                    .input(OrePrefix.cableGtHex, voltagePartsMaterial(i), 8)
                    .input(OrePrefix.springSmall, voltagePartsMaterial(i), 4)
                    .input(OrePrefix.spring, voltagePartsMaterial(i + 1), 4)
                    .fluidInputs(Lubricant.getFluid(8000))
                    .output(HI_POWER_TRANSFORMER[i])
                    .EUt(VA[i]).duration(800).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_POWER_TRANSFORMER[i])
                    .input(Pump(i))
                    .input(OrePrefix.cableGtOctal, voltagePartsMaterial(i + 1), 16)
                    .input(OrePrefix.cableGtHex, voltagePartsMaterial(i), 32)
                    .input(OrePrefix.springSmall, voltagePartsMaterial(i), 16)
                    .input(OrePrefix.spring, voltagePartsMaterial(i + 1), 16)
                    .fluidInputs(Lubricant.getFluid(32000))
                    .output(EXTREME_POWER_TRANSFORMER[i])
                    .EUt(VA[i]).duration(3200).buildAndRegister();
        }
    }

    public static void RotorHolders() {
        // Rotor Holder (UHV)
        ModHandler.addShapedRecipe(true, "rotor_holder_uhv", ROTOR_HOLDERS_HI[0].getStackForm(),
                "SGS", "GHG", "SGS",
                'H', MetaTileEntities.HULL[UHV].getStackForm(),
                'G', new UnificationEntry(OrePrefix.gear, Duranium),
                'S', new UnificationEntry(OrePrefix.gearSmall, Neutronium));

        // Enhanced Rotor Holder (IV)
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[IV])
                .input(OrePrefix.gear, HSSG, 8)
                .input(OrePrefix.gearSmall, TungstenSteel, 8)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .fluidInputs(SodiumPotassium.getFluid(2000))
                .output(POWER_ENHANCED_ROTOR_HOLDERS[0])
                .EUt(VH[ZPM]).duration(1200).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[IV])
                .input(OrePrefix.gear, HSSG, 8)
                .input(OrePrefix.gearSmall, TungstenSteel, 8)
                .fluidInputs(Lubricant.getFluid(8000))
                .output(EFFICIENCY_ENHANCED_ROTOR_HOLDERS[0])
                .EUt(VH[ZPM]).duration(1200).buildAndRegister();

        // Enhanced Rotor Holder (LuV - UHV)
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[LuV])
                .input(OrePrefix.gear, Ruthenium, 8)
                .input(OrePrefix.gearSmall, RhodiumPlatedPalladium, 8)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .fluidInputs(SodiumPotassium.getFluid(4000))
                .output(POWER_ENHANCED_ROTOR_HOLDERS[1])
                .stationResearch(b -> b
                        .researchStack(POWER_ENHANCED_ROTOR_HOLDERS[0].getStackForm())
                        .CWUt(16).EUt(VA[UV]))
                .duration(1200).EUt(VA[UV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .input(OrePrefix.gear, Trinium, 8)
                .input(OrePrefix.gearSmall, NaquadahAlloy, 8)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .fluidInputs(SodiumPotassium.getFluid(8000))
                .output(POWER_ENHANCED_ROTOR_HOLDERS[2])
                .stationResearch(b -> b
                        .researchStack(POWER_ENHANCED_ROTOR_HOLDERS[1].getStackForm())
                        .CWUt(64).EUt(VA[UV]))
                .duration(1200).EUt(VA[UV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(OrePrefix.gear, Tritanium, 8)
                .input(OrePrefix.gearSmall, Darmstadtium, 8)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .fluidInputs(SodiumPotassium.getFluid(16000))
                .output(POWER_ENHANCED_ROTOR_HOLDERS[3])
                .stationResearch(b -> b
                        .researchStack(POWER_ENHANCED_ROTOR_HOLDERS[2].getStackForm())
                        .CWUt(128).EUt(VA[UV]))
                .duration(1200).EUt(VA[UV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(OrePrefix.gear, Duranium, 8)
                .input(OrePrefix.gearSmall, Neutronium, 8)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .fluidInputs(SodiumPotassium.getFluid(32000))
                .output(POWER_ENHANCED_ROTOR_HOLDERS[4])
                .stationResearch(b -> b
                        .researchStack(POWER_ENHANCED_ROTOR_HOLDERS[3].getStackForm())
                        .CWUt(512).EUt(VA[UV]))
                .duration(1200).EUt(VA[UV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[LuV])
                .input(OrePrefix.gear, Ruthenium, 8)
                .input(OrePrefix.gearSmall, RhodiumPlatedPalladium, 8)
                .fluidInputs(Lubricant.getFluid(4000))
                .output(EFFICIENCY_ENHANCED_ROTOR_HOLDERS[1])
                .stationResearch(b -> b
                        .researchStack(EFFICIENCY_ENHANCED_ROTOR_HOLDERS[0].getStackForm())
                        .CWUt(16).EUt(VA[UV]))
                .duration(1200).EUt(VA[UV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .input(OrePrefix.gear, Trinium, 8)
                .input(OrePrefix.gearSmall, NaquadahAlloy, 8)
                .fluidInputs(Lubricant.getFluid(8000))
                .output(EFFICIENCY_ENHANCED_ROTOR_HOLDERS[2])
                .stationResearch(b -> b
                        .researchStack(EFFICIENCY_ENHANCED_ROTOR_HOLDERS[1].getStackForm())
                        .CWUt(64).EUt(VA[UV]))
                .duration(1200).EUt(VA[UV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(OrePrefix.gear, Tritanium, 8)
                .input(OrePrefix.gearSmall, Darmstadtium, 8)
                .fluidInputs(Lubricant.getFluid(16000))
                .output(EFFICIENCY_ENHANCED_ROTOR_HOLDERS[3])
                .stationResearch(b -> b
                        .researchStack(EFFICIENCY_ENHANCED_ROTOR_HOLDERS[2].getStackForm())
                        .CWUt(128).EUt(VA[UV]))
                .duration(1200).EUt(VA[UV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(OrePrefix.gear, Duranium, 8)
                .input(OrePrefix.gearSmall, Neutronium, 8)
                .fluidInputs(Lubricant.getFluid(32000))
                .output(EFFICIENCY_ENHANCED_ROTOR_HOLDERS[4])
                .stationResearch(b -> b
                        .researchStack(EFFICIENCY_ENHANCED_ROTOR_HOLDERS[3].getStackForm())
                        .CWUt(512).EUt(VA[UV]))
                .duration(1200).EUt(VA[UHV]).buildAndRegister();

        // Advances Rotor Holder (IV)
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[IV])
                .input(OrePrefix.gear, HSSG, 16)
                .input(OrePrefix.gearSmall, TungstenSteel, 16)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(OrePrefix.wireGtDouble, lossless(IV), 8)
                .fluidInputs(Lubricant.getFluid(8000))
                .output(ADVANCED_ROTOR_HOLDERS[0])
                .duration(2400).EUt(VA[UV]).buildAndRegister();

        // Advanced Rotor Holder (LuV - UHV)
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[LuV])
                .input(OrePrefix.gear, Ruthenium, 16)
                .input(OrePrefix.gearSmall, RhodiumPlatedPalladium, 16)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(OrePrefix.wireGtDouble, lossless(LuV), 8)
                .fluidInputs(Lubricant.getFluid(16000))
                .output(ADVANCED_ROTOR_HOLDERS[1])
                .stationResearch(b -> b
                        .researchStack(ADVANCED_ROTOR_HOLDERS[0].getStackForm())
                        .CWUt(16).EUt(VA[UHV]))
                .duration(2400).EUt(VA[UHV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .input(OrePrefix.gear, Trinium, 16)
                .input(OrePrefix.gearSmall, NaquadahAlloy, 16)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(OrePrefix.wireGtDouble, lossless(ZPM), 8)
                .fluidInputs(Lubricant.getFluid(32000))
                .output(ADVANCED_ROTOR_HOLDERS[2])
                .stationResearch(b -> b
                        .researchStack(ADVANCED_ROTOR_HOLDERS[1].getStackForm())
                        .CWUt(32).EUt(VA[UHV]))
                .duration(2400).EUt(VA[UHV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(OrePrefix.gear, Tritanium, 16)
                .input(OrePrefix.gearSmall, Darmstadtium, 16)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(OrePrefix.wireGtDouble, lossless(UV), 8)
                .fluidInputs(Lubricant.getFluid(64000))
                .output(ADVANCED_ROTOR_HOLDERS[3])
                .stationResearch(b -> b
                        .researchStack(ADVANCED_ROTOR_HOLDERS[2].getStackForm())
                        .CWUt(64).EUt(VA[UHV]))
                .duration(2400).EUt(VA[UHV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(OrePrefix.gear, Duranium, 16)
                .input(OrePrefix.gearSmall, Neutronium, 16)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(OrePrefix.wireGtDouble, lossless(UHV), 8)
                .fluidInputs(Lubricant.getFluid(128000))
                .output(ADVANCED_ROTOR_HOLDERS[4])
                .stationResearch(b -> b
                        .researchStack(ADVANCED_ROTOR_HOLDERS[3].getStackForm())
                        .CWUt(128).EUt(VA[UHV]))
                .duration(2400).EUt(VA[UHV]).buildAndRegister();
    }
}
