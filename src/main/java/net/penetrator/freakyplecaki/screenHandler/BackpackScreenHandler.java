package net.penetrator.freakyplecaki.screenHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;
import net.penetrator.freakyplecaki.item.BackpackItem;

public class BackpackScreenHandler extends ScreenHandler {

    private final ItemStack backpackStack;
    private final DefaultedList<ItemStack> items;
    private final Inventory inv;

    public BackpackScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlers.BACKPACK, syncId);

        // The backpack item the player is holding
        this.backpackStack = playerInventory.getSelectedStack();

        // Load stored items from the backpack's data component
        this.items = BackpackItem.getInventory(backpackStack);

        // Create an Inventory that directly uses the DefaultedList
        this.inv = new Inventory() {

            @Override
            public int size() {
                return items.size();
            }

            @Override
            public boolean isEmpty() {
                for (ItemStack stack : items) {
                    if (!stack.isEmpty()) return false;
                }
                return true;
            }

            @Override
            public ItemStack getStack(int slot) {
                return items.get(slot);
            }

            @Override
            public ItemStack removeStack(int slot, int amount) {
                ItemStack existing = items.get(slot);
                if (existing.isEmpty()) return ItemStack.EMPTY;

                ItemStack split = existing.split(amount);
                markDirty();
                return split;
            }

            @Override
            public ItemStack removeStack(int slot) {
                ItemStack removed = items.get(slot);
                items.set(slot, ItemStack.EMPTY);
                markDirty();
                return removed;
            }

            @Override
            public void setStack(int slot, ItemStack stack) {
                items.set(slot, stack);
                markDirty();
            }

            @Override
            public void markDirty() {
                BackpackItem.saveInventory(backpackStack, items);
            }

            @Override
            public boolean canPlayerUse(PlayerEntity player) {
                return true;
            }

            @Override
            public void clear() {
                items.clear();
                markDirty();
            }
        };

        // -------------------------
        // BACKPACK SLOTS (27 slots)
        // -------------------------
        int index = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(inv, index++, 8 + col * 18, 18 + row * 18));
            }
        }

        // -------------------------
        // PLAYER INVENTORY (27 slots)
        // -------------------------
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9,
                        8 + col * 18, 84 + row * 18));
            }
        }

        // -------------------------
        // HOTBAR (9 slots)
        // -------------------------
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        // Optional: implement shift-click behavior later
        return ItemStack.EMPTY;
    }
}