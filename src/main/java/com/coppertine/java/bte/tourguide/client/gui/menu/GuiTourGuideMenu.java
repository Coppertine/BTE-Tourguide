package com.coppertine.java.bte.tourguide.client.gui.menu;

import net.minecraft.client.gui.GuiScreen;

public class GuiTourGuideMenu extends GuiScreen {


    /**
     * Millisecond of GUI being opened, used for fading in GUI.
     */
    private long timeOpened = System.currentTimeMillis();

    public GuiTourGuideMenu() {
    }

    @Override
    public void initGui() {

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        // Todo: Check if parent was GuiMainMenu, if so, use dirt background. if not, use below fade in effect.
//        long timeSinceOpen = System.currentTimeMillis() - timeOpened;
//        float alphaMultiplier; // This all calculates the alpha for the fade-in effect.
//        alphaMultiplier = 0.5F;
//            int fadeMilis = 500;
//            if (timeSinceOpen <= fadeMilis) {
//                alphaMultiplier = (float) timeSinceOpen / (fadeMilis * 2);
//            }
//        int alpha = (int)(255*alphaMultiplier); // Alpha of the text will increase from 0 to 127 over 500ms.
//
//        int startColor = new Color(0,0, 0, (int)(alpha*0.5)).getRGB();
//        int endColor = new Color(0,0, 0, alpha).getRGB();
//        drawGradientRect(0, 0, width, height, startColor, endColor);
//        GlStateManager.enableBlend();


    }


}
