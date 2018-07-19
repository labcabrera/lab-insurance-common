package org.lab.insurance.common.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.lab.insurance.common.model.HolidayCalendar;
import org.lab.insurance.common.repository.HolidayCalendarRepository;
import org.lab.insurance.common.services.HolidayCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

@RequestMapping("/calendar")
@RestController
public class HolidayCalendarController {

	@Autowired
	private HolidayCalendarService calendarService;

	@Autowired
	private HolidayCalendarRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<HolidayCalendar> find(@PathVariable String id) {
		return ResponseEntity.ok(repository.findById(id).get());
	}

	@PostMapping("/next-laboral")
	public LocalDate nextLaboralDay(@RequestBody NextLaboralDayRequest request) {
		LocalDate localDate = LocalDate.from(request.getFrom());
		return calendarService.getNextLaboralDay(localDate, request.getDays(), request.getCalendarId());
	}

	@PostMapping("/check-laboral")
	public Boolean checkLaboralDay(@RequestBody CheckLaboralDayRequest request) {
		LocalDate localDate = LocalDate.from(request.getFrom());
		return calendarService.isLaboralDay(localDate, request.getCalendarId());
	}

	@Getter
	@Setter
	static class CheckLaboralDayRequest {
		private LocalDateTime from;
		private String calendarId;
	}

	@Getter
	@Setter
	static final class NextLaboralDayRequest extends CheckLaboralDayRequest {
		private Integer days;
	}
}
