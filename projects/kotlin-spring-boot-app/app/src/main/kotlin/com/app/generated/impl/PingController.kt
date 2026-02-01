package com.app.generated.impl

import com.app.generated.api.PingApi
import com.app.generated.model.PingResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController : PingApi {
    override fun ping(): ResponseEntity<PingResponse> =
        ResponseEntity.ok(
            PingResponse(
                message = "pong",
                appVersion = "0.1.0",
            ),
        )
}
