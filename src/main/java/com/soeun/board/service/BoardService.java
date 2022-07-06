package com.soeun.board.service;


import com.soeun.board.model.BoardDto;
import com.soeun.board.repository.BoardMapper;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    // 게시글 수정
    @Transactional
    public BoardDto updateBoard(Integer Id, BoardDto boardDto) {
        BoardDto boardData = boardMapper.findById(Id).orElseThrow(IllegalArgumentException::new);
        boardData.update(boardDto.getTitle(),boardDto.getImg(), boardDto.getIsnotice(), boardDto.getContent());
        return boardData;
    }

    // 게시글 추가
    public BoardDto saveBoard(BoardDto boardDto) {
        return boardMapper.save(boardDto);
    }

    // 게시글 삭제
    public void deleteBoard(Integer Id) {
        boardMapper.deleteById(Id);
    }

}
