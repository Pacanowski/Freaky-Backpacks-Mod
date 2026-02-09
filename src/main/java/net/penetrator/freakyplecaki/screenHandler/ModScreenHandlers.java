package net.penetrator.freakyplecaki.screenHandler;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.penetrator.freakyplecaki.FreakyPlecaki;

public class ModScreenHandlers {
    public static final ScreenHandlerType<BackpackScreenHandler> BACKPACK =
            Registry.register(
                    Registries.SCREEN_HANDLER,
                    Identifier.of(FreakyPlecaki.MOD_ID, "backpack"),
                    new ScreenHandlerType<>(BackpackScreenHandler::new, FeatureFlags.VANILLA_FEATURES)
            );
}

