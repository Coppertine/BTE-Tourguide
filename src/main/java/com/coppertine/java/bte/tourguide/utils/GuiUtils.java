package com.coppertine.java.bte.tourguide.utils;

import com.coppertine.java.bte.tourguide.mixin.GuiScreenAccessor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiUtils {

    public static void addButton(GuiScreen screen, GuiButton button)
    {
        GuiScreenAccessor acc = (GuiScreenAccessor) screen;
        acc.getButtons().add(button);
    }
}
