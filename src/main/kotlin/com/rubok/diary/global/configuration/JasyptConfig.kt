package com.rubok.diary.global.configuration

import org.jasypt.encryption.StringEncryptor
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JasyptConfig {

    var password: String = ""

    @Value("\${jasypt.encryptor.password}")
    fun run(key: String) {
        password = key
    }

    @Value("\${jasypt.encryptor.algorithm}")
    var algorithm: String = ""

    @Bean("jasyptStringEncryptor")
    fun stringEncryptor(): StringEncryptor {
        val encryptor = PooledPBEStringEncryptor()
        val config = SimpleStringPBEConfig()
        config.password = password // 암호화할 때 사용하는 키
        config.algorithm = algorithm // 암호화 알고리즘
        config.setKeyObtentionIterations("1000") // 반복할 해싱 회수
        config.setPoolSize("1") // 인스턴스 pool
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator") // salt 생성 클래스
        config.stringOutputType = "base64" //인코딩 방식
        encryptor.setConfig(config)
        return encryptor
    }
}