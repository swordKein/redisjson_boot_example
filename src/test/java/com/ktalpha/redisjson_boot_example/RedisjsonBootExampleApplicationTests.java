package com.ktalpha.redisjson_boot_example;

import com.ktalpha.redisjson_boot_example.service.RedisTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisjsonBootExampleApplicationTests {
	@Autowired
	RedisTestService redisTestService;

	@Test
	void contextLoads() {
	}

	@Test
	void redisTest1() {
		try {
			redisTestService.test1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
