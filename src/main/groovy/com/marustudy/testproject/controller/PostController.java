package com.marustudy.testproject.controller;

import com.marustudy.testproject.dto.MemberDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "POST 메소드 TEST")
@RestController
@RequestMapping("/api/v1/post-api")

public class PostController {

    @PostMapping("default")
    public String postMethod(){
        return "POST Hello World";
    }
    // http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map->{
            sb.append(map.getKey() + " " + map.getValue() + "\n");
        });
        return sb.toString();
    }
    // http://localhost:8080/api/v1/post-api/member2
    @PostMapping("member2")
    public String postMember2(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }
}
