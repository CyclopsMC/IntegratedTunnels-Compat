package org.cyclops.integratedtunnelscompat.modcompat.mekanism.network;

import org.cyclops.cyclopscore.config.extendedconfig.CapabilityConfig;
import org.cyclops.cyclopscore.modcompat.capabilities.DefaultCapabilityStorage;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;

/**
 * Config for the gas network capability.
 * @author rubensworks
 *
 */
public class GasNetworkConfig extends CapabilityConfig<IGasNetwork> {

    public GasNetworkConfig() {
        super(
                IntegratedTunnelsCompat._instance,
                "gasNetwork",
                IGasNetwork.class,
                new DefaultCapabilityStorage<IGasNetwork>(),
                () -> new GasNetwork(null)
        );
    }

}
