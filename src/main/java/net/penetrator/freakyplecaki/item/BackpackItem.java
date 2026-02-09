package net.penetrator.freakyplecaki.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.penetrator.freakyplecaki.screenHandler.BackpackScreenHandler;

public class BackpackItem extends Item {
    public static final int SIZE = 27;

    public BackpackItem(Settings settings) {
        super(settings);
    }

    public static DefaultedList<ItemStack> getInventory(ItemStack stack) {
        DefaultedList<ItemStack> items = DefaultedList.ofSize(SIZE, ItemStack.EMPTY);

        ContainerComponent container = stack.get(DataComponentTypes.CONTAINER);
        if (container != null) {
            // fills the list with the stored items
            container.copyTo(items);
        }

        return items;
    }

    public static void saveInventory(ItemStack stack, DefaultedList<ItemStack> items) {
        // create a container component from the list and attach it to the stack
        ContainerComponent container = ContainerComponent.fromStacks(items);
        stack.set(DataComponentTypes.CONTAINER, container);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient()) {
            player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                    (syncId, inv, p) -> new BackpackScreenHandler(syncId, inv),
                    Text.literal("Backpack")
            ));
        }

        return ActionResult.SUCCESS;
    }

}
