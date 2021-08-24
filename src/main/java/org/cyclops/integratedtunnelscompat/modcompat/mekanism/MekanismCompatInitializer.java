package org.cyclops.integratedtunnelscompat.modcompat.mekanism;

import mekanism.api.chemical.gas.GasStack;
import mekanism.api.chemical.gas.IGasHandler;
import mekanism.api.chemical.infuse.IInfusionHandler;
import mekanism.api.chemical.infuse.InfusionStack;
import mekanism.api.chemical.pigment.IPigmentHandler;
import mekanism.api.chemical.pigment.PigmentStack;
import mekanism.api.chemical.slurry.ISlurryHandler;
import mekanism.api.chemical.slurry.SlurryStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;
import org.cyclops.commoncapabilities.api.ingredient.IngredientComponent;
import org.cyclops.cyclopscore.config.ConfigHandler;
import org.cyclops.cyclopscore.modcompat.ICompatInitializer;
import org.cyclops.cyclopscore.modcompat.capabilities.DefaultCapabilityProvider;
import org.cyclops.integrateddynamics.Reference;
import org.cyclops.integrateddynamics.api.network.AttachCapabilitiesEventNetwork;
import org.cyclops.integrateddynamics.api.network.IPositionedAddonsNetworkIngredients;
import org.cyclops.integratedtunnelscompat.IntegratedTunnelsCompat;
import org.cyclops.integratedtunnelscompat.modcompat.mekanism.network.*;
import org.cyclops.integratedtunnelscompat.modcompat.mekanism.part.PartTypes;

