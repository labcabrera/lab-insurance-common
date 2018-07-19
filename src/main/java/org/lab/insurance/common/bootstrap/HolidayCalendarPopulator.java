package org.lab.insurance.common.bootstrap;

import java.io.InputStream;
import java.util.List;

import org.lab.insurance.common.exception.InsuranceCommonException;
import org.lab.insurance.common.model.HolidayCalendar;
import org.lab.insurance.common.repository.HolidayCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HolidayCalendarPopulator {

	@Autowired
	private HolidayCalendarRepository repository;

	@Autowired
	private ObjectMapper objectMapper;

	public void initialize() {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			try (InputStream in = classLoader.getResourceAsStream("bootstrap/holidays.js")) {
				long t0 = System.currentTimeMillis();
				List<HolidayCalendar> list = objectMapper.readValue(in, new TypeReference<List<HolidayCalendar>>() {
				});
				repository.insert(list);
				log.info("Inserted {} calendars in {}", list.size(), System.currentTimeMillis() - t0);
			}
		}
		catch (Exception ex) {
			throw new InsuranceCommonException("Calendar bootstrap error", ex);
		}
	}

}
