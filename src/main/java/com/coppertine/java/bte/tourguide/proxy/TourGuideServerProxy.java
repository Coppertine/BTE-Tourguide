package com.coppertine.java.bte.tourguide.proxy;

import com.coppertine.java.bte.tourguide.BTETourGuideMod;
import com.coppertine.java.bte.tourguide.network.TourGuideNetworkManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

public class TourGuideServerProxy extends TourGuideProxy{

    @Override
    public Side getSide() {
        return Side.SERVER;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        TourGuideNetworkManager.registerHandlers(Side.SERVER);
        BTETourGuideMod.logger.debug("BTE TourGuide server pre-init");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        BTETourGuideMod.logger.debug("BTE TourGuide server init");
        //Todo: Add Server Event Handlers if needed
        //MinecraftForge.EVENT_BUS.register(new ServerTerramapEventHandler());

    }

//    @Override
//    public void onServerHello(S2CTerramapHelloPacket s) {
//        // Should never be called on server
//    }

    @Override
    public double getDefaultGuiSize() {
        // Don't care on server, this is just for the client config
        return 0;
    }

    @Override
    public void onServerStarting(FMLServerStartingEvent event) {
        // Todo: Register server commands here.
        //event.registerServerCommand(new TerrashowCommand());
    }

}
