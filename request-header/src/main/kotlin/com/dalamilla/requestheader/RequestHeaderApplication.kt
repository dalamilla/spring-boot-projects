package com.dalamilla.requestheader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RequestHeaderApplication

fun main(args: Array<String>) {
	runApplication<RequestHeaderApplication>(*args)
}
