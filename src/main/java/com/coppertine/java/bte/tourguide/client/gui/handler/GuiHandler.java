package com.coppertine.java.bte.tourguide.client.gui.handler;

import com.coppertine.java.bte.tourguide.BTETourGuideMod;
import fr.thesmyler.smylibgui.screen.TestScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

public class GuiHandler {

    private static final int BUTTON_TOUR_GUIDE = 1789052;
    private final BTETourGuideMod mod;

    public GuiHandler(BTETourGuideMod mod) {
        this.mod = mod;
    }

    @SubscribeEvent
    public void onGuiScreen(GuiScreenEvent.InitGuiEvent.Post event) {

        GuiScreen guiScreen = event.getGui();
        if (!(guiScreen instanceof GuiMainMenu)) {
            return;
        }
        BTETourGuideMod.logger.log(Level.INFO, "In Main Menu, placing in new button.");


        GuiButton button = new GuiButton(BUTTON_TOUR_GUIDE, event.getGui().width / 2 - 100,
                event.getGui().height / 4 + 10 + 3 * 38, I18n.format("btetourguide.gui.tourguide"));
        event.getButtonList().add(button);
    }

    @SubscribeEvent
    public void onButton(GuiScreenEvent.ActionPerformedEvent.Pre event) {
        if (!event.getButton().enabled) return;

        if (event.getGui() instanceof GuiMainMenu) {
            if (event.getButton().id == BUTTON_TOUR_GUIDE) {
                // Open Tour Guide Menu
                //new GuiTourGuideMenu();
                TestScreen screen = new TestScreen(event.getGui());
            }
        }
    }
}
