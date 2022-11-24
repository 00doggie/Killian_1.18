package com.examplemod.network;

import com.examplemod.init.custom.Ruler;
import com.examplemod.init.custom.RulerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DisplayDistancePacket {
 public static final String PLAYER_DISTANCE = "test";






    public DisplayDistancePacket() {
    }

    public DisplayDistancePacket(FriendlyByteBuf buf) {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
       ServerPlayer player = context.getSender();




            Minecraft.getInstance().player.displayClientMessage(new TextComponent(PLAYER_DISTANCE), false);
        });
        return true;
    }
}
