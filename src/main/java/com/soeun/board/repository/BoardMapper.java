package com.soeun.board.repository;

import com.soeun.board.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface BoardMapper extends JpaRepository<BoardDto, Integer> {
}
