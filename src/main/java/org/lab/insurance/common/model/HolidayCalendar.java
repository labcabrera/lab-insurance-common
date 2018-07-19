package org.lab.insurance.common.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "labCommonCalendars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class HolidayCalendar {

	@Id
	private String id;

	private String name;

	private List<Holiday> dates;

	public HolidayCalendar(String id) {
		this.id = id;
	}

}
