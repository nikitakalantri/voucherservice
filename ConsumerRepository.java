package com.voucher.consumer.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voucher.consumer.service.model.ConsumerModel;

@Repository
public interface ConsumerRepository extends JpaRepository<ConsumerModel, Integer>{

}
