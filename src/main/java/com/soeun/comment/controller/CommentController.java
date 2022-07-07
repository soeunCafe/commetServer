package com.soeun.comment.controller;

import com.soeun.comment.config.SecurityService;
import com.soeun.comment.model.CommentDto;
import com.soeun.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    SecurityService securityService;

    @Autowired
    CommentDto commentDto;

    // 댓글 삭제
    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable Integer Id) {
        commentService.deleteComment(Id);
    }

    // 댓글 추가
    @PostMapping
    public CommentDto saveCategory(@RequestBody CommentDto commentDto) {
        return commentService.saveComment(commentDto);
    }

    // 댓글 수정
    @PutMapping("/{Id}")
    public CommentDto updateComment(@PathVariable Integer Id, @RequestBody CommentDto commentDto) {
        return commentService.updateComment(Id, commentDto);
    }

    // 특정 댓글 조회
    @GetMapping("/{cafeid}/{categoryid}/{boardid}/{Id}")
    public CommentDto getComment(@PathVariable Integer cafeid, @PathVariable Integer categoryid, @PathVariable Integer boardid, @PathVariable Integer Id){
        commentDto.setUserid(securityService.getIdAtToken());
        return commentService.getComment(cafeid,categoryid,boardid,Id);
    }

    // 게시판 댓글 조회
    @GetMapping("/{cafeid}/{categoryid}/{boardid}")
    public List<CommentDto> getComment2(@PathVariable Integer cafeid, @PathVariable Integer categoryid, @PathVariable Integer boardid){
        commentDto.setUserid(securityService.getIdAtToken());
        return commentService.getComment2(cafeid,categoryid,boardid);
    }


    //    전체 댓글 조회
//    @GetMapping
//    public List<CommentDto> selectCategory() {
//
//        return commentService.selectBoard();
//    }

    // 게시판 조회
//    @GetMapping("/{cafeid}/{categoryid}")
//    public CommentDto getBoard(@PathVariable Integer cafeid, @PathVariable Integer categoryid) {
//        // 토큰에서 아이디 가져오기
//        commentDto.setUserid(securityService.getIdAtToken());
//        //boardrDto.setUsername(securityService.getIdAtToken());
//        //boardrDto.setUserimg(securityService.getIdAtToken());
//        return commentService.getBoard(cafeid,categoryid);
//    }

    // 게시물 조회
//    @GetMapping("/{cafeid}/{categoryid}/{Id}")
//    public CommentDto getBoard2(@PathVariable Integer cafeid, @PathVariable Integer categoryid, @PathVariable Integer Id){
//        commentDto.setUserid(securityService.getIdAtToken());
//        return commentService.getBoard2(cafeid,categoryid,Id);
//    }

}
