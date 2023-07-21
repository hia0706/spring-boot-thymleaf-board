package kr.co.jhta.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
    @MappedSuperClass

 */

// member, board, 등등 사용하기 위해서 만든 추상클래스
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDateTimeEntity {

    // 등록하면 현재 날짜가 들어감
    @CreatedDate
    private LocalDateTime createdDate;
    // 수정하면 현재 날짜가 들어감
    @LastModifiedDate
    private LocalDateTime updatedDate;

}
