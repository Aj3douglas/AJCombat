package org.aj.ajcombat.core

import net.minecraft.item.IItemTier
import net.minecraft.item.crafting.Ingredient

class AdvancedSwordTier(private val repairMaterial:Ingredient, private val maxUses:Int):IItemTier {
    override fun getRepairMaterial(): Ingredient = repairMaterial
    override fun getHarvestLevel(): Int = 4
    override fun getMaxUses(): Int = maxUses
    override fun getAttackDamage(): Float = 3f
    override fun getEnchantability(): Int =  25
    override fun getEfficiency(): Float = 5f
}