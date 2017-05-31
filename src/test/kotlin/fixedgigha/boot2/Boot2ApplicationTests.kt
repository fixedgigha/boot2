package fixedgigha.boot2

import fixedgigha.boot2.model.Person
import kotlin.jvm.javaClass
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.http.MediaType.APPLICATION_JSON
import java.time.Duration
import org.springframework.web.reactive.function.client.bodyToFlux
import reactor.core.publisher.Flux
import reactor.core.publisher.test

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Boot2ApplicationTests {

	@Autowired
	lateinit var restTemplate: TestRestTemplate

	@Test
	fun loadPeople() {
		val args = mutableListOf(Person(id = "1", firstName = "Jim", lastName = "Speakman", age = 48))
		val result = restTemplate.postForEntity("/people", args, args.javaClass)
		Assert.assertEquals(HttpStatus.OK, result.statusCode)
        println("People ${result.body}")
	}

    @Test
    fun getPeople() {
        val args = mutableListOf<Person>()
        val result = restTemplate.getForEntity("/people?lastName=Speakman", args.javaClass)
        Assert.assertEquals(HttpStatus.OK, result.statusCode)
        println("People ${result.body}")
    }

    @LocalServerPort
    var port : Int? = null

    lateinit var client: WebClient

    @Before
    fun setup() {
        client = WebClient.create("http://localhost:$port")
    }

    @Test
    fun reactLoadPeople() {
        val flux : Flux<Person> = client.get().uri("/people?lastName=Speakman").accept(APPLICATION_JSON)
                .retrieve().bodyToFlux()

        flux.test().consumeNextWith {
            println("Consumed ${it.firstName}")
            Assert.assertEquals("Jim", it.firstName)
        }.verifyComplete()


    }


}
