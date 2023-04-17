package com.example.sssss.controller;

import com.example.sssss.entity.Study_record;
import com.example.sssss.service.StudyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudyRecordController {

    @Autowired
    private StudyRecordService studyRecordService;
    @GetMapping("/study/list")
    public String studyList(Model model) {

        List<Study_record> list = studyRecordService.doSelectAll();
        model.addAttribute("list" , list);
        return "study/study_list";
    }

    @GetMapping("/study/insert")
    public String insertStudy() {

        return "study/study_insert";
    }
}
