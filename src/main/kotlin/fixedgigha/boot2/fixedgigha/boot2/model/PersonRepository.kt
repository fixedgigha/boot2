package fixedgigha.boot2.fixedgigha.boot2.model

import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface PersonRepository : ReactiveCrudRepository<Person, String> {

    fun findByLastName(lastName: Mono<String>): Flux<Person>

    @Query("{'firstName' : ?0, 'lastName' : ?!}")
    fun findByFirstNameAndLastName(firstName: String, lastName: String)
}
