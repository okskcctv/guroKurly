package com.kurly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.kurly.config.BaseEntity;
import com.kurly.constant.ProSellStatus;
import com.kurly.exception.OutOfStockException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
public class Product extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_id")
	private Long id;		// 상품 코드
	
	@Column(nullable=false, length=50)
	private String productNm;	// 상품 이름
	
	@Column(name="price", nullable=false)
	private int price;		// 가격
	
	@Column(nullable=false)
	private int stock;		// 재고 수량
	
	@Lob
	@Column(nullable=false)
	private String detail;		// 상세설명
	
	@Enumerated(EnumType.STRING)
	private ProSellStatus ProSellStatus;	// 판매 상태
	
	@Column(nullable=false)
	private int soldQty;		// 판매량 - stock 과 같이 움직임 기본 0
	
	@Column(nullable=false)
	private int reviewCount;		// 리뷰수
	
	// 상품 수정 메서드
	// updateProduct DTO 받아서 변환
	
	
	// 재고 감소 메서드
	public void removeStrok(int stock) {
		int restStock = this.stock - stock;
		if(restStock < 0) {
			throw new OutOfStockException("상품의 재고가 부족합니다."
					+ "(현재 재고 수량: " + this.stock + ")");
		}
		this.stock = restStock;
		this.soldQty += stock;
	}
	
	// 재고 증가
	public void addStock(int stock) {
		this.stock += stock;
		this.soldQty -= stock;
	}
}
