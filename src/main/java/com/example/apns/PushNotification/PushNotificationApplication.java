package com.example.apns.PushNotification;

import com.example.apns.PushNotification.domain.InAppNotificationPriority;
import com.example.apns.PushNotification.domain.RemoteConfig;
import com.example.apns.PushNotification.repository.InAppNotificationPriorityRepository;
import com.example.apns.PushNotification.repository.RemoteConfigRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Push notification application.
 */
@EnableScheduling
@SpringBootApplication
public class PushNotificationApplication {


 /**
  * 
  * @param repository 
  * @param remoteConfigRepository 
  */
	@Bean
	public ApplicationRunner runner(InAppNotificationPriorityRepository repository, RemoteConfigRepository remoteConfigRepository) {
		return args -> {
			repository.deleteAll();
			repository.save(new InAppNotificationPriority("Generic", "VeryLow", 5));
			repository.save(new InAppNotificationPriority("Gallery", "Low", 10));
			repository.save(new InAppNotificationPriority("System", "High", 15));
			repository.save(new InAppNotificationPriority("Auth", "VeryHigh", 20));

			repository.findAll().forEach(System.out::println);

			Map<String, Object> customParams = new HashMap<>();

			customParams.put("STRING_TEXT", "Stella nobilis nomen est.");
			customParams.put("IMAGE", "Powerful places of dogma will safely know a pure power.");
			customParams.put("BUTTON_TITLE", "Get Started");

			remoteConfigRepository.deleteAll();

			remoteConfigRepository.save(new RemoteConfig(RemoteConfig.ConfigType.Interstetial,LocalDate.now(), LocalDate.now().plusDays(10), "active", "Generic", true , false, " ", customParams));
			remoteConfigRepository.save(new RemoteConfig(RemoteConfig.ConfigType.Interstetial,LocalDate.now(), LocalDate.now().plusDays(46), "active", "Payment", false ,false, " ", customParams));
			remoteConfigRepository.save(new RemoteConfig(RemoteConfig.ConfigType.Interstetial,LocalDate.now(), LocalDate.now().plusDays(46), "active", "Generic", false ,true, "customerId", customParams));

			remoteConfigRepository.findAll().forEach(System.out::println);
		};
	}

 /**
  * The entry point of application
  *
  * @param args the input arguments
  */
	public static void main(String[] args) {
		SpringApplication.run(PushNotificationApplication.class, args);
	}
}
