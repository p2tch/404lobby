package dev.p2tch.lobby.configuration

import eu.okaeri.configs.OkaeriConfig

class GeneralConfiguration: OkaeriConfig() {
    var allowedActions: ActionsConfiguration = ActionsConfiguration()

    var tabList: TablistConfiguration = TablistConfiguration()
}