package org.cyclops.integratedtunnelscompat.proxy;

import org.cyclops.cyclopscore.init.ModBase;
import org.cyclops.cyclopscore.proxy.ClientProxyComponent;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;

/**
 * Proxy for the client side.
 *
 * @author rubensworks
 *
 */
public class ClientProxy extends ClientProxyComponent {

    public ClientProxy() {
        super(new CommonProxy());
    }

    @Override
    public ModBase getMod() {
        return IntegratedTunnelsCompat._instance;
    }

}
