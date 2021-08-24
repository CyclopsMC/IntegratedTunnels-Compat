package org.cyclops.integratedtunnelscompat.modcompat.mekanism.part;

import org.cyclops.integrateddynamics.IntegratedDynamics;
import org.cyclops.integrateddynamics.api.part.IPartTypeRegistry;

/**
 * @author rubensworks
 */
public class PartTypes {

    public static final IPartTypeRegistry REGISTRY = IntegratedDynamics._instance.getRegistryManager().getRegistry(IPartTypeRegistry.class);

    public static void load() {}

    public static final PartTypeInterfaceGas INTERFACE_GAS = REGISTRY.register(new PartTypeInterfaceGas("interface_gas"));
    public static final PartTypeInterfaceInfusion INTERFACE_INFUSION = REGISTRY.register(new PartTypeInterfaceInfusion("interface_infusion"));
    public static final PartTypeInterfacePigment INTERFACE_PIGMENT = REGISTRY.register(new PartTypeInterfacePigment("interface_pigment"));
    public static final PartTypeInterfaceSlurry INTERFACE_SLURRY = REGISTRY.register(new PartTypeInterfaceSlurry("interface_slurry"));

}
