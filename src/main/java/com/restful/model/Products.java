package com.restful.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name = "Products")
public class Products implements java.io.Serializable {

	private int productId;
	private String productName;
	private String unit;
	private BigDecimal price;
	private int supplierId;
	private int categoryId;
	private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

	public Products() {
	}

	public Products(int productId, String productName, String unit, BigDecimal price, int supplierId, int categoryId) {
		this.productId = productId;
		this.productName = productName;
		this.unit = unit;
		this.price = price;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
	}

	public Products(int productId, String productName, String unit, BigDecimal price, int supplierId, int categoryId,
			Set<OrderDetails> orderDetailses) {
		this.productId = productId;
		this.productName = productName;
		this.unit = unit;
		this.price = price;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.orderDetailses = orderDetailses;
	}

	@Id

	@Column(name = "ProductID", unique = true, nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "ProductName", nullable = false, length = 50)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "Unit", nullable = false, length = 50)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "Price", nullable = false, precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "SupplierID", nullable = false)
	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	@Column(name = "CategoryID", nullable = false)
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<OrderDetails> getOrderDetailses() {
		return this.orderDetailses;
	}

	public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
		this.orderDetailses = orderDetailses;
	}

}