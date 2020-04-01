package com.voucher.demo.voucherService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.voucher.demo.voucherService.exception.ResourceNotFoundException;
import com.voucher.demo.voucherService.model.VoucherModel;
import com.voucher.demo.voucherService.repository.VoucherRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class VoucherController {
	
	@Autowired
	private VoucherRepository voucherRepository;
	
	@ApiOperation(value = "Create new voucher")
	@RequestMapping(value = "createVoucher", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public VoucherModel createVoucher(@RequestBody VoucherModel voucher) {
		return this.voucherRepository.save(voucher);
	}
	
	@ApiOperation(value = "Fetch voucher")
	@RequestMapping(value = "fetchVoucher", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public List<VoucherModel> fetchVoucher() {
		return this.voucherRepository.findAll();

	}

	@ApiOperation(value = "Fetch voucher by id")
	@RequestMapping(value = "fetchVoucher/{voucherNumber}", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public ResponseEntity<VoucherModel> fetchVoucherById(@PathVariable("voucherNumber") int voucherNumber) throws ResourceNotFoundException {
		VoucherModel voucher = voucherRepository.findById(voucherNumber).orElseThrow(()-> new ResourceNotFoundException("Not found"));
		return ResponseEntity.ok(voucher);

	}

}
