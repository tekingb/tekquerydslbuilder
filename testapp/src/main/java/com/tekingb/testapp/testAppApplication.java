package com.tekingb.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.tekingb.tekboolexp.tekNumberPath;
import com.tekingb.tekboolexp.tekDatePath;
import com.tekingb.tekboolexp.tekPredicate;
import com.tekingb.tekboolexp.tekBuilder;
import com.tekingb.tekboolexp.tekParamService;
import com.tekingb.tekboolexp.tekParam;




import java.util.Arrays;

@SpringBootApplication
@ComponentScan("com.tekingb.testapp")
public class testAppApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(testAppApplication.class, args);

    String[] beanNames = ctx.getBeanDefinitionNames();
    Arrays.sort(beanNames);

    for (String name : beanNames) {
      System.out.println(name);
    }
  }


  @Bean
  public tekNumberPath tekNumberPath() {
    return new tekNumberPath();
  }

  @Bean
  public tekDatePath tekDatePath() {
    return new tekDatePath();
  }

  @Bean
  public tekPredicate predicate() {
    return new tekPredicate();
  }

  @Bean
  public tekBuilder builder() {
    return new tekBuilder();
  }

  @Bean
  public tekParamService tekParamService() {
    return new tekParam(0, 50, "name");
  }




}
