package com.rubok.diary.user.domain

import com.rubok.diary.user.controller.dto.response.UserLoginResponse
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import java.time.LocalDateTime

class SecurityUser : User {
    private var userId: Long? = null
    private var role: String? = null
    private var useYn: Boolean? = null
    private val createdAt: LocalDateTime? = null
    private val createdBy: String? = null

    constructor(username: String?, password: String?, authorities: MutableCollection<out GrantedAuthority>?) : super(username, password, authorities) {
        User(username, password, authorities)
    }

    constructor(userId: Long, role: String, useYn: Boolean) : this(null, null, null) {
        this.userId = userId
        this.role = role
        this.useYn = useYn
    }


    companion object {
    fun getLoginUserInfo(): UserLoginResponse {
        return SecurityContextHolder.getContext().authentication.principal as UserLoginResponse
    }
    }
}