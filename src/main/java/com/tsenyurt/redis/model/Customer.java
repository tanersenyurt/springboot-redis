package com.tsenyurt.redis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by : tanersenyurt
 * Date : 29.08.2018
 ***/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer
{
    private long id;
    private String name;
    private String surname;
}
