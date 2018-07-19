package org.lab.insurance.common.controller;

import java.time.LocalDateTime;

import org.lab.insurance.common.services.TimestampProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/timestamp")
public class TimestampController {

	@Autowired
	private TimestampProvider timestampProvider;

	@GetMapping("/local-date")
	public LocalDateTime getCurrentDate() {
		return timestampProvider.getCurrentDate();
	}

	@GetMapping("/local-date-time")
	public LocalDateTime getCurrentDateTime() {
		return timestampProvider.getCurrentDateTime();
	}

}
