package ca.webvue.common.entity;

import org.apache.commons.lang.builder.CompareToBuilder;

public class OrderEntity extends BaseEntity implements Comparable<OrderEntity> {
	
	public static final String ORDER_PROPERTY_NAME = "order";

	/** 排序 */
	private Integer order;

	/**
	 * 获取排序
	 * 
	 * @return 排序
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * 设置排序
	 * 
	 * @param order
	 *            排序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * 实现compareTo方法
	 * 
	 * @param orderEntity
	 *            排序对象
	 * @return 比较结果
	 */
	public int compareTo(OrderEntity orderEntity) {
		return new CompareToBuilder().append(getOrder(), orderEntity.getOrder()).append(getId(), orderEntity.getId()).toComparison();
	}
}
