package com.rubok.diary.user.component

import com.rubok.diary.user.domain.SecurityUser
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationProvider : AuthenticationProvider {
    override fun authenticate(authentication: Authentication?): Authentication {
        if (SecurityContextHolder.getContext() != null) {
            val result =
                UsernamePasswordAuthenticationToken(SecurityUser.getLoginUserInfo(), null, authentication!!.authorities)
            result.details = authentication.details
            return result
        }
        return authentication!!
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication!!)
    }
}