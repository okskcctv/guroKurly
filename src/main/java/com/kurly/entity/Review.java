package com.kurly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kurly.config.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
public class Review extends BaseEntity {

	@Id
	@Column(name = "review_num")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String reviewContent;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_number")
	private Member member;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	private Product product;
}
