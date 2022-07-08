package com.example.basic.rest;

import com.example.basic.model.Diary;
import com.example.basic.model.Response;
import com.example.basic.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Controller
@RequestMapping("/api/diary")
public class    DiaryRestController {

    @Autowired
    DiaryRepository diaryRepository;

    @GetMapping("/getDiaries")
    @ResponseBody
    public List<Diary> getAllDiaries() {

        return diaryRepository.findAll();

    }
    @RequestMapping(value = "/saveResponse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<Response> saveMsgResponse(@RequestHeader("invocationFrom")String  invocationFrom,@Valid @RequestBody Diary diary) {
    diaryRepository.save(diary);
    Response response=new Response();
    response.setStatusMsg("its ok!");
    response.setStatusCode("200");

    return ResponseEntity.status(HttpStatus.CREATED).header("isMsgSaved","true").body(response);



    }



}
