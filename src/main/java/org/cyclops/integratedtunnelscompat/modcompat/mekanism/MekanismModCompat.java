package org.cyclops.integratedtunnelscompat.modcompat.mekanism;

import org.cyclops.cyclopscore.modcompat.ICompatInitializer;
import org.cyclops.cyclopscore.modcompat.IModCompat;
import org.cyclops.integratedtunnelscompat.Reference;

/**
 * Capabilities for Vanilla.
 * @author rubensworks
 */
public class MekanismModCompat implements IModCompat {

    @Override
    public String getId() {
        return Reference.MOD_MEKANISM;
    }

    @Override
    public boolean isEnabledDefault() {
        return true;
    }

    @Override
    public String getComment() {
        return "Network types for chemicals.";
    }

    @Override
    public ICompatInitializer createInitializer() {
        return new MekanismCompatInitializer();
    }

}
