package net.penetrator.freakyplecaki.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.penetrator.freakyplecaki.FreakyPlecaki;

public class ModItems {

    static Item.Settings backpacksettings = new Item.Settings().maxCount(1).component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT);


    public static final Item BACKPACK = registerItem("backpack", backpacksettings);
    //public static final Item LARGE_BACKPACK = registerItem("large_backpack", backpacksettings);





    private static Item registerItem(String name, Item.Settings settings) {
        Identifier id = Identifier.of(FreakyPlecaki.MOD_ID, name);
        return Registry.register(Registries.ITEM, id, new BackpackItem(settings.registryKey(RegistryKey.of(Registries.ITEM.getKey(), id))));
    }

    public static void registerModItems() {
        FreakyPlecaki.LOGGER.info("Registering mod items for " + FreakyPlecaki.MOD_ID);
    }
}
