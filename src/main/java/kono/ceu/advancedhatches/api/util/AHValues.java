package kono.ceu.advancedhatches.api.util;

import net.minecraft.util.ResourceLocation;

import org.jetbrains.annotations.NotNull;

import kono.ceu.advancedhatches.Tags;

public class AHValues {

    public static final String MODID = Tags.MODID;
    public static final String MODNAME = Tags.MODNAME;

    @NotNull
    public static ResourceLocation ahId(@NotNull String path) {
        return new ResourceLocation(MODID, path);
    }
}
