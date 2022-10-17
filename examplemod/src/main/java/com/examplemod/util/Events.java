package com.examplemod.util;

import com.examplemod.ExampleMod;
import com.examplemod.init.ItemInit;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;


/*@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus =  Mod.EventBusSubscriber.Bus.FORGE)

public class Events extends Item{











    public static Player player;
    public static Level level;

    static int exposing = 0;
    static int weathering = 0;
    static int oxodizing = 0;

    public static boolean isExposed = false;
    public static boolean isWeathered = false;
    public static boolean isOxodized = false;

    public Events(Properties p_41383_) {
        super(p_41383_);
    }


    private static void exposeReset() {
        exposing = 0;
    }

    private static void weatherReset() {
        weathering = 0;
    }

    private static void oxodizeReset() {
      oxodizing = 0;
    }





    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent evt) {
        Player ePlayer = evt.player;
        Inventory inventory = ePlayer.getInventory();
        ItemStack stack = new ItemStack(ItemInit.COPPER_SWORD.get());
        ItemStack stack2 = new ItemStack(ItemInit.EXPOSED_COPPER_SWORD.get());
        ItemStack stack3 = new ItemStack(ItemInit.WEATHERED_COPPER_SWORD.get());

        if (evt.phase == TickEvent.Phase.END && inventory.contains(stack)) {

            exposing++;
            isExposed = true;
           // System.out.println(exposing);
           // System.out.println(isExposed);

            return;
        }
        if (evt.phase == TickEvent.Phase.END && inventory.contains(stack2)) {

           weathering++;
           isWeathered = true;
           // System.out.println(weathering);
           // System.out.println(isWeathered);

            return;
        }
        if (evt.phase == TickEvent.Phase.END && inventory.contains(stack3)) {

            oxodizing++;
            isOxodized = true;
           // System.out.println(oxodizing);
            //System.out.println(isOxodized);

            return;
        }
    }





        @SubscribeEvent
        public static void weatherSword (PlayerEvent event){
            Inventory inventory = event.getPlayer().getInventory();
            ItemStack stack = new ItemStack(ItemInit.COPPER_SWORD.get());
            ItemStack stack2 = new ItemStack(ItemInit.EXPOSED_COPPER_SWORD.get());
            ItemStack stack3 = new ItemStack(ItemInit.WEATHERED_COPPER_SWORD.get());


            int index = inventory.findSlotMatchingItem(stack);
            int index2 = inventory.findSlotMatchingItem(stack2);
            int index3 = inventory.findSlotMatchingItem(stack3);

            if (inventory.contains(stack) && exposing == 200) {
                stack = new ItemStack(ItemInit.EXPOSED_COPPER_SWORD.get());
                inventory.setItem(index, stack);

            }
            if (exposing >= 200 && (isExposed == true)) {
                exposeReset();
            }

            if (inventory.contains(stack2) && weathering == 300) {
                stack2 = new ItemStack(ItemInit.WEATHERED_COPPER_SWORD.get());

                inventory.setItem(index2,stack2);






            }
            if (weathering >= 300 && (isWeathered == true)) {
                weatherReset();
            }

            if (inventory.contains(stack3) && oxodizing == 400) {
                stack3 = new ItemStack(ItemInit.OXODIZED_COPPER_SWORD.get());
                inventory.setItem(index3, stack3);

            }
            if (oxodizing >= 400 && (isOxodized == true)) {
              oxodizeReset();
            }


        }
    }

 */


