package dev.p2tch.lobby.service

import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

class TabListService {
    fun show(player: Player, header: Component, footer: Component) {
        player.sendPlayerListHeaderAndFooter(header, footer)
    }
}