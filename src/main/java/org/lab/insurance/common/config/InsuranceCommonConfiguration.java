package org.lab.insurance.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories("org.lab.insurance.common.repository")
@ComponentScan("org.lab.insurance.common")
public class InsuranceCommonConfiguration {

}
