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

    override fun findById(id: Long): BoardVO {
        val board = boardJpaRepository.findById(id).orElseThrow { throw RuntimeException("Not Found") }
        return boardMapper.toDomainBoardVO(board)
    }

    override fun save(board: BoardVO): BoardVO {
        return boardMapper.toDomainBoardVO(
            boardJpaRepository.save(
                boardMapper.toEntityBoardForSave(board)
            )
        )
    }

    override fun update(board: BoardVO): BoardVO {
        boardJpaRepository.findById(board.idx).orElseThrow { throw RuntimeException("Not Found") }
        return boardMapper.toDomainBoardVO(
            boardJpaRepository.save(
                boardMapper.toEntityBoardForUpdate(board)
            )
        )
    }

    override fun deleteById(id: Long) {
        boardJpaRepository.findById(id).orElseThrow { throw RuntimeException("Not Found") }
        boardJpaRepository.deleteById(id)
    }
}