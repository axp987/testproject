package com.spring.testproject.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@MappedSuperclass // Persist 자동으로 인식을 해야만 필드 변수를 ProductEntity에 포함 해줄수 있다
@EntityListeners(AuditingEntityListener.class) // import org.springframework.data.jpa.domain.support.AuditingEntityListener; >> Prepersist, PreUpdate
// AuditingEntityListener 클래스를 사용하겠다는 의미
// AuditingEntityListener.class << 로 인해서  @CreatedDate,  @LastModifiedDate 어노테이션들의 처리들을 진행할 수 있다
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false) // 개발자가 의미로 변경할 수 없게끔, 미리 속성을 지정 해준다
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;
}
