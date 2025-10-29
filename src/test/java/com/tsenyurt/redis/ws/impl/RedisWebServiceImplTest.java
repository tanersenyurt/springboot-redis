package com.tsenyurt.redis.ws.impl;

import com.tsenyurt.redis.model.Customer;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RedisWebServiceImplTest {

    @Mock
    private RedisTemplate<String, Object> redisTemplate;

    @Mock
    private ChannelTopic topic;

    @InjectMocks
    private RedisWebServiceImpl redisWebService;

    @Test
    public void testSendMessage() {
        // Given
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Test Name");
        customer.setSurname("Test Surname");

        String expectedTopic = "test-topic";
        when(topic.getTopic()).thenReturn(expectedTopic);

        // When
        redisWebService.sendMessage(customer);

        // Then
        String expectedMessage = new JSONObject(customer).toString();
        verify(redisTemplate).convertAndSend(expectedTopic, expectedMessage);
    }
}
