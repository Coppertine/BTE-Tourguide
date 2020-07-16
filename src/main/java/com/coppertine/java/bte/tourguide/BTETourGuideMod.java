package com.coppertine.java.bte.tourguide;

import com.coppertine.java.bte.tourguide.client.gui.handler.MainMenuHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = BTETourGuideMod.MODID, name = BTETourGuideMod.NAME, version = BTETourGuideMod.VERSION, useMetadata = true)
public class BTETourGuideMod
{
    public static final String MODID = "bte-tourguide";
    public static final String NAME = "Build The Earth Tour Guide";
    public static final String VERSION = "0.0.1";

    public static Logger logger;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void initClient()
    {
        new MainMenuHandler().register();
    }
}
