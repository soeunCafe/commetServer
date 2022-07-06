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
    private Integer titlecafeid;
    private Integer categoryid;
    private String title;
    private String img;
    private Integer isnotice;

    public void update(String title, String img, Integer isnotice) {
        this.title = title;
        this.img = img;
        this.isnotice = isnotice;
    }

}
