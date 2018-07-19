package org.lab.insurance.common.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Holiday {

	private LocalDate date;
	private String name;

}
