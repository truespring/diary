package com.rubok.diary.board.adapter.outgoing.persistence.mapper

import com.rubok.diary.board.adapter.outgoing.model.BoardJpaEntity
import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardVO
import com.rubok.diary.global.util.DateUtils
import org.springframework.stereotype.Component

@Component
class BoardMapper {

    fun toDomainBoardVO(boardJpaEntity: BoardJpaEntity): BoardVO {
        return BoardVO(
            idx = boardJpaEntity.idx!!,
            title = boardJpaEntity.title,
            contents = boardJpaEntity.contents,
            author = boardJpaEntity.author,
            createdAt = DateUtils.convertDateToString(boardJpaEntity.createdAt),
            updatedAt = DateUtils.convertDateToString(boardJpaEntity.updatedAt)
        )
    }

    fun toEntityBoardForSave(boardVO: BoardVO): BoardJpaEntity {
        return BoardJpaEntity(
            title = boardVO.title,
            contents = boardVO.contents,
            author = boardVO.author,
        )
    }

    fun toEntityBoardForUpdate(boardVO: BoardVO): BoardJpaEntity {
        return BoardJpaEntity(
            idx = boardVO.idx,
            title = boardVO.title,
            contents = boardVO.contents,
            author = boardVO.author,
        )
    }
}