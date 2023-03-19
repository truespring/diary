package com.rubok.diary.user.domain

import com.rubok.diary.global.base.BaseEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "diary_user")
data class DiaryUser(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    val email: String,

    val firstName: String? = null,

    val lastName: String? = null,

    val fullName: String? = firstName + lastName,

    val age: Int? = null,

    val active: Boolean = false,

    val lastLogin: LocalDateTime? = null
) : BaseEntity()
