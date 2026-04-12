package com.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @GetMapping("/users")
    fun searchUsers(condition: SearchUserCondition): Map<String, Any?> {
        // デモ用: 受け取った SearchUserCondition の内容をそのまま JSON として返す
        return mapOf(
            "receivedCondition" to condition,
            "message" to "This is a demo response to show how query parameters are mapped to a single object.",
        )
    }
}
