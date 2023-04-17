package com.example.sssss.controller;

import com.example.sssss.entity.Study_record;
import com.example.sssss.service.StudyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
/**
*
* StudyRecordController의 설명을 여기에 작성한다
 * 공부 기록 작업
* @author SONG_DA_WOON
* @version 1.0.0
* 작성일 2023/04/18
**/
@Controller
public class StudyRecordController {


    @Autowired
    private StudyRecordService studyRecordService;

    // 리스트 조회
    @GetMapping("/study/list")
    public String studyList(Model model) {

        List<Study_record> list = studyRecordService.doSelectAll();
        model.addAttribute("list" , list);
        return "study/study_list";
    }

    // 등록 페이지 진입
    @GetMapping("/study/insert")
    public String insertStudy() {

        return "study/study_insert";
    }

    // 등록 버튼 클릭시 일어나는 곳
    @PostMapping("/study/insert_exe")
    public String doInsExe(@ModelAttribute Study_record studyRecord) {

//        studyRecord.setReg_day(LocalDateTime.now());
//        studyRecord.setMod_day(LocalDateTime.now());
        studyRecordService.doInsert(studyRecord);

        return "redirect:/study/list";
    }


    // *****************************************************************************************************************
    // 송다운 방법
//    @GetMapping("/study/modify/{id}")
//    public String modifyStudy(@PathVariable("id") Long id, Model model) {
//
//        Study_record studyRecord = studyRecordService.doSelectOne(id);
//
//        model.addAttribute("detail", studyRecord);
//        return "study/study_mod";
//    }
    // *****************************************************************************************************************


    @GetMapping("/study/modify")
    public String doMod(HttpServletRequest request, Model model) {
        String strKeyId = request.getParameter("key_id");

        Study_record studyRecord = studyRecordService.doSelectOne(Long.valueOf(strKeyId));

//        request.setAttribute("detail", studyRecord);

        model.addAttribute("detail", studyRecord);
        return "study/study_mod";
    }

    @PostMapping("/study/modify_exe")
    public String modifyStudyExe(@ModelAttribute Study_record studyRecord) {

//        studyRecord.setMod_day(LocalDateTime.now());
        studyRecordService.doUpdate(studyRecord);

        return "redirect:/study/list";
    }

    @GetMapping("/study/delete")
    public String deleteStudy(@RequestParam(value="key_id", defaultValue = "--") String strKeyId) {
        studyRecordService.doDelete(Long.valueOf(strKeyId));

        return "redirect:/study/list";
    }
}
