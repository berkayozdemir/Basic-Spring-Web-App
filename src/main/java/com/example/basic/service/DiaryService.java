package com.example.basic.service;

import com.example.basic.model.Diary;
import com.example.basic.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    public  void saveMessageInService(Diary diary) {
        System.out.println(diary.toString());
        int newdiary=diaryRepository.save(diary);
        System.out.println("succesfull!");

    }

    public List<Diary> findMessages() {
        List<Diary> diaryList=  diaryRepository.findAll();
        System.out.println("print size of diarylist:"+diaryList.size());

    return diaryList;
    }
}
