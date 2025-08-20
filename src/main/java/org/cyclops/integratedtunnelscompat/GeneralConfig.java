package org.cyclops.integratedtunnelscompat;

import org.cyclops.cyclopscore.config.extendedconfig.DummyConfigCommon;

/**
 * A config with general options for this mod.
 * @author rubensworks
 *
 */
public class GeneralConfig extends DummyConfigCommon<IntegratedTunnelsCompat> {

    public GeneralConfig() {
        super(IntegratedTunnelsCompat._instance, "general");
    }

}
