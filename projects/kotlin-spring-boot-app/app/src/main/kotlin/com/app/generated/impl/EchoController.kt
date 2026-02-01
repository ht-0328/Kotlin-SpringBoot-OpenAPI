package com.app.generated.impl

import com.app.generated.api.EchoApi
import com.app.generated.model.EchoResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class EchoController : EchoApi {
    override fun echo(text: String): ResponseEntity<EchoResponse> {
        return ResponseEntity.ok(
            EchoResponse(
                echoedText = text
            )
        )
    }
}
