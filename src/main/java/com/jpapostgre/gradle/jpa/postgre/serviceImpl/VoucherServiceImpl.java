package com.jpapostgre.gradle.jpa.postgre.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpapostgre.gradle.jpa.postgre.model.VoucherModel;
import com.jpapostgre.gradle.jpa.postgre.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService{
	
	@Autowired
	com.jpapostgre.gradle.jpa.postgre.repository.VoucherRepository VoucherRepository;

	@Override
	public VoucherModel save(VoucherModel voucher) {
		return this.VoucherRepository.save(voucher);
	}

	@Override
	public List<VoucherModel> findAll() {
		return this.VoucherRepository.findAll();
	}

	@Override
	public Optional<VoucherModel> findById(int voucherNumber) {
		return this.VoucherRepository.findById(voucherNumber);
	}

}
