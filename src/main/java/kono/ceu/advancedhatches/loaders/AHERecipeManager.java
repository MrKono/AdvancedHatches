package kono.ceu.advancedhatches.loaders;

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
