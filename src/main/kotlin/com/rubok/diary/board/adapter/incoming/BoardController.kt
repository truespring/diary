package com.rubok.diary.board.adapter.incoming

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardVO
import com.rubok.diary.board.application.port.incoming.BoardQueriesUseCase
import org.springframework.web.bind.annotation.PostMapping

@BoardV1Controller
class BoardController(
    private val boardQueriesUseCase: BoardQueriesUseCase
) {

    @PostMapping("/boards")
    fun getBoardList(): List<BoardVO> {
        return boardQueriesUseCase.getBoardList()
    }
}