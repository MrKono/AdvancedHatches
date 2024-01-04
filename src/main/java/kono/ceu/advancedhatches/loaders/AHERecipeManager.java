package kono.ceu.advancedhatches.loaders;

import static kono.ceu.advancedhatches.api.util.AHValuesConfigurable.*;
import static kono.ceu.advancedhatches.loaders.recipe.AHMTEMachineRecipeLoader.*;

public class AHERecipeManager {

    public static void Load() {
        if (enabledLowTier) {
            EnergyHatches4A();
            EnergyHatches16A();
        }
        EnergyHatches64and128A();
        Transformers();
    }
}
