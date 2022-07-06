package com.soeun.board.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Getter
@Entity
// @NoArgsConstructor : 기본 생성자 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Table: DB 테이블명 쓰기
@Table(name="board")
public class BoardDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer cafeid;
    private Integer categoryid;
    private String title;  // 제목
    private String img;  // 이미지
    private Integer isnotice;  // 공지 여부
    private  String userid;
    private  String username;
    private String userimg;
    private  String content;


    public void update(String title, String img, Integer isnotice, String content) {
        this.title = title;
        this.img = img;
        this.isnotice = isnotice;
        this.content = content;
    }

}
