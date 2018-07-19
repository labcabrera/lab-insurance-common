package org.lab.insurance.common;

import org.lab.insurance.common.bootstrap.InsuranceCommonPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class InsuranceCommonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceCommonApplication.class, args);
	}

	@Autowired
	private InsuranceCommonPopulator populator;

	@Override
	public void run(String... args) throws Exception {
		if (!populator.isInitialized()) {
			populator.initialize();
		}
	}
}
