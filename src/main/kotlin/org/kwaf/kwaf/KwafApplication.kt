package org.kwaf.kwaf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KwafApplication

fun main(args: Array<String>) {
    runApplication<KwafApplication>(*args)
}
