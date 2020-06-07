package org.aj.ajcombat.core

import net.minecraft.block.material.Material
import net.minecraft.item.*
import net.minecraft.item.crafting.Ingredient
import net.minecraft.nbt.CompoundNBT
import net.minecraft.util.ResourceLocation
import org.aj.ajcombat.init.ModItemGroups

class AdvancedSword(attackDamage:Int, repairItem:Ingredient): SwordItem(AdvancedSwordTier(repairItem, 5),
        attackDamage, 1.6f, Properties().group(ModItemGroups.CUSTOM_SWORDS))