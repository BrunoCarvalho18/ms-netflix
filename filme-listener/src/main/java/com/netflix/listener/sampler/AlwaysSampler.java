package com.netflix.listener.sampler;

import org.springframework.context.annotation.Bean;

public class AlwaysSampler {

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

}
