package com.rubok.diary.role

import com.rubok.diary.role.domain.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    fun findRoleByUserId(userId: Long): Role?
}