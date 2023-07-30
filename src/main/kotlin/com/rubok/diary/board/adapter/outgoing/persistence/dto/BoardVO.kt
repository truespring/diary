package com.rubok.diary.board.adapter.outgoing.persistence.dto

import java.time.LocalDateTime

class BoardVO(
    private val idx: Long,
    private val title: String,
    private val contents: String,
    private val author: String,
    private val createdAt: LocalDateTime,
    private val updatedAt: LocalDateTime
)