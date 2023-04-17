package com.example.sssss.study.controller;

import com.example.sssss.common.JSONResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
@Controller
public class SsController {

    @GetMapping("/")
    public String home() {
        log.info("SsController home called...................................");
        return "redirect:/user/home";
    }

    @GetMapping("/user/home")
    public String realHome() {
        log.info("SsController realHome called...................................");

        return "user/home";
    }


// www.daleseo.com/js-window-fetch/
    // @RequestBody 객체 로 받는 방법
//    @PostMapping("/user/save")
//    @ResponseBody
//    public JSONResponse<?> userSave(@RequestBody UserInfo userInfo) {
//        System.out.println("이름 ; " + userInfo.name);
//        System.out.println("이메일 ; " + userInfo.email);
//        return new JSONResponse<>(200, "SUCCESS", null);
//    }

    // HttpServletRequest 로 받는 방법
//    @PostMapping("/user/save")
//    @ResponseBody
//    public JSONResponse<?> userSave2(HttpServletRequest request) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//        JSONObject jsonObject = new JSONObject(sb.toString());
//        String email = jsonObject.getString("email");
//        String name = jsonObject.getString("name");
//
//        System.out.println("email : " + email);
//        System.out.println("name : " + name);
//        return new JSONResponse<>(200, "SUCCESS", null);
//    }

//    @PostMapping("/user/save")
//    @ResponseBody
//    public JSONResponse<?> userSave(@RequestParam(required = false) String name, @RequestParam(required = false) String email) {
//        System.out.println("이름 ; " + name);
//        System.out.println("이메일 ; " + email);
//        return new JSONResponse<>(200, "SUCCESS", null);
//    }


@Data
static class UserInfo {
    private String name;
    private String email;
}

}

// @PathVariable
// @RequestParm
// @RequestBody