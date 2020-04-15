package com.jpapostgre.gradle.jpa.postgre.service;

import java.util.List;
import java.util.Optional;

import com.jpapostgre.gradle.jpa.postgre.model.VoucherModel;

public interface VoucherService {

	VoucherModel save(VoucherModel voucher);

	List<VoucherModel> findAll(Integer pageNo, Integer pageSize, String sortBy);

	Optional<VoucherModel> findById(int voucherNumber);

}
