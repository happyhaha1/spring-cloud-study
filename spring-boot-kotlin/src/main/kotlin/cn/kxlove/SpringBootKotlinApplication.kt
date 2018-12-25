package cn.kxlove

import cn.kxlove.modle.User
import cn.kxlove.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

/**
 *
 * <p>SpringBootKotlinApplication</p>
 *
 * @author zhengkaixin
 * @since 2018-12-21 14:53
 */

@SpringBootApplication
class SpringBootKotlinApplication {
    private val log = LoggerFactory.getLogger(SpringBootKotlinApplication::class.java)

    @Bean
    fun init(repository: UserRepository) = CommandLineRunner {
        repository.save(User("Jack", "Bauer"))
        repository.save(User("Chloe", "O'Brian"))
        repository.save(User("Kim", "Bauer"))
        repository.save(User("David", "Palmer"))
        repository.save(User("Michelle", "Dessler"))

        // fetch all customers
        log.info("Customers found with findAll():")
        log.info("-------------------------------")
        repository.findAll().forEach { log.info(it.toString()) }
        log.info("")

        // fetch an individual customer by ID
        val customer = repository.findById(1L)
        customer.ifPresent { it ->
            log.info("Customer found with findById(1L):")
            log.info("--------------------------------")
            log.info(it.toString())
            log.info("")
        }

        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):")
        log.info("--------------------------------------------")
        repository.findByLastName("Bauer").forEach { log.info(it.toString()) }
        log.info("")
    }
}

fun main(args: Array<String>) {
//    SpringApplicationBuilder(SpringBootKotlinApplication::class.java)
//        .web(WebApplicationType.NONE)
//        .run(*args)
    runApplication<SpringBootKotlinApplication>(*args) {
        webApplicationType = WebApplicationType.NONE
    }
}