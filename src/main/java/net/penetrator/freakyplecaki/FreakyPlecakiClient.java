package net.penetrator.freakyplecaki;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.penetrator.freakyplecaki.screenHandler.BackpackScreen;
import net.penetrator.freakyplecaki.screenHandler.ModScreenHandlers;

public class FreakyPlecakiClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.BACKPACK, BackpackScreen::new);
    }
}
