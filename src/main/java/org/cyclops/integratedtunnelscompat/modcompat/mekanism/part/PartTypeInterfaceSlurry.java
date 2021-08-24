package org.cyclops.integratedtunnelscompat.modcompat.mekanism.part;

import mekanism.api.chemical.slurry.ISlurryHandler;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryStack;
import net.minecraftforge.common.capabilities.Capability;
import org.cyclops.cyclopscore.init.ModBase;
import org.cyclops.integratedtunnels.core.part.PartTypeInterfacePositionedAddon;
import org.cyclops.integratedtunnelscompat.GeneralConfig;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;
import org.cyclops.integratedtunnelscompat.modcompat.mekanism.MekanismCompatInitializer;
import org.cyclops.integratedtunnelscompat.modcompat.mekanism.network.ISlurryNetwork;

/**
 * Interface for slurry handlers.
 * @author rubensworks
 */
public class PartTypeInterfaceSlurry extends PartTypeInterfacePositionedAddon<ISlurryNetwork, ISlurryHandler, PartTypeInterfaceSlurry, PartTypeInterfaceSlurry.State> {
    public PartTypeInterfaceSlurry(String name) {
        super(name);
    }

    @Override
    public ModBase getMod() {
        return IntegratedTunnelsCompat._instance;
    }

    @Override
    public Capability<ISlurryNetwork> getNetworkCapability() {
        return MekanismCompatInitializer.NETWORK_SLURRY;
    }

    @Override
    public Capability<ISlurryHandler> getTargetCapability() {
        return MekanismCompatInitializer.SLURRY_HANDLER_CAPABILITY;
    }

    @Override
    protected PartTypeInterfaceSlurry.State constructDefaultState() {
        return new PartTypeInterfaceSlurry.State();
    }
    
    @Override
    public int getConsumptionRate(State state) {
        return GeneralConfig.interfaceSlurryBaseConsumption;
    }

    public static class State extends PartTypeInterfacePositionedAddon.State<ISlurryNetwork, ISlurryHandler, PartTypeInterfaceSlurry, PartTypeInterfaceSlurry.State> {

        @Override
        public Capability<ISlurryHandler> getTargetCapability() {
            return MekanismCompatInitializer.SLURRY_HANDLER_CAPABILITY;
        }

        @Override
        public ISlurryHandler getCapabilityInstance() {
            return new SlurryHandler(this, getTargetCapability());
        }
    }

    public static class SlurryHandler extends ChemicalHandlerPartStateAdapter<ISlurryNetwork, ISlurryHandler, Slurry, SlurryStack, ISlurryHandler> implements ISlurryHandler {
        public SlurryHandler(State state, Capability<ISlurryHandler> targetCapability) {
            super(state, targetCapability, MekanismCompatInitializer.INGREDIENT_SLURRYSTACK);
        }
    }
}
