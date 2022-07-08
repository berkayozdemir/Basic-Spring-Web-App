package com.example.basic.proxy;


import com.example.basic.config.ProjectConfiguration;
import com.example.basic.model.Diary;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="diaryProxy", url = "http://localhost:8081/api/diary/getDiaries",configuration = ProjectConfiguration.class)
public interface DiaryProxy {
    @RequestMapping(value = "/getDiaries",method = RequestMethod.GET)
    @Headers(value = "Content-Type: application/json")
    public List<Diary> getMessages();
}
