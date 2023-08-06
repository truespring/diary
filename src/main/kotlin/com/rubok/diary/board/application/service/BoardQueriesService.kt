package com.rubok.diary.board.application.service

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardSelectVO
import com.rubok.diary.board.application.port.incoming.BoardQueriesUseCase
import com.rubok.diary.board.application.port.outgoing.BoardRepositoryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class BoardQueriesService(
    private val boardRepositoryPort: BoardRepositoryPort
) : BoardQueriesUseCase {
    override fun getBoardList(): List<BoardSelectVO> {
        return boardRepositoryPort.findAll()
    }

    override fun getBoardDetail(id: Long): BoardSelectVO {
        return boardRepositoryPort.findById(id)
    }
}