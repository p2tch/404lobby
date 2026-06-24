package dev.p2tch.lobby.module

import com.google.inject.AbstractModule
import dev.p2tch.lobby.configuration.GeneralConfiguration
import dev.p2tch.lobby.configuration.MessagesConfiguration
import eu.okaeri.configs.ConfigManager
import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer
import java.io.File

class ConfigurationModule(
    private val dataFolder: File
): AbstractModule() {
    override fun configure() {
        bind(GeneralConfiguration::class.java).toInstance(
            createConfiguration(GeneralConfiguration::class.java, "config.yml")
        )

        bind(MessagesConfiguration::class.java).toInstance(
            createConfiguration(MessagesConfiguration::class.java, "messages.yml")
        )
    }

    private fun <T: OkaeriConfig> createConfiguration(clazz: Class<T>, fileName: String): T =
        ConfigManager.create(clazz) {
            it.configure { opt ->
                opt.configurer(
                    YamlSnakeYamlConfigurer()
                )

                opt.bindFile(
                    File(dataFolder, fileName)
                )
            }

            it.saveDefaults()
            it.load(true)
        }
}