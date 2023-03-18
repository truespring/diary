package com.rubok.diary.global.response

data class CommonResponse<T>(
    val status: Int,
    val message: String,
    val data: T? = null
)