package com.test.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="property-file")
public class PropertyAccessBean {

	private String name;
	private String description;

}
