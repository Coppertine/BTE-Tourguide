package com.coppertine.java.bte.tourguide.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

public abstract class TourGuideProxy {

    public abstract Side getSide();
    public abstract void preInit(FMLPreInitializationEvent event);
    public abstract void init(FMLInitializationEvent event);
    public abstract void onServerStarting(FMLServerStartingEvent event);
    //TODO: Figure out why this exists.
    // public abstract void onServerHello(S2CTerramapHelloPacket pkt);
    public abstract double getDefaultGuiSize();

    public boolean isClient()
    {
        return this.getSide().equals(Side.CLIENT);
    }

    public boolean isDedicatedServer()
    {
        return this.getSide().equals(Side.SERVER);
    }
}
