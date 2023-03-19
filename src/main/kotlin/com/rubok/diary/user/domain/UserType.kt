package com.rubok.diary.user.domain

import lombok.Getter

@Getter
class UserType {
    private val userId: Long? = null
    private val role: String? = null
    private val useYn: String? = null

    fun toUser(userId: Long?, role: String?, useYn: String?): SecurityUser {
        return SecurityUser(userId!!, role!!, useYn!!)
    }
}