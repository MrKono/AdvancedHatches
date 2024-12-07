package kono.ceu.advancedhatches.common;

import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import kono.ceu.advancedhatches.AdvancedHatchesLog;
import kono.ceu.advancedhatches.api.util.AHValues;
import kono.ceu.advancedhatches.common.metatileentities.AHMetaTileEntities;
import kono.ceu.advancedhatches.loaders.AHERecipeManager;

@Mod.EventBusSubscriber(modid = AHValues.MODID)
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {}

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {}

    public static void registerItem(RegistryEvent.Register<Item> event) {}

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return itemBlock;
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        AdvancedHatchesLog.logger.info("Start: Registering MetaTileEntities");
        AHMetaTileEntities.init();
        AdvancedHatchesLog.logger.info("Finish: Registering MetaTileEntities");
        AdvancedHatchesLog.logger.info("Start: Registering Recipes");
        AHERecipeManager.Load();
        AdvancedHatchesLog.logger.info("Finish: Registering Recipes");
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerRecipesLow(RegistryEvent.Register<IRecipe> event) {
        AdvancedHatchesLog.logger.info("Start: Registering Recipes");
        // AHERecipeManager.postLoad();
        AdvancedHatchesLog.logger.info("Finish: Registering Recipes");
    }
}
