package com.rubok.diary.global.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class DateUtilsTests{

    @Test
    @DisplayName("LocalDateTime을 String으로 변환하는 테스트")
    fun convertDateToStringTest(){
        // given
        val localDateTimeString = "2021-08-01T00:00:00"
        val localDateTime = LocalDateTime.parse(localDateTimeString)
        val expected = "2021-08-01 00:00:00"

        // when
        val actual = DateUtils.convertDateToString(localDateTime)

        // then
        assertEquals(expected, actual)
    }
}