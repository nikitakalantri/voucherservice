package com.jpapostgre.gradle.jpa.postgre.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jpapostgre.gradle.jpa.postgre.model.VoucherModel;

@Repository
public interface VoucherRepository extends PagingAndSortingRepository<VoucherModel, Integer>{

}
