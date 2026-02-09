package net.penetrator.freakyplecaki.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.penetrator.freakyplecaki.FreakyPlecaki;

public class ModItemGroups {
    public static final ItemGroup BACKPACKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FreakyPlecaki.MOD_ID, "backpacks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BACKPACK))
                    .displayName(Text.of("Freaky Plecaki"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BACKPACK);


                    }).build());


    public static void registerItemGroups(){

        FreakyPlecaki.LOGGER.info("Registering item groups for " + FreakyPlecaki.MOD_ID);
    }
}
