package com.jpapostgre.gradle.jpa.postgre.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpapostgre.gradle.jpa.postgre.model.VoucherModel;
import com.jpapostgre.gradle.jpa.postgre.service.VoucherService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class VoucherController {

	@Autowired
	private VoucherService voucherService;

	@ApiOperation(value = "Create new voucher")
	@RequestMapping(value = "/createVoucher", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public VoucherModel createVoucher(@RequestBody VoucherModel voucher) {
		return this.voucherService.save(voucher);
	}

	@ApiOperation(value = "Fetch voucher")
	@RequestMapping(value = "/fetchVoucher", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public java.util.List<VoucherModel> fetchVoucher(
			 @RequestParam(defaultValue = "0") Integer pageNo, 
             @RequestParam(defaultValue = "10") Integer pageSize,
             @RequestParam(defaultValue = "id") String sortBy) {
		return this.voucherService.findAll(pageNo, pageSize, sortBy);

	}

	@ApiOperation(value = "Fetch voucher by id")
	@RequestMapping(value = "/fetchVoucher/{voucherNumber}", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public Optional<VoucherModel> fetchVoucherById(@PathVariable("voucherNumber") int voucherNumber) {
		return this.voucherService.findById(voucherNumber);
	}

}
