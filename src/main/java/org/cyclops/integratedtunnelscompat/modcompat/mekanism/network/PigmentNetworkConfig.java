package org.cyclops.integratedtunnelscompat.modcompat.mekanism.network;

import org.cyclops.cyclopscore.config.extendedconfig.CapabilityConfig;
import org.cyclops.cyclopscore.modcompat.capabilities.DefaultCapabilityStorage;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;

/**
 * Config for the pigment network capability.
 * @author rubensworks
 *
 */
public class PigmentNetworkConfig extends CapabilityConfig<IPigmentNetwork> {

    public PigmentNetworkConfig() {
        super(
                IntegratedTunnelsCompat._instance,
                "pigmentNetwork",
                IPigmentNetwork.class,
                new DefaultCapabilityStorage<IPigmentNetwork>(),
                () -> new PigmentNetwork(null)
        );
    }

}
