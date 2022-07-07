package com.soeun.comment.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Component
//@Table: DB 테이블명 쓰기
@Table(name="comment")
public class CommentDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;           // 댓글 id

    private Integer categoryid;   // 카테고리 id
    private Integer cafeid;       // 카페 id
    private Integer boardid;      // 게시판 id
    private Integer userid;      // 사용자 id
    private String comment;      // 댓글 내용
    private String username;     // 사용자 이름
    private String userimg;      // 사용자 이미지

    public void update(String comment) {
        this.comment = comment;
    }
 
}
