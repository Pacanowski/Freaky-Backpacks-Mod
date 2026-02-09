package net.penetrator.freakyplecaki.item;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.penetrator.freakyplecaki.FreakyPlecaki;

public class ModItems {

    public static final Item BACKPACK = registerItem("backpack", new BackpackItem(new Item.Settings().maxCount(1).component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT)));

    //nie powiem
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(FreakyPlecaki.MOD_ID, name), item);
    }
    public static void registerModItems(){
        FreakyPlecaki.LOGGER.info("Registering mod items for " + FreakyPlecaki.MOD_ID);

    }
}
