package com.rubok.diary.role.enums

import org.springframework.security.core.GrantedAuthority

enum class UserRole(private val roleName: String, private val level: Int, private val description: String): GrantedAuthority {
    ROLE_USER("USER", 1, "일반 사용자"),
    ROLE_ADMIN("ADMIN", 2, "관리자");

    override fun getAuthority(): String {
        return roleName
    }

    fun getRoleName(): String {
        return roleName
    }
}