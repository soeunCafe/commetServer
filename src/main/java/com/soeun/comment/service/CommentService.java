package com.soeun.comment.service;

import com.soeun.comment.model.CommentDto;
import com.soeun.comment.repository.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;


    // 댓글 삭제
    public void deleteComment(Integer Id) {
        commentMapper.deleteById(Id);
    }

    // 댓글 추가
    public CommentDto saveComment(CommentDto commentDto) {
        return commentMapper.save(commentDto);
    }

    // 댓글 수정
    @Transactional
    public CommentDto updateComment(Integer Id, CommentDto commentDto) {
        CommentDto commentData = commentMapper.findById(Id).orElseThrow(IllegalArgumentException::new);
        commentData.update(commentDto.getComment());
        return commentData;
    }
    // 특정 댓글 조회

    public CommentDto getComment(Integer cafeid, Integer categoryid, Integer boardid, Integer Id) {
        return (CommentDto) commentMapper.findByCafeidAndCategoryidAndBoardidAndId(cafeid,categoryid,boardid,Id).orElseThrow(IllegalArgumentException::new);
    }

    // 게시판 댓글 조회
    public List<CommentDto> getComment2(Integer cafeid, Integer categoryid, Integer boardid) {
        return (List<CommentDto>) commentMapper.findByCafeidAndCategoryidAndBoardid(cafeid,categoryid,boardid);
        //.orElseThrow(IllegalArgumentException::new);
    }

    //    전체 댓글 조회
//    public List<CommentDto> selectBoard() {
//        return commentMapper.findAll();
//    }


    // 게시물 조회
//    public CommentDto getBoard(Integer cafeid, Integer categoryid) {
//        return (CommentDto) commentMapper.findByCafeidAndCategoryid(cafeid,categoryid).orElseThrow(IllegalArgumentException::new);
//    }
//
//    public CommentDto getBoard2(Integer cafeid, Integer categoryid, Integer Id) {
//        return (CommentDto) commentMapper.findByCafeidAndCategoryidAndId(cafeid,categoryid,Id).orElseThrow(IllegalArgumentException::new);
//    }


}
