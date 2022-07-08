package com.example.basic.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="diaries")
public class Diary  extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private int diaryId;

    @NotBlank(message="Name must not be blank")
    private String diary_name;

    @NotBlank(message="Name must not be blank")
    private String diary_writed_date;

    @NotBlank(message="Name must not be blank")
    @Size(min=5, message="Subject must be at least 5 characters long")
    private String diary_content;

    public int getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(int id) {
        this.diaryId = id;
    }

}
