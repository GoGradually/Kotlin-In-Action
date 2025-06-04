package gogradually.ch1

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
open class HelloSpring
fun main(args: Array<String>) {
    SpringApplication.run(HelloSpring::class.java, *args)
}

@RestController
class GreetingResource{
    @GetMapping
    fun index(): List<Greeting> = listOf(
        Greeting(1, "Hello!"),
        Greeting(2, "Bonjour!"),
        Greeting(3, "London!"),
    )
}

data class Greeting(val id: Int, val message: String)