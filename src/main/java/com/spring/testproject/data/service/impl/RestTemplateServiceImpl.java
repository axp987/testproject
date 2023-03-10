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
                .expand("Flature") // ????????? ?????? ???????????? ?????? , ??? ???????????? ??????
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
                // 1st. uri??? ?????? @queryParam??? ServerBox ?????? @RequestParam?????? ?????? ??? ??????,
                .queryParam("name", "Flature")
                .queryParam("email", "jjj@jjj.com")
                .queryParam("organization", "Spring Hub Studio")
                .encode()
                .build()
                .toUri();

        // 2st. MemberDTO ????????? ?????? request ?????? ServerBox ?????? @RequestBody MemberDTO??? ?????? ??? ??????.
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

    
    // ????????? ?????? ??????????????????? ???????????? ?????? ??????
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
        
        // HEADER ?????? ????????? ????????? ??????
        RequestEntity<MemberDTO> requestEntity = RequestEntity
                .post(uri) // get, delete, phatch ??????
                // 1st. ServerBox ?????????????????????  .header("xxx", value) ??? @RequsetHeader ??? ?????????.
                .header("Spring-header", "Spring Hub Studio")
                .body(memberDTO);

        // 2st. ServerBox ????????????????????? @RequestBody??? ?????????
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity, MemberDTO.class);

        LOGGER.info("status code: {}", responseEntity.getStatusCode());
        LOGGER.info("body: {}", responseEntity.getBody());
        
        
        // 
        return responseEntity;
    }
}
