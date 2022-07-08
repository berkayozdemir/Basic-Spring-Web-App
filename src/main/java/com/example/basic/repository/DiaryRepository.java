package com.example.basic.repository;

import com.example.basic.model.Diary;
import com.example.basic.rowmapper.DiaryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DiaryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DiaryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Diary diary) {
        String sql = "insert into diaries (diary_name,diary_writed_date,diary_content,created_at,created_by) values (?,?,?,?,?)";
        int a= jdbcTemplate.update(sql,diary.getDiary_name(),diary.getDiary_writed_date(),diary.getDiary_content(),LocalDateTime.now(),"anonim");

        System.out.println(a);
    return a;
    }


public List<Diary>findAll() {
    String sql = "select * from diaries";
    return jdbcTemplate.query(sql,new DiaryRowMapper());



}


}
