package dev.p2tch.lobby.service

import com.google.inject.Inject
import dev.p2tch.lobby.configuration.GeneralConfiguration
import dev.p2tch.lobby.extension.toMiniMessage
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class UIManager @Inject constructor(
    private val generalConfiguration: GeneralConfiguration,
    private val tabListService: TabListService
) {
    fun update(player: Player) {
        val tabListConfiguration = generalConfiguration.tabList

        if (tabListConfiguration.enabled) {
            val header = tabListConfiguration.headerLines.joinToString("<br>")
            val footer = tabListConfiguration.footerLines.joinToString("<br>")

            tabListService.show(
                player,
                header.toMiniMessage(),
                footer.toMiniMessage()
            )
        }
    }

    fun updateAfterReload() {
        val tabListConfiguration = generalConfiguration.tabList

        if (tabListConfiguration.enabled) {
            val header = tabListConfiguration.headerLines.joinToString("<br>")
            val footer = tabListConfiguration.footerLines.joinToString("<br>")

            Bukkit.getOnlinePlayers().forEach { player ->
                tabListService.show(
                    player,
                    header.toMiniMessage(),
                    footer.toMiniMessage()
                )
            }
        }
    }
}