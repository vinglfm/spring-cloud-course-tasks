package com.apryshchepa.scloudtask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    @Bean
    public ProcessingTask processingTask() {
        return new ProcessingTask();
    }

    public class ProcessingTask implements CommandLineRunner {
        @Override
        public void run(String... params) throws Exception {
            if (params != null) {
                System.out.println("parameter length: " + params.length);
                if (params.length > 0) {
                    String stationId = params[1];
                    String licensePlate = params[2];
                    String timestamp = params[3];
                    System.out.println("Station ID is " + stationId + ", plate is " + licensePlate + ", timestamp is " + timestamp);
                }
            }
            System.out.println("Task completed.");
        }
    }
}


