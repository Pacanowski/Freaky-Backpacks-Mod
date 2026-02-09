package net.penetrator.freakyplecaki.screenHandler;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.penetrator.freakyplecaki.FreakyPlecaki;

@Environment(EnvType.CLIENT)
public class BackpackScreen extends HandledScreen<BackpackScreenHandler> {
    private static final Identifier TEXTURE =
            Identifier.of(FreakyPlecaki.MOD_ID, "textures/gui/backpack.png");

    public BackpackScreen(BackpackScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawGuiTexture(
                RenderPipelines.GUI,
                Identifier.of(FreakyPlecaki.MOD_ID, "gui/backpack"),
                this.x, this.y,
                this.backgroundWidth,
                this.backgroundHeight
        );
    }



}