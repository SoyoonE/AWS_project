package com.awsService.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}

// @MappedSuperClass
// JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 함.

// @EntityListeners(AuditingEntityListener.class)
// BaseTimeEntity클래스에 Auditing 기능 포함시킴.

// @CreateDate
// Entity가 생성되어 저장될 때 시간이 자동 저장됨.

// @LastModifiedDate
// 조회한 Entity 값을 변경할 때 시간이 자동 저장됨.