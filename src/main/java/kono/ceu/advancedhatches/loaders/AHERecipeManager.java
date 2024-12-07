package kono.ceu.advancedhatches.loaders;

import gregtech.api.recipes.ingredients.GTRecipeItemInput;
import gregtech.api.recipes.ingredients.nbtmatch.NBTCondition;
import gregtech.api.recipes.ingredients.nbtmatch.NBTMatcher;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Glass;
import static gregtech.api.unification.material.Materials.Lapis;
import static gregtech.integration.IntegrationUtil.getModItem;
import static kono.ceu.advancedhatches.api.util.AHValuesConfigurable.*;
import static kono.ceu.advancedhatches.loaders.recipe.AHMTEMachineRecipeLoader.*;

public class AHERecipeManager {

    public static void Load() {
        if (enabledLowTier) {
            EnergyHatchesLow();
        }
        EnergyHatches();
        Transformers();
        RotorHolders();
    }
}
