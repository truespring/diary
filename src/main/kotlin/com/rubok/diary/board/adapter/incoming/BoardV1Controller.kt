package com.rubok.diary.board.adapter.incoming

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Tag(name = "게시판 API", description = "게시판 API Document 입니다.")
@RequestMapping("/api/v1/boards")
annotation class BoardV1Controller