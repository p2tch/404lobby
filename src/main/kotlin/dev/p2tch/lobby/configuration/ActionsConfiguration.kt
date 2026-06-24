package dev.p2tch.lobby.configuration

import eu.okaeri.configs.OkaeriConfig

class ActionsConfiguration: OkaeriConfig() {
    var breakBlocks: Boolean = false
    var placeBlocks: Boolean = false
    var sendMessages: Boolean = true
    var pvp: Boolean = false
}