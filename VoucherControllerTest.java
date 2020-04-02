package com.voucher.demo.voucherService.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.voucher.demo.voucherService.model.VoucherModel;
import com.voucher.demo.voucherService.repository.VoucherRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class VoucherControllerTest {
	
	@MockBean
	VoucherRepository repository;

	
	@Test
    public void testCreateVoucher() 
    {
		VoucherModel voucherModel = new VoucherModel();
		voucherModel.setVoucherNumber(5003);
		voucherModel.setVoucherType("Personal");
		voucherModel.setVoucherAmount("6000");
		voucherModel.setRequestedQuantity("50");
		repository.save(voucherModel);
		Assert.assertNotNull(voucherModel.getVoucherNumber());
    }

}
