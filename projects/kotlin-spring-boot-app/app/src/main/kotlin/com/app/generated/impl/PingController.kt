package com.app.generated.impl

import com.app.generated.api.PingApi
import com.app.generated.model.Ping200Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController : PingApi {
    override fun ping(): ResponseEntity<Ping200Response> =
        ResponseEntity.ok(
            Ping200Response(
                message = "pong",
                appVersion = "0.1.0",
            ),
        )
}
