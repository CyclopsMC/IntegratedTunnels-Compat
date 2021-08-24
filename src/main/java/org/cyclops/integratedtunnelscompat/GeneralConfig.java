package org.cyclops.integratedtunnelscompat;

import net.minecraftforge.fml.config.ModConfig;
import org.cyclops.cyclopscore.config.ConfigurableProperty;
import org.cyclops.cyclopscore.config.extendedconfig.DummyConfig;

/**
 * A config with general options for this mod.
 * @author rubensworks
 *
 */
public class GeneralConfig extends DummyConfig {

    @ConfigurableProperty(category = "core", comment = "The maximum network gas transfer rate.", isCommandable = true, minimalValue = 0, configLocation = ModConfig.Type.SERVER)
    public static int gasRateLimit = Integer.MAX_VALUE;
    @ConfigurableProperty(category = "core", comment = "The maximum network infusion transfer rate.", isCommandable = true, minimalValue = 0, configLocation = ModConfig.Type.SERVER)
    public static int infusionRateLimit = Integer.MAX_VALUE;
    @ConfigurableProperty(category = "core", comment = "The maximum network pigment transfer rate.", isCommandable = true, minimalValue = 0, configLocation = ModConfig.Type.SERVER)
    public static int pigmentRateLimit = Integer.MAX_VALUE;
    @ConfigurableProperty(category = "core", comment = "The maximum network slurry transfer rate.", isCommandable = true, minimalValue = 0, configLocation = ModConfig.Type.SERVER)
    public static int slurryRateLimit = Integer.MAX_VALUE;

    @ConfigurableProperty(category = "general", comment = "The base energy usage for the gas interface.", minimalValue = 0, configLocation = ModConfig.Type.SERVER)
    public static int interfaceGasBaseConsumption = 0;
    @ConfigurableProperty(category = "general", comment = "The base energy usage for the infusion interface.", minimalValue = 0, configLocation = ModConfig.Type.SERVER)
    public static int interfaceInfusionBaseConsumption = 0;
    @ConfigurableProperty(category = "general", comment = "The base energy usage for the pigment interface.", minimalValue = 0, configLocation = ModConfig.Type.SERVER)
    public static int interfacePigmentBaseConsumption = 0;
    @ConfigurableProperty(category = "general", comment = "The base energy usage for the slurry interface.", minimalValue = 0, configLocation = ModConfig.Type.SERVER)
    public static int interfaceSlurryBaseConsumption = 0;

    public GeneralConfig() {
        super(IntegratedTunnelsCompat._instance, "general");
    }

}
