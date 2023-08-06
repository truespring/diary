package com.rubok.diary.board.application.port.incoming

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardSaveVO
import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardSelectVO

interface BoardCommendsUseCase {
    fun createBoard(board: BoardSaveVO): BoardSelectVO
    fun updateBoard(board: BoardSaveVO): BoardSelectVO
    fun deleteBoard(id: Long)
}