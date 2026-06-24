package dev.p2tch.lobby.extension

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

private val mm = MiniMessage.miniMessage()

fun String.toMiniMessage(): Component =
    mm.deserialize(this)