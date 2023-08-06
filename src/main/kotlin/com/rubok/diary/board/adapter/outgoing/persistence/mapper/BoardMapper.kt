package com.rubok.diary.board.adapter.outgoing.persistence.mapper

import com.rubok.diary.board.adapter.outgoing.model.BoardJpaEntity
import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardSaveVO
import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardSelectVO
import com.rubok.diary.global.util.DateUtils
import org.springframework.stereotype.Component

@Component
class BoardMapper {

    fun toDomainBoardVO(boardJpaEntity: BoardJpaEntity): BoardSelectVO {
        return BoardSelectVO(
            idx = boardJpaEntity.idx!!,
            title = boardJpaEntity.title,
            contents = boardJpaEntity.contents,
            author = boardJpaEntity.author,
            createdAt = DateUtils.convertDateToString(boardJpaEntity.createdAt),
            updatedAt = DateUtils.convertDateToString(boardJpaEntity.updatedAt)
        )
    }

    fun toEntityBoardForSave(boardVO: BoardSaveVO): BoardJpaEntity {
        return BoardJpaEntity(
            title = boardVO.title,
            contents = boardVO.contents,
            author = boardVO.author,
        )
    }

    fun toEntityBoardForUpdate(boardSelectVO: BoardSaveVO): BoardJpaEntity {
        return BoardJpaEntity(
            idx = boardSelectVO.idx,
            title = boardSelectVO.title,
            contents = boardSelectVO.contents,
            author = boardSelectVO.author,
        )
    }
}