package com.examplemod.util;

import com.examplemod.init.ItemInit;


import com.mojang.realmsclient.util.JsonUtils;
import net.minecraft.world.entity.Entity;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;


public class CopperSword extends SwordItem {
    private int maxTicks = 300;


    public CopperSword(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    public enum Rust {
        CLEAN(() -> ItemInit.COPPER_SWORD.get()),
        EXPOSE(() -> ItemInit.  EXPOSED_COPPER_SWORD.get()),
        WEATHER(() -> ItemInit.OXODIZED_COPPER_SWORD.get());


        private final Supplier<Item> rusting;

        Rust(Supplier<Item> rusting) {
            this.rusting = rusting;
        }

        public Item getRusting() {
            return rusting.get();
        }
    }


    Rust rust = Rust.CLEAN;


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {


        entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {

        int index = -1;

        for (int i = 0; i < handler.getSlots(); i++) {
            if (handler.getStackInSlot(i) == stack)
                index = i;

        }

                            if (index >= 0) {
                                if (getTicks(stack) >= this.maxTicks) {
                                    ItemStack newStack = new ItemStack(ItemInit.EXPOSED_COPPER_SWORD.get(), 1, stack.getTag());
                                    setTicks(newStack, 0);
                                    handler.extractItem(index, 1, false);
                                    handler.insertItem(index, newStack, false);


                                }
                                setTicks(stack, getTicks(stack) + 1);

                            }



                    });


                super.inventoryTick(stack, level, entity, slot, selected);
            }






        public static void setTicks (ItemStack stack,int ticks){
            stack.getOrCreateTag().putInt("ticks", ticks);
            System.out.println(ticks);
        }


        public static int getTicks (ItemStack stack){

            return stack.hasTag() ? stack.getTag().getInt("ticks") : 0;

        }
    }






