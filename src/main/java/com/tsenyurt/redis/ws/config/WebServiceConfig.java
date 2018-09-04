package com.tsenyurt.redis.ws.config;

import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by : tanersenyurt
 * Date : 29.08.2018
 ***/

@Configuration
@ImportResource("classpath:jaxwsconfig.xml")
public class WebServiceConfig
{
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new WSSpringServlet(),"/ws/*");
    }
}
