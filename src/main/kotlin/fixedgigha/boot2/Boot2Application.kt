package fixedgigha.boot2

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class Boot2Application

fun main(args: Array<String>) {
    SpringApplication.run(Boot2Application::class.java, *args)
}
