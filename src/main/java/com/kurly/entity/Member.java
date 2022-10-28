package com.kurly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kurly.config.BaseEntity;
import com.kurly.constant.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
public class Member extends BaseEntity {
	
	@Id
	@Column(name = "user_number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String name;

    @Column(unique = true)
    private String userid;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;
	
    // DTO -> entity 맴버생성 메서드
    // createMember DTO랑 passwordEncoder 받아서 member 리턴
    
}
