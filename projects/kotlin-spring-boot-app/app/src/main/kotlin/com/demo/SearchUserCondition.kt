package com.demo

data class SearchUserCondition(
    val keyword: String? = null,
    val statuses: List<String>? = null,
    val page: Int? = null,
    val size: Int? = null
)
