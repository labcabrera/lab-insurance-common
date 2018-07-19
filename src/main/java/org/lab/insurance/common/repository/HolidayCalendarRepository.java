package org.lab.insurance.common.repository;

import org.lab.insurance.common.model.HolidayCalendar;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HolidayCalendarRepository extends MongoRepository<HolidayCalendar, String> {

}
