package dev.p2tch.lobby.command

import com.google.inject.Inject
import dev.p2tch.lobby.annotation.RegisteredCommand
import dev.p2tch.lobby.command.argument.ConfigurationFiles
import dev.p2tch.lobby.constant.Permissions
import dev.p2tch.lobby.domain.PluginVersion
import dev.p2tch.lobby.extension.toMiniMessage
import dev.p2tch.lobby.service.ConfigurationManager
import dev.p2tch.lobby.service.UIManager
import dev.p2tch.lobby.util.Prefix
import dev.rollczi.litecommands.annotations.argument.Arg
import dev.rollczi.litecommands.annotations.async.Async
import dev.rollczi.litecommands.annotations.command.Command
import dev.rollczi.litecommands.annotations.context.Context
import dev.rollczi.litecommands.annotations.execute.Execute
import dev.rollczi.litecommands.annotations.execute.ExecuteDefault
import dev.rollczi.litecommands.annotations.permission.Permission
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.util.Optional
import kotlin.time.measureTime

@Command(name = "404lobby")
@Permission(Permissions.PLUGIN_COMMAND)
@RegisteredCommand
class PluginCommand @Inject constructor(
    private val configurationManager: ConfigurationManager,
    private val pluginVersion: PluginVersion,
    private val uiManager: UIManager
) {
    @ExecuteDefault
    fun execute(@Context player: Player) {
        player.sendMessage(
            "${Prefix.DARK_ARROW.build(false)} <gray>You are currently using <#ff7575><bold>404lobby</bold> ${pluginVersion.version}".toMiniMessage()
        )
    }

    @Async
    @Execute(name = "reload")
    fun reload(@Context player: Player, @Arg configuration: Optional<ConfigurationFiles>) {
        val conf = configuration.orElse(ConfigurationFiles.ALL)

        val duration = measureTime {
            configurationManager.reload(conf)

            uiManager.updateAfterReload()
        }

        player.sendMessage(
            "${Prefix.DARK_ARROW.build(false)} <gray>Reloaded in <#ff7575>$duration".toMiniMessage()
        )
    }
}