package com.app.generated.impl

import com.app.generated.api.FilesApi
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody
import java.io.OutputStream

@RestController
class FilesController : FilesApi {
    override fun downloadFile(fileId: String): ResponseEntity<StreamingResponseBody> {
        val stream =
            StreamingResponseBody { outputStream: OutputStream ->
                outputStream.write("This is a sample download file content for fileId: $fileId.".toByteArray())
                outputStream.flush()
            }

        val headers = HttpHeaders()
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"sample.txt\"")
        headers.contentType = MediaType.APPLICATION_OCTET_STREAM

        return ResponseEntity(stream, headers, HttpStatus.OK)
    }
}
