package com.coppertine.java.bte.tourguide.config;

import com.coppertine.java.bte.tourguide.BTETourGuideMod;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class TourGuideClientPreferences {

    public static final String FILENAME = "tourguide_client_preferences.json";
    private static File file = null;
    private static Preferences preferences = new Preferences();

    public static void load() {
        if(!file.exists()) {
            preferences = new Preferences();
            BTETourGuideMod.logger.info("Client preference file did not exist, used default settings.");
        } else {
            try {
                String text = String.join("\n", Files.readLines(file, Charset.defaultCharset()));
                Gson gson = new Gson();
                preferences = gson.fromJson(text, Preferences.class);
            } catch (IOException | JsonSyntaxException e) {
                BTETourGuideMod.logger.error("Failed to load client preference file, setting to default now!");
                BTETourGuideMod.logger.catching(e);
                preferences = new Preferences();
            }
        }
    }

    public static void setFile(File file) {
        if(TourGuideClientPreferences.file == null) {
            TourGuideClientPreferences.file = file;
        } else {
            BTETourGuideMod.logger.error("Tried to set client preference file but it was already set?");
        }
    }

    private static class Preferences {
        Map<String, ServerPreferences> servers = new HashMap<String, ServerPreferences>();
    }

    private static class ServerPreferences {
        // Todo: Include possibility for servers to create their own guides for
        //  end users to view.
//        public String genSettings = "";
//        public SavedMapState mapState = new SavedMapState();
    }
}
