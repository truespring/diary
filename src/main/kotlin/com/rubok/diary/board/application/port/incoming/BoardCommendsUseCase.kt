package com.rubok.diary.board.application.port.incoming

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardVO

interface BoardCommendsUseCase {
    fun createBoard(board: BoardVO): BoardVO
    fun updateBoard(board: BoardVO): BoardVO
    fun deleteBoard(id: Long)
}