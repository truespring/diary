package com.rubok.diary.board.adapter.outgoing.persistence.mapper

import com.rubok.diary.board.adapter.outgoing.model.BoardJpaEntity
import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardVO
import org.springframework.stereotype.Component

@Component
class BoardMapper {

    fun toDomainBoardVO(boardJpaEntity: BoardJpaEntity): BoardVO {
        return BoardVO(
            idx = boardJpaEntity.idx!!,
            title = boardJpaEntity.title,
            contents = boardJpaEntity.contents,
            author = boardJpaEntity.author,
            createdAt = boardJpaEntity.createdAt,
            updatedAt = boardJpaEntity.updatedAt
        )
    }
}