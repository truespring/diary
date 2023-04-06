package com.rubok.diary.user.repository

import com.rubok.diary.user.domain.DiaryUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiaryUserRepository : JpaRepository<DiaryUser, Long> {
    fun findDiaryUserByEmail(email: String): DiaryUser?
    fun findDiaryUserByEmailAndPassword(email: String, password: String): DiaryUser?
}