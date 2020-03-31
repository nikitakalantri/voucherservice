package com.voucher.service.voucher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Voucher")
public class Voucher {
	@Id
	@GeneratedValue
	private int voucherNumber;
	@Column(name = "voucherType")
	private String voucherType;
	@Column(name = "voucherAmount")
	private String voucherAmount;
	@Column(name = "requestedQuantity")
	private String requestedQuantity;

	public Voucher() {
		super();
	}

	public Voucher(int voucherNumber, String voucherType, String voucherAmount, String requestedQuantity) {
		super();
		this.voucherNumber = voucherNumber;
		this.voucherType = voucherType;
		this.voucherAmount = voucherAmount;
		this.requestedQuantity = requestedQuantity;
	}

	public int getVoucherNumber() {
		return voucherNumber;
	}

	public void setVoucherNumber(int voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	public String getVoucherType() {
		return voucherType;
	}

	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

	public String getVoucherAmount() {
		return voucherAmount;
	}

	public void setVoucherAmount(String voucherAmount) {
		this.voucherAmount = voucherAmount;
	}

	public String getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(String requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	@Override
	public String toString() {
		return "Voucher [voucherNumber=" + voucherNumber + ", voucherType=" + voucherType + ", voucherAmount="
				+ voucherAmount + ", requestedQuantity=" + requestedQuantity + "]";
	}


}
