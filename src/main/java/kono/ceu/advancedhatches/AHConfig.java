package kono.ceu.advancedhatches;

import kono.ceu.advancedhatches.api.util.AHValues;
import net.minecraftforge.common.config.Config;

@Config(modid = AHValues.MODID)
public class AHConfig {
    /*
    @Config.Comment()
    @Config.Name()
    @Config.RequiresMcRestart
    public static
     */

    @Config.Name("MTE ID Option")
    @Config.RequiresMcRestart
    public static IDOptions Id = new IDOptions();

    @Config.Comment("Config options for High Amp Energy Hatches")
    @Config.Name("High Amp Hatch Option")
    @Config.RequiresMcRestart
    public static EnergyHatchOptions EnergyHatchOption = new EnergyHatchOptions();

    @Config.Comment("Config options for GCYM Compat. If GCYM is not installed, it is ignored")
    @Config.Name("GCYM Compat")
    @Config.RequiresMcRestart
    public static gcymCompat gcymCompat = new gcymCompat();

    public static class IDOptions {
        @Config.Comment({"Change the starting ID of the MetaTileEntityID used by this add-on.",
                "By Default, this add-on uses MetaTileEntityIDs of 25000-26999.",
                "Only change this if the crash is caused by a duplicate MTEIDs.",
                "WARNING: If you change it, the one already created will disappear or be changed to another one."})
        public int startId = 25000;
    }

    public static class EnergyHatchOptions {
        @Config.Comment({"Whether to enable the Low Tier Energy Hatch", "Default: false",
        "4A: ULV-HV, 16A: ULV-EV, 64A: ULV-EV, 128A: ULV-IV"})
        public boolean enabledLowTierHatches = false;
    }

    public static class gcymCompat {
        @Config.Comment({"Whether to force to enable the UEV+ Voltage Control Unit.", "If \"highTierContent\" is true, this setting is ignored.",
                "WARNING: No recipe available", "Default: false"})
        public boolean enabledHighVoltageUnit = false;

        @Config.Comment({"Whether to force to enable the more Parallel Hatches",
                "WARNING: No recipe available", "Default:false"})
        public boolean enabledParallel1024 = false;
        public boolean enabledParallel4096 = false;
        public boolean enabledParallel16384 = false;
        public boolean enabledParallel65536 = false;
        public boolean enabledParallel262144 = false;
        public boolean enabledParallel1048576 = false;
    }
}
