package com.rubok.diary.user.domain

import com.rubok.diary.global.domain.BaseEntity
import jakarta.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long? = null,

) : BaseEntity()
