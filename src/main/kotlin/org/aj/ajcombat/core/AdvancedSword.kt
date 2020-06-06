package org.aj.ajcombat.core

import net.minecraft.item.ItemStack
import net.minecraft.item.ItemTier
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolItem

class AdvancedSword(attackDamage:Int): SwordItem(ItemTier.WOOD, attackDamage, 5f, Properties()) {
    override fun isBookEnchantable(stack: ItemStack, book: ItemStack): Boolean = false

}