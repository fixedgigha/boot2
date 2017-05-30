package fixedgigha.boot2

import fixedgigha.boot2.model.Person
import kotlin.jvm.javaClass
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

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
}
