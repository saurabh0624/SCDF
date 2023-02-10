package com.tutorial.SCDFTask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;

@SpringBootApplication
@EnableTask
public class ScdfTaskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScdfTaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello");
	}

	@BeforeTask
	public void onTaskStartup(TaskExecution taskExecution) {
		System.out.println("In task startup");
	}

	@AfterTask
	public void onTaskEnd(TaskExecution taskExecution) {
		System.out.println("In task end");
	}

	@FailedTask
	public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
		System.out.println("In task failed");
	}
}
/*
Spring Task creates 5 tables
	task_execution
	task_execution_params
	task_lock
	task_seq
	task_task_batch
 */