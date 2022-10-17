package com.examplemod.init.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Inventory;

public class RulerScreen  extends AbstractContainerScreen<RulerMenu> {
    private EditBox textField;



    public RulerScreen(RulerMenu p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
    }

    public void resize(Minecraft p_97677_, int p_97678_, int p_97679_) {
        String textFieldValue = this.textField.getValue();
        this.init(p_97677_, p_97678_, p_97679_);
        this.textField.setValue(textFieldValue);
    }
    public void containerTick() {
        super.containerTick();
        this.textField.tick();
    }

    @Override
    protected void init() {
        this.addRenderableWidget(new Button(this.width / 2 - 75, this.height * 3 / 4 - 10, 150, 20,
                CommonComponents.GUI_DONE, (p_97691_) -> this.onClose()));

        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);

        this.textField = new EditBox(this.font, this.width / 2 - 92, this.height / 4 - 10, 184, 20, new TextComponent("Rename variable"));
        this.textField.setMaxLength(50);
        this.textField.setFocus(true);
        this.textField.setCanLoseFocus(false);
        this.textField.setEditable(true);
        this.textField.setValue("");
        this.setInitialFocus(this.textField);


    }
    public boolean keyPressed(int p_97878_, int p_97879_, int p_97880_) {
        if (p_97878_ == 256) {
            this.minecraft.player.closeContainer();
        }

        return !this.textField.keyPressed(p_97878_, p_97879_, p_97880_) && !this.textField.canConsumeInput() ? super.keyPressed(p_97878_, p_97879_, p_97880_) : true;
    }




    @Override
    protected void renderBg(PoseStack poseStack, float pPartialTick, int pMouseX, int pMouseY) {
        this.renderBackground(poseStack);
        this.textField.render(poseStack, pMouseX, pMouseY, pPartialTick);
    }

    public void onClose() {

        super.onClose();

        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
    }

}
