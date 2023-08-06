package com.rubok.diary.global.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtils {

    companion object {
        private const val pattern = "yyyy-MM-dd HH:mm:ss"
        @JvmStatic
        fun convertDateToString(date: LocalDateTime): String {
            return date.format(DateTimeFormatter.ofPattern(pattern))
        }
    }
}