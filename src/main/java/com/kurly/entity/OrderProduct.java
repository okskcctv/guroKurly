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
public class OrderProduct extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orders_pro_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orders_id")
	private Orders orders;
	
	private int orderPrice;		// 주문가격
	
	private int count;		// 주문수량
	
	// OrderProduct 객체 생성
	// createOrderProduct product와 count를 받아서 orderProduct 반환
	public static OrderProduct createOrderProduct(Product product, int count) {
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setProduct(product);
		orderProduct.setCount(count);
		orderProduct.setOrderPrice(product.getPrice());
		
		product.removeStrok(count);
		return orderProduct;
	}
	
	// 주문 총 가격
	public int getTotalPrice() {
		return orderPrice * count;
	}
	
	// 주문 취소시 주문 수량 만큼 재고 추가
	public void cancel() {
		this.getProduct().addStock(count);
	}
}
