package com.jpapostgre.gradle.jpa.postgre.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpapostgre.gradle.jpa.postgre.model.VoucherModel;
import com.jpapostgre.gradle.jpa.postgre.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService {

	@Autowired
	com.jpapostgre.gradle.jpa.postgre.repository.VoucherRepository VoucherRepository;

	@Override
	public VoucherModel save(VoucherModel voucher) {
		return this.VoucherRepository.save(voucher);
	}

	@Override
	public Optional<VoucherModel> findById(int voucherNumber) {
		return this.VoucherRepository.findById(voucherNumber);
	}

	@Override
	public List<VoucherModel> findAll(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<VoucherModel> pagedResult = VoucherRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<VoucherModel>();
		}
	}

}
