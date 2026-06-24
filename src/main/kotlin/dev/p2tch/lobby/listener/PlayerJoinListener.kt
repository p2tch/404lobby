package dev.p2tch.lobby.listener

import com.google.inject.Inject
import dev.p2tch.lobby.annotation.RegisteredListener
import dev.p2tch.lobby.service.UIManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

@RegisteredListener
class PlayerJoinListener @Inject constructor(
    private val uiManager: UIManager
): Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player

        uiManager.update(player)
    }
}