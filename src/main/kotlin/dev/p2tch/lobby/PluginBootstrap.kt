package dev.p2tch.lobby

import com.google.inject.Guice
import dev.p2tch.lobby.module.PluginModule
import org.bukkit.plugin.java.JavaPlugin

class PluginBootstrap: JavaPlugin() {
    override fun onEnable() {
        val injector = Guice.createInjector(
            PluginModule(this)
        )

        injector.getInstance(PluginInitializer::class.java).init()
    }

    override fun onDisable() {

    }
}