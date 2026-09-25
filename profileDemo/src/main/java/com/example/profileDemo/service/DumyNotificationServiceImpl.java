package com.example.profileDemo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service 
@Profile({"default", "dev", "staging"})
public class DumyNotificationServiceImpl implements NotificationService {

	@Override
	public String send() {
		return "Dummy notification";
	}

}
