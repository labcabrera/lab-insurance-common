package org.lab.insurance.common.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class HolidayCalendarService {

	public LocalDate getNextLaboralDay(LocalDate date, int days, String calendarId) {
		LocalDate tmp = LocalDate.from(date);

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

	public boolean isLaboralDay(LocalDate date, String calendarId) {
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
