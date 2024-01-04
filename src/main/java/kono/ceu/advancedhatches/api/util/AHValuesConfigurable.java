package kono.ceu.advancedhatches.api.util;

import kono.ceu.advancedhatches.AHConfig;

public class AHValuesConfigurable {

    // Boolean
    public static boolean enabledLowTier = AHConfig.EnergyHatchOption.enabledLowTierHatches;
    public static boolean enabledHighTier = AHConfig.EnergyHatchOption.enabledHighTierHatches;

    public static boolean enabledHighVoltageUnit = AHConfig.gcymCompat.enabledHighVoltageUnit;
    public static boolean enabledParallel1024 = AHConfig.gcymCompat.enabledParallel1024;
    public static boolean enabledParallel4096 = AHConfig.gcymCompat.enabledParallel4096;
    public static boolean enabledParallel16384 = AHConfig.gcymCompat.enabledParallel16384;
    public static boolean enabledParallel65536 = AHConfig.gcymCompat.enabledParallel65536;
    public static boolean enabledParallel262144 = AHConfig.gcymCompat.enabledParallel262144;
    public static boolean enabledParallel1048576 = AHConfig.gcymCompat.enabledParallel1048576;


}

