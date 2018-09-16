package org.kwaf.kwaf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
class KwafApplication

fun main(args: Array<String>) {
    runApplication<KwafApplication>(*args)
}
