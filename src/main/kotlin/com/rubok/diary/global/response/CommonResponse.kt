package com.rubok.diary.global.response

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import lombok.*
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CommonResponse<T> {

    @Getter
    @NoArgsConstructor
    class Error(private val fieldName: String, private val message: String) {
        companion object {
            fun of(bindingResult: BindingResult): List<Error> {
                return bindingResult.allErrors.stream()
                    .map { error ->
                        error.defaultMessage?.let {
                            Error(
                                (error as FieldError).field, it
                            )
                        }
                    }.toList()
            }
        }
    }

    enum class Result {
        SUCCESS, FAIL
    }

    enum class ErrorType {
        ERROR, WARNING
    }

    private val result: Result? = null
    private val data: T? = null
    private val message: String? = null
    private val errorCode: String? = null
    private val errorType: ErrorType? = null

    fun <T> success(data: T, message: String?): CommonResponse<T> {
        return CommonResponse.builder()
            .result(Result.SUCCESS)
            .data(data)
            .message(message)
            .build()
    }

    fun <T> success(data: T): CommonResponse<T> {
        return success(data, null)
    }

    fun fail(message: String?, errorCode: String?, errorType: ErrorType?): CommonResponse<Any?> {
        return CommonResponse.builder()
            .result(Result.FAIL)
            .message(message)
            .errorCode(errorCode)
            .errorType(errorType)
            .build()
    }

    fun fail(errorCode: ErrorCode): CommonResponse<Any?> {
        return CommonResponse.builder()
            .result(Result.FAIL)
            .message(errorCode.getErrorMsg())
            .errorCode(errorCode.name)
            .build()
    }

    @Throws(JsonProcessingException::class)
    fun fail(bindingResult: List<Error?>?): CommonResponse<Any?>? {
        val mapper = ObjectMapper()
        return CommonResponse.fail(
            mapper.writeValueAsString(bindingResult),
            ErrorCode.COMMON_INVALID_PARAMETER.name,
            ErrorType.ERROR
        )
    }
}