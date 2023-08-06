package com.rubok.diary.board.application.port.outgoing

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardSaveVO
import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardSelectVO

interface BoardRepositoryPort {
    fun findAll(): List<BoardSelectVO>
    fun findById(id: Long): BoardSelectVO
    fun save(board: BoardSaveVO): BoardSelectVO
    fun update(board: BoardSaveVO): BoardSelectVO
    fun deleteById(id: Long)
}