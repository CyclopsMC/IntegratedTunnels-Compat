package org.cyclops.integratedtunnelscompat.modcompat.mekanism.network;

import mekanism.api.chemical.infuse.InfusionStack;
import org.cyclops.commoncapabilities.api.ingredient.IngredientComponent;
import org.cyclops.integrateddynamics.core.network.PositionedAddonsNetworkIngredients;
import org.cyclops.integratedtunnelscompat.GeneralConfig;

/**
 * A network that can hold infusions.
 * @author rubensworks
 */
public class InfusionNetwork extends PositionedAddonsNetworkIngredients<InfusionStack, Integer> implements IInfusionNetwork {

    public InfusionNetwork(IngredientComponent<InfusionStack, Integer> component) {
        super(component);
    }

    @Override
    public long getRateLimit() {
        return GeneralConfig.infusionRateLimit;
    }
}
