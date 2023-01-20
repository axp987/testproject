package com.spring.testproject.controller;

import com.spring.testproject.data.dto.MemberDTO;
import com.spring.testproject.data.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/rest-template")
public class RestTemplateController {
    RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping(value = "/around-hub")
    public String getAroundHub() {
        return restTemplateService.getSpringHub();
    }

    @GetMapping(value = "/name")
    public String getName() {
        return restTemplateService.getName();
    }

//    @GetMapping(value = "/name2")
//    public String getName2() {
//        return restTemplateService.getName2();
//    }

    @PostMapping(value = "/dto")
    public ResponseEntity<MemberDTO> postDto() {
        return restTemplateService.postDto();
    }

    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDTO> addHeader() {
        return restTemplateService.addHeader();
    }
}

