package com.coppertine.java.bte.tourguide.proxy;

import com.coppertine.java.bte.tourguide.BTETourGuideMod;
import com.coppertine.java.bte.tourguide.config.TourGuideClientPreferences;
import com.coppertine.java.bte.tourguide.network.TourGuideNetworkManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.io.File;
import java.io.IOException;

public class TourGuideClientProxy extends TourGuideProxy{

    @Override
    public Side getSide() {
        return Side.CLIENT;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        BTETourGuideMod.logger.debug("BTE TourGuide client pre-init");
        TourGuideNetworkManager.registerHandlers(Side.CLIENT);
//        try {
//            TerramapMod.cacheManager = new CacheManager(TerramapConfig.cachingDir);
//            TerramapMod.cacheManager.createDirectory();
//        } catch (IOException e) {
//            TerramapMod.logger.catching(e);
//            TerramapMod.logger.error("Caching directory doesn't seem to be valid, we will use a temporary one.");
//            TerramapMod.logger.error("Make sure your config is correct!");
//            TerramapMod.cacheManager = new CacheManager();
//
//        }
//        TerramapMod.cacheManager.startWorker();

        File clientPrefs = new File(event.getModConfigurationDirectory().getAbsoluteFile()
                + "/" + TourGuideClientPreferences.FILENAME);
        TourGuideClientPreferences.setFile(clientPrefs);
        TourGuideClientPreferences.load();
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void onServerStarting(FMLServerStartingEvent event) {
        // Nothing is done here.. this is the client.
    }

    @Override
    public double getDefaultGuiSize() {
        return 0;
    }
}
