package com.rubok.diary.board.application.port.incoming

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardVO

interface BoardQueriesUseCase {
    fun getBoardList(): List<BoardVO>
}