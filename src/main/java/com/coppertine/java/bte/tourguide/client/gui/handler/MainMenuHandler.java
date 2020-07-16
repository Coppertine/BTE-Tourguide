package com.coppertine.java.bte.tourguide.client.gui.handler;

import com.coppertine.java.bte.tourguide.utils.EventRegistrations;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.client.gui.GuiMainMenu;
import org.jline.reader.Widget;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.gui.GuiButton;

import java.util.List;

public class MainMenuHandler extends EventRegistrations {

    @SubscribeEvent
    public void onInit(GuiScreenEvent.InitGuiEvent.Post event)
    {
        GuiScreen guiScreen = event.getGui();
        List<GuiButton> buttonList = event.getButtonList();
        if (guiScreen instanceof GuiMainMenu) {
            // Now to add in a new button
            GuiMainMenu gui = (GuiMainMenu) guiScreen;
            int realmsOffset = 0;

            for (GuiButton button : buttonList) {
                // Let's move everything up.
                // Buttons that aren't in a rectangle directly above our space don't need moving
                if (button.x + button.getButtonWidth() < gui.width / 2 - 100
                        || button.x > gui.width / 2 + 100
                        || button.y > gui.height / 4 + 10 + 4 * 24 + 20) continue;
                // Move button up to make space for one rows of buttons
                // and then move back down by 10 to compensate for the space to the exit button that was already there
                int offset = -1 * 24 + 10;
                button.y += offset;
            }


        }
    }
}
