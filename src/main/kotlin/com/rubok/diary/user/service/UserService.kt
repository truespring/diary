package com.rubok.diary.user.service

import lombok.RequiredArgsConstructor
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserService: UserDetailsService {
    private val FAILURE = "해당 작업을 수행하지 못했습니다."
    private val SUCCESS = "해당 작업이 완료되었습니다."

    override fun loadUserByUsername(username: String?): UserDetails {
        TODO("Not yet implemented")
    }
}