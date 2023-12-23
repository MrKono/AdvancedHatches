package kono.ceu.advancedhatches.api.util;

import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class AHValues {
    public static final String MOD_ID = "advancedhatches";
    public static final String MOD_NAME = "AdvancedHatches",
    MOD_NAME_GSYM = "gcym";

    @NotNull
    public static ResourceLocation ahId(@NotNull String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
