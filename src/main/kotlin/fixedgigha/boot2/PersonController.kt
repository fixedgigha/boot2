package fixedgigha.boot2

import fixedgigha.boot2.fixedgigha.boot2.model.PersonRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import fixedgigha.boot2.fixedgigha.boot2.model.Person
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping



@RestController
class PersonController(val repository: PersonRepository, val template: ReactiveMongoTemplate) {

    @GetMapping("/people")
    fun namesByLastName(@RequestParam lastName: Mono<String>): Flux<String> =
        repository.findByLastName(lastName).map { it.firstName + " " + it.lastName }

    @PostMapping("/people")
    fun namesByLastname(@RequestBody people: Flux<Person>): Flux<Person> {

        return template.insertAll(people.collectList())
    }
}