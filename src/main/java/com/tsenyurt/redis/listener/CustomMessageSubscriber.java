package com.tsenyurt.redis.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsenyurt.redis.model.Customer;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.io.IOException;

/**
 * Created by : tanersenyurt
 * Date : 29.08.2018
 ***/
public class CustomMessageSubscriber implements MessageListener
{
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try
        {
            Customer customer = new ObjectMapper().readValue(message.toString(), Customer.class);
            System.out.println("Received >> " + customer.toString() +  ", " + Thread.currentThread().getName() );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
