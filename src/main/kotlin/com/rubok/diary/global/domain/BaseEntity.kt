package com.rubok.diary.global.domain

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }
}