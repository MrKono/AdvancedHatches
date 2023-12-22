package kono.ceu.advancedhatches;

import gregtech.GTInternalTags;
import kono.ceu.advancedhatches.api.util.AHValues;
import kono.ceu.advancedhatches.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Tags.MODID,
        version = Tags.VERSION,
        name = Tags.MODNAME,
        acceptedMinecraftVersions = "[1.12, 1.12.2]",
        dependencies = GTInternalTags.DEP_VERSION_STRING)

public class AdvancedHatches {

    @SidedProxy(modId = AHValues.MOD_ID,
            clientSide = "kono.ceu.advancedhatches.client.ClientProxy",
            serverSide = "kono.ceu.advancedhatches.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static AdvancedHatches instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
