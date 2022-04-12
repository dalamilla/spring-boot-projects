package com.dalamilla.requestheader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@SpringBootApplication
class RequestHeaderApplication

fun main(args: Array<String>) {
    runApplication<RequestHeaderApplication>(*args)
}

@RestController
class MessageResource {

    @CrossOrigin(origins = ["*"])
    @GetMapping("/api/whoami")
    fun whoami(
        request: HttpServletRequest,
        @RequestHeader("Accept-Language") language: String,
        @RequestHeader("User-Agent") software: String,


        ): Message = Message(request.remoteAddr, language, software)
}

data class Message(val ipaddress: String, val language: String, val software: String)
