package com.rubok.diary.global.configuration

import com.rubok.diary.user.handler.LoginFailureHandler
import com.rubok.diary.user.handler.LoginSuccessHandler
import com.rubok.diary.user.service.UserService
import lombok.AllArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableMethodSecurity
class SecurityConfig {

    private val userService: UserService? = null
//    private val userQueries: UserQueries? = null
    private val authenticationConfiguration: AuthenticationConfiguration? = null

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        return http
            .csrf { obj: CsrfConfigurer<HttpSecurity> -> obj.disable() }
            .httpBasic { obj: HttpBasicConfigurer<HttpSecurity> -> obj.disable() }
            .authorizeRequests() //                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                    .loginPage("/")
                    .loginProcessingUrl("/login/process")
                    .usernameParameter("loginId")
                    .passwordParameter("password")
                    .successHandler(LoginSuccessHandler())
                    .failureHandler(LoginFailureHandler())
            .and()
                .logout()
                    .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me").permitAll()
            .and()
                .sessionManagement()
                    .maximumSessions(1)
                    .maxSessionsPreventsLogin(false)
                    .expiredUrl("/login?error=true&exception=Have been attempted to login from a new place. or session expired")
            .and()
            .and()
                .rememberMe()
                .alwaysRemember(false)
                .tokenValiditySeconds(3600)
                .rememberMeParameter("remember-me")
            .and()
//            .addFilterBefore(restLoginProcessingFilter(), UsernamePasswordAuthenticationFilter::class.java)
//            .addFilterAfter(ajaxSessionCheckFilter(), ExceptionTranslationFilter::class.java)
            .build()
    }

    @Bean
    @Throws(java.lang.Exception::class)
    fun authenticationManagerBean(): AuthenticationManager? {
        return authenticationConfiguration?.authenticationManager
    }

    @Bean
    fun authenticationSuccessHandler(): AuthenticationSuccessHandler? {
        return LoginSuccessHandler()
    }

    @Bean
    fun authenticationFailureHandler(): AuthenticationFailureHandler? {
        return LoginFailureHandler()
    }
}