package com.spring.testproject.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfiguration {
    // 일단 main 메소드가 있는 class에 @EnableJpaAuditing 어노테이션을 작성해도 되지만,
    // 나중에 @SpringBootTest 어노테이션(Test 폴더)에서 
    // Jpa 객체가 없는데도 Enable 되는 현상이 발생하여 테스트가 정상적으로 실행되지 않는 경우가 발생한다 
}
