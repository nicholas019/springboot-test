package com.marustudy.testproject.controller;

import com.marustudy.testproject.dto.MemberDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "GET 메소드 TEST")
@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World!!!";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping("/name")
    public String getName(){
        return "Maru";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    // Path parameter 방법 1
    @GetMapping(value = "/variable1/{var}")
    public String getVariable1(@PathVariable String var){
        return var;
    }

    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    // Path parameter 방법 2
    @GetMapping(value = "/variable2/{var}")
    public String getVariable2(@PathVariable("var") String var){
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name={..}&email={..}&organization={..}
    // 쿼리스트링 1 : 쿼리스트링이 정해저있는경우
    @GetMapping("/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2&key3=value3&key4=value4....
    // 쿼리스트링2 : 쿼리스트링이 불규칙할경우
    @GetMapping("/request2")
    public String getRequestParam2(
            @RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map-> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name={..}&email={..}&organization={..}
    // 쿼리스트링 3 : 쿼리스트링이 들어오는 값이 정해저있고 특정 형식을 별도로 정의후에 이를 이용해 출력하는 경우
    @GetMapping("/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();

    }

}
