package dev.p2tch.lobby.configuration

import eu.okaeri.configs.OkaeriConfig

class TablistConfiguration: OkaeriConfig() {
    var enabled: Boolean = false

    var header: String = "404lobby"
    var footer: String = "github.com/p2tch/404lobby"
}