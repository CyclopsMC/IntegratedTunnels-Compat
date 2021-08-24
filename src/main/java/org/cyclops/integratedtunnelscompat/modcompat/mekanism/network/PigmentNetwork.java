package org.cyclops.integratedtunnelscompat.modcompat.mekanism.network;

import mekanism.api.chemical.pigment.PigmentStack;
import org.cyclops.commoncapabilities.api.ingredient.IngredientComponent;
import org.cyclops.integrateddynamics.core.network.PositionedAddonsNetworkIngredients;
import org.cyclops.integratedtunnelscompat.GeneralConfig;

/**
 * A network that can hold pigments.
 * @author rubensworks
 */
public class PigmentNetwork extends PositionedAddonsNetworkIngredients<PigmentStack, Integer> implements IPigmentNetwork {

    public PigmentNetwork(IngredientComponent<PigmentStack, Integer> component) {
        super(component);
    }

    @Override
    public long getRateLimit() {
        return GeneralConfig.pigmentRateLimit;
    }
}
