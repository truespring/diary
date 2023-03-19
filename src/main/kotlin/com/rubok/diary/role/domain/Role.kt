package com.rubok.diary.role.domain

import com.rubok.diary.global.base.BaseEntity
import com.rubok.diary.role.enums.UserRole
import com.rubok.diary.user.domain.DiaryUser
import javax.persistence.*

@Entity
@Table(name = "user_role")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Enumerated(EnumType.STRING)
    val role: UserRole,

    @OneToOne
    val user: DiaryUser
) : BaseEntity()