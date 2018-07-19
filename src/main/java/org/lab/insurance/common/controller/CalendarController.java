package org.lab.insurance.common.controller;

import java.time.LocalDateTime;

import org.lab.insurance.common.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;
import lombok.Setter;

@RequestMapping("/calendar")
public class CalendarController {

	@Autowired
	private CalendarService calendarService;

	@PostMapping("/next")
	public LocalDateTime nextLaboralDay(@RequestBody NextLaboralDayRequest request) {
		return calendarService.getNextLaboralDay(request.getFrom(), request.getDays(), request.getCalendarId());
	}

	@Getter
	@Setter
	static final class NextLaboralDayRequest {
		private LocalDateTime from;
		private Integer days;
		private String calendarId;
	}

}
