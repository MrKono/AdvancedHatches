package kono.ceu.advancedhatches.common;

import gregtech.api.unification.material.event.PostMaterialEvent;
import kono.ceu.advancedhatches.api.unification.materials.AHMaterialFragAddition;
import kono.ceu.advancedhatches.api.util.AHValues;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = AHValues.MODID)
public class AHEventHandler {

    @SubscribeEvent
    public static void registerMaterialFlags(PostMaterialEvent event) {
        AHMaterialFragAddition.init();
    }

}
