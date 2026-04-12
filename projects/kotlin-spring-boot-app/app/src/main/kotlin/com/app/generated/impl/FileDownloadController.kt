package com.app.generated.impl

import com.app.generated.api.DefaultApi
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class FileDownloadController : DefaultApi {
    override fun downloadFile(): ResponseEntity<Resource> {
        val fileContent = "This is a test file content.".toByteArray()
        val resource = ByteArrayResource(fileContent)

        return ResponseEntity
            .ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"test.txt\"")
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .contentLength(fileContent.size.toLong())
            .body(resource)
    }
}
