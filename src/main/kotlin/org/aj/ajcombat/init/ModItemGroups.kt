package org.aj.ajcombat.init

import com.example.examplemod.ExampleMod
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import org.aj.ajcombat.AJCombat.MOD_ID
import java.util.function.Supplier


object ModItemGroups{
    class ModItemGroup(name: String, private val iconSupplier: Supplier<ItemStack>):ItemGroup(name){
        override fun createIcon(): ItemStack = iconSupplier.get()
    }
    val CUSTOM_SWORDS = ModItemGroup(MOD_ID, Supplier{ ItemStack(ModItems.ADVANCED_DIAMOND_SWORD) })
}