package com.example.mowitnow.configuration;

import com.example.mowitnow.TondeuseTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    @EnableBatchProcessing
    public class BatchConfig {
        @Bean
        public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, TondeuseTasklet tondeuseTasklet) {
            Step step = stepBuilderFactory.get("tondeuseStep")
                    .tasklet(tondeuseTasklet)
                    .build();

            return jobBuilderFactory.get("tondeuseJob")
                    .incrementer(new RunIdIncrementer())
                    .start(step)
                    .build();
        }
    }
