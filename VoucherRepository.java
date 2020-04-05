package com.jpapostgre.gradle.jpa.postgre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpapostgre.gradle.jpa.postgre.model.VoucherModel;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherModel, Integer>{

}
