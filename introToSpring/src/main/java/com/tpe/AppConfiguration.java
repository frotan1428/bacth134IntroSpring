package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration // this is our configuration class
@ComponentScan ("com.tpe")//to be able to scan my POJO classes and creates one instance from each
//by default it will scan all package which are inside the package which it it exist
// and puts them inside spring container
@PropertySource("classpath:application.properties")// annotation to specify the location file that contains key-value pairs to be used
                                                    // in your application
public class AppConfiguration {

    @Autowired
    private Environment environment; //to read application.properties file we Environment Interface from  Spring framework
    //The Environment interface provides a number of methods for accessing properties, such as getProperty()

    @Bean //crates bean from Random class, and puts inside of a container
    //@Bean is used to create bean for existing classes
    public Random randomInteger(){
        return new Random();
    }
    @Bean
    public Properties properties(){
        Properties properties= new Properties();
        properties.put("MyEmail",environment.getProperty("app.email"));
        properties.put("MyPhone",environment.getProperty("app.phone"));
        return properties;
    }




}
