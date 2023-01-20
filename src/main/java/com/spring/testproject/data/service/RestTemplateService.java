package com.spring.testproject.data.service;

import com.spring.testproject.data.dto.MemberDTO;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Member;

public interface RestTemplateService {
    public String getSpringHub();

    public String getName();

    public String getName2();

    public ResponseEntity<MemberDTO> postDto();

    public ResponseEntity<MemberDTO> addHeader();
}
