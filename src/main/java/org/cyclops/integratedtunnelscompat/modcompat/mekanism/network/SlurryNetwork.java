package org.cyclops.integratedtunnelscompat.modcompat.mekanism.network;

import mekanism.api.chemical.slurry.SlurryStack;
import org.cyclops.commoncapabilities.api.ingredient.IngredientComponent;
import org.cyclops.integrateddynamics.core.network.PositionedAddonsNetworkIngredients;
import org.cyclops.integratedtunnelscompat.GeneralConfig;

/**
 * A network that can hold slurries.
 * @author rubensworks
 */
public class SlurryNetwork extends PositionedAddonsNetworkIngredients<SlurryStack, Integer> implements ISlurryNetwork {

    public SlurryNetwork(IngredientComponent<SlurryStack, Integer> component) {
        super(component);
    }

    @Override
    public long getRateLimit() {
        return GeneralConfig.slurryRateLimit;
    }
}
