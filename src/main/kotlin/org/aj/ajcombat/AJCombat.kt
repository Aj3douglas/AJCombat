package org.aj.ajcombat

import com.google.common.reflect.TypeToken
import com.google.gson.GsonBuilder
import com.google.gson.stream.JsonReader
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.loading.FMLPaths
import org.aj.ajcombat.AJCombat.MOD_ID
import org.aj.ajcombat.core.Sword
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.FileReader
import java.io.Reader
import java.nio.file.Files
import java.nio.file.Path
import java.util.function.Supplier

@Mod(MOD_ID)
object AJCombat {

    const val MOD_ID = "ajcombat"
    val logger: Logger = LogManager.getLogger()
    private var swordsFile:Path
    val gson = GsonBuilder().create()
    init{
        logger.debug("AJ Combat mod starting up!")
        val configDir = FMLPaths.CONFIGDIR.get().resolve(MOD_ID)
        swordsFile = configDir.resolve("swords.json")
        if(Files.notExists(swordsFile)){
            Files.createDirectory(configDir)
            this::class.java.getResourceAsStream("/assets/$MOD_ID/swords_default.json").use { Files.copy(it, swordsFile) }
        }
    }
    fun readSwords() :List<Sword> = gson.fromJson(
            JsonReader(FileReader(swordsFile.toFile()) as Reader),
            object : TypeToken<List<Sword>>(){}.type
    )
}