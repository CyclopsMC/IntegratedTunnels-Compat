package org.cyclops.integratedtunnelscompat.modcompat.mekanism.part;

import mekanism.api.Action;
import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.chemical.IChemicalHandler;
import net.minecraftforge.common.capabilities.Capability;
import org.cyclops.commoncapabilities.api.ingredient.IngredientComponent;
import org.cyclops.integrateddynamics.api.network.IPositionedAddonsNetworkIngredients;
import org.cyclops.integratedtunnels.core.part.PartTypeInterfacePositionedAddon;

import javax.annotation.Nonnull;

/**
 * @author rubensworks
 */
public class ChemicalHandlerPartStateAdapter<N extends IPositionedAddonsNetworkIngredients<?, ?>, T, C extends Chemical<C>, S extends ChemicalStack<C>, H extends IChemicalHandler<C, S>> implements IChemicalHandler<C, S> {

    private final PartTypeInterfacePositionedAddon.State<N, T, ?, ?> state;
    private final Capability<H> handlerCapability;
    private final IngredientComponent<S, Integer> ingredientComponent;

    public ChemicalHandlerPartStateAdapter(PartTypeInterfacePositionedAddon.State<N, T, ?, ?> state, Capability<H> handlerCapability, IngredientComponent<S, Integer> ingredientComponent) {
        this.state = state;
        this.handlerCapability = handlerCapability;
        this.ingredientComponent = ingredientComponent;
    }

    protected H getChemicalHandler() {
        return state.getPositionedAddonsNetwork().getChannelExternal(this.handlerCapability, state.getChannel());
    }

    @Override
    public int getTanks() {
        if (!state.isNetworkAndPositionValid()) {
            return 0;
        }
        state.disablePosition();
        int ret = getChemicalHandler().getTanks();
        state.enablePosition();
        return ret;
    }

    @Override
    public S getChemicalInTank(int tank) {
        if (!state.isNetworkAndPositionValid()) {
            return getEmptyStack();
        }
        state.disablePosition();
        S ret = getChemicalHandler().getChemicalInTank(tank);
        state.enablePosition();
        return ret;
    }

    @Override
    public void setChemicalInTank(int tank, S stack) {
        if (state.isNetworkAndPositionValid()) {
            state.disablePosition();
            getChemicalHandler().setChemicalInTank(tank, stack);
            state.enablePosition();
        }
    }

    @Override
    public long getTankCapacity(int tank) {
        if (!state.isNetworkAndPositionValid()) {
            return 0;
        }
        state.disablePosition();
        long ret = getChemicalHandler().getTankCapacity(tank);
        state.enablePosition();
        return ret;
    }

    @Override
    public boolean isValid(int tank, S stack) {
        if (!state.isNetworkAndPositionValid()) {
            return false;
        }
        state.disablePosition();
        boolean ret = getChemicalHandler().isValid(tank, stack);
        state.enablePosition();
        return ret;
    }

    @Override
    public S insertChemical(int tank, S stack, Action action) {
        if (!state.isNetworkAndPositionValid()) {
            return stack;
        }
        state.disablePosition();
        S ret = getChemicalHandler().insertChemical(tank, stack, action);
        state.enablePosition();
        return ret;
    }

    @Override
    public S extractChemical(int tank, long l, Action action) {
        if (!state.isNetworkAndPositionValid()) {
            return getEmptyStack();
        }
        state.disablePosition();
        S ret = getChemicalHandler().extractChemical(tank, l, action);
        state.enablePosition();
        return ret;
    }

    @Override
    public S insertChemical(S stack, Action action) {
        if (!state.isNetworkAndPositionValid()) {
            return stack;
        }
        state.disablePosition();
        S ret = getChemicalHandler().insertChemical(stack, action);
        state.enablePosition();
        return ret;
    }

    @Override
    public S extractChemical(S stack, Action action) {
        if (!state.isNetworkAndPositionValid()) {
            return getEmptyStack();
        }
        state.disablePosition();
        S ret = getChemicalHandler().extractChemical(stack, action);
        state.enablePosition();
        return ret;
    }

    @Override
    public S extractChemical(long amount, Action action) {
        if (!state.isNetworkAndPositionValid()) {
            return getEmptyStack();
        }
        state.disablePosition();
        S ret = getChemicalHandler().extractChemical(amount, action);
        state.enablePosition();
        return ret;
    }

    @Nonnull
    @Override
    public S getEmptyStack() {
        return this.ingredientComponent.getMatcher().getEmptyInstance();
    }
}
