package kono.ceu.advancedhatches.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;


import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static kono.ceu.advancedhatches.api.util.AHValuesConfigurable.enabledHighTier;
import static kono.ceu.advancedhatches.common.metatileentities.AHMetaTileEntities.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static kono.ceu.advancedhatches.loaders.AHIngredientHelper.*;

public class AHMTEMachineRecipeLoader {

    public static void EnergyHatches4A() {
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_INPUT_HATCH[ULV])
                .input(OrePrefix.wireGtQuadruple, voltagePartsMaterial(ULV), 2)
                .input(OrePrefix.plate, voltageMaterial(ULV), 2)
                .output(ENERGY_INPUT_4A_LOW[ULV])
                .EUt(4).duration(200).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[ULV])
                .input(OrePrefix.wireGtQuadruple, voltagePartsMaterial(ULV), 2)
                .input(OrePrefix.plate, voltageMaterial(ULV), 2)
                .output(ENERGY_OUTPUT_4A_LOW[ULV])
                .EUt(4).duration(200).buildAndRegister();
        for (int i = 1; i < ENERGY_INPUT_4A_LOW.length; i ++) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_INPUT_HATCH[i])
                    .input(OrePrefix.wireGtQuadruple, voltagePartsMaterial(i), 2)
                    .input(OrePrefix.plate, voltageMaterial(i), 2)
                    .output(ENERGY_INPUT_4A_LOW[i])
                    .EUt(VA[i - 1]).duration(100).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[i])
                    .input(OrePrefix.wireGtQuadruple, voltagePartsMaterial(i), 2)
                    .input(OrePrefix.plate, voltageMaterial(i), 2)
                    .output(ENERGY_OUTPUT_4A_LOW[i])
                    .EUt(VA[i - 1]).duration(100).buildAndRegister();
        }
    }

    public static void EnergyHatches16A() {
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.TRANSFORMER[ULV])
                .input(ENERGY_INPUT_4A_LOW[ULV])
                .input(OrePrefix.wireGtOctal, voltagePartsMaterial(ULV), 2)
                .input(OrePrefix.plate, voltageMaterial(ULV), 4)
                .output(ENERGY_INPUT_16A_LOW[ULV])
                .EUt(4).duration(200).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.TRANSFORMER[ULV])
                .input(ENERGY_OUTPUT_4A_LOW[ULV])
                .input(OrePrefix.wireGtOctal, voltagePartsMaterial(ULV), 2)
                .input(OrePrefix.plate, voltageMaterial(ULV), 4)
                .output(ENERGY_OUTPUT_16A_LOW[ULV])
                .EUt(4).duration(200).buildAndRegister();

        for (int i = 1; i < ENERGY_INPUT_16A_LOW.length - 1; i++) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(MetaTileEntities.TRANSFORMER[i])
                    .input(ENERGY_INPUT_4A_LOW[i])
                    .input(OrePrefix.wireGtOctal, voltagePartsMaterial(i), 2)
                    .input(OrePrefix.plate, voltageMaterial(i), 4)
                    .output(ENERGY_INPUT_16A_LOW[i])
                    .EUt(VA[i - 1]).duration(200).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(MetaTileEntities.TRANSFORMER[i])
                    .input(ENERGY_OUTPUT_4A_LOW[i])
                    .input(OrePrefix.wireGtOctal, voltagePartsMaterial(i), 2)
                    .input(OrePrefix.plate, voltageMaterial(i), 4)
                    .output(ENERGY_OUTPUT_16A_LOW[i])
                    .EUt(VA[i - 1]).duration(200).buildAndRegister();
        }

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.TRANSFORMER[EV])
                .input(ENERGY_INPUT_HATCH_4A[0])
                .input(OrePrefix.wireGtOctal, voltagePartsMaterial(EV), 2)
                .input(OrePrefix.plate, voltageMaterial(EV), 4)
                .output(ENERGY_INPUT_16A_LOW[EV])
                .EUt(VA[EV - 1]).duration(200).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.TRANSFORMER[EV])
                .input(ENERGY_OUTPUT_HATCH_4A[0])
                .input(OrePrefix.wireGtOctal, voltagePartsMaterial(EV), 2)
                .input(OrePrefix.plate, voltageMaterial(EV), 4)
                .output(ENERGY_OUTPUT_16A_LOW[EV])
                .EUt(VA[EV - 1]).duration(200).buildAndRegister();
    }

    public static void EnergyHatches64and128A() {
        //64A
        if (enabledHighTier) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[ULV])
                    .input(ENERGY_INPUT_16A_LOW[ULV])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(ULV), 2)
                    .input(OrePrefix.plateDouble, voltagePartsMaterial(ULV), 4)
                    .input(VoltageCoil(ULV), 2)
                    .input(PICs(ULV), 4)
                    .fluidInputs(SodiumPotassium.getFluid(2000))
                    .output(ENERGY_INPUT_64A[ULV])
                    .EUt(4).duration(400).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[ULV])
                    .input(ENERGY_OUTPUT_16A_LOW[ULV])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(ULV), 2)
                    .input(OrePrefix.plateDouble, voltageMaterial(ULV), 4)
                    .input(VoltageCoil(ULV), 2)
                    .input(PICs(ULV), 4)
                    .fluidInputs(SodiumPotassium.getFluid(2000))
                    .output(ENERGY_OUTPUT_64A[ULV])
                    .EUt(4).duration(400).buildAndRegister();

            for (int i = 1; i < GTValues.IV; i++) {
                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(POWER_TRANSFORMER[i])
                        .input(ENERGY_INPUT_16A_LOW[i])
                        .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 2)
                        .input(OrePrefix.plateDouble, voltageMaterial(i), 4)
                        .input(VoltageCoil(i), 2)
                        .input(PICs(i), 4)
                        .fluidInputs(SodiumPotassium.getFluid(2000))
                        .output(ENERGY_INPUT_64A[i])
                        .EUt(VA[i - 1]).duration(400).buildAndRegister();

                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(POWER_TRANSFORMER[i])
                        .input(ENERGY_OUTPUT_16A_LOW[i])
                        .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 2)
                        .input(OrePrefix.plateDouble, voltageMaterial(i), 4)
                        .input(VoltageCoil(i), 2)
                        .input(PICs(i), 4)
                        .fluidInputs(SodiumPotassium.getFluid(2000))
                        .output(ENERGY_OUTPUT_64A[i])
                        .EUt(VA[i - 1]).duration(400).buildAndRegister();
            }
        }
        for (int i = GTValues.IV; i <= GTValues.UV; i++) {
                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(POWER_TRANSFORMER[i])
                        .input(ENERGY_INPUT_HATCH_16A[i - GTValues.IV])
                        .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 2)
                        .input(OrePrefix.plateDouble, voltageMaterial(i), 4)
                        .input(VoltageCoil(i), 2)
                        .input(PICs(i), 4)
                        .fluidInputs(SodiumPotassium.getFluid(2000))
                        .output(ENERGY_INPUT_64A[i])
                        .EUt(VA[i - 1]).duration(400).buildAndRegister();

                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(POWER_TRANSFORMER[i])
                        .input(ENERGY_OUTPUT_HATCH_16A[i - GTValues.IV])
                        .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 2)
                        .input(OrePrefix.plateDouble, voltageMaterial(i), 4)
                        .input(VoltageCoil(i), 2)
                        .input(PICs(i), 4)
                        .fluidInputs(SodiumPotassium.getFluid(2000))
                        .output(ENERGY_OUTPUT_64A[i])
                        .EUt(VA[i - 1]).duration(400).buildAndRegister();
            }
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UV])
                .input(ENERGY_INPUT_HATCH_16A[GTValues.UHV - GTValues.IV])
                .input(OrePrefix.wireGtHex, voltagePartsMaterial(UHV), 2)
                .input(OrePrefix.plateDouble, voltageMaterial(UHV), 4)
                .input(VoltageCoil(UHV), 2)
                .input(PICs(UHV), 4)
                .fluidInputs(SodiumPotassium.getFluid(2000))
                .output(ENERGY_INPUT_64A[UHV])
                .EUt(VA[UHV - 1]).duration(400).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UV])
                .input(ENERGY_OUTPUT_HATCH_16A[GTValues.UHV - GTValues.IV])
                .input(OrePrefix.wireGtHex, voltagePartsMaterial(UHV), 2)
                .input(OrePrefix.plateDouble, voltageMaterial(UHV), 4)
                .input(VoltageCoil(UHV), 2)
                .input(PICs(UHV), 4)
                .fluidInputs(SodiumPotassium.getFluid(2000))
                .output(ENERGY_OUTPUT_64A[UHV])
                .EUt(VA[UHV - 1]).duration(400).buildAndRegister();
        //128A
        if (enabledHighTier) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ULTRA_HI_AMP_TRANSFORMER[ULV])
                    .input(ENERGY_INPUT_64A[ULV])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(ULV), 4)
                    .input(OrePrefix.plateDouble, voltageMaterial(ULV), 8)
                    .input(VoltageCoil(ULV), 8)
                    .input(PICWs(ULV), 4)
                    .fluidInputs(SodiumPotassium.getFluid(4000))
                    .output(ENERGY_INPUT_128A[ULV])
                    .EUt(4).duration(1600).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ULTRA_HI_AMP_TRANSFORMER[ULV])
                    .input(ENERGY_OUTPUT_64A[ULV])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(ULV), 4)
                    .input(OrePrefix.plateDouble, voltageMaterial(ULV), 8)
                    .input(VoltageCoil(ULV), 8)
                    .input(PICWs(ULV), 4)
                    .fluidInputs(SodiumPotassium.getFluid(4000))
                    .output(ENERGY_OUTPUT_128A[ULV])
                    .EUt(4).duration(1600).buildAndRegister();

            for (int i = 1; i < GTValues.IV; i++) {
                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(ULTRA_HI_AMP_TRANSFORMER[i])
                        .input(ENERGY_INPUT_64A[i])
                        .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 4)
                        .input(OrePrefix.plateDouble, voltageMaterial(i), 8)
                        .input(VoltageCoil(i), 8)
                        .input(PICWs(i), 4)
                        .fluidInputs(SodiumPotassium.getFluid(4000))
                        .output(ENERGY_INPUT_128A[i])
                        .EUt(VA[i - 1]).duration(1600).buildAndRegister();

                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(ULTRA_HI_AMP_TRANSFORMER[i])
                        .input(ENERGY_OUTPUT_64A[i])
                        .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 4)
                        .input(OrePrefix.plateDouble, voltageMaterial(i), 8)
                        .input(VoltageCoil(i), 8)
                        .input(PICWs(i), 4)
                        .fluidInputs(SodiumPotassium.getFluid(4000))
                        .output(ENERGY_OUTPUT_128A[i])
                        .EUt(VA[i - 1]).duration(1600).buildAndRegister();
            }
        }
        for (int i = GTValues.IV; i <= GTValues.UV; i++) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ULTRA_HI_AMP_TRANSFORMER[i])
                    .input(ENERGY_INPUT_64A[i])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 4)
                    .input(OrePrefix.plateDouble, voltageMaterial(i), 8)
                    .input(VoltageCoil(i), 8)
                    .input(PICWs(i), 4)
                    .fluidInputs(SodiumPotassium.getFluid(4000))
                    .output(ENERGY_INPUT_128A[i])
                    .EUt(VA[i - 1]).duration(1600).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ULTRA_HI_AMP_TRANSFORMER[i])
                    .input(ENERGY_OUTPUT_64A[i])
                    .input(OrePrefix.wireGtHex, voltagePartsMaterial(i), 4)
                    .input(OrePrefix.plateDouble, voltageMaterial(i), 8)
                    .input(VoltageCoil(i), 8)
                    .input(PICWs(i), 4)
                    .fluidInputs(SodiumPotassium.getFluid(4000))
                    .output(ENERGY_OUTPUT_128A[i])
                    .EUt(VA[i - 1]).duration(1600).buildAndRegister();
        }
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ULTRA_HI_AMP_TRANSFORMER[UV])
                .input(ENERGY_INPUT_64A[UHV])
                .input(OrePrefix.wireGtHex, voltagePartsMaterial(UHV), 4)
                .input(OrePrefix.plateDouble, voltageMaterial(UHV), 8)
                .input(VoltageCoil(UHV), 8)
                .input(PICWs(UHV), 4)
                .fluidInputs(SodiumPotassium.getFluid(4000))
                .output(ENERGY_INPUT_128A[UHV])
                .EUt(VA[UHV - 1]).duration(1600).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ULTRA_HI_AMP_TRANSFORMER[UV])
                .input(ENERGY_OUTPUT_64A[UHV])
                .input(OrePrefix.wireGtHex, voltagePartsMaterial(UHV), 4)
                .input(OrePrefix.plateDouble, voltageMaterial(UHV), 8)
                .input(VoltageCoil(UHV), 8)
                .input(PICWs(UHV), 4)
                .fluidInputs(SodiumPotassium.getFluid(4000))
                .output(ENERGY_OUTPUT_128A[UHV])
                .EUt(VA[UHV - 1]).duration(1600).buildAndRegister();
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
                    .output(ULTRA_HI_AMP_TRANSFORMER[i])
                    .EUt(VA[i]).duration(800).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ULTRA_HI_AMP_TRANSFORMER[i])
                    .input(Pump(i))
                    .input(OrePrefix.cableGtOctal, voltagePartsMaterial(i + 1), 16)
                    .input(OrePrefix.cableGtHex, voltagePartsMaterial(i), 32)
                    .input(OrePrefix.springSmall, voltagePartsMaterial(i), 16)
                    .input(OrePrefix.spring, voltagePartsMaterial(i + 1), 16)
                    .fluidInputs(Lubricant.getFluid(32000))
                    .output(ULTRA_POWER_TRANSFORMER[i])
                    .EUt(VA[i]).duration(3200).buildAndRegister();
        }
    }

    public static void Converter() {
        for (int i = 0; i < HI_AMP_CONVERTER[0].length; i++) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[i])
                    .input(OrePrefix.cableGtHex, RedAlloy, 2)
                    .input(OrePrefix.cableGtHex, voltagePartsMaterial(i), 8)
                    .input(OrePrefix.circuit, tier(i), 1)
                    .circuitMeta(0)
                    .output(HI_AMP_CONVERTER[0][i])
                    .EUt(VA[i]).duration(200).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[i])
                    .input(OrePrefix.cableGtHex, RedAlloy, 4)
                    .input(OrePrefix.cableGtHex, voltagePartsMaterial(i), 16)
                    .input(OrePrefix.circuit, tier(i), 2)
                    .circuitMeta(1)
                    .output(HI_AMP_CONVERTER[1][i])
                    .EUt(VA[i]).duration(2 * 200).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[i])
                    .input(OrePrefix.cableGtHex, RedAlloy, 8)
                    .input(OrePrefix.cableGtHex, voltagePartsMaterial(i), 32)
                    .input(OrePrefix.circuit, tier(i), 4)
                    .circuitMeta(2)
                    .output(HI_AMP_CONVERTER[2][i])
                    .EUt(VA[i]).duration(4 * 200).buildAndRegister();

            if (i < HI_AMP_CONVERTER[0].length - 1) {
                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(HULL[i])
                        .input(OrePrefix.cableGtHex, RedAlloy, 16)
                        .input(OrePrefix.cableGtHex, voltagePartsMaterial(i), 64)
                        .input(OrePrefix.circuit, tier(i), 8)
                        .circuitMeta(3)
                        .output(HI_AMP_CONVERTER[3][i])
                        .EUt(VA[i]).duration(8 * 200).buildAndRegister();
            }
        }
    }

    public static void RotorHolders() {
        //Rotor Holder (UHV)
        ModHandler.addShapedRecipe(true, "rotor_holder_uhv", ROTOR_HOLDERS_HI[0].getStackForm(),
                "SGS", "GHG", "SGS",
                'H', MetaTileEntities.HULL[UHV].getStackForm(),
                'G', new UnificationEntry(OrePrefix.gear, Duranium),
                'S', new UnificationEntry(OrePrefix.gearSmall, Neutronium));

        //Enhanced Rotor Holder (IV)
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

        //Enhanced Rotor Holder (LuV - UHV)
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

        //Advances Rotor Holder (IV)
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[IV])
                .input(OrePrefix.gear, HSSG, 16)
                .input(OrePrefix.gearSmall, TungstenSteel, 16)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(OrePrefix.wireGtDouble, lossless(IV), 8)
                .fluidInputs(Lubricant.getFluid(8000))
                .output(ADVANCED_ROTOR_HOLDERS[0])
                .duration(2400).EUt(VA[UV]).buildAndRegister();

        //Advanced Rotor Holder (LuV - UHV)
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
