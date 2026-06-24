package dev.p2tch.lobby.configuration

import eu.okaeri.configs.OkaeriConfig

class TablistConfiguration: OkaeriConfig() {
    var enabled: Boolean = false

    var headerLines: List<String> = listOf(
        "",
        "<#ff7575>404lobby",
        "",
        "<gray> A lightweight, fully customizable lobby solution engineered for",
        "<#ff7575>modern Minecraft servers.",
        ""
    )

    var footerLines: List<String> = listOf(
        "",
        "<#ff7575>github.com/p2tch/404lobby",
        ""
    )
}