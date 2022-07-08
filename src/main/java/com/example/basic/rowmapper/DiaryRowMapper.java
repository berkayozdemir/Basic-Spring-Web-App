package com.example.basic.rowmapper;

import com.example.basic.model.Diary;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiaryRowMapper implements RowMapper<Diary> {
    @Override
    public Diary mapRow(ResultSet rs, int rowNum) throws SQLException {
        Diary diary=new Diary();
        diary.setDiaryId( rs.getInt("id"));
        diary.setDiary_name(rs.getString("diary_name"));
        diary.setDiary_writed_date(rs.getString("diary_writed_date"));
        diary.setDiary_content(rs.getString("diary_content"));
        diary.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        diary.setCreated_by(rs.getString("created_by"));
        if(null!=rs.getTimestamp("updated_at")){
            diary.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
        }

        diary.setUpdated_by(rs.getString("updated_by"));

        return diary;
    }
}
