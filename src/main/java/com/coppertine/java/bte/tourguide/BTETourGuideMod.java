package com.coppertine.java.bte.tourguide;

import com.coppertine.java.bte.tourguide.client.gui.handler.MainMenuHandler;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = BTETourGuideMod.MODID, name = BTETourGuideMod.NAME, version = BTETourGuideMod.VERSION, useMetadata = true)
public class BTETourGuideMod implements Module
{
    public static final String MODID = "bte-tourguide";
    public static final String NAME = "Build The Earth Tour Guide";
    public static final String VERSION = "0.0.1";

    @Mod.Instance(MODID)
    public static BTETourGuideMod instance;

    public static Logger logger;
    private final List<Module> modules = new ArrayList<>();

    public BTETourGuideMod()
    {

        //register modules
        modules.add(this);

    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        modules.forEach(Module::initClient);
    }

    @Override
    public void initClient()
    {
        new MainMenuHandler().register();
    }
}
