package com.olexyn.about.quarkus.app

import org.eclipse.microprofile.config.ConfigProvider

object ConfigUtil {
    fun getConfigValue(key: String): String? =
        try {
            ConfigProvider.getConfig().getValue(key, String::class.java)
        } catch (e: Exception) {
            null // or handle the exception as needed
        }
}
