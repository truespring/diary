package com.rubok.diary.board.application.port.outgoing

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardVO

interface BoardRepositoryPort {
    fun findAll(): List<BoardVO>
    fun findById(id: Long): BoardVO
    fun save(board: BoardVO): BoardVO
    fun update(board: BoardVO): BoardVO
    fun deleteById(id: Long)
}