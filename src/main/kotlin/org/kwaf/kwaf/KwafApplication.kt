package org.kwaf.kwaf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
class KwafApplication

fun main(args: Array<String>) {
    runApplication<KwafApplication>(*args)
}
