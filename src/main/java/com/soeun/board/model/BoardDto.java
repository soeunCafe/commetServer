package com.soeun.board.model;

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
@Table(name="board")
public class BoardDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;          // 게시판 id
    private Integer cafeid;      // cafe id
    private Integer categoryid;  // 카테고리 id
    private String title;        // 제목
    private String img;          // 이미지
    private Integer isnotice;    // 공지 여부
    private Integer userid;      // 사용자 id
    private String username;     // 사용자 이름
    private String userimg;      // 사용자 프로필 사진
    private String content;      // 게시글 내용
}
