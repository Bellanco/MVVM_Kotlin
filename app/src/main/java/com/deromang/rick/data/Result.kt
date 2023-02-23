package com.deromang.rick.data

/**
 * Authentication result : success (user details) or error message.
 */
data class Result<T>(
    val success: T? = null,
    val error: Int? = null
)