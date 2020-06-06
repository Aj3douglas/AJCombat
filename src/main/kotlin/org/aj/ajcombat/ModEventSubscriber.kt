package org.aj.ajcombat

import com.example.examplemod.ExampleMod
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import net.minecraft.item.Item
import net.minecraft.item.ItemTier
import net.minecraft.item.SwordItem
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ColorHandlerEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.loading.FMLPaths
import net.minecraftforge.registries.IForgeRegistryEntry
import org.aj.ajcombat.AJCombat.MOD_ID
import org.aj.ajcombat.AJCombat.logger
import org.aj.ajcombat.AJCombat.readSwords
import org.aj.ajcombat.core.Sword
import org.aj.ajcombat.init.ModItemGroups
import org.aj.ajcombat.init.ModItems
import java.io.File


@Mod.EventBusSubscriber(modid = MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD )
object ModEventSubscriber {
    @SubscribeEvent
    fun onRegisterItems(event: RegistryEvent.Register<Item>){
        readSwords().forEach{
            println("Registering ${it.name} sword")
            event.registry.register(
            setup(SwordItem(ItemTier.WOOD, it.attackDamage, 5f, Item.Properties().group(ModItemGroups.CUSTOM_SWORDS)), it.name)
            )
        }
    }

    private fun <T : IForgeRegistryEntry<T>> setup(entry: T, name: String): T = setup(entry, ResourceLocation(MOD_ID, name))

    private fun <T : IForgeRegistryEntry<T>> setup(entry: T, registryName: ResourceLocation): T {
        entry.registryName = registryName
        return entry
    }

}