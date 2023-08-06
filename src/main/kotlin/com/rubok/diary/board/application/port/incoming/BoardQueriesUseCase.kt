package com.rubok.diary.board.application.port.incoming

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardSelectVO

interface BoardQueriesUseCase {
    fun getBoardList(): List<BoardSelectVO>
    fun getBoardDetail(id: Long): BoardSelectVO
}