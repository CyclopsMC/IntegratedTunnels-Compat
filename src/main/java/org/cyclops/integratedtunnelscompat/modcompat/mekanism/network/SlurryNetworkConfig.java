package org.cyclops.integratedtunnelscompat.modcompat.mekanism.network;

import org.cyclops.cyclopscore.config.extendedconfig.CapabilityConfig;
import org.cyclops.cyclopscore.modcompat.capabilities.DefaultCapabilityStorage;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;

/**
 * Config for the slurry network capability.
 * @author rubensworks
 *
 */
public class SlurryNetworkConfig extends CapabilityConfig<ISlurryNetwork> {

    public SlurryNetworkConfig() {
        super(
                IntegratedTunnelsCompat._instance,
                "slurryNetwork",
                ISlurryNetwork.class,
                new DefaultCapabilityStorage<ISlurryNetwork>(),
                () -> new SlurryNetwork(null)
        );
    }

}
