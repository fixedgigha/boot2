package fixedgigha.boot2.model

@org.springframework.stereotype.Repository
interface PersonRepository : org.springframework.data.repository.reactive.ReactiveCrudRepository<Person, String> {

    fun findByLastName(lastName: reactor.core.publisher.Mono<String>): reactor.core.publisher.Flux<Person>

    @org.springframework.data.mongodb.repository.Query("{'firstName' : ?0, 'lastName' : ?1}")
    fun findByFirstNameAndLastName(firstName: String, lastName: String)
}
