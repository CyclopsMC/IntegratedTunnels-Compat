package org.cyclops.integratedtunnelscompat.modcompat.mekanism.part;

import mekanism.api.chemical.infuse.IInfusionHandler;
import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.infuse.InfusionStack;
import net.minecraftforge.common.capabilities.Capability;
import org.cyclops.cyclopscore.init.ModBase;
import org.cyclops.integratedtunnels.core.part.PartTypeInterfacePositionedAddon;
import org.cyclops.integratedtunnelscompat.GeneralConfig;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;
import org.cyclops.integratedtunnelscompat.modcompat.mekanism.MekanismCompatInitializer;
import org.cyclops.integratedtunnelscompat.modcompat.mekanism.network.IInfusionNetwork;

/**
 * Interface for infusion handlers.
 * @author rubensworks
 */
public class PartTypeInterfaceInfusion extends PartTypeInterfacePositionedAddon<IInfusionNetwork, IInfusionHandler, PartTypeInterfaceInfusion, PartTypeInterfaceInfusion.State> {
    public PartTypeInterfaceInfusion(String name) {
        super(name);
    }

    @Override
    public ModBase getMod() {
        return IntegratedTunnelsCompat._instance;
    }

    @Override
    public Capability<IInfusionNetwork> getNetworkCapability() {
        return MekanismCompatInitializer.NETWORK_INFUSION;
    }

    @Override
    public Capability<IInfusionHandler> getTargetCapability() {
        return MekanismCompatInitializer.INFUSION_HANDLER_CAPABILITY;
    }

    @Override
    protected PartTypeInterfaceInfusion.State constructDefaultState() {
        return new PartTypeInterfaceInfusion.State();
    }
    
    @Override
    public int getConsumptionRate(State state) {
        return GeneralConfig.interfaceInfusionBaseConsumption;
    }

    public static class State extends PartTypeInterfacePositionedAddon.State<IInfusionNetwork, IInfusionHandler, PartTypeInterfaceInfusion, PartTypeInterfaceInfusion.State> {

        @Override
        public Capability<IInfusionHandler> getTargetCapability() {
            return MekanismCompatInitializer.INFUSION_HANDLER_CAPABILITY;
        }

        @Override
        public IInfusionHandler getCapabilityInstance() {
            return new InfusionHandler(this, getTargetCapability());
        }
    }

    public static class InfusionHandler extends ChemicalHandlerPartStateAdapter<IInfusionNetwork, IInfusionHandler, InfuseType, InfusionStack, IInfusionHandler> implements IInfusionHandler {
        public InfusionHandler(State state, Capability<IInfusionHandler> targetCapability) {
            super(state, targetCapability, MekanismCompatInitializer.INGREDIENT_INFUSIONSTACK);
        }
    }
}
