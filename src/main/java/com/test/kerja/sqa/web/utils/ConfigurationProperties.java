package com.test.kerja.sqa.web.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	@Value("${FIRST_NAME}")
	private String FIRST_NAME;
	@Value("${LAST_NAME}")
	private String LAST_NAME;
	
	@Value("${EMAIL_USER}")
	private String EMAIL_USER;
	@Value("${PHONE_USER}")
	private String PHONE_USER;
	@Value("${ADDRES_USER}")
	private String ADDRES_USER;
	@Value("${PASSWORD_USER}")
	private String PASSWORD_USER;
	@Value("${SUCCES}")
	private String SUCCES;
	@Value("${Error}")
	private String Error;
	
	
}
