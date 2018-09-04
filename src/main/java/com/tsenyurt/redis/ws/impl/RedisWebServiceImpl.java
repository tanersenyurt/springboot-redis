package com.tsenyurt.redis.ws.impl;

import com.tsenyurt.redis.model.Customer;
import com.tsenyurt.redis.ws.RedisWebService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by : tanersenyurt
 * Date : 29.08.2018
 ***/
@SOAPBinding
@WebService(endpointInterface = "com.tsenyurt.redis.ws.RedisWebService", serviceName = "RedisWebService")
public class RedisWebServiceImpl implements RedisWebService
{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ChannelTopic topic;

    @Override
    public void sendMessage(Customer customer)
    {
        redisTemplate.convertAndSend(topic.getTopic(),new JSONObject(customer).toString());
    }
}
