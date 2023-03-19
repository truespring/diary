package com.rubok.diary.user.domain

import lombok.Getter

@Getter
class UserType {
    private val userId: Int? = null
    private val role: String? = null
    private val useYn: String? = null

    fun toUser(userId: Int?, role: String?, useYn: String?): SecurityUser {
        return SecurityUser(userId!!, role!!, useYn!!)
    }
}