package com.examplemod.init.custom;

import com.examplemod.network.DisplayDistancePacket;
import com.examplemod.network.ModMessages;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;

import java.lang.ref.WeakReference;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public class RulerScreen  extends AbstractContainerScreen<RulerMenu> implements Button.OnPress {
    private EditBox NameBox;
    private UUID uuid;
    private int entityId;
    private Supplier entitySupplier;
 public static String displayName = "";
    public static double distanceBetween;
    public static String name;
 public static Player player;
  public static  ServerLevel serverLevel;
    public static String s=String.valueOf(distanceBetween);



    public RulerScreen(RulerMenu p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
    }






    public void resize(Minecraft p_97677_, int p_97678_, int p_97679_) {
        String textFieldValue = this.NameBox.getValue();
        this.init(p_97677_, p_97678_, p_97679_);
        this.NameBox.setValue(textFieldValue);
    }
    public void containerTick() {
        super.containerTick();
        this.NameBox.tick();
    }



    @Override
    protected void init() {

        NameBox = new EditBox(this.font, this.width / 2 - 92, this.height / 4 - 10, 184, 20, new TextComponent("name"));
        NameBox.setMaxLength(60);
        this.addRenderableWidget(NameBox);



        this.addRenderableWidget(new Button(this.width / 2 - 75, this.height * 3 / 4 - 10, 150, 20,
                CommonComponents.GUI_DONE,  this::onPress));

        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);


        /*name = "";
        Optional<ServerPlayer> targetOp = serverLevel.getPlayers(playerTest -> playerTest.getName().getString().equals(name)).stream().findFirst();
        if (targetOp.isPresent()) {
            distanceBetween = targetOp.get().distanceTo(player);
        } else {
            //User does not exist!

        }

         */





        this.NameBox.setMaxLength(50);
        this.NameBox.setFocus(true);
        this.NameBox.setCanLoseFocus(false);
        this.NameBox.setEditable(true);


   //this.NameBox.setValue(name);
        this.setInitialFocus(this.NameBox);






    }

    @Override
    public void onPress(Button button){
//Minecraft.getInstance().player.displayClientMessage(Component.nullToEmpty(DisplayDistancePacket.PLAYER_DISTANCE), false);
ModMessages.sendToServer(new DisplayDistancePacket());
onClose();

    }



    public boolean keyPressed(int p_97878_, int p_97879_, int p_97880_) {
        if (p_97878_ == 256) {
            this.minecraft.player.closeContainer();

        }
        if (p_97879_ == 13) {
            this.minecraft.player.closeContainer();

        }

        return !this.NameBox.keyPressed(p_97878_, p_97879_, p_97880_) && !this.NameBox.canConsumeInput() ? super.keyPressed(p_97878_, p_97879_, p_97880_) : true;
    }
    @Override
    protected void renderBg(PoseStack poseStack, float pPartialTick, int pMouseX, int pMouseY) {
        this.renderBackground(poseStack);
        this.NameBox.render(poseStack, pMouseX, pMouseY, pPartialTick);
    }

    public void onClose() {

        super.onClose();

        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);

    }

}
