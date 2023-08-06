package com.rubok.diary.board.adapter.outgoing.model

import com.rubok.diary.global.domain.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "board")
class BoardJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long? = null,
    val title: String,
    val contents: String,
    val author: String
): BaseEntity()