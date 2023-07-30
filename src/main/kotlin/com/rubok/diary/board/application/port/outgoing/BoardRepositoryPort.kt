package com.rubok.diary.board.application.port.outgoing

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardVO

interface BoardRepositoryPort {
    fun findAll(): List<BoardVO>
}