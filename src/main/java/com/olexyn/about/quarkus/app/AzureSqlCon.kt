package com.olexyn.about.quarkus.app

import java.sql.Connection
import java.sql.DriverManager

class AzureSqlCon {


    fun test() {


        val connectionString = String.format(
            "jdbc:sqlserver://%s:1433;database=%s;" +
                    "user=%s;password=%s;encrypt=true;trustServerCertificate=false;" +
                    "hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
            ConfigUtil.getConfigValue("azure.sql.serverName"),
            ConfigUtil.getConfigValue("azure.sql.databaseName"),
            ConfigUtil.getConfigValue("azure.sql.username"),
            ConfigUtil.getConfigValue("azure.sql.password")
        )

        try {

            val connection: Connection = DriverManager.getConnection(connectionString)
            connection.nativeSQL("CREATE TABLE assets (\n" +
                    "                        id SERIAL PRIMARY KEY,\n" +
                    "                        name VARCHAR(255) NOT NULL,\n" +
                    "                        description TEXT NOT NULL\n" +
                    ");\n")
            println("Connected to the database.")
            // Use the connection here
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
