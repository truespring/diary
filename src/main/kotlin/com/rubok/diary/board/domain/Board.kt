package com.rubok.diary.board.domain

import java.time.LocalDateTime

class Board(
    private val idx: Long,
    private val title: String,
    private val contents: String,
    private val author: String,
    private val createdAt: LocalDateTime,
    private val updatedAt: LocalDateTime
)