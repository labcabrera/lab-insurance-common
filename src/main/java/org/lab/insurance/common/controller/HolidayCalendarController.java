package org.lab.insurance.common.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.lab.insurance.common.exception.InsuranceCommonException;
import org.lab.insurance.common.model.HolidayCalendar;
import org.lab.insurance.common.repository.HolidayCalendarRepository;
import org.lab.insurance.common.services.HolidayCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		Optional<HolidayCalendar> optional = repository.findById(id);
		return optional.isPresent() ? ResponseEntity.ok(optional.get()) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/next-laboral")
	public LocalDate nextLaboralDay(@RequestBody NextLaboralDayRequest request) {
		LocalDate localDate = LocalDate.from(request.getFrom());
		HolidayCalendar calendar = repository.findById(request.getCalendarId()).orElseThrow(
			() -> new InsuranceCommonException("Invalid calendar identifier '" + request.getCalendarId() + "'"));
		return calendarService.getNextLaboralDay(localDate, request.getDays(), calendar);
	}

	@PostMapping("/check-laboral")
	public Boolean checkLaboralDay(@RequestBody CheckLaboralDayRequest request) {
		LocalDate localDate = LocalDate.from(request.getFrom());
		HolidayCalendar calendar = repository.findById(request.getCalendarId()).orElseThrow(
			() -> new InsuranceCommonException("Invalid calendar identifier '" + request.getCalendarId() + "'"));
		return calendarService.isLaboralDay(localDate, calendar);
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
