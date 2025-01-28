package com.DepartmentAPI.DepartmentAPI.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getmodelmapper(){
        return new ModelMapper();
    }

}
