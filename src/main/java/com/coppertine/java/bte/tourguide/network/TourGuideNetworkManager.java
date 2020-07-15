package com.coppertine.java.bte.tourguide.network;

import com.coppertine.java.bte.tourguide.BTETourGuideMod;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.nio.charset.Charset;

public class TourGuideNetworkManager {

    // The channel instance
    public static final SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel(BTETourGuideMod.MODID);
    public static final Charset CHARSET = Charset.forName("utf-8");

    // Packet discriminator counter, should be increased for each packet type.
    private static int discriminator = 0;

    /**
     * Registers the handlers
     *
     * @param side
     */
    public static void registerHandlers(Side side){
        //registerS2C(S2CTerramapHelloPacketHandler.class, S2CTerramapHelloPacket.class);
//        registerS2C(S2CPlayerSyncPacketHandler.class, S2CPlayerSyncPacket.class);
//        registerS2C(S2CRegistrationExpiresPacketHandler.class, S2CRegistrationExpiresPacket.class);
//        registerS2C(S2CTpCommandSyncPacketHandler.class, S2CTpCommandSyncPacket.class);
//        registerC2S(C2SRegisterForUpdatesPacketHandler.class, C2SRegisterForUpdatesPacket.class);
    }

//    private static <REQ extends IMessage, REPLY extends IMessage> void registerS2C(Class<? extends IMessageHandler<REQ, REPLY>> handlerclass, Class<REQ> msgclass) {
//        CHANNEL.registerMessage(handlerclass, msgclass, discriminator++, Side.CLIENT);
//    }
//
//    private static <REQ extends IMessage, REPLY extends IMessage> void registerC2S(Class<? extends IMessageHandler<REQ, REPLY>> handlerclass, Class<REQ> msgclass) {
//        CHANNEL.registerMessage(handlerclass, msgclass, discriminator++, Side.SERVER);
//    }

    public static void encodeStringToByteBuf(String str, ByteBuf buf) {
        byte[] strBytes = str.getBytes(CHARSET);
        buf.writeInt(strBytes.length);
        buf.writeBytes(strBytes);
    }

    public static String decodeStringFromByteBuf(ByteBuf buf) {
        return buf.readCharSequence(buf.readInt(), CHARSET).toString();
    }
}
