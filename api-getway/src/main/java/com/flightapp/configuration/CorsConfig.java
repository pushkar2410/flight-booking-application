package com.flightapp.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;



@Configuration
public class CorsConfig {
	@Bean
	public CorsWebFilter corsWebFilter() {

		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Content-Type", "Access-Control-Allow-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("token"));
		// corsConfiguration.addAllowedHeader("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);

		return new CorsWebFilter(source);
	}
}
