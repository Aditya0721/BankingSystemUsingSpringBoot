package org.login;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//java-based configuration

//@Configuration : The Java configuration class is marked with this annotation. This annotation identifies this as a configuration class,
// and it’s expected to contain details on beans that are to be created in the Spring application context.
@Configuration
@ComponentScan(basePackages = {"org.login.service", "org.login.controller", "org.login.repository","org.login.dto"})
public class LoginConfig {

    // @Bean : This annotation is used to declare a bean. The methods of configuration class that creates an instance of the desired bean are annotated with this annotation.
    // These methods are called by Spring container during bootstrap and the values returned by these methods are treated as Spring beans.
    // By default, only one bean instance is created for a bean definition by the Spring Container, and that instance is used by the container for the whole application lifetime.

//    @Bean(name="customerLoginRepository")
//    public LoginRepository loginRepository2(){
//        return new LoginRepositoryImpl2();
//    }

    // jAVA-BASED CONFIGURATION
//    @Bean(name="customerLoginRepository")
//    public LoginRepository loginRepository(){
//        return new LoginRepositoryImpl();
//    }
//
//    @Bean
//    public LoginService loginService(){
//        return new LoginServiceImpl(loginRepository());
//    }

}