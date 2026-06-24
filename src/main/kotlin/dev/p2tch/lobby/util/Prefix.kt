package dev.p2tch.lobby.util

enum class Prefix(val colorTag: String, val symbol: String) {
    DARK_ARROW("<dark_gray>", "»");

    fun build(space: Boolean): String {
        return if (space) "$colorTag$symbol "
        else colorTag + symbol
    }
}