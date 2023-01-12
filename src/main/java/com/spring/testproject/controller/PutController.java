package com.spring.testproject.controller;

import com.spring.testproject.data.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/vi/put-get")
public class PutController {

    @PutMapping(value = "/default")
    public String putMethod() {
        return "Put Hello World";
    }

    @PutMapping(value = "/member")
    public String putMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String putMember(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

    @PutMapping(value = "/member2")
    public MemberDTO putMemberDto2(@RequestBody MemberDTO memberDTO) {
        return memberDTO;
        // json 형식으로 반환(리턴) 됨
    }
    
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
        // json 형식으로 반환(리턴) 됨
        // 다른 메서드는 http 200코드 반환 되지만 HttpStatus.ACCEPTED(202)를 통해 반환 코드를 변경할 수 있다.

    }
}
