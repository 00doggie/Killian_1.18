package com.examplemod.util;

import com.examplemod.ExampleMod;
import com.examplemod.init.ItemInit;


import net.minecraft.world.entity.player.Player;



import net.minecraft.world.level.Level;

import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;



@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus =  Mod.EventBusSubscriber.Bus.FORGE)

public class Events {
    @SubscribeEvent
    public static void negateFallDamage(LivingFallEvent event) {

        if (event.getEntityLiving() instanceof Player) {
            Player player = (Player) event.getEntityLiving();


            if (((Player) event.getEntityLiving()).getInventory().getArmor(0) != null
                    && ((Player) event.getEntityLiving()).getInventory().getArmor(0).getItem().equals(ItemInit.PLATINUM_BOOTS.get())
                    && event.getEntityLiving().level.dimension() != Level.NETHER) {
                event.setCanceled(true);
            }


        }




    }
}















