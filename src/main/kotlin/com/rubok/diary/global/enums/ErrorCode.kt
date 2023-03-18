package com.rubok.diary.global.enums

import lombok.Getter
import lombok.RequiredArgsConstructor

@Getter
@RequiredArgsConstructor
enum class ErrorCode(private val errorMsg: String) {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생하였습니다. 잠시 후 다시 시도해주세요."),
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다.");

    fun getErrorMsg(vararg arg: Any): String {
        return String.format(errorMsg, *arg)
    }
}