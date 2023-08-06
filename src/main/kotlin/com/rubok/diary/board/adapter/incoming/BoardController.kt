package com.rubok.diary.board.adapter.incoming

import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardSaveVO
import com.rubok.diary.board.adapter.outgoing.persistence.dto.BoardSelectVO
import com.rubok.diary.board.application.port.incoming.BoardCommendsUseCase
import com.rubok.diary.board.application.port.incoming.BoardQueriesUseCase
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*

@BoardV1Controller
class BoardController(
    private val boardQueriesUseCase: BoardQueriesUseCase,
    private val boardCommendsUseCase: BoardCommendsUseCase
) {
    @GetMapping("")
    @Operation(summary = "게시물 목록 조회", description = "게시물 목록을 조회합니다.")
    fun getBoardList(): List<BoardSelectVO> {
        return boardQueriesUseCase.getBoardList()
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시물 상세 조회", description = "게시물 상세를 조회합니다.")
    fun getBoardDetail(@PathVariable id: Long): BoardSelectVO {
        return boardQueriesUseCase.getBoardDetail(id)
    }

    @PostMapping("")
    @Operation(summary = "게시물 생성", description = "게시물을 생성합니다.")
    fun createBoard(@RequestBody board: BoardSaveVO): BoardSelectVO {
        return boardCommendsUseCase.createBoard(board)
    }

    @PatchMapping("")
    @Operation(summary = "게시물 수정", description = "게시물을 수정합니다.")
    fun updateBoard(@RequestBody board: BoardSaveVO): BoardSelectVO {
        return boardCommendsUseCase.updateBoard(board)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시물 삭제", description = "게시물을 삭제합니다.")
    fun deleteBoard(@PathVariable id: Long) {
        boardCommendsUseCase.deleteBoard(id)
    }
}