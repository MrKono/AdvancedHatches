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

    @Config.Comment("Config options for High Amp Energy Hatches")
    @Config.Name("High Amp Hatch Option")
    @Config.RequiresMcRestart
    public static EnergyHatchOptions EnergyHatchOption = new EnergyHatchOptions();

    @Config.Comment("Config options for GCYM Compat. If GCYM is not installed, it is ignored")
    @Config.Name("GCYM Compat")
    @Config.RequiresMcRestart
    public static gcymCompat gcymCompat = new gcymCompat();

    public static class EnergyHatchOptions {
        @Config.Comment({"Whether to enable the ULV - EV Tier Energy Hatch", "Default: false"})
        public boolean enabledLowTierHatches = false;

        @Config.Comment({"Whether to enable the HEV+ Tier Energy Hatch", "If \"highTierContent\" is true, this setting is ignored.", "Default: false"})
        public boolean enabledHighTierHatches = false;
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