/**
 * @author rubensworks
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MekanismCompatInitializer implements ICompatInitializer {

    @ObjectHolder("mekanism:gasstack")
    public static IngredientComponent<GasStack, Integer> INGREDIENT_GASSTACK;
    @ObjectHolder("mekanism:infusionstack")
    public static IngredientComponent<InfusionStack, Integer> INGREDIENT_INFUSIONSTACK;
    @ObjectHolder("mekanism:pigmentstack")
    public static IngredientComponent<PigmentStack, Integer> INGREDIENT_PIGMENTSTACK;
    @ObjectHolder("mekanism:slurrystack")
    public static IngredientComponent<SlurryStack, Integer> INGREDIENT_SLURRYSTACK;

    @CapabilityInject(IGasNetwork.class)
    public static Capability<IGasNetwork> NETWORK_GAS = null;
    @CapabilityInject(IInfusionNetwork.class)
    public static Capability<IInfusionNetwork> NETWORK_INFUSION = null;
    @CapabilityInject(IPigmentNetwork.class)
    public static Capability<IPigmentNetwork> NETWORK_PIGMENT = null;
    @CapabilityInject(ISlurryNetwork.class)
    public static Capability<ISlurryNetwork> NETWORK_SLURRY = null;

    @CapabilityInject(IGasHandler.class)
    public static Capability<IGasHandler> GAS_HANDLER_CAPABILITY = null;
    @CapabilityInject(IInfusionHandler.class)
    public static Capability<IInfusionHandler> INFUSION_HANDLER_CAPABILITY = null;
    @CapabilityInject(IPigmentHandler.class)
    public static Capability<IPigmentHandler> PIGMENT_HANDLER_CAPABILITY = null;
    @CapabilityInject(ISlurryHandler.class)
    public static Capability<ISlurryHandler> SLURRY_HANDLER_CAPABILITY = null;

    @Override
    public void initialize() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(EventPriority.HIGHEST, this::beforeRegistriesCreated);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(EventPriority.LOWEST, this::afterRegistriesCreated);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void beforeRegistriesCreated(RegistryEvent.NewRegistry event) {
        PartTypes.load();
    }

    private void afterRegistriesCreated(RegistryEvent.NewRegistry event) {
        ConfigHandler configHandler = IntegratedTunnelsCompat._instance.getConfigHandler();

        configHandler.addConfigurable(new GasNetworkConfig());
        configHandler.addConfigurable(new InfusionNetworkConfig());
        configHandler.addConfigurable(new PigmentNetworkConfig());
        configHandler.addConfigurable(new SlurryNetworkConfig());
    }

    @SubscribeEvent
    public void onNetworkLoad(AttachCapabilitiesEventNetwork event) {
        GasNetwork gasNetwork = new GasNetwork(MekanismCompatInitializer.INGREDIENT_GASSTACK);
        IGasHandler gasChannel = gasNetwork.getChannelExternal(MekanismCompatInitializer.GAS_HANDLER_CAPABILITY,
                IPositionedAddonsNetworkIngredients.DEFAULT_CHANNEL);
        event.addCapability(new ResourceLocation(Reference.MOD_ID, "gas_network"),
                new DefaultCapabilityProvider<>(() -> MekanismCompatInitializer.NETWORK_GAS, gasNetwork));
        event.addCapability(new ResourceLocation(Reference.MOD_ID, "gas_storage_network"),
                new DefaultCapabilityProvider<>(() -> MekanismCompatInitializer.GAS_HANDLER_CAPABILITY, gasChannel));
        event.addFullNetworkListener(gasNetwork);

        InfusionNetwork infusionNetwork = new InfusionNetwork(MekanismCompatInitializer.INGREDIENT_INFUSIONSTACK);
        IInfusionHandler infusionChannel = infusionNetwork.getChannelExternal(MekanismCompatInitializer.INFUSION_HANDLER_CAPABILITY,
                IPositionedAddonsNetworkIngredients.DEFAULT_CHANNEL);
        event.addCapability(new ResourceLocation(Reference.MOD_ID, "infusion_network"),
                new DefaultCapabilityProvider<>(() -> MekanismCompatInitializer.NETWORK_INFUSION, infusionNetwork));
        event.addCapability(new ResourceLocation(Reference.MOD_ID, "infusion_storage_network"),
                new DefaultCapabilityProvider<>(() -> MekanismCompatInitializer.INFUSION_HANDLER_CAPABILITY, infusionChannel));
        event.addFullNetworkListener(infusionNetwork);

        PigmentNetwork pigmentNetwork = new PigmentNetwork(MekanismCompatInitializer.INGREDIENT_PIGMENTSTACK);
        IPigmentHandler pigmentChannel = pigmentNetwork.getChannelExternal(MekanismCompatInitializer.PIGMENT_HANDLER_CAPABILITY,
                IPositionedAddonsNetworkIngredients.DEFAULT_CHANNEL);
        event.addCapability(new ResourceLocation(Reference.MOD_ID, "pigment_network"),
                new DefaultCapabilityProvider<>(() -> MekanismCompatInitializer.NETWORK_PIGMENT, pigmentNetwork));
        event.addCapability(new ResourceLocation(Reference.MOD_ID, "pigment_storage_network"),
                new DefaultCapabilityProvider<>(() -> MekanismCompatInitializer.PIGMENT_HANDLER_CAPABILITY, pigmentChannel));
        event.addFullNetworkListener(pigmentNetwork);

        SlurryNetwork slurryNetwork = new SlurryNetwork(MekanismCompatInitializer.INGREDIENT_SLURRYSTACK);
        ISlurryHandler slurryChannel = slurryNetwork.getChannelExternal(MekanismCompatInitializer.SLURRY_HANDLER_CAPABILITY,
                IPositionedAddonsNetworkIngredients.DEFAULT_CHANNEL);
        event.addCapability(new ResourceLocation(Reference.MOD_ID, "slurry_network"),
                new DefaultCapabilityProvider<>(() -> MekanismCompatInitializer.NETWORK_SLURRY, slurryNetwork));
        event.addCapability(new ResourceLocation(Reference.MOD_ID, "slurry_storage_network"),
                new DefaultCapabilityProvider<>(() -> MekanismCompatInitializer.SLURRY_HANDLER_CAPABILITY, slurryChannel));
        event.addFullNetworkListener(slurryNetwork);
    }
}
