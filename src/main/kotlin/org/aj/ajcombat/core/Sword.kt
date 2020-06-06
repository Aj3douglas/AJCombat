package org.aj.ajcombat.core

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import net.minecraft.item.Item


data class Sword(
        @SerializedName("key")
        val name:String,
        val durability:Int,
        @SerializedName("attack_damage")
        val attackDamage:Int,
        @SerializedName("repair_material")
        val repairMaterial:String
)