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

@Entity
@Getter @Setter
public class ProImg extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_img_id")
	private Long id;
	
	private String imgName;		// 이미지 파일명
	
	private String oriImgName;	// 원본 이미지 파일명
	
	private String imgUrl;		// 이미지 조회 경로
	
	private String repImgYn;		// 대표 이미지 여부
	
	// 상품 엔티티와 다대일 관계 설정
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	private Product product;
	
	// 이미지 정보를 변경하는 메서드
	public void updateProductImg(String oriImgName, String imgName, String imgUrl) {
		this.oriImgName = oriImgName;
		this.imgName = imgName;
		this.imgUrl = imgUrl;
	}
}
