package com.rubok.diary.board.adapter.outgoing.persistence.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "게시물 등록 VO")
class BoardSaveVO(
    @Schema(description = "게시물 번호")
    val idx: Long,
    @Schema(description = "게시물 제목")
    val title: String,
    @Schema(description = "게시물 내용")
    val contents: String,
    @Schema(description = "게시물 작성자")
    val author: String,
)