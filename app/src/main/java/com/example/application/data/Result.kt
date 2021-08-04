package com.example.application.data

/**
 * Authentication result : success (user details) or error message.
 */
data class Result<T>(
    val success: T? = null,
    val error: Int? = null
)