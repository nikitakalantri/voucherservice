package com.jpapostgre.gradle.jpa.postgre.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpapostgre.gradle.jpa.postgre.model.VoucherModel;
import com.jpapostgre.gradle.jpa.postgre.repository.VoucherRepository;
import com.jpapostgre.gradle.jpa.postgre.serviceImpl.VoucherServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VoucherControllerIntegrationTests {

	@LocalServerPort
	private int port;

	@MockBean
	VoucherRepository voucherRepository;

	@MockBean
	VoucherServiceImpl voucherServiceImpl;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private static final ObjectMapper om = new ObjectMapper();

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateVoucher() throws Exception {
		VoucherModel voucherModel = new VoucherModel(1, "Personal", "50", "5000");
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/v1/createVoucher", voucherModel, String.class);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	public void testFetchVoucher() throws Exception {
		List<VoucherModel> list = new ArrayList<VoucherModel>();
		VoucherModel voucherOne = new VoucherModel(50001, "corporate", "200000", "5000");
		VoucherModel voucherTwo = new VoucherModel(2, "Personal", "6000", "50000");
		VoucherModel voucherThree = new VoucherModel(3, "Corporate", "50000", "5000");
		VoucherModel voucherFour = new VoucherModel(4, "Corporate", "3000", "500");
		VoucherModel voucherFive = new VoucherModel(5, "Corporate", "4000", "1000");
		VoucherModel voucherSix = new VoucherModel(6, "Personal", "50000", "10");
		VoucherModel voucherSeven = new VoucherModel(7, "Corporate", "50000", "10");
		VoucherModel voucherEight = new VoucherModel(8, "Personal", "50000", "100");
		VoucherModel voucherNine = new VoucherModel(9, "Personal", "100000", "100");
		VoucherModel voucherTen = new VoucherModel(10, "Personal", "1000000", "100");
		VoucherModel voucherEleven = new VoucherModel(1, "Personal", "50", "5000");

		list.add(voucherOne);
		list.add(voucherTwo);
		list.add(voucherThree);
		list.add(voucherFour);
		list.add(voucherFive);
		list.add(voucherSix);
		list.add(voucherSeven);
		list.add(voucherEight);
		list.add(voucherNine);
		list.add(voucherTen);
		list.add(voucherEleven);

		Mockito.when(voucherServiceImpl.findAll()).thenReturn(list);
		String expected = om.writeValueAsString(list);
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/fetchVoucher",
				String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);
		Mockito.verify(voucherServiceImpl).findAll();
	}

	@Test
	public void testFetchVoucherById() throws JSONException {

		Optional<VoucherModel> voucherModel = Optional.of(new VoucherModel(1, "Personal", "50", "5000"));
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/v1/fetchVoucher/1", voucherModel, String.class);
		// Mockito.when(voucherRepository.findById(1)).thenReturn(voucherModel);
		Optional<VoucherModel> vou = voucherServiceImpl.findById(1);
		assertEquals("Personal", vou.get().getVoucherType());
		assertEquals("50", vou.get().getVoucherAmount());
		assertEquals("5000", vou.get().getRequestedQuantity());

		// JSONAssert.assertEquals(voucherModel, response.getBody(), false);

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
