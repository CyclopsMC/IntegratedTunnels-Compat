package org.cyclops.integratedtunnelscompat.modcompat.mekanism.network;

import mekanism.api.chemical.gas.GasStack;
import org.cyclops.commoncapabilities.api.ingredient.IngredientComponent;
import org.cyclops.integrateddynamics.core.network.PositionedAddonsNetworkIngredients;
import org.cyclops.integratedtunnelscompat.GeneralConfig;

/**
 * A network that can hold gases.
 * @author rubensworks
 */
public class GasNetwork extends PositionedAddonsNetworkIngredients<GasStack, Integer> implements IGasNetwork {

    public GasNetwork(IngredientComponent<GasStack, Integer> component) {
        super(component);
    }

    @Override
    public long getRateLimit() {
        return GeneralConfig.gasRateLimit;
    }
}
