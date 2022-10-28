package com.kurly.config;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter
public abstract class BaseEntity extends BaseTimeEntity {
	// 생성자와 수정자는 필요하지 않은 경우도 있기에 상속구조를 통해 분리해둔다.

	@CreatedBy
	@Column(updatable = false)
	private String createdBy;	// 생성자
	
	@LastModifiedBy
	private String modifiedBy;	// 수정자
}
