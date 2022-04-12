package com.dalamilla.requestheader

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class RequestHeaderApplicationTests(@Autowired val mockMvc: MockMvc) {

    @Test
    fun checkPath() {
        mockMvc.perform(
            get("/api/whoami").header("Accept-Language", "en-US,en;q=0.9,es;q=0.8")
                .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64")
        )
            .andExpect(status().isOk)
    }

    @Test
    fun checkValues() {
        mockMvc.perform(
            get("/api/whoami").header("Accept-Language", "en-US,en;q=0.9,es;q=0.8")
                .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64")
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.software").value("Mozilla/5.0 (X11; Linux x86_64"))
            .andExpect(jsonPath("$.language").value("en-US,en;q=0.9,es;q=0.8"))
            .andExpect(jsonPath("$.ipaddress").value("127.0.0.1"))
    }
}
