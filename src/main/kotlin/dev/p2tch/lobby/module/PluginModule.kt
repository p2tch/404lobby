package dev.p2tch.lobby.module

import com.google.inject.AbstractModule
import dev.p2tch.lobby.PluginBootstrap
import org.bukkit.plugin.java.JavaPlugin

class PluginModule(
    private val pluginBootstrap: PluginBootstrap
): AbstractModule() {
    override fun configure() {
        bind(JavaPlugin::class.java).toInstance(pluginBootstrap)
    }
}