package com.soeun.board.controller;

import com.soeun.board.model.BoardDto;
import com.soeun.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {


    @Autowired
    private BoardService boardService;

    // 게시글 수정하기
    @PutMapping("/{Id}")
    public BoardDto updateCategory(@PathVariable Integer Id, @RequestBody BoardDto boardDto) {
        return boardService.updateBoard(Id, boardDto);
    }

}
