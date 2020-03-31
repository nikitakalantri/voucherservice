package com.voucher.service.voucher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class VoucherApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoucherApplication.class, args);
	}

}
