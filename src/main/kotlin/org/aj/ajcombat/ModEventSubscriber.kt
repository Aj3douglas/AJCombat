package org.aj.ajcombat

import com.example.examplemod.ExampleMod
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemTier
import net.minecraft.item.SwordItem
import net.minecraft.item.crafting.Ingredient
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.tags.Tag
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ColorHandlerEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.loading.FMLPaths
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.IForgeRegistryEntry
import org.aj.ajcombat.AJCombat.MOD_ID
import org.aj.ajcombat.AJCombat.logger
import org.aj.ajcombat.AJCombat.readSwords
import org.aj.ajcombat.core.AdvancedSword
import org.aj.ajcombat.core.AdvancedSwordTier
import org.aj.ajcombat.core.Sword
import org.aj.ajcombat.init.ModItemGroups
import org.aj.ajcombat.init.ModItems
import java.io.File
import java.lang.RuntimeException


@Mod.EventBusSubscriber(modid = MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD )
object ModEventSubscriber {
    @SubscribeEvent
    fun onRegisterItems(event: RegistryEvent.Register<Item>){
        readSwords().forEach{
            println("Registering ${it.name} sword")
            event.registry.register(
            setup(AdvancedSword(it.attackDamage, resolveIngredient(it.repairMaterial)), it.name)
            )
        }
    }

    private fun <T : IForgeRegistryEntry<T>> setup(entry: T, name: String): T = setup(entry, ResourceLocation(MOD_ID, name))

    private fun <T : IForgeRegistryEntry<T>> setup(entry: T, registryName: ResourceLocation): T {
        entry.registryName = registryName
        return entry
    }

    private fun resolveItemTag(tagName:String):Tag<Item> =
            ItemTags.getCollection()[ResourceLocation(tagName)] ?: throw RuntimeException("The item tag $tagName does not exist!")

    private fun resolveIngredient(material:String):Ingredient =
        if(material.contains(":")) Ingredient.fromItems(resolveItem(material))
    else Ingredient.fromTag(ItemTags.LOGS)

    private fun resolveItem(registryName:String):Item = ForgeRegistries.ITEMS.getValue(ResourceLocation(registryName)) ?: throw RuntimeException("The item $registryName does not exist!")


}