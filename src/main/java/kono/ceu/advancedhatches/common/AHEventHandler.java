package kono.ceu.advancedhatches.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import gregtech.api.unification.material.event.PostMaterialEvent;

import kono.ceu.advancedhatches.api.unification.materials.AHMaterialFragAddition;
import kono.ceu.advancedhatches.api.util.AHValues;

@Mod.EventBusSubscriber(modid = AHValues.MODID)
public class AHEventHandler {

    @SubscribeEvent
    public static void registerMaterialFlags(PostMaterialEvent event) {
        AHMaterialFragAddition.init();
    }
}
