package com.rubok.diary.board.adapter.outgoing.persistence.jpa

import com.rubok.diary.board.adapter.outgoing.model.BoardJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BoardJpaRepository : JpaRepository<BoardJpaEntity, Long>