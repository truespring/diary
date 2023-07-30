package com.rubok.diary.board.adapter.incoming

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@RequestMapping("/api/v1/board")
annotation class BoardV1Controller