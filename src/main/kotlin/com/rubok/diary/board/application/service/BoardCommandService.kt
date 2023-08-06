package com.rubok.diary.board.application.service

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardVO
import com.rubok.diary.board.application.port.incoming.BoardCommendsUseCase
import com.rubok.diary.board.application.port.outgoing.BoardRepositoryPort
import org.springframework.stereotype.Service

@Service
class BoardCommandService(
    private val boardRepositoryPort: BoardRepositoryPort
) : BoardCommendsUseCase {
    override fun createBoard(board: BoardVO): BoardVO {
        return boardRepositoryPort.save(board)
    }

    override fun updateBoard(board: BoardVO): BoardVO {
        return boardRepositoryPort.update(board)
    }

    override fun deleteBoard(id: Long) {
        boardRepositoryPort.deleteById(id)
    }
}