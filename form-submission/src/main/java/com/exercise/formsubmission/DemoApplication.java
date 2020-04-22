package com.exercise.formsubmission;

import java.io.IOException;

import com.exercise.formsubmission.service.DBManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		final DBManager dbm = new DBManager();

		new Thread(() -> {
			dbm.start();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				//Do nothing
			}

			SpringApplication.run(DemoApplication.class, args)
			.addApplicationListener(e -> {
				
					// try {
					// 	dbm.close();
					// } catch (IOException e1) {
					// 	//Do nothing
					// }
			});

		}).start();


	}

}
