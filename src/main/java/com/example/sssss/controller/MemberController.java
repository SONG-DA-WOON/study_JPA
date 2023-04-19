package com.example.sssss.controller;

import com.example.sssss.entity.Study_member;
import com.example.sssss.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private StudyMemberService studyMemberService;

    @GetMapping("/member/list")
    public String memberSignUp(Model model) {
        List<Study_member> list = studyMemberService.doSelectAll();
        model.addAttribute("list", list);
        return "member/member_list";
    }

    // 입력
    @GetMapping("/member/insert")
    public String doIns() {
        return "member/member_join";
    }

    // 회원가입
    @PostMapping("/member/insert_exe")
    public String doInsertExe(@ModelAttribute Study_member studyMember) {

        studyMemberService.doInsert(studyMember);

        return "redirect:/member/list";
    }

    // 삭제
    @GetMapping("/member/delete")
    public String deleteMember(@RequestParam(value = "key_id", defaultValue = "--") String strMemberId) {
        studyMemberService.doDelete(Long.valueOf(strMemberId));

        return "redirect:/member/list";
    }
}
