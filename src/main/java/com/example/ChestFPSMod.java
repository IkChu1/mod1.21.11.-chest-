package com.example.chestfps;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChestFPSMod implements ClientModInitializer {
    public static final String MOD_ID = "chestfps";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Переключатель режима "Fast Chest". 
    // True = статические модели (высокий FPS, нет анимации).
    // False = ванильный рендер (низкий FPS, есть анимация).
    public static boolean fastChestsEnabled = true; 

    @Override
    public void onInitializeClient() {
        LOGGER.info("ChestFPS+ is initializing! Fast chests are " + (fastChestsEnabled ? "ENABLED" : "DISABLED"));
    }
}
