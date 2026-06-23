package dev.p2tch.lobby

import com.google.inject.Inject
import com.google.inject.Injector
import dev.p2tch.lobby.loader.CommandLoader
import dev.p2tch.lobby.loader.ListenerLoader
import org.bukkit.plugin.java.JavaPlugin
import pl.notkris.aaapi.guice.GuiceInstanceProvider
import pl.notkris.aaapi.registry.LoaderRegistry

class PluginInitializer @Inject constructor(
    private val injector: Injector,
    private val javaPlugin: JavaPlugin,
    private val commandLoader: CommandLoader,
    private val listenerLoader: ListenerLoader
) {
    fun init() {
        prepareLoaders()
    }

    fun prepareLoaders() {
        val registry = LoaderRegistry(
            javaPlugin.javaClass.packageName,
            javaPlugin.javaClass.classLoader,
            GuiceInstanceProvider(injector)
        )

        registry.register(commandLoader)
        registry.register(listenerLoader) // automatically registers listeners

        registry.loadAll()
    }
}