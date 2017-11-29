package com.nineton.calendar.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.nineton.calendar.converter.DateConverter;
import com.nineton.calendar.extend.DecryptEncryptFastJsonHttpMessageConverter;
import com.nineton.calendar.extend.RequestDecryptResponseEncryptBodyMethodProcessor;
import com.nineton.calendar.extend.RequestDecryptResponseEncryptBodyProcessor;
import com.nineton.calendar.interceptor.MyInterceptor;
import com.nineton.calendar.pojo.Theme;
import com.nineton.calendar.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    private MyInterceptor myInterceptor;
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;
    @Autowired
    private ThemeService themeService;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        List<Theme> themes = themeService.findAllTheme();
        for(Theme theme:themes){
            registry.addResourceHandler(theme.getFileName()+"**").addResourceLocations("file:"+theme.getFileName());
            super.addResourceHandlers(registry);
        }
        // TODO Auto-generated method stub

    }
    /**
     * 增加字符串转日期的功能
     */
    @PostConstruct
    public void initEditableValidation() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter
                .getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer
                    .getConversionService();
            genericConversionService.addConverter(new DateConverter());
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/img/**");
        //registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new FastJsonHttpMessageConverter4());
    }
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        RequestDecryptResponseEncryptBodyProcessor processor=new RequestDecryptResponseEncryptBodyProcessor();
        List<MediaType> types=new ArrayList<>();
        types.add(MediaType.APPLICATION_JSON_UTF8);
        types.add(MediaType.TEXT_PLAIN);
        types.add(MediaType.parseMediaType("application/*+json;charset=UTF-8"));
        types.add(MediaType.parseMediaType("application/text; charset=utf-8"));
        DecryptEncryptFastJsonHttpMessageConverter converters=new DecryptEncryptFastJsonHttpMessageConverter();
        converters.setRequestDecryptResponseEncryptBodyProcessor(processor);
        converters.setSupportedMediaTypes(types);
        List<HttpMessageConverter<?>> list=new ArrayList<>();
        list.add(converters);
        argumentResolvers.add(new RequestDecryptResponseEncryptBodyMethodProcessor(list));
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        RequestDecryptResponseEncryptBodyProcessor processor=new RequestDecryptResponseEncryptBodyProcessor();
        List<MediaType> types=new ArrayList<>();
        types.add(MediaType.TEXT_PLAIN);
        types.add(MediaType.APPLICATION_JSON_UTF8);
        types.add(MediaType.parseMediaType("application/*+json;charset=UTF-8"));
        types.add(MediaType.parseMediaType("application/text; charset=utf-8"));
        DecryptEncryptFastJsonHttpMessageConverter converters=new DecryptEncryptFastJsonHttpMessageConverter();
        converters.setRequestDecryptResponseEncryptBodyProcessor(processor);
        converters.setSupportedMediaTypes(types);
        List<HttpMessageConverter<?>> list=new ArrayList<>();
        list.add(converters);
        returnValueHandlers.add(new RequestDecryptResponseEncryptBodyMethodProcessor(list));
    }


}
