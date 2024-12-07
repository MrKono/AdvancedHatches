package kono.ceu.advancedhatches.api.unification.materials;

import gregtech.api.unification.material.Materials;

public class AHMaterialFragAddition {

    public static void init() {
        Materials.Neutronium.addFlags("generate_small_gear");
    }
}
