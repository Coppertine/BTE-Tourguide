package com.coppertine.java.bte.tourguide.client.gui.handler;

import com.coppertine.java.bte.tourguide.utils.EventRegistrations;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class GuiHandler extends EventRegistrations {

    private static final int BUTTON_TOUR_GUIDE = 1789052;
    @SubscribeEvent
    public void injectIntoIngameMenu(GuiScreenEvent.InitGuiEvent.Post event) {

        GuiScreen guiScreen = event.getGui();
        if (!(guiScreen instanceof GuiMainMenu)) {
            return;
        }

        InjectedButton button = new InjectedButton(
                guiScreen,
                BUTTON_TOUR_GUIDE,
                guiScreen.width / 2 - 100,
                guiScreen.height / 4 + 10 + 4 * 24,
                200,
                20,
                "btetourguide.gui.tourguide",
                this::onButton
        );

        if (guiScreen.getClass().getName().endsWith("custommainmenu.gui.GuiFakeMain")) {
            // CustomMainMenu uses a different list in the event than in its Fake gui
            addButton(event, button);
            return;
        }
        addButton(guiScreen, button);

    }

}
