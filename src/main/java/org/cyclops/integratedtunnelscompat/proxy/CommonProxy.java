package org.cyclops.integratedtunnelscompat.proxy;

import org.cyclops.cyclopscore.init.ModBaseNeoForge;
import org.cyclops.cyclopscore.proxy.CommonProxyComponent;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;

/**
 * Proxy for server and client side.
 * @author rubensworks
 *
 */
public class CommonProxy extends CommonProxyComponent {

    @Override
    public ModBaseNeoForge<?> getMod() {
        return IntegratedTunnelsCompat._instance;
    }

}
