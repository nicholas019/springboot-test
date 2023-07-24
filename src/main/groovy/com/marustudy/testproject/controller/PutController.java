package com.marustudy.testproject.controller;


import com.marustudy.testproject.dto.MemberDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "PUT 메소드 TEST")
@RestController
@RequestMapping(value = "/api/v1/put-api")
public class PutController {
    // http://localhost:8080//api/v1/put-api/default
    @PutMapping(value = "/default")
    public String putMethod(){ return "Hello World";}

    // http://localhost:8080//api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // http://localhost:8080//api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDTO memberDTO){ return memberDTO.toString();}

    // http://localhost:8080//api/v1/put-api/member2
    // 클래스 자체를 리턴하면 json 형태로 리턴된다
    @PutMapping(value = "/member2")
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDTO){ return memberDTO;}

    // http://localhost:8080//api/v1/put-api/member3
    // http status값까지 같이 전달된다
    @PutMapping(value = "/member3")
    public ResponseEntity postMemberDto3(@RequestBody MemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }




}
