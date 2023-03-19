package com.rubok.diary.user.service

import com.rubok.diary.role.RoleRepository
import com.rubok.diary.user.domain.SecurityUser
import com.rubok.diary.user.repository.DiaryUserRepository
import lombok.RequiredArgsConstructor
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserService(private val diaryUserRepository: DiaryUserRepository, private val roleRepository: RoleRepository): UserDetailsService {
    private val FAILURE = "해당 작업을 수행하지 못했습니다."
    private val SUCCESS = "해당 작업이 완료되었습니다."

    override fun loadUserByUsername(username: String?): UserDetails {
        val diaryUser = username?.let { diaryUserRepository.findDiaryUserByUsername(it) }
            ?: throw UsernameNotFoundException("User not found with username: $username")
        val userRole = diaryUser.id?.let { roleRepository.findRoleByUserId(it) }
        return SecurityUser(diaryUser.id!!, userRole?.role.toString(), "Y")
    }
}