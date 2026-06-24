package dev.p2tch.lobby.service

import com.google.inject.Inject
import dev.p2tch.lobby.command.argument.ConfigurationFiles
import dev.p2tch.lobby.configuration.GeneralConfiguration
import dev.p2tch.lobby.configuration.MessagesConfiguration

class ConfigurationManager @Inject constructor(
    private val generalConfiguration: GeneralConfiguration,
    private val messagesConfiguration: MessagesConfiguration
) {
    fun reload(configuration: ConfigurationFiles) {
        when (configuration) {
            ConfigurationFiles.ALL -> reload()
            ConfigurationFiles.GENERAL -> generalConfiguration.load(true)
            ConfigurationFiles.MESSAGES -> messagesConfiguration.load(true)
        }
    }

    fun reload() {
        generalConfiguration.load(true)
        messagesConfiguration.load(true)
    }
}