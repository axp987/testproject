package com.spring.testproject.data.service.impl;

import com.spring.testproject.data.dto.MemberDTO;
import com.spring.testproject.data.service.RestTemplateService;
import org.hibernate.validator.constraints.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {
    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);


    @Override
    public String getSpringHub() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8989")
                .path("/api/server/Spring-hub")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code: {}", responseEntity.getStatusCode());
        LOGGER.info("body: {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8989")
                .path("/api/server/name")
                .queryParam("name", "Flature")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code: {}", responseEntity.getStatusCode());
        LOGGER.info("body: {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName2() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8989")
                .path("/api/server/path-variable/{name}")
                .encode()
                .build()
                .expand("Flature") // 복수의 값을 넣어야할 경우 , 를 추가하여 구분
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status Code: {}", responseEntity.getStatusCode());
        LOGGER.info("body: {}", responseEntity.getBody());

        return responseEntity.getBody();
    }
    
    @Override
    public ResponseEntity<MemberDTO> postDto() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8989")
                .path("/api/server/name")
                // 1st. uri로 보낸 @queryParam은 ServerBox 에서 @RequestParam으로 받을 수 있고,
                .queryParam("name", "Flature")
                .queryParam("email", "jjj@jjj.com")
                .queryParam("organization", "Spring Hub Studio")
                .encode()
                .build()
                .toUri();

        // 2st. MemberDTO 객체로 보낸 request 값은 ServerBox 에서 @RequestBody MemberDTO로 받을 수 있다.
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Leehochan");
        memberDTO.setEmail("aaa@aaa.com");
        memberDTO.setOrganization("Spring Lee Hochan!!");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);

        LOGGER.info("status code: {}", responseEntity.getStatusCode());
        LOGGER.info("body: {}", responseEntity.getBody());

        return responseEntity;
    }

    
    // 보안을 위해 어쎈트케이션? 방식으로 많이 사용
    @Override
    public ResponseEntity<MemberDTO> addHeader() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8989")
                .path("/api/server/add-header")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Leehochan");
        memberDTO.setEmail("aaa@aaa.com");
        memberDTO.setOrganization("Spring Lee Hochan!!");
        
        // HEADER 부분 ★★★ 중요한 부분
        RequestEntity<MemberDTO> requestEntity = RequestEntity
                .post(uri) // get, delete, phatch 등등
                // 1st. ServerBox 프로젝트에서는  .header("xxx", value) 를 @RequsetHeader 로 받는다.
                .header("Spring-header", "Spring Hub Studio")
                .body(memberDTO);

        // 2st. ServerBox 프로젝트에서는 @RequestBody로 받는다
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity, MemberDTO.class);

        LOGGER.info("status code: {}", responseEntity.getStatusCode());
        LOGGER.info("body: {}", responseEntity.getBody());
        
        
        // 
        return responseEntity;
    }
}
