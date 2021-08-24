package org.cyclops.integratedtunnelscompat.modcompat.mekanism.part;

import mekanism.api.chemical.pigment.IPigmentHandler;
import mekanism.api.chemical.pigment.Pigment;
import mekanism.api.chemical.pigment.PigmentStack;
import net.minecraftforge.common.capabilities.Capability;
import org.cyclops.cyclopscore.init.ModBase;
import org.cyclops.integratedtunnels.core.part.PartTypeInterfacePositionedAddon;
import org.cyclops.integratedtunnelscompat.GeneralConfig;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;
import org.cyclops.integratedtunnelscompat.modcompat.mekanism.MekanismCompatInitializer;
import org.cyclops.integratedtunnelscompat.modcompat.mekanism.network.IPigmentNetwork;

/**
 * Interface for pigment handlers.
 * @author rubensworks
 */
public class PartTypeInterfacePigment extends PartTypeInterfacePositionedAddon<IPigmentNetwork, IPigmentHandler, PartTypeInterfacePigment, PartTypeInterfacePigment.State> {
    public PartTypeInterfacePigment(String name) {
        super(name);
    }

    @Override
    public ModBase getMod() {
        return IntegratedTunnelsCompat._instance;
    }

    @Override
    public Capability<IPigmentNetwork> getNetworkCapability() {
        return MekanismCompatInitializer.NETWORK_PIGMENT;
    }

    @Override
    public Capability<IPigmentHandler> getTargetCapability() {
        return MekanismCompatInitializer.PIGMENT_HANDLER_CAPABILITY;
    }

    @Override
    protected PartTypeInterfacePigment.State constructDefaultState() {
        return new PartTypeInterfacePigment.State();
    }
    
    @Override
    public int getConsumptionRate(State state) {
        return GeneralConfig.interfacePigmentBaseConsumption;
    }

    public static class State extends PartTypeInterfacePositionedAddon.State<IPigmentNetwork, IPigmentHandler, PartTypeInterfacePigment, PartTypeInterfacePigment.State> {

        @Override
        public Capability<IPigmentHandler> getTargetCapability() {
            return MekanismCompatInitializer.PIGMENT_HANDLER_CAPABILITY;
        }

        @Override
        public IPigmentHandler getCapabilityInstance() {
            return new PigmentHandler(this, getTargetCapability());
        }
    }

    public static class PigmentHandler extends ChemicalHandlerPartStateAdapter<IPigmentNetwork, IPigmentHandler, Pigment, PigmentStack, IPigmentHandler> implements IPigmentHandler {
        public PigmentHandler(State state, Capability<IPigmentHandler> targetCapability) {
            super(state, targetCapability, MekanismCompatInitializer.INGREDIENT_PIGMENTSTACK);
        }
    }
}
