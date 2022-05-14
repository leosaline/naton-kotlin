package com.leo.naton

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NatonApplication

fun main(args: Array<String>) {
	runApplication<NatonApplication>(*args)
}
