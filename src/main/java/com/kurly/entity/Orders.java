package com.kurly.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.kurly.config.BaseEntity;
import com.kurly.constant.OrderStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
public class Orders extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orders_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_number")
	private Member member;
	
	private LocalDateTime orderDate;	// 주문일
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;	// 주문상태
	
	// 양방향 연관 매핑 주인 설정(OrderProduct가 주인)
	// 영속성 전이(cascade) - Order가 삭제되면 OrderProduct도 함께 삭제됨
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderProduct> orderProducts = new ArrayList<>();
	
	// 주문 상품 추가
	public void addOrderProduct(OrderProduct orderProduct) {
		orderProducts.add(orderProduct);
		orderProduct.setOrders(this);	// Orders를 orderProduct에 세팅
	}
	
	// 주문 추가
	public static Orders createOrder(Member member, List<OrderProduct> orderProductList) {
		Orders order = new Orders();
		order.setMember(member);
		
		for(OrderProduct orderProduct : orderProductList) {
			order.addOrderProduct(orderProduct);
		}
		
		order.setOrderStatus(OrderStatus.ORDER);
		order.setOrderDate(LocalDateTime.now());
		return order;
	}
	
	
	// 총 주문 금액 계산
	public int getTotalPrice() {
		int totalPrice = 0;
		for(OrderProduct orderProduct : orderProducts) {
			totalPrice += orderProduct.getTotalPrice();
		}
		return totalPrice;
	}
	
	// 주문 상태를 취소 상태로 바꿈
	public void cancelOrder() {
		this.orderStatus = OrderStatus.CANCEL;
		for(OrderProduct orderProduct : orderProducts) {
			orderProduct.cancel();
		}
	}
	
}
