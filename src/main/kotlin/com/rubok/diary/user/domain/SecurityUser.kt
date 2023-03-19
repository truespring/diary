package com.rubok.diary.user.domain

import com.rubok.diary.user.controller.dto.response.UserLoginResponse
import lombok.Getter
import lombok.Setter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import java.time.LocalDateTime


@Getter
@Setter
class SecurityUser : User {
    private var userId: Long? = null
    private var role: String? = null
    private var useYn: String? = null
    private val createdAt: LocalDateTime? = null
    private val createdBy: String? = null

    constructor(username: String?, password: String?, authorities: MutableCollection<out GrantedAuthority>?) : super(username, password, authorities) {
        User(username, password, authorities)
    }

    constructor(userId: Long, role: String, useYn: String) : this(null, null, null) {
        this.userId = userId
        this.role = role
        this.useYn = useYn
    }

    fun getLoginUserInfo(): UserLoginResponse {
        return SecurityContextHolder.getContext().authentication.principal as UserLoginResponse
    }
}