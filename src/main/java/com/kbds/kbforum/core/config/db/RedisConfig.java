package com.kbds.kbforum.core.config.db;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * <pre>
 * 파일명     : RedisConfig.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 24.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 24.     	    |	   유한솔       	|                             |	
 * ===============================================================================
 * </pre>
 */
@EnableCaching
@Configuration
public class RedisConfig {

  private @Value("127.0.0.1") String redisHost;
  private @Value("6379") int redisPort;

  @Bean
  public JedisConnectionFactory connectionFactory() {

    JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();

    jedisConnectionFactory.setHostName("127.0.0.1");

    jedisConnectionFactory.setPort(6379);

    jedisConnectionFactory.setUsePool(true);

    return jedisConnectionFactory;
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {

    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

    redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());

    redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

    redisTemplate.setConnectionFactory(connectionFactory());

    redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));

    return redisTemplate;
  }

  @Bean
  public RedisCacheManager cacheManager() {

    RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());

    Map<String, Long> expires = new HashMap<>();

    expires.put("sessionData", (long) 7200);

    expires.put("portalData", (long) 7200);

    expires.put("referenceData", (long) 86400);


    redisCacheManager.setExpires(expires);

    return redisCacheManager;

  }
}
