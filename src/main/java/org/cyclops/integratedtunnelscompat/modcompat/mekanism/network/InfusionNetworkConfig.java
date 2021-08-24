package org.cyclops.integratedtunnelscompat.modcompat.mekanism.network;

import org.cyclops.cyclopscore.config.extendedconfig.CapabilityConfig;
import org.cyclops.cyclopscore.modcompat.capabilities.DefaultCapabilityStorage;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;

/**
 * Config for the infusion network capability.
 * @author rubensworks
 *
 */
public class InfusionNetworkConfig extends CapabilityConfig<IInfusionNetwork> {

    public InfusionNetworkConfig() {
        super(
                IntegratedTunnelsCompat._instance,
                "infusionNetwork",
                IInfusionNetwork.class,
                new DefaultCapabilityStorage<IInfusionNetwork>(),
                () -> new InfusionNetwork(null)
        );
    }

}
