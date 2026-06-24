package dev.p2tch.lobby

import com.google.inject.Inject
import com.google.inject.Injector
import dev.p2tch.lobby.loader.CommandLoader
import dev.p2tch.lobby.loader.ListenerLoader
import dev.rollczi.litecommands.LiteCommands
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import pl.notkris.aaapi.guice.GuiceInstanceProvider
import pl.notkris.aaapi.registry.LoaderRegistry

class PluginInitializer @Inject constructor(
    private val injector: Injector,
    private val javaPlugin: JavaPlugin,
    private val commandLoader: CommandLoader,
    private val listenerLoader: ListenerLoader
) {
    lateinit var liteCommands: LiteCommands<CommandSender>

    fun init() {
        prepareLoaders()

        registerCommands()
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

    fun registerCommands() {
        liteCommands = LiteBukkitFactory.builder(javaPlugin)
            .commands(commandLoader.getInstances())
            .build()
    }
}