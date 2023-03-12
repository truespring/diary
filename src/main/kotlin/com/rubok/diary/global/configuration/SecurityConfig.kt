package com.rubok.diary.global.configuration

import lombok.AllArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableMethodSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests()
                .requestMatchers("/").hasAuthority("")
            .and()
//            .addFilterBefore()
//            .addFilterAfter()
        return http.build()
    }
}