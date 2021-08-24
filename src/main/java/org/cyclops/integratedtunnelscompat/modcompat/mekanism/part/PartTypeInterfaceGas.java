package org.cyclops.integratedtunnelscompat.modcompat.mekanism.part;

import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.chemical.gas.IGasHandler;
import net.minecraftforge.common.capabilities.Capability;
import org.cyclops.cyclopscore.init.ModBase;
import org.cyclops.integratedtunnels.core.part.PartTypeInterfacePositionedAddon;
import org.cyclops.integratedtunnelscompat.GeneralConfig;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;
import org.cyclops.integratedtunnelscompat.modcompat.mekanism.MekanismCompatInitializer;
import org.cyclops.integratedtunnelscompat.modcompat.mekanism.network.IGasNetwork;

/**
 * Interface for gas handlers.
 * @author rubensworks
 */
public class PartTypeInterfaceGas extends PartTypeInterfacePositionedAddon<IGasNetwork, IGasHandler, PartTypeInterfaceGas, PartTypeInterfaceGas.State> {
    public PartTypeInterfaceGas(String name) {
        super(name);
    }

    @Override
    public ModBase getMod() {
        return IntegratedTunnelsCompat._instance;
    }

    @Override
    public Capability<IGasNetwork> getNetworkCapability() {
        return MekanismCompatInitializer.NETWORK_GAS;
    }

    @Override
    public Capability<IGasHandler> getTargetCapability() {
        return MekanismCompatInitializer.GAS_HANDLER_CAPABILITY;
    }

    @Override
    protected PartTypeInterfaceGas.State constructDefaultState() {
        return new PartTypeInterfaceGas.State();
    }
    
    @Override
    public int getConsumptionRate(State state) {
        return GeneralConfig.interfaceGasBaseConsumption;
    }

    public static class State extends PartTypeInterfacePositionedAddon.State<IGasNetwork, IGasHandler, PartTypeInterfaceGas, PartTypeInterfaceGas.State> {

        @Override
        public Capability<IGasHandler> getTargetCapability() {
            return MekanismCompatInitializer.GAS_HANDLER_CAPABILITY;
        }

        @Override
        public IGasHandler getCapabilityInstance() {
            return new GasHandler(this, getTargetCapability());
        }
    }

    public static class GasHandler extends ChemicalHandlerPartStateAdapter<IGasNetwork, IGasHandler, Gas, GasStack, IGasHandler> implements IGasHandler {
        public GasHandler(State state, Capability<IGasHandler> targetCapability) {
            super(state, targetCapability, MekanismCompatInitializer.INGREDIENT_GASSTACK);
        }
    }
}
