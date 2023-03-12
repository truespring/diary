package com.rubok.diary.global.exception

import com.rubok.diary.global.response.ErrorCode
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.web.filter.OncePerRequestFilter

class GlobalExceptionFilterHandler : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    open fun setErrorResponse(status: HttpStatus, response: HttpServletResponse, ex: Throwable, errorCode: ErrorCode) {
        response.status = status.value()
        response.contentType = "application/json"

    }
}