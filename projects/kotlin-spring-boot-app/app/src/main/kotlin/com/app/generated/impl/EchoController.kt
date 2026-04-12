package com.app.generated.impl

import com.app.generated.api.EchoApi
import com.app.generated.model.Echo200Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class EchoController : EchoApi {
    override fun echo(text: String): ResponseEntity<Echo200Response> =
        ResponseEntity.ok(
            Echo200Response(
                echoedText = text,
            ),
        )
}
