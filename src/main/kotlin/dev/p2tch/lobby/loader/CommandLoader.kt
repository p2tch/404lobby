package dev.p2tch.lobby.loader

import dev.p2tch.lobby.annotation.RegisteredCommand
import pl.notkris.aaapi.loader.ClassTypeLoader
import java.util.Collections

class CommandLoader: ClassTypeLoader() {
    private val instances = mutableSetOf<Any>()

    override fun type(): Class<out Annotation> =
        RegisteredCommand::class.java

    override fun process(clazz: Class<*>, instance: Any) {
        instances.add(instance)
    }

    fun getInstances(): Set<Any> {
        return Collections.unmodifiableSet(instances)
    }
}