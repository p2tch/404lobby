package dev.p2tch.lobby.loader

import com.google.inject.Inject
import dev.p2tch.lobby.annotation.RegisteredListener
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import pl.notkris.aaapi.loader.ClassTypeLoader

class ListenerLoader @Inject constructor(
    private val javaPlugin: JavaPlugin
): ClassTypeLoader() {
    override fun type(): Class<out Annotation> =
        RegisteredListener::class.java

    override fun process(clazz: Class<*>, instance: Any) {
        javaPlugin.server.pluginManager.registerEvents(instance as Listener, javaPlugin)
    }
}