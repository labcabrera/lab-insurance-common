package org.lab.insurance.common.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class CalendarService {

	public LocalDateTime getNextLaboralDay(LocalDateTime date, int days, String calendarId) {
		LocalDateTime tmp = LocalDateTime.from(date);
		// Note: in the case of previous dates we want to have an offset
		int check = days < 0 ? Math.abs(days) - 1 : days;
		int count = 0;
		int increment = days < 0 ? -1 : 1;
		do {
			if (!isLaboralDay(tmp, calendarId)) {
				tmp = tmp.plusDays(increment);
				continue;
			}
			tmp = tmp.plusDays(increment);
			count++;
		}
		while (count < check);
		return tmp;
	}

	public boolean isLaboralDay(LocalDateTime date, String calendarId) {
		// TODO check holiday
		switch (date.getDayOfWeek()) {
		case SATURDAY:
		case SUNDAY:
			return false;
		default:
			return true;
		}
	}
}
