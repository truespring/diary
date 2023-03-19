package com.rubok.diary.role.enums

enum class UserRole(private val roleName: String) {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    override fun toString(): String {
        return roleName
    }
}