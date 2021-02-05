package com.example.experimentrestfulvalidate.config;

import com.example.experimentrestfulvalidate.error.ExceptionTranslator;
import com.example.experimentrestfulvalidate.validator.ModelValidator;
import com.example.experimentrestfulvalidate.validator.ModelValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Locale;

@Configuration
public class ConfigSpring {

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource
//                = new ReloadableResourceBundleMessageSource();
//
//        messageSource.setBasename("classpath:messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }

//    @Bean
//    public LocaleResolver locale() {
//
//        SessionLocaleResolver localResolver=new SessionLocaleResolver();
//        localResolver.setDefaultLocale(Locale.US);
//        return localResolver;
//    }
//
//    @Bean
//    public LocaleResolver localeResolver(){
//        CookieLocaleResolver resolver = new CookieLocaleResolver();
//        resolver.setDefaultLocale(new Locale("en")); // your default locale
//        return resolver;
//    }

    @Bean
    public ExceptionTranslator exceptionTranslator(@Autowired MessageSource messageSource) {
        return new ExceptionTranslator(messageSource, "%s[%s]", Locale.ENGLISH);
    }

    @Bean
    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Bean
    public ModelValidator modelValidator() {
        return new ModelValidatorImpl(validator());
    }
}
