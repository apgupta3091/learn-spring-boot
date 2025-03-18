package com.in28minutes.learn_spring_framework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherAppliction {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext
                (SimpleSpringContextLauncherAppliction.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}
