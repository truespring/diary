package com.rubok.diary.global.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: BadRequestException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessage.BAD_REQUEST.message)
    }

    @ExceptionHandler(InternalServerErrorException::class)
    fun handleInternalServerErrorException(ex: InternalServerErrorException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessage.INTERNAL_SERVER_ERROR.message)
    }
}

class BadRequestException(message: String) : RuntimeException(message)
class InternalServerErrorException(message: String) : RuntimeException(message)


enum class ErrorMessage(val title: String, val message: String) {
    BAD_REQUEST("Bad Request", "The request was invalid."),
    NOT_FOUND("Not Found", "The requested resource was not found."),
    UNAUTHORIZED("Unauthorized", "The user is not authorized to access this resource."),
    FORBIDDEN("Forbidden", "The user is forbidden from accessing this resource."),
    INTERNAL_SERVER_ERROR("Internal Server Error", "An unexpected error occurred. Please try again later.")
}