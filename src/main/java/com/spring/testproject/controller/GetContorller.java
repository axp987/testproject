package com.spring.testproject.controller;

import com.spring.testproject.data.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetContorller {

    //@RequestMapping(value="/hello.do", method= RequestMethod.GET)
    // http://localhost:8989/api/v1/get-api/hello.do
    @GetMapping("/hello.do")
    public String hello() {
        return "helloWorld";
    }

    // http://localhost:8989/api/v1/get-api/helloPost.do
    @RequestMapping(value = "/helloPost.do", method = RequestMethod.POST)
    public String helloPost() {
        return "Hello Request POST";
    }

    // http://localhost:8989/api/v1/get-api/helloPathVariable1.do/{String 값}
    @GetMapping(value="/helloPathVariable1.do/{variable}&{variableTest}")
    public String getVariable1(@PathVariable String variable, @PathVariable String variableTest) {
        return variable + " " + variableTest;
    }

    // http://localhost:8989/api/v1/get-api/helloPathVariable2.do/{String 값}
    @GetMapping(value= "/helloPathVariable2.do/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // http://localhost:8989/api/v1/get-api/helloMap?key1=value&key2=value2
    @GetMapping(value="/helloMap")
    public String getMapValue(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        String []arr = new String[param.size()];

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " " + map.getValue() + "\n");
        });

        /*
        param.forEach((key, value -> sb.append(key).append(" : ").append(value).append("\n"));
         */

        return sb.toString();
    }

    // http://localhost:8989/api/v1/get-api/helloMember.do?name=lee&email=lee@gmail.com&organization=gmail
    @GetMapping(value= "/helloMember.do")
    public String getRequestParam(MemberDTO memberDTO) {
        return memberDTO.toString();
    }

}
