package fixedgigha.boot2

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@EnableReactiveMongoRepositories
class MongoConfig : AbstractReactiveMongoConfiguration() {

    @Bean
    override fun mongoClient() : MongoClient = MongoClients.create()

    override fun getDatabaseName() = "boot2"
}