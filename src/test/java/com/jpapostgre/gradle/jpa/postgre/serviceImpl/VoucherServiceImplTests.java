package com.jpapostgre.gradle.jpa.postgre.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpapostgre.gradle.jpa.postgre.model.VoucherModel;
import com.jpapostgre.gradle.jpa.postgre.repository.VoucherRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class VoucherServiceImplTests {

	@InjectMocks
	VoucherServiceImpl voucherServiceImpl;

	@Mock
	VoucherRepository voucherRepository;

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllTest() {
		List<VoucherModel> list = new ArrayList<VoucherModel>();
		VoucherModel voucherOne = new VoucherModel(1, "Personal", "50", "5000");
		VoucherModel voucherTwo = new VoucherModel(2, "Corporate", "1000", "5000");
		VoucherModel voucherThree = new VoucherModel(1, "Personal", "10000", "50000");
		VoucherModel voucherFour = new VoucherModel(4, "Corporate", "10000", "50000");
		list.add(voucherOne);
		list.add(voucherTwo);
		list.add(voucherThree);
		list.add(voucherFour);
		Mockito.when(voucherRepository.findAll()).thenReturn(list);
		List<VoucherModel> voucherList = voucherServiceImpl.findAll();
		assertEquals(4, voucherList.size());
		Mockito.verify(voucherRepository).findAll();
	}

	@Test
	public void findByIdTest() {
		Optional<VoucherModel> voucherModel =  Optional.of(new VoucherModel(1, "Personal", "50", "5000"));
		Mockito.when(voucherRepository.findById(1)).thenReturn(voucherModel);
		Optional<VoucherModel> vou = voucherServiceImpl.findById(1);
		assertEquals("Personal", vou.get().getVoucherType());
		assertEquals("50", vou.get().getVoucherAmount());
		assertEquals("5000", vou.get().getRequestedQuantity());
	}
	
	@Test
	public void saveTest() {
		VoucherModel voucherOne = new VoucherModel(1, "Personal", "50", "5000");
		voucherServiceImpl.save(voucherOne);
		Mockito.verify(voucherRepository).save(voucherOne);
	}
}
