package com.tsenyurt.redis.ws;

import com.tsenyurt.redis.model.Customer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by : tanersenyurt
 * Date : 29.08.2018
 ***/
@WebService
public interface RedisWebService
{
    @WebMethod
    public void sendMessage(@WebParam(name = "message") Customer customer);

}
