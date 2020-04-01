package com.voucher.demo.voucherService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voucher.demo.voucherService.model.VoucherModel;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherModel, Integer>{

}
