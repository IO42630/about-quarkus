package com.olexyn.about.quarkus.app

import com.azure.cosmos.CosmosClientBuilder
import com.azure.cosmos.models.CosmosQueryRequestOptions
import com.olexyn.about.quarkus.model.Asset

class CosmosCon {


    fun test() {
        println("CosmosCon")
        val cosmosClient = CosmosClientBuilder()
            .endpoint("<Your-CosmosDB-URI>")
            .key("<Your-CosmosDB-Key>")
            .buildClient()

        val database = cosmosClient.getDatabase("<Your-Database-Name>")
        val container = database.getContainer("<Your-Container-Name>")

        // Example query
        val query = "SELECT * FROM c"
        val feedResponse = container.queryItems(query, CosmosQueryRequestOptions(), Asset::class.java)

        // Iterate through the results
        for (item in feedResponse) {
            println(item)
        }
    }
}
