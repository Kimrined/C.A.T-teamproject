package com.CAT.board;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

public interface WebMvcConfigurer {

	void addCorsMappings(CorsRegistry refistry);

}
