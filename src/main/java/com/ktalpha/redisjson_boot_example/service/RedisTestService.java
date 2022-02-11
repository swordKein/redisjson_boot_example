package com.ktalpha.redisjson_boot_example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class RedisTestService implements CommandLineRunner, RedisTestServiceImpl {
    private final static Logger logger = LoggerFactory.getLogger(RedisTestService.class);

    @Override
    public void run(String... args) throws Exception {

    }

    @Autowired
    @Qualifier("redisStringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void run1(String... strings) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        try {
            for (int i = 0; i < 10; i++) {
                logger.info("=====================================================================");
                logger.info("start loop " + i);
                String key = "key" + i;
                stringRedisTemplate.opsForValue().set(key, "value" + i);

                String primaryKeyValue = stringRedisTemplate.opsForValue().get(key);

                logger.info("=====================================================================");
                logger.info(String.format("read from the redis, key %s value is %s", key, primaryKeyValue));
            }
        }finally {
            latch.await();
        }
    }

    @Override
    public void test1(String... strings) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        String key = "";
        String primaryKeyValue = "";

        try {
            for (int i = 0; i < 5; i++) {
                logger.info("=====================================================================");
                logger.info("start loop " + i);
                key = "key" + i;
                stringRedisTemplate.opsForValue().set(key, "value" + i);

                primaryKeyValue = stringRedisTemplate.opsForValue().get(key);

                logger.info("=====================================================================");
                logger.info(String.format("read from the redis, key %s value is %s", key, primaryKeyValue));
            }

            key = "test_0211";
            stringRedisTemplate.opsForValue().set("test_0211","{\"test\":\"test2011\"}");

            primaryKeyValue = stringRedisTemplate.opsForValue().get(key);
            logger.info(String.format("key %s value is %s", key, primaryKeyValue));

        }finally {
            latch.await();
        }
    }
}
