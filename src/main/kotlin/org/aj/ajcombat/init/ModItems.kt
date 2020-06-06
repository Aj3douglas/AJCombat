package org.aj.ajcombat.init

import net.minecraft.item.Item
import net.minecraftforge.registries.ObjectHolder
import org.aj.ajcombat.AJCombat.MOD_ID

object ModItems {
    @ObjectHolder("$MOD_ID:advanced_diamond_sword")
    @JvmStatic
    lateinit var ADVANCED_DIAMOND_SWORD: Item
}