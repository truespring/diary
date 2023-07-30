package com.rubok.diary.board.adapter.outgoing.persistence

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardVO
import com.rubok.diary.board.adapter.outgoing.persistence.jpa.BoardJpaRepository
import com.rubok.diary.board.adapter.outgoing.persistence.mapper.BoardMapper
import com.rubok.diary.board.application.port.outgoing.BoardRepositoryPort
import org.springframework.stereotype.Repository

@Repository
class BoardPersistenceAdapter(
    private val boardMapper: BoardMapper,
    private val boardJpaRepository: BoardJpaRepository
) : BoardRepositoryPort {
    override fun findAll(): List<BoardVO> {
        val boardList = boardJpaRepository.findAll()
        return boardList.map { boardMapper.toDomainBoardVO(it) }
    }
}