package com.app.generated.impl

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.request
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(FilesController::class)
class FilesControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `downloadFile returns 200 OK and expected stream content`() {
        val testFileId = "12345"
        val expectedContent = "This is a sample download file content for fileId: $testFileId."

        val mvcResult =
            mockMvc
                .perform(get("/files/$testFileId/download"))
                .andExpect(request().asyncStarted())
                .andReturn()

        mockMvc
            .perform(asyncDispatch(mvcResult))
            .andExpect(status().isOk)
            .andExpect(header().string(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"sample.txt\""))
            .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE))
            .andExpect(content().string(expectedContent))
    }
}
