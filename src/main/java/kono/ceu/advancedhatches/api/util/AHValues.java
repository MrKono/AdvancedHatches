package kono.ceu.advancedhatches.api.util;

import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class AHValues {
    public static final String MODID = "advancedhatches";
    public static final String MODNAME = "AdvancedHatches",
    MODNAME_GCYM = "gcym";

    @NotNull
    public static ResourceLocation ahId(@NotNull String path) {
        return new ResourceLocation(MODID, path);
    }
}
