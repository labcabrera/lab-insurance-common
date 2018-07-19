package org.lab.insurance.common.bootstrap;

import org.lab.insurance.common.repository.HolidayCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InsuranceCommonPopulator {

	@Autowired
	private HolidayCalendarRepository calendarRepository;

	@Autowired
	private HolidayCalendarPopulator holidayCalendarPopulator;

	public boolean isInitialized() {
		return calendarRepository.count() > 0;
	}

	public void initialize() {
		log.debug("Populating bootstrap data");
		holidayCalendarPopulator.initialize();
	}

}
