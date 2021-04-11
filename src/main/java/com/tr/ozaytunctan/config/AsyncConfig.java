package com.tr.ozaytunctan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(2);
		taskExecutor.setMaxPoolSize(2);
		taskExecutor.setQueueCapacity(200);
        taskExecutor.setThreadNamePrefix("userThread-");
        taskExecutor.initialize();   
        return taskExecutor;
	}

}
