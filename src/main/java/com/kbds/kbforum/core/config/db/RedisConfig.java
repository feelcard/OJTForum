package com.kbds.kbforum.core.config.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

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

@Configuration
public class RedisConfig {

  private @Value("127.0.0.1") String redisHost;
  private @Value("8888") int redisPort;

  @Bean
  public JedisConnectionFactory connectionFactory() {

    JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();

    jedisConnectionFactory.setHostName(redisHost);

    jedisConnectionFactory.setPort(redisPort);

    jedisConnectionFactory.setUsePool(true);

    return jedisConnectionFactory;
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {

    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

    redisTemplate.setKeySerializer(new StringRedisSerializer());

    redisTemplate.setValueSerializer(new StringRedisSerializer());

    redisTemplate.setConnectionFactory(connectionFactory());

    return redisTemplate;
  }
}
