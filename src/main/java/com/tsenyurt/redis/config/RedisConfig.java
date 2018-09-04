package com.tsenyurt.redis.config;

import com.tsenyurt.redis.listener.CustomMessageSubscriber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import java.util.concurrent.Executors;

/**
 * Created by : tanersenyurt
 * Date : 29.08.2018
 ***/
@Configuration
@ComponentScan("com.tsenyurt.redis")
public class RedisConfig
{

    @Value("${redis.host.address:127.0.0.1}")
    private String redisHostName;

    @Value("${redis.port:33334}")
    private int redisPort;

    @Value("${redis.default.topic:deneme}")
    private String redisTopic;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(redisHostName);
        jedisConnectionFactory.setPort(redisPort);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }

    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new CustomMessageSubscriber());
    }


    @Bean
    RedisMessageListenerContainer redisContainer() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory());
        container.addMessageListener(messageListener(), topic());
        container.setTaskExecutor(Executors.newFixedThreadPool(4));
        return container;
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic(redisTopic);
    }

}
