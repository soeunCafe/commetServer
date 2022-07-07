package com.soeun.comment.repository;

import com.soeun.comment.model.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface CommentMapper extends JpaRepository<CommentDto, Integer>{
    Optional<Object> findByCafeidAndCategoryidAndBoardidAndId(Integer cafeid, Integer categoryid, Integer boardid, Integer id);

    List<CommentDto> findByCafeidAndCategoryidAndBoardid(Integer cafeid, Integer categoryid, Integer boardid);
//>
//    Optional<Object> findByCafeidAndCategoryid(Integer cafeid, Integer categoryid);
//
//    Optional<Object> findByCafeidAndCategoryidAndId(Integer cafeid, Integer categoryid, Integer Id);
}
