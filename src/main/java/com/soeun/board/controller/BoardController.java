package com.soeun.board.controller;

import com.soeun.board.model.BoardDto;
import com.soeun.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")
public class BoardController {


    @Autowired
    private BoardService boardService;

    // 게시글 수정하기
    @PutMapping("/{Id}")
    public BoardDto updateBoard(@PathVariable Integer Id, @RequestBody BoardDto boardDto) {


        return boardService.updateBoard(Id, boardDto);
    }

    // 게시글 추가하기
    @PostMapping
    public BoardDto saveCategory(@RequestBody BoardDto boardDto) {
        return boardService.saveBoard(boardDto);
    }

    // 게시글 삭제하기
    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable Integer Id) {
        boardService.deleteBoard(Id);
    }
    @GetMapping
    public String fsffs(@PathVariable Integer Id) {
        return  "test";
    }
}
