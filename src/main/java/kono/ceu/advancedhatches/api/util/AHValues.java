package kono.ceu.advancedhatches.api.util;

import kono.ceu.advancedhatches.Tags;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class AHValues {
    public static final String MODID = Tags.MODID;
    public static final String MODNAME = Tags.MODNAME;

    @NotNull
    public static ResourceLocation ahId(@NotNull String path) {
        return new ResourceLocation(MODID, path);
    }
}
