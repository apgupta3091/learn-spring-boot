package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//YourBusinessClass
@Component
class YourBusinessClass {

    private Dependency1 dependecy1;
    private Dependency2 dependency2;

//    @Autowired
    public YourBusinessClass(Dependency1 dependecy1, Dependency2 dependency2) {
        System.out.println("Constructor Injection - YourBusinessClass");
        this.dependecy1 = dependecy1;
        this.dependency2 = dependency2;
    }

    //    @Autowired
//    public void setDependecy1(Dependency1 dependecy1) {
//        System.out.println("Setter Injection -setDependency1");
//        this.dependecy1 = dependecy1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setter Injection -setDependency2");
//        this.dependency2 = dependency2;
//    }

    public String toString() {
        return "Using " + dependecy1 + " and " + dependency2;
    }

}

//Dep1
@Component
class Dependency1 {

}

//Dep2
@Component
class Dependency2 {

}



@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext
                (DepInjectionLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
