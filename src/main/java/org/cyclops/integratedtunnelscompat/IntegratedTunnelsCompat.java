package org.cyclops.integratedtunnelscompat;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;
import org.cyclops.cyclopscore.init.ModBaseVersionable;
import org.cyclops.cyclopscore.proxy.IClientProxy;
import org.cyclops.cyclopscore.proxy.ICommonProxy;
import org.cyclops.integratedtunnelscompat.proxy.ClientProxy;
import org.cyclops.integratedtunnelscompat.proxy.CommonProxy;

/**
 * The main mod class of this mod.
 * @author rubensworks (aka kroeserr)
 *
 */
@Mod(Reference.MOD_ID)
public class IntegratedTunnelsCompat extends ModBaseVersionable<IntegratedTunnelsCompat> {

    
    /**
     * The unique instance of this mod.
     */
    public static IntegratedTunnelsCompat _instance;

    public IntegratedTunnelsCompat() {
        super(Reference.MOD_ID, (instance) -> _instance = instance);
    }

    @Override
    protected ItemGroup constructDefaultItemGroup() {
        return null;
    }

    @Override
    protected IClientProxy constructClientProxy() {
        return new ClientProxy();
    }

    @Override
    protected ICommonProxy constructCommonProxy() {
        return new CommonProxy();
    }

    /**
     * Log a new info message for this mod.
     * @param message The message to show.
     */
    public static void clog(String message) {
        clog(Level.INFO, message);
    }
    
    /**
     * Log a new message of the given level for this mod.
     * @param level The level in which the message must be shown.
     * @param message The message to show.
     */
    public static void clog(Level level, String message) {
        IntegratedTunnelsCompat._instance.getLoggerHelper().log(level, message);
    }
}
