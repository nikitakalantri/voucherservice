package com.voucher.service.voucher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.voucher.service.voucher.model.Voucher;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/")
public class VoucherController {

	@ApiOperation(value = "Create new voucher")
	@RequestMapping(value = "createVoucher", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public String createVoucher(@RequestBody Voucher voucher) {
		return "DOne";

	}

	@ApiOperation(value = "Fetch voucher")
	@RequestMapping(value = "fetchVoucher", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public ResponseEntity<?> fetchVoucher() {
		return null;

	}

	@ApiOperation(value = "Fetch voucher by id")
	@RequestMapping(value = "fetchVoucher/{voucherNumber}", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public ResponseEntity<?> fetchVoucherById(@PathVariable("voucherNumber") long voucherNumber) {
		return null;

	}
}
