package org.springstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springstudy.binding.converter.LevelToStringConverter;
import org.springstudy.binding.converter.StringToLevelConverter;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public InternalResourceViewResolver jstlViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

//    @Bean
//    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(MyWebBindingInitializer myWebBindingInitializer) {
//        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
//
//        requestMappingHandlerAdapter.setWebBindingInitializer(myWebBindingInitializer);
//        return requestMappingHandlerAdapter;
//    }

    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();

        Set<Converter> converters = new HashSet<>();

        converters.add(levelToStringConverter());
        converters.add(stringToLevelConverter());
        conversionServiceFactoryBean.setConverters(converters);
        return conversionServiceFactoryBean;
    }

    @Bean
    public Converter stringToLevelConverter() {
        return new StringToLevelConverter();
    }

    @Bean
    public Converter levelToStringConverter() {
        return new LevelToStringConverter();
    }
}
