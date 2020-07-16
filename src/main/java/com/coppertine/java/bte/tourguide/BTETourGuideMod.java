package com.coppertine.java.bte.tourguide;

import com.coppertine.java.bte.tourguide.client.gui.handler.GuiHandler;
import com.coppertine.java.bte.tourguide.client.gui.handler.MainMenuHandler;
import com.coppertine.java.bte.tourguide.eventhandlers.CommonTourGuideEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = BTETourGuideMod.MODID, name = BTETourGuideMod.NAME, version = BTETourGuideMod.VERSION, useMetadata = true)
public class BTETourGuideMod
{
    public static final String MODID = "btetourguide";
    public static final String NAME = "Build The Earth Tour Guide";
    public static final String VERSION = "0.0.1";

    @Mod.Instance(MODID)
    public static BTETourGuideMod instance;

    public static Logger logger;


    public BTETourGuideMod()
    {



    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new CommonTourGuideEventHandler());
        MinecraftForge.EVENT_BUS.register(new GuiHandler(this));
        MinecraftForge.EVENT_BUS.register(new MainMenuHandler());

    }




}
